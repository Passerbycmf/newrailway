package zjnu.newrailway.project.system.service;

import zjnu.newrailway.project.system.bean.AssetManagement;
import java.util.List;

/**
 * 资产管理 服务层
 * 
 * @author cmf
 * @date 2018-11-01
 */
public interface IAssetManagementService 
{
	/**
     * 查询资产管理信息
     * 
     * @param id 资产管理ID
     * @return 资产管理信息
     */
	public AssetManagement selectAssetManagementById(Integer id);
	
	/**
     * 查询资产管理列表
     * 
     * @param assetManagement 资产管理信息
     * @return 资产管理集合
     */
	public List<AssetManagement> selectAssetManagementList(AssetManagement assetManagement);
	
	/**
     * 新增资产管理
     * 
     * @param assetManagement 资产管理信息
     * @return 结果
     */
	public int insertAssetManagement(AssetManagement assetManagement);
	
	/**
     * 修改资产管理
     * 
     * @param assetManagement 资产管理信息
     * @return 结果
     */
	public int updateAssetManagement(AssetManagement assetManagement);
		
	/**
     * 删除资产管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAssetManagementByIds(String ids);

	/**
	 * 校检资产名称
	 * @param assetManagement 资产管理信息
	 * @return 结果
	 */
	public 	String checkAssetName(AssetManagement assetManagement);

	/**
	 * 校检资产编号
	 * @param assetManagement 资产管理信息
	 * @return 结果
	 */
    public String checkAssetNumber(AssetManagement assetManagement);

	/**
	 * 校检资产编号
	 * @param assetManagement 资产管理信息
	 * @return 结果
	 */
	public String checkNumber(AssetManagement assetManagement);
}
