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
import zjnu.newrailway.project.system.bean.RegularSecurityInformation;
import zjnu.newrailway.project.system.service.IRegularSecurityInformationService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 常规安全 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-23
 */
@Controller
@RequestMapping("/system/regularSecurityInformation")
public class RegularSecurityInformationController extends BaseController
{
    private String prefix = "system/regularSecurityInformation";
	
	@Autowired
	private IRegularSecurityInformationService regularSecurityInformationService;
	
	@RequiresPermissions("system:regularSecurityInformation:view")
	@GetMapping()
	public String regularSecurityInformation()
	{
	    return prefix + "/regularSecurityInformation";
	}
	
	/**
	 * 查询常规安全列表
	 */
	@RequiresPermissions("system:regularSecurityInformation:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(RegularSecurityInformation regularSecurityInformation)
	{
		startPage();
        List<RegularSecurityInformation> list = regularSecurityInformationService.selectRegularSecurityInformationList(regularSecurityInformation);
		return getDataTable(list);
	}
	
	/**
	 * 新增常规安全
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存常规安全
	 */
	@RequiresPermissions("system:regularSecurityInformation:add")
	@Log(title = "常规安全", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(RegularSecurityInformation regularSecurityInformation)
	{		
		return toAjax(regularSecurityInformationService.insertRegularSecurityInformation(regularSecurityInformation));
	}

	/**
	 * 修改常规安全
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		RegularSecurityInformation regularSecurityInformation = regularSecurityInformationService.selectRegularSecurityInformationById(id);
		mmap.put("regularSecurityInformation", regularSecurityInformation);
	    return prefix + "/edit";
	}
	

	
	/**
	 * 删除常规安全
	 */
	@RequiresPermissions("system:regularSecurityInformation:remove")
	@Log(title = "常规安全", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(regularSecurityInformationService.deleteRegularSecurityInformationByIds(ids));
	}
	
}
