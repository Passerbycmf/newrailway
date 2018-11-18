package zjnu.newrailway.project.system.service;

import zjnu.newrailway.project.system.bean.Staff;
import java.util.List;

/**
 * 公司员工 服务层
 * 
 * @author cmf
 * @date 2018-11-16
 */
public interface IStaffService 
{
	/**
     * 查询公司员工信息
     * 
     * @param staffId 公司员工ID
     * @return 公司员工信息
     */
	public Staff selectStaffById(Integer staffId);
	
	/**
     * 查询公司员工列表
     * 
     * @param staff 公司员工信息
     * @return 公司员工集合
     */
	public List<Staff> selectStaffList(Staff staff);
	
	/**
     * 新增公司员工
     * 
     * @param staff 公司员工信息
     * @return 结果
     */
	public int insertStaff(Staff staff);
	
	/**
     * 修改公司员工
     * 
     * @param staff 公司员工信息
     * @return 结果
     */
	public int updateStaff(Staff staff);

	/**
	 * 通过员工staffId删除员工
	 *
	 * @param staffId 员工ID
	 * @return 结果
	 */
	public int deleteStaffById(Integer staffId);
		
	/**
     * 删除公司员工信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteStaffByIds(String ids);

	/**
	 * 根据员工staffId查询员工所属岗位组
	 *
	 * @param staffId 用户staffId
	 * @return 结果
	 */
	String selectStaffPostGroup(Integer staffId);
	
}
