package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.project.system.mapper.AssetManagementMapper;
import zjnu.newrailway.project.system.bean.AssetManagement;
import zjnu.newrailway.project.system.service.IAssetManagementService;
import zjnu.newrailway.common.utils.Convert;

import javax.annotation.Resource;

/**
 * 资产管理 服务层实现
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Service
public class AssetManagementServiceImpl implements IAssetManagementService {
	@Autowired
	private AssetManagementMapper assetManagementMapper;

	/**
	 * 查询资产管理信息
	 *
	 * @param id 资产管理ID
	 * @return 资产管理信息
	 */
	@Override
	public AssetManagement selectAssetManagementById(Integer id) {
		return assetManagementMapper.selectAssetManagementById(id);
	}

	/**
	 * 查询资产管理列表
	 *
	 * @param assetManagement 资产管理信息
	 * @return 资产管理集合
	 */
	@Override
	public List<AssetManagement> selectAssetManagementList(AssetManagement assetManagement) {
		return assetManagementMapper.selectAssetManagementList(assetManagement);
	}

	/**
	 * 新增资产管理
	 *
	 * @param assetManagement 资产管理信息
	 * @return 结果
	 */
	@Override
	public int insertAssetManagement(AssetManagement assetManagement) {
		return assetManagementMapper.insertAssetManagement(assetManagement);
	}

	/**
	 * 修改资产管理
	 *
	 * @param assetManagement 资产管理信息
	 * @return 结果
	 */
	@Override
	public int updateAssetManagement(AssetManagement assetManagement) {
		return assetManagementMapper.updateAssetManagement(assetManagement);
	}

	/**
	 * 删除资产管理对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteAssetManagementByIds(String ids) {
		return assetManagementMapper.deleteAssetManagementByIds(Convert.toStrArray(ids));
	}

	/**
	 * 校检资产名称
	 *
	 * @param assetManagement
	 * @return 结果
	 */
	@Override
	public String checkAssetName(AssetManagement assetManagement) {
		AssetManagement management = assetManagementMapper.checkAssetName(assetManagement.getAssetName());
		if (StringUtils.isNotNull(management)) {
			return UserConstants.TYPE_NOT_UNIQUE;
		}
		return UserConstants.TYPE_UNIQUE;
	}

	/**
	 * 校检资产编号
	 *
	 * @param assetManagement
	 * @return 结果
	 */
	@Override
	public String checkAssetNumber(AssetManagement assetManagement) {
		AssetManagement management = assetManagementMapper.checkAssetNumber(assetManagement.getAssetNumber());
		if (StringUtils.isNotNull(management)) {
			return UserConstants.TYPE_NOT_UNIQUE;
		}
		return UserConstants.TYPE_UNIQUE;

	}
}

