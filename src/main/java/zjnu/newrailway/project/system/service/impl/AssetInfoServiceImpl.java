package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.project.system.mapper.AssetInfoMapper;
import zjnu.newrailway.project.system.bean.AssetInfo;
import zjnu.newrailway.project.system.service.IAssetInfoService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 资产 服务层实现
 * 
 * @author cmf
 * @date 2018-10-28
 */
@Service
public class AssetInfoServiceImpl implements IAssetInfoService 
{
	@Autowired
	private AssetInfoMapper assetInfoMapper;

	/**
     * 查询资产信息
     * 
     * @param id 资产ID
     * @return 资产信息
     */
    @Override
	public AssetInfo selectAssetInfoById(Integer id)
	{
	    return assetInfoMapper.selectAssetInfoById(id);
	}
	
	/**
     * 查询资产列表
     * 
     * @param assetInfo 资产信息
     * @return 资产集合
     */
	@Override
	public List<AssetInfo> selectAssetInfoList(AssetInfo assetInfo)
	{
	    return assetInfoMapper.selectAssetInfoList(assetInfo);
	}
	
    /**
     * 新增资产
     * 
     * @param assetInfo 资产信息
     * @return 结果
     */
	@Override
	public int insertAssetInfo(AssetInfo assetInfo)
	{
	    return assetInfoMapper.insertAssetInfo(assetInfo);
	}
	
	/**
     * 修改资产
     * 
     * @param assetInfo 资产信息
     * @return 结果
     */
	@Override
	public int updateAssetInfo(AssetInfo assetInfo)
	{
	    return assetInfoMapper.updateAssetInfo(assetInfo);
	}

	/**
     * 删除资产对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAssetInfoByIds(String ids)
	{
		return assetInfoMapper.deleteAssetInfoByIds(Convert.toStrArray(ids));
	}


	/**
	 *检验资产类型是否唯一
	 * @param assetInfo
	 * @return
	 */
	@Override
	public String checkType(AssetInfo assetInfo) {
		AssetInfo info = assetInfoMapper.checkType(assetInfo.getAssettype());
		if(StringUtils.isNotNull(info)){
			return UserConstants.TYPE_NOT_UNIQUE;
		}
		return UserConstants.TYPE_UNIQUE;

	}

}
