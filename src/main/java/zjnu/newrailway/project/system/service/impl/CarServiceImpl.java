package zjnu.newrailway.project.system.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.utils.DateUtil;
import zjnu.newrailway.project.system.bean.model.TimeCar;
import zjnu.newrailway.project.system.mapper.CarMapper;
import zjnu.newrailway.project.system.bean.Car;
import zjnu.newrailway.project.system.service.ICarService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 汽车基地经营管理 服务层实现
 * 
 * @author cmf
 * @date 2018-11-23
 */
@Service
public class CarServiceImpl implements ICarService 
{
	@Autowired
	private CarMapper carMapper;

	/**
     * 查询汽车基地经营管理信息
     * 
     * @param id 汽车基地经营管理ID
     * @return 汽车基地经营管理信息
     */
    @Override
	public Car selectCarById(Integer id)
	{
	    return carMapper.selectCarById(id);
	}
	
	/**
     * 查询汽车基地经营管理列表
     * 
     * @param car 汽车基地经营管理信息
     * @return 汽车基地经营管理集合
     */
	@Override
	public List<TimeCar> selectCarList(Car car)
	{
	    return carMapper.selectCarList(car);
	}
	
    /**
     * 新增汽车基地经营管理
     * 
     * @param timeCar 汽车基地经营管理信息
     * @return 结果
     */
	@Override
	public int insertCar(TimeCar timeCar)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		timeCar.setCrTime(df.format(new Date()));
		return carMapper.insertCar(timeCar);
	}
	
	/**
     * 修改汽车基地经营管理
     * 
     * @param car 汽车基地经营管理信息
     * @return 结果
     */
	@Override
	public int updateCar(TimeCar car)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");
	    car.setUpTime(dateFormat.format(new Date()));
		return carMapper.updateCar(car);
	}

	/**
     * 删除汽车基地经营管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCarByIds(String ids)
	{
		return carMapper.deleteCarByIds(Convert.toStrArray(ids));
	}
	
}


