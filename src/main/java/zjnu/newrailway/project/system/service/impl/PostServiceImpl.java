package zjnu.newrailway.project.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.Convert;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.project.system.bean.Post;
import zjnu.newrailway.project.system.mapper.PostMapper;
import zjnu.newrailway.project.system.mapper.StaffPostMapper;
import zjnu.newrailway.project.system.mapper.UserPostMapper;
import zjnu.newrailway.project.system.service.IPostService;


import java.util.List;

/**
 * 岗位 服务层实现
 * 
 * @author cmf
 * @date 2018-10-13
 */
@Service
public class PostServiceImpl implements IPostService
{
	@Autowired
	private PostMapper postMapper;

	@Autowired
	private UserPostMapper userPostMapper;

	@Autowired
	private StaffPostMapper staffPostMapper;
	/**
     * 查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 岗位信息
     */
    @Override
	public Post selectPostById(Integer postId)
	{
	    return postMapper.selectPostById(postId);
	}
	
	/**
     * 查询岗位列表
     * 
     * @param post 岗位信息
     * @return 岗位集合
     */
	@Override
	public List<Post> selectPostList(Post post)
	{
	    return postMapper.selectPostList(post);
	}

	/**
	 * 查询所有岗位
	 *
	 * @return 岗位列表
	 */
	@Override
	public List<Post> selectPostAll()
	{
		return postMapper.selectPostAll();
	}

	/**
	 * 根据用户ID查询岗位
	 *
	 * @param userId 用户ID
	 * @return 岗位列表
	 */
	@Override
	public List<Post> selectPostsByUserId(Integer userId)
	{
		List<Post> userPosts = postMapper.selectPostsByUserId(userId);
		List<Post> posts = postMapper.selectPostAll();
		for (Post post : posts)
		{
			for (Post userRole : userPosts)
			{
				if (post.getPostId().longValue() == userRole.getPostId().longValue())
				{
					post.setFlag(true);
					break;
				}
			}
		}
		return posts;
	}



    /**
     * 新增岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	@Override
	public int insertPost(Post post)
	{
	    return postMapper.insertPost(post);
	}
	
	/**
     * 修改岗位
     * 
     * @param post 岗位信息
     * @return 结果
     */
	@Override
	public int updatePost(Post post)
	{
	    return postMapper.updatePost(post);
	}

	/**
     * 删除岗位对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePostByIds(String ids) throws Exception {
		Integer[] postIds = Convert.toLongArray(ids);
		for (Integer postId : postIds)
		{
			Post post = selectPostById(postId);
			if (countUserPostById(postId) > 0 && countStaffPostById(postId) > 0)
			{
				throw new Exception(String.format("%1$s已分配,不能删除", post.getPostName()));
			}
		}
		return postMapper.deletePostByIds(Convert.toStrArray(ids));
	}

	/**
	 * 通过岗位ID查询岗位使用数量
	 *
	 * @param postId 岗位ID
	 * @return 结果
	 */
	@Override
	public int countStaffPostById(Integer postId)
	{
		return staffPostMapper.countStaffPostById(postId);
	}


	/**
	 * 通过岗位ID查询岗位使用数量
	 *
	 * @param postId 岗位ID
	 * @return 结果
	 */
	@Override
	public int countUserPostById(Integer postId)
	{
		return userPostMapper.countUserPostById(postId);
	}

	/**
	 * 校验岗位名称是否唯一
	 * @param post 岗位信息
	 * @return
	 */
	@Override
	public String checkPostNameUnique(Post post) {
		Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
		Post info = postMapper.checkPostNameUnique(post.getPostName());
		if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue())
		{
			return UserConstants.POST_NAME_NOT_UNIQUE;
		}
		return UserConstants.POST_NAME_UNIQUE;
	}

	/**
	 * 校验岗位编码是否唯一
	 *
	 * @param post 岗位信息
	 * @return 结果
	 */
	@Override
	public String checkPostCodeUnique(Post post)
	{
		Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
		Post info = postMapper.checkPostCodeUnique(post.getPostCode());
		if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue())
		{
			return UserConstants.POST_CODE_NOT_UNIQUE;
		}
		return UserConstants.POST_CODE_UNIQUE;
	}

	/**
	 * 根据员工ID查询岗位
	 * @param staffId 用户ID
	 * @return
	 */
	@Override
	public List<Post> selectPostsByStaffId(Integer staffId) {
		List<Post> staffPosts = postMapper.selectPostsByStaffId(staffId);
		List<Post> posts = postMapper.selectPostAll();
		for (Post post : posts)
		{
			for (Post staffPost : staffPosts)
			{
				if (post.getPostId().longValue() == staffPost.getPostId().longValue())
				{
					post.setFlag(true);
					break;
				}
			}
		}
		return posts;
	}

}
