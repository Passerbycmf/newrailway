package zjnu.newrailway.project.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.project.system.bean.Rent;
import zjnu.newrailway.project.system.service.IRentService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 承租项点 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-04
 */
@Controller
@RequestMapping("/system/rent")
public class RentController extends BaseController
{
    private String prefix = "system/rent";
	
	@Autowired
	private IRentService rentService;
	
	@RequiresPermissions("system:rent:view")
	@GetMapping()
	public String rent()
	{
	    return prefix + "/rent";
	}
	
	/**
	 * 查询承租项点列表
	 */
	@RequiresPermissions("system:rent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Rent rent)
	{
		startPage();
        List<Rent> list = rentService.selectRentList(rent);
		return getDataTable(list);
	}
	
	/**
	 * 新增承租项点
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存承租项点
	 */
	@RequiresPermissions("system:rent:add")
	@Log(title = "承租项点", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Rent rent)
	{		
		return toAjax(rentService.insertRent(rent));
	}

	/**
	 * 修改承租项点
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Rent rent = rentService.selectRentById(id);
		mmap.put("rent", rent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存承租项点
	 */
	@RequiresPermissions("system:rent:edit")
	@Log(title = "承租项点", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Rent rent)
	{		
		return toAjax(rentService.updateRent(rent));
	}
	
	/**
	 * 删除承租项点
	 */
	@RequiresPermissions("system:rent:remove")
	@Log(title = "承租项点", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(rentService.deleteRentByIds(ids));
	}

	/**
	 * 查看承租项点详情
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Rent rent = rentService.selectRentById(id);
		mmap.put("rent", rent);
		return prefix + "/detail";
	}
	
}
