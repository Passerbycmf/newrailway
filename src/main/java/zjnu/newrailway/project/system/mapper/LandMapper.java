package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.Asset;
import java.util.List;	

/**
 * 资产管理 数据层
 * 
 * @author cmf
 * @date 2018-11-01
 */

public interface LandMapper
{
	/**
     * 查询资产管理信息
     * 
     * @param id 资产管理ID
     * @return 资产管理信息
     */
	public Asset selectLandById(Integer id);
	
	/**
     * 查询资产管理列表
     * 
     * @param land 资产管理信息
     * @return 资产管理集合
     */
	public List<Asset> selectLandList(Asset land);
	
	/**
     * 新增资产管理
     * 
     * @param land 资产管理信息
     * @return 结果
     */
	public int insertLand(Asset land);
	
	/**
     * 修改资产管理
     * 
     * @param land 资产管理信息
     * @return 结果
     */
	public int updateLand(Asset land);
	
	/**
     * 删除资产管理
     * 
     * @param id 资产管理ID
     * @return 结果
     */
	public int deleteLandById(Integer id);
	
	/**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLandByIds(String[] ids);

	/**
	 *
	 * @param assetName
	 * @return 结果
	 */
	public Asset checkAssetName(String assetName);

	/**
	 *
	 * @param assetNumber
	 * @return 结果
	 */
	public Asset checkAssetNumber(Integer assetNumber);
}