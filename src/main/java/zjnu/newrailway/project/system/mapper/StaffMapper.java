package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.Staff;
import java.util.List;	

/**
 * 公司员工 数据层
 * 
 * @author cmf
 * @date 2018-11-16
 */
public interface StaffMapper 
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
     * 删除公司员工
     * 
     * @param staffId 公司员工ID
     * @return 结果
     */
	public int deleteStaffById(Integer staffId);
	
	/**
     * 批量删除公司员工
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteStaffByIds(String[] ids);
	
}