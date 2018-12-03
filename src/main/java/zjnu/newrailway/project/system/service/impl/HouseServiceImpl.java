package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.project.system.mapper.HouseMapper;
import zjnu.newrailway.project.system.bean.Asset;
import zjnu.newrailway.project.system.service.IHouseService;
import zjnu.newrailway.common.utils.Convert;



/**
 * 资产管理 服务层实现
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Service
public class HouseServiceImpl implements IHouseService {
	@Autowired
	private HouseMapper houseMapper;

	/**
	 * 查询资产管理信息
	 *
	 * @param assetId 资产管理ID
	 * @return 资产管理信息
	 */
	@Override
	public Asset selectHouseById(Integer assetId) {
		return houseMapper.selectHouseById(assetId);
	}

	/**
	 * 查询资产管理列表
	 *
	 * @param house 资产管理信息
	 * @return 资产管理集合
	 */
	@Override
	public List<Asset> selectHouseList(Asset house) {
		return houseMapper.selectHouseList(house);
	}

	/**
	 * 新增资产管理
	 *
	 * @param house 资产管理信息
	 * @return 结果
	 */
	@Override
	public int insertHouse(Asset house) {
		return houseMapper.insertHouse(house);
	}

	/**
	 * 修改资产管理
	 *
	 * @param house 资产管理信息
	 * @return 结果
	 */
	@Override
	public int updateHouse(Asset house) {
		return houseMapper.updateHouse(house);
	}

	/**
	 * 删除资产管理对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteHouseByIds(String ids) {
		return houseMapper.deleteHouseByIds(Convert.toStrArray(ids));
	}

	/**
	 * 校检资产名称
	 *
	 * @param house
	 * @return 结果
	 */
	@Override
	public String checkAssetName(Asset house) {
		Asset management = houseMapper.checkAssetName(house.getAssetName());
		if (StringUtils.isNotNull(management)) {
			return UserConstants.TYPE_NOT_UNIQUE;
		}
		return UserConstants.TYPE_UNIQUE;
	}

	/**
	 * 校检资产编号
	 *
	 * @param house
	 * @return 结果
	 */
	@Override
	public String checkAssetNumber(Asset house) {
		Asset management = houseMapper.checkAssetNumber(house.getAssetNumber());
		if (StringUtils.isNotNull(management)) {
			return UserConstants.TYPE_NOT_UNIQUE;
		}
		return UserConstants.TYPE_UNIQUE;

	}

	@Override
	public int insertHousetest(Asset house) {
		return houseMapper.insertHouseTest(house);
	}

}

