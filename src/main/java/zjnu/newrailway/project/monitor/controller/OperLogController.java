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
import zjnu.newrailway.project.monitor.bean.OperLog;
import zjnu.newrailway.project.monitor.service.IOperLogService;


import java.util.List;

/**
 * 操作日志记录 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-09
 */
@Controller
@RequestMapping("/monitor/operlog")
public class OperLogController extends BaseController
{
    private String prefix = "monitor/operLog";
	
	@Autowired
	private IOperLogService operLogService;
	
	@RequiresPermissions("monitor:operlog:view")
	@GetMapping()
	public String operLog()
	{
	    return prefix + "/operLog";
	}
	
	/**
	 * 查询操作日志记录列表
	 */
	@RequiresPermissions("monitor:operlog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OperLog operLog)
	{
		startPage();
        List<OperLog> list = operLogService.selectOperLogList(operLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增操作日志记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存操作日志记录
	 */
	@RequiresPermissions("monitor:operlog:add")
	@Log(title = "操作日志记录", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OperLog operLog)
	{		
		return toAjax(operLogService.insertOperLog(operLog));
	}

	/**
	 * 修改操作日志记录
	 */
	@GetMapping("/edit/{operId}")
	public String edit(@PathVariable("operId") Integer operId, ModelMap mmap)
	{
		OperLog operLog = operLogService.selectOperLogById(operId);
		mmap.put("operLog", operLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存操作日志记录
	 */
	@RequiresPermissions("monitor:operlog:edit")
	@Log(title = "操作日志记录", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OperLog operLog)
	{		
		return toAjax(operLogService.updateOperLog(operLog));
	}
	
	/**
	 * 删除操作日志记录
	 */
	@RequiresPermissions("monitor:operlog:remove")
	@Log(title = "操作日志记录", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(operLogService.deleteOperLogByIds(ids));
	}
	
}
