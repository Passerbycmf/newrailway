package zjnu.newrailway.project.system.service;

import zjnu.newrailway.project.system.bean.Land;

import java.util.List;

/**
 * 资产管理 服务层
 * 
 * @author cmf
 * @date 2018-11-01
 */
public interface ILandService
{
	/**
     * 查询资产管理信息
     * 
     * @param id 资产管理ID
     * @return 资产管理信息
     */
	public Land selectLandById(Integer id);
	
	/**
     * 查询资产管理列表
     * 
     * @param land 资产管理信息
     * @return 资产管理集合
     */
	public List<Land> selectLandList(Land land);
	
	/**
     * 新增资产管理
     * 
     * @param land 资产管理信息
     * @return 结果
     */
	public int insertLand(Land land);
	
	/**
     * 修改资产管理
     * 
     * @param land 资产管理信息
     * @return 结果
     */
	public int updateLand(Land land);
		
	/**
     * 删除资产管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLandByIds(String ids);

	/**
	 * 校检资产名称
	 * @param land 资产管理信息
	 * @return 结果
	 */
	public 	String checkAssetName(Land land);

	/**
	 * 校检资产编号
	 * @param land 资产管理信息
	 * @return 结果
	 */
    public String checkAssetNumber(Land land);
}
