package zjnu.newrailway.project.system.controller;

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
import zjnu.newrailway.project.system.bean.Train;
import zjnu.newrailway.project.system.service.ITrainService;

import java.util.List;

/**
 * 培训 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-30
 */
@Controller
@RequestMapping("/system/train")
public class TrainController extends BaseController
{
    private String prefix = "system/train";
	
	@Autowired
	private ITrainService trainService;
	
	@RequiresPermissions("system:train:view")
	@GetMapping()
	public String train()
	{
	    return prefix + "/pretrain";
	}

	@RequiresPermissions("system:train:view")
	@GetMapping("/train/{rentId}")
	public String trainTo(@PathVariable("rentId") Integer rentId)
	{
		return prefix + "/train";
	}
	/**
	 * 查询培训列表
	 */
	@RequiresPermissions("system:train:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Train train)
	{
		startPage();
        List<Train> list = trainService.selectTrainList(train);
		return getDataTable(list);
	}
	
	/**
	 * 新增培训
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存培训
	 */
	@RequiresPermissions("system:train:add")
	@Log(title = "培训", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Train train)
	{		
		return toAjax(trainService.insertTrain(train));
	}

	/**
	 * 修改培训
	 */
	@GetMapping("/edit/{trainId}")
	public String edit(@PathVariable("trainId") Integer trainId, ModelMap mmap)
	{
		Train train = trainService.selectTrainById(trainId);
		mmap.put("train", train);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存培训
	 */
	@RequiresPermissions("system:train:edit")
	@Log(title = "培训", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Train train)
	{		
		return toAjax(trainService.updateTrain(train));
	}
	
	/**
	 * 删除培训
	 */
	@RequiresPermissions("system:train:remove")
	@Log(title = "培训", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(trainService.deleteTrainByIds(ids));
	}
	
}
