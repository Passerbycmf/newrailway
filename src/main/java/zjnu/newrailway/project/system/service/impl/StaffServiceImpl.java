package zjnu.newrailway.project.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.project.system.bean.Post;
import zjnu.newrailway.project.system.bean.StaffPost;
import zjnu.newrailway.project.system.mapper.PostMapper;
import zjnu.newrailway.project.system.mapper.StaffMapper;
import zjnu.newrailway.project.system.bean.Staff;
import zjnu.newrailway.project.system.mapper.StaffPostMapper;
import zjnu.newrailway.project.system.service.IStaffService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 公司员工 服务层实现
 * 
 * @author cmf
 * @date 2018-11-16
 */
@Service
public class StaffServiceImpl implements IStaffService 
{
	@Autowired
	private StaffMapper staffMapper;

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private StaffPostMapper staffPostMapper;


	/**
     * 查询公司员工信息
     * 
     * @param staffId 公司员工ID
     * @return 公司员工信息
     */
    @Override
	public Staff selectStaffById(Integer staffId)
	{
	    return staffMapper.selectStaffById(staffId);
	}
	
	/**
     * 查询公司员工列表
     * 
     * @param staff 公司员工信息
     * @return 公司员工集合
     */
	@Override
	public List<Staff> selectStaffList(Staff staff)
	{
	    return staffMapper.selectStaffList(staff);
	}
	
    /**
     * 新增公司员工
     * 
     * @param staff 公司员工信息
     * @return 结果
     */
	@Override
	public int insertStaff(Staff staff)
	{
		int rows = staffMapper.insertStaff(staff);
		// 新增用户岗位关联
		insertStaffPost(staff);
		return rows;

	}

	/**
	 * 新增员工岗位信息
	 *
	 * @param staff 用户对象
	 */
	public void insertStaffPost(Staff staff)
	{
		// 新增员工与岗位管理
		List<StaffPost> list = new ArrayList<StaffPost>();
		for (Integer postId : staff.getPostIds())
		{
			StaffPost up = new StaffPost();
			up.setStaffId(staff.getStaffId());
			up.setPostId(postId);
			list.add(up);
		}
		if (list.size() > 0)
		{
			staffPostMapper.batchStaffPost(list);
		}
	}
	
	/**
     * 修改公司员工
     * 
     * @param staff 公司员工信息
     * @return 结果
     */
	@Override
	public int updateStaff(Staff staff)
	{
		Integer staffId = staff.getStaffId();
		// 删除员工与岗位关联
		staffPostMapper.deleteStaffPostByStaffId(staffId);
		// 新增员工与岗位管理
		insertStaffPost(staff);
		return staffMapper.updateStaff(staff);
	}

	/**
	 * 通过员工ID删除用户
	 *
	 * @param staffId 员工ID
	 * @return 结果
	 */
	@Override
	public int deleteStaffById(Integer staffId)
	{
		// 删除员工与岗位表
		staffPostMapper.deleteStaffPostByStaffId(staffId);
		return staffMapper.deleteStaffById(staffId);
	}


	/**
     * 删除公司员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteStaffByIds(String ids)
	{
		return staffMapper.deleteStaffByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询员工所属岗位组
	 *
	 * @param staffId 员工ID
	 * @return 结果
	 */
	@Override
	public String selectStaffPostGroup(Integer staffId)
	{
		List<Post> list = postMapper.selectPostsByStaffId(staffId);
		StringBuffer idsStr = new StringBuffer();
		for (Post post : list)
		{
			idsStr.append(post.getPostName()).append(",");
		}
		if (StringUtils.isNotEmpty(idsStr.toString()))
		{
			return idsStr.substring(0, idsStr.length() - 1);
		}
		return idsStr.toString();
	}
	
}
