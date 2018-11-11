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
import zjnu.newrailway.project.system.bean.DevelopProjects;
import zjnu.newrailway.project.system.bean.model.TestDevelop;
import zjnu.newrailway.project.system.service.IDevelopProjectsService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 开发项目 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/system/developProjects")
public class DevelopProjectsController extends BaseController
{
    private String prefix = "system/developProjects";
	
	@Autowired
	private IDevelopProjectsService developProjectsService;
	
	@RequiresPermissions("system:developProjects:view")
	@GetMapping()
	public String developProjects()
	{
	    return prefix + "/developProjects";
	}
	
	/**
	 * 查询开发项目列表
	 */
	@RequiresPermissions("system:developProjects:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(DevelopProjects developProjects)
	{
		startPage();
        List<DevelopProjects> list = developProjectsService.selectDevelopProjectsList(developProjects);
		return getDataTable(list);
	}
	
	/**
	 * 新增开发项目
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存开发项目
	 */
	@RequiresPermissions("system:developProjects:add")
	@Log(title = "开发项目", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(DevelopProjects developProjects)
	{		
		return toAjax(developProjectsService.insertDevelopProjects(developProjects));
	}

	/**
	 * 修改开发项目
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		DevelopProjects developProjects = developProjectsService.selectDevelopProjectsById(id);
		mmap.put("developProjects", developProjects);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存开发项目
	 */
	@RequiresPermissions("system:developProjects:edit")
	@Log(title = "开发项目", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(DevelopProjects developProjects)
	{		
		return toAjax(developProjectsService.updateDevelopProjects(developProjects));
	}
	
	/**
	 * 删除开发项目
	 */
	@RequiresPermissions("system:developProjects:remove")
	@Log(title = "开发项目", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(developProjectsService.deleteDevelopProjectsByIds(ids));
	}

	/**
	 * 查看详情
	 * @param id
	 * @param map
	 * @return
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, ModelMap map)
	{
		DevelopProjects developProjects = developProjectsService.selectDevelopProjectsById(id);
		map.put("developProjects", developProjects);
		return prefix + "/detail";
	}

	/**
	 * 新增相应资产名称的开发项目
	 * @return
	 */
	@GetMapping("/toAdd")
	public String toAdd(){
		return prefix + "/developAdd";
	}

    /**
     *  资产名称写死
     * @param testDevelop
     * @return
     */
	@RequestMapping("/addDevelop")
	@ResponseBody
	public AjaxResult addDevelop(TestDevelop testDevelop){
		return toAjax(developProjectsService.addDevelop(testDevelop));
	}

	/**
	 * 查看相应资产名称的施工进度
	 * @param id
	 * @param map
	 * @return
	 */
	@GetMapping("/progress/{id}")

	public String progress(@PathVariable("id")Integer id,ModelMap map){
		DevelopProjects developProjects = developProjectsService.selectDevelopProjectsById(id);
		map.put("developProjects",developProjects);
		return prefix + "/progressList";
	}

	/**
	 * 新增某个资产的一个开发项目的施工进度
	 * @return
	 */
	@GetMapping("/toAddProgress")
	public String toAddProgress(){
		return  prefix + "/addProgress";
	}
}
