package zjnu.newrailway.project.monitor.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.project.monitor.bean.Logininfor;
import zjnu.newrailway.project.monitor.service.ILogininforService;


import java.util.List;

/**
 * 系统访问记录 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-11
 */
@Controller
@RequestMapping("/monitor/logininfor")
public class LogininforController extends BaseController
{
    private String prefix = "monitor/logininfor";
	
	@Autowired
	private ILogininforService logininforService;
	
	@RequiresPermissions("monitor:logininfor:view")
	@GetMapping()
	public String logininfor()
	{
	    return prefix + "/logininfor";
	}
	
	/**
	 * 查询系统访问记录列表
	 */
	@RequiresPermissions("monitor:logininfor:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Logininfor logininfor)
	{
		startPage();
        List<Logininfor> list = logininforService.selectLogininforList(logininfor);
		return getDataTable(list);
	}
	
	/**
	 * 新增系统访问记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存系统访问记录
	 */
	@RequiresPermissions("monitor:logininfor:add")
	@Log(title = "系统访问记录", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Logininfor logininfor)
	{		
		return toAjax(logininforService.insertLogininfor(logininfor));
	}

	/**
	 * 修改系统访问记录
	 */
	@GetMapping("/edit/{infoId}")
	public String edit(@PathVariable("infoId") Integer infoId, ModelMap mmap)
	{
		Logininfor logininfor = logininforService.selectLogininforById(infoId);
		mmap.put("logininfor", logininfor);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存系统访问记录
	 */
	@RequiresPermissions("monitor:logininfor:edit")
	@Log(title = "系统访问记录", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Logininfor logininfor)
	{		
		return toAjax(logininforService.updateLogininfor(logininfor));
	}
	
	/**
	 * 删除系统访问记录
	 */
	@RequiresPermissions("monitor:logininfor:remove")
	@Log(title = "系统访问记录", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(logininforService.deleteLogininforByIds(ids));
	}
	
}
