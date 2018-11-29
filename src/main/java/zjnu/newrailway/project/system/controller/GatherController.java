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
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.project.system.bean.Gather;
import zjnu.newrailway.project.system.bean.model.TestGather;
import zjnu.newrailway.project.system.service.IGatherService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 收款 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-28
 */
@Controller
@RequestMapping("/system/gather")
public class GatherController extends BaseController
{
    private String prefix = "system/gather";
	
	@Autowired
	private IGatherService gatherService;
	
	@RequiresPermissions("system:gather:view")
	@GetMapping()
	public String gather()
	{
	    return prefix + "/gather";
	}
	
	/**
	 * 查询收款列表
	 */
	@RequiresPermissions("system:gather:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Gather gather)
	{
		startPage();
        List<Gather> list = gatherService.selectGatherList(gather);
		return getDataTable(list);
	}

	/**
	 * 查看详情
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Gather gather = gatherService.selectGatherById(id);
		mmap.put("gather",gather);
		return prefix + "/detail";
	}

	/**
	 * 新增收款
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	/**
	 * 新增保存收款
	 */
	@RequiresPermissions("system:gather:add")
	@Log(title = "收款", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TestGather testGather)
	{		
		return toAjax(gatherService.insertGather(testGather));
	}

	/**
	 * 修改收款
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Gather gather = gatherService.selectGatherById(id);
		mmap.put("gather", gather);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存收款
	 */
	@RequiresPermissions("system:gather:edit")
	@Log(title = "收款", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TestGather testGather)
	{		
		return toAjax(gatherService.updateGather(testGather));
	}
	
	/**
	 * 删除收款
	 */
	@RequiresPermissions("system:gather:remove")
	@Log(title = "收款", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(gatherService.deleteGatherByIds(ids));
	}

	/**
	 * 校验合同ID
	 */
	@PostMapping("/checkContractID")
	@ResponseBody
	public String checkContractID(Gather gather){
		String flag = "0";
		if(StringUtils.isNotNull(gather)){
			flag = gatherService.checkContractID(gather);

		}
		return flag;
	}
}
