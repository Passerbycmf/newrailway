package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.Rent;
import java.util.List;	

/**
 * 承租项点 数据层
 * 
 * @author cmf
 * @date 2018-11-04
 */
public interface RentMapper 
{
	/**
     * 查询承租项点信息
     * 
     * @param id 承租项点ID
     * @return 承租项点信息
     */
	public Rent selectRentById(Integer id);
	
	/**
     * 查询承租项点列表
     * 
     * @param rent 承租项点信息
     * @return 承租项点集合
     */
	public List<Rent> selectRentList(Rent rent);
	
	/**
     * 新增承租项点
     * 
     * @param rent 承租项点信息
     * @return 结果
     */
	public int insertRent(Rent rent);
	
	/**
     * 修改承租项点
     * 
     * @param rent 承租项点信息
     * @return 结果
     */
	public int updateRent(Rent rent);
	
	/**
     * 删除承租项点
     * 
     * @param id 承租项点ID
     * @return 结果
     */
	public int deleteRentById(Integer id);
	
	/**
     * 批量删除承租项点
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRentByIds(String[] ids);
	
}