package zjnu.newrailway.project.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zjnu.newrailway.common.utils.ExcelUtil;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.project.system.bean.Car;
import zjnu.newrailway.project.system.bean.Contract;
import zjnu.newrailway.project.system.bean.model.TimeCar;
import zjnu.newrailway.project.system.service.ICarService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 汽车基地经营管理 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-23
 */
@Controller
@RequestMapping("/system/car")
public class CarController extends BaseController
{
    private String prefix = "system/car";
	
	@Autowired
	private ICarService carService;
	
	@RequiresPermissions("system:car:view")
	@GetMapping()
	public String car()
	{
	    return prefix + "/car";
	}
	
	/**
	 * 查询汽车基地经营管理列表
	 */
	@RequiresPermissions("system:car:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Car car)
        {
		startPage();
        List<TimeCar> list = carService.selectCarList(car);
		return getDataTable(list);
	}
	
	/**
	 * 新增汽车基地经营管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存汽车基地经营管理
	 */
	@RequiresPermissions("system:car:add")
	@Log(title = "汽车基地经营管理", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TimeCar car)
	{		
		return toAjax(carService.insertCar(car));
	}

	/**
	 * 修改汽车基地经营管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Car car = carService.selectCarById(id);
		mmap.put("car", car);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存汽车基地经营管理
	 */
	@RequiresPermissions("system:car:edit")
	@Log(title = "汽车基地经营管理", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TimeCar car)
	{		
		return toAjax(carService.updateCar(car));
	}
	
	/**
	 * 删除汽车基地经营管理
	 */
	@RequiresPermissions("system:car:remove")
	@Log(title = "汽车基地经营管理", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(carService.deleteCarByIds(ids));
	}


	@GetMapping("/check/{id}")
	public String check(@PathVariable("id") Integer id, ModelMap map){
		Car car = carService.selectCarById(id);
		map.put("car",car);
		return prefix + "/check" ;
	}



	/**
	 * 导出
	 * @param car
	 * @return
	 * @throws Exception
	 */
	@Log(title = "汽车管理", action = BusinessType.EXPORT)
	@RequiresPermissions("system:car:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Car car) throws Exception
	{
		try
		{
			List<TimeCar> list = carService.selectCarList(car);
			ExcelUtil<TimeCar> util = new ExcelUtil<TimeCar>(TimeCar.class);
			return util.exportExcel(list, "car");
		}
		catch (Exception e)
		{
			return error("导出Excel失败，请联系网站管理员！");
		}
	}



}
