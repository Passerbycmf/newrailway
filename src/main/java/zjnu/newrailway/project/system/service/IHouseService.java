package zjnu.newrailway.project.system.service;

import zjnu.newrailway.project.system.bean.Asset;
import java.util.List;

/**
 * 资产管理 服务层
 * 
 * @author cmf
 * @date 2018-11-01
 */
public interface IHouseService
{
	/**
     * 查询资产管理信息
     * 
     * @param id 资产管理ID
     * @return 资产管理信息
     */
	public Asset selectHouseById(Integer id);
	
	/**
     * 查询资产管理列表
     * 
     * @param house 资产管理信息
     * @return 资产管理集合
     */
	public List<Asset> selectHouseList(Asset house);
	
	/**
     * 新增资产管理
     * 
     * @param house 资产管理信息
     * @return 结果
     */
	public int insertHouse(Asset house);
	
	/**
     * 修改资产管理
     * 
     * @param House 资产管理信息
     * @return 结果
     */
	public int updateHouse(Asset House);
		
	/**
     * 删除资产管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteHouseByIds(String ids);

	/**
	 * 校检资产名称
	 * @param house 资产管理信息
	 * @return 结果
	 */
	public 	String checkAssetName(Asset house);

	/**
	 * 校检资产编号
	 * @param house 资产管理信息
	 * @return 结果
	 */
    public String checkAssetNumber(Asset house);


	int insertHousetest(Asset house);
}
