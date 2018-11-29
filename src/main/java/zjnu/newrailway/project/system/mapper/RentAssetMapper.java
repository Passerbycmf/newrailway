package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.RentAsset;
import java.util.List;	

/**
 * 员工岗位关联 数据层
 * 
 * @author cmf
 * @date 2018-11-27
 */
public interface RentAssetMapper 
{
	/**
     * 查询资产项点关联信息
     * 
     * @param rentId 项点关联ID
     * @return 资产关联信息
     */
	public RentAsset selectRentAssetById(String rentId);
	

	public List<RentAsset> selectRentAssetList(RentAsset rentAsset);

	public int insertRentAsset(RentAsset rentAsset);
	

	public int updateRentAsset(RentAsset rentAsset);
	

	public int deleteRentAssetById(String rentId);
	

	public int deleteRentAssetByIds(String[] rentIds);

	public int countRentAssetById(Integer assetId);

	public int batchRentAsset(List<RentAsset> rentAssetList);
	
}