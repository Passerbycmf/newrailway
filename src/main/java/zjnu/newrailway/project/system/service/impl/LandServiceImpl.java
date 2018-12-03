package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.project.system.bean.Asset;
import zjnu.newrailway.project.system.mapper.LandMapper;
import zjnu.newrailway.project.system.service.ILandService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 资产管理 服务层实现
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Service
public class LandServiceImpl implements ILandService {
	@Autowired
	private LandMapper landMapper;

	/**
	 * 查询资产管理信息
	 *
	 * @param assetId 资产管理ID
	 * @return 资产管理信息
	 */
	@Override
	public Asset selectLandById(Integer assetId) {
		return landMapper.selectLandById(assetId);
	}

	/**
	 * 查询资产管理列表
	 *
	 * @param land 资产管理信息
	 * @return 资产管理集合
	 */
	@Override
	public List<Asset> selectLandList(Asset land) {
		return landMapper.selectLandList(land);
	}

	/**
	 * 新增资产管理
	 *
	 * @param land 资产管理信息
	 * @return 结果
	 */
	@Override
	public int insertLand(Asset land) {

		return landMapper.insertLand(land);
	}

	/**
	 * 修改资产管理
	 *
	 * @param land 资产管理信息
	 * @return 结果
	 */
	@Override
	public int updateLand(Asset land) {
		return landMapper.updateLand(land);
	}

	/**
	 * 删除资产管理对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteLandByIds(String ids) {
		return landMapper.deleteLandByIds(Convert.toStrArray(ids));
	}

	/**
	 * 校检资产名称
	 *
	 * @param land
	 * @return 结果
	 */
	@Override
	public String checkAssetName(Asset land) {
		Asset management = landMapper.checkAssetName(land.getAssetName());
		if (StringUtils.isNotNull(management)) {
			return UserConstants.TYPE_NOT_UNIQUE;
		}
		return UserConstants.TYPE_UNIQUE;
	}

	/**
	 * 校检资产编号
	 *
	 * @param land
	 * @return 结果
	 */
	@Override
	public String checkAssetNumber(Asset land) {
		Asset management = landMapper.checkAssetNumber(land.getAssetNumber());
		if (StringUtils.isNotNull(management)) {
			return UserConstants.TYPE_NOT_UNIQUE;
		}
		return UserConstants.TYPE_UNIQUE;

	}
}

