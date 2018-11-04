package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.project.system.mapper.RentMapper;
import zjnu.newrailway.project.system.bean.Rent;
import zjnu.newrailway.project.system.service.IRentService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 承租项点 服务层实现
 * 
 * @author cmf
 * @date 2018-11-04
 */
@Service
public class RentServiceImpl implements IRentService 
{
	@Autowired
	private RentMapper rentMapper;

	/**
     * 查询承租项点信息
     * 
     * @param id 承租项点ID
     * @return 承租项点信息
     */
    @Override
	public Rent selectRentById(Integer id)
	{
	    return rentMapper.selectRentById(id);
	}
	
	/**
     * 查询承租项点列表
     * 
     * @param rent 承租项点信息
     * @return 承租项点集合
     */
	@Override
	public List<Rent> selectRentList(Rent rent)
	{
	    return rentMapper.selectRentList(rent);
	}
	
    /**
     * 新增承租项点
     * 
     * @param rent 承租项点信息
     * @return 结果
     */
	@Override
	public int insertRent(Rent rent)
	{
	    return rentMapper.insertRent(rent);
	}
	
	/**
     * 修改承租项点
     * 
     * @param rent 承租项点信息
     * @return 结果
     */
	@Override
	public int updateRent(Rent rent)
	{
	    return rentMapper.updateRent(rent);
	}

	/**
     * 删除承租项点对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRentByIds(String ids)
	{
		return rentMapper.deleteRentByIds(Convert.toStrArray(ids));
	}
	
}
