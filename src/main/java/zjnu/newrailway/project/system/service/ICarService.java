package zjnu.newrailway.project.system.service;

import zjnu.newrailway.project.system.bean.Car;
import zjnu.newrailway.project.system.bean.model.TimeCar;

import java.util.List;

/**
 * 汽车基地经营管理 服务层
 * 
 * @author cmf
 * @date 2018-11-23
 */
public interface ICarService 
{
	/**
     * 查询汽车基地经营管理信息
     * 
     * @param id 汽车基地经营管理ID
     * @return 汽车基地经营管理信息
     */
	public Car selectCarById(Integer id);
	
	/**
     * 查询汽车基地经营管理列表
     * 
     * @param car 汽车基地经营管理信息
     * @return 汽车基地经营管理集合
     */
	public List<TimeCar> selectCarList(Car car);
	
	/**
     * 新增汽车基地经营管理
     * 
     * @param car 汽车基地经营管理信息
     * @return 结果
     */
	public int insertCar(TimeCar car);
	
	/**
     * 修改汽车基地经营管理
     * 
     * @param car 汽车基地经营管理信息
     * @return 结果
     */
	public int updateCar(TimeCar car);
		
	/**
     * 删除汽车基地经营管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCarByIds(String ids);
	
}
