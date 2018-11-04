package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.AssetInfo;
import java.util.List;	

/**
 * 资产 数据层
 * 
 * @author cmf
 * @date 2018-10-28
 */
public interface AssetInfoMapper 
{
	/**
     * 查询资产信息
     * 
     * @param id 资产ID
     * @return 资产信息
     */
	public AssetInfo selectAssetInfoById(Integer id);
	
	/**
     * 查询资产列表
     * 
     * @param assetInfo 资产信息
     * @return 资产集合
     */
	public List<AssetInfo> selectAssetInfoList(AssetInfo assetInfo);
	
	/**
     * 新增资产
     * 
     * @param assetInfo 资产信息
     * @return 结果
     */
	public int insertAssetInfo(AssetInfo assetInfo);
	
	/**
     * 修改资产
     * 
     * @param assetInfo 资产信息
     * @return 结果
     */
	public int updateAssetInfo(AssetInfo assetInfo);
	
	/**
     * 删除资产
     * 
     * @param id 资产ID
     * @return 结果
     */
	public int deleteAssetInfoById(Integer id);
	
	/**
     * 批量删除资产
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAssetInfoByIds(String[] ids);

	AssetInfo checkType(String assettype);
}