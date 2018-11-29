package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.project.system.mapper.AssetManagementMapper;
import zjnu.newrailway.project.system.bean.AssetManagement;
import zjnu.newrailway.project.system.service.IAssetManagementService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 资产管理 服务层实现
 * 
 * @author cmf
 * @date 2018-11-27
 */
@Service
public class AssetManagementServiceImpl implements IAssetManagementService 
{
	@Autowired
	private AssetManagementMapper assetManagementMapper;

	/**
     * 查询资产管理信息
     * 
     * @param id 资产管理ID
     * @return 资产管理信息
     */
    @Override
	public AssetManagement selectAssetManagementById(Integer id)
	{
	    return assetManagementMapper.selectAssetManagementById(id);
	}
	
	/**
     * 查询资产管理列表
     * 
     * @param assetManagement 资产管理信息
     * @return 资产管理集合
     */
	@Override
	public List<AssetManagement> selectAssetManagementList(AssetManagement assetManagement)
	{
	    return assetManagementMapper.selectAssetManagementList(assetManagement);
	}
	
    /**
     * 新增资产管理
     * 
     * @param assetManagement 资产管理信息
     * @return 结果
     */
	@Override
	public int insertAssetManagement(AssetManagement assetManagement)
	{
	    return assetManagementMapper.insertAssetManagement(assetManagement);
	}
	
	/**
     * 修改资产管理
     * 
     * @param assetManagement 资产管理信息
     * @return 结果
     */
	@Override
	public int updateAssetManagement(AssetManagement assetManagement)
	{
	    return assetManagementMapper.updateAssetManagement(assetManagement);
	}

	/**
     * 删除资产管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAssetManagementByIds(String ids)
	{
		return assetManagementMapper.deleteAssetManagementByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询所有资产
	 * @return
	 */
	@Override
	public List<AssetManagement> selectAssetName() {
		return assetManagementMapper.selectAssetsAll();
	}

	@Override
	public List<AssetManagement> selectAssetsByRentId(Integer rentId) {
		List<AssetManagement> assetManagements = assetManagementMapper.selectAssetsByRentId(rentId);
		List<AssetManagement> assets = assetManagementMapper.selectAssetsAll();
		for (AssetManagement assetManagement : assetManagements)
		{
			assetManagement.setFlag(true);
			break;
		}
		return assets;

	}

}
