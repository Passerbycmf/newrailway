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
import zjnu.newrailway.project.system.bean.RepairProjects;
import zjnu.newrailway.project.system.bean.model.TestRepair;
import zjnu.newrailway.project.system.mapper.RepairProjectsMapper;
import zjnu.newrailway.project.system.service.IRepairProjectsService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 修缮项目 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/system/repairProjects")
public class RepairProjectsController extends BaseController
{
    private String prefix = "system/repairProjects";
	
	@Autowired
	private IRepairProjectsService repairProjectsService;

	@Autowired
	private RepairProjectsMapper repairProjectsMapper;
	
	@RequiresPermissions("system:repairProjects:view")
	@GetMapping()
	public String repairProjects()
	{
	    return prefix + "/repairProjects";
	}
	
	/**
	 * 查询修缮项目列表
	 */
	@RequiresPermissions("system:repairProjects:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(RepairProjects repairProjects)
	{
		startPage();
        List<RepairProjects> list = repairProjectsService.selectRepairProjectsList(repairProjects);
		return getDataTable(list);
	}
	
	/**
	 * 新增修缮项目
	 */
	@GetMapping("/add")
	public String add()
	{
		return prefix + "/add";
	}
	
	/**
	 * 新增保存修缮项目
	 */
	@RequiresPermissions("system:repairProjects:add")
	@Log(title = "修缮项目", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(RepairProjects repairProjects)
	{

		return toAjax(repairProjectsService.insertRepairProjects(repairProjects));
	}

	/**
	 * 添加修缮信息
	 * @param testRepair
	 * @return
	 */
	@RequestMapping("/testAdd")
	@ResponseBody
	public AjaxResult testAdd(TestRepair testRepair) {
		return toAjax(repairProjectsService.addTest(testRepair));
	}

	/**
	 * 土地新增相应资产名称的修缮项目
	 */
	@GetMapping("/toAdd")
	public String toAdd()
	{
		return prefix + "/repairAdd";
	}

	/**
	 * 房屋新增相应资产名称的修缮项目
	 */
	@GetMapping("/toHouseAdd")
	public String toHouseAdd()
	{
		return prefix + "/repairHouseAdd";
	}

	/**
	 * 土地资产名称写死
	 * @param testRepair
	 * @return
	 */
	@RequestMapping("/addRepair")
	@ResponseBody
	public AjaxResult addRepair(TestRepair testRepair){
		return toAjax(repairProjectsService.addRepair(testRepair));
	}

	/**
	 * 房屋资产名称写死
	 * @param testRepair
	 * @return
	 */
	@RequestMapping("/addRepairHouse")
	@ResponseBody
	public AjaxResult addRepairHouse(TestRepair testRepair){
		return toAjax(repairProjectsService.addRepairHouse(testRepair));
	}

	/**
	 * 修改修缮项目
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		RepairProjects repairProjects = repairProjectsService.selectRepairProjectsById(id);
		mmap.put("repairProjects", repairProjects);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存修缮项目
	 */
	@RequiresPermissions("system:repairProjects:edit")
	@Log(title = "修缮项目", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TestRepair testRepair)
	{		
		return toAjax(repairProjectsService.updateRepairProjects(testRepair));
	}
	
	/**
	 * 删除修缮项目
	 */
	@RequiresPermissions("system:repairProjects:remove")
	@Log(title = "修缮项目", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(repairProjectsService.deleteRepairProjectsByIds(ids));
	}

	/**
	 * 查看详情
	 * @param id
	 * @param mmap
	 * @return
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, ModelMap mmap)
	{
		RepairProjects repairProjects = repairProjectsService.selectRepairProjectsById(id);
		mmap.put("repairProjects", repairProjects);
		return prefix + "/detail";
	}

	/**
	 * 新增修缮项目改造前图片
	 */
	@GetMapping("/addToPicture")
	public String addToPicture()
	{
		return prefix + "/addToPicture";
	}

}
