package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.StaffPost;
import java.util.List;	

/**
 * 员工岗位关联 数据层
 * 
 * @author cmf
 * @date 2018-11-16
 */
public interface StaffPostMapper 
{
	/**
	 * 通过员工ID删除员工和岗位关联
	 *
	 * @param staffId 员工ID
	 * @return 结果
	 */
	public int deleteStaffPostByStaffId(Integer staffId);

	/**
	 * 通过岗位ID查询岗位使用数量
	 *
	 * @param postId 岗位ID
	 * @return 结果
	 */
	public int countStaffPostById(Integer postId);

	/**
	 * 批量删除员工和岗位关联
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteStaffPost(Integer[] ids);

	/**
	 * 批量新增员工岗位信息
	 *
	 * @param staffPostList 员工角色列表
	 * @return 结果
	 */
	public int batchStaffPost(List<StaffPost> staffPostList);
	
}