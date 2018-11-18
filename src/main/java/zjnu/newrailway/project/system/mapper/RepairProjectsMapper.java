package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.RepairProjects;
import java.util.List;

/**
 * 修缮项目 数据层
 * 
 * @author cmf
 * @date 2018-11-01
 */
public interface RepairProjectsMapper 
{
	/**
     * 查询修缮项目信息
     * 
     * @param difference 修缮项目ID
     * @return 修缮项目信息
     */
	public RepairProjects selectRepairProjectsById(Integer difference);
	
	/**
     * 查询修缮项目列表
     * 
     * @param repairProjects 修缮项目信息
     * @return 修缮项目集合
     */
	public List<RepairProjects> selectRepairProjectsList(RepairProjects repairProjects);
	
	/**
     * 新增修缮项目
     * 
     * @param repairProjects 修缮项目信息
     * @return 结果
     */
	public int insertRepairProjects(RepairProjects repairProjects);
	
	/**
     * 修改修缮项目
     * 
     * @param repairProjects 修缮项目信息
     * @return 结果
     */
	public int updateRepairProjects(RepairProjects repairProjects);
	
	/**
     * 删除修缮项目
     * 
     * @param id 修缮项目ID
     * @return 结果
     */
	public int deleteRepairProjectsById(Integer id);
	
	/**
     * 批量删除修缮项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRepairProjectsByIds(String[] ids);

	/**
	 * 增加修缮信息
	 * @param repairProjects
	 * @return
	 */
    int insert(RepairProjects repairProjects);

	/**
	 * 查询全部修缮信息
	 * @return
	 */
	List<RepairProjects> selectRepairProjectsAll();

	/**
	 * 根据资产名称查询修缮信息
	 * @param assetName
	 * @return
	 */
    List<RepairProjects> selectRepairProjectsByAssetName(String assetName);

	/**
	 * 土地获得资产名称
	 * @return
	 */
	String getAssetName();

	/**
	 * 房屋获得资产名称
	 * @return
	 */
	String getHouseAssetName();
}