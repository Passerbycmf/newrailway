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
import zjnu.newrailway.project.system.bean.Assessment;
import zjnu.newrailway.project.system.bean.Rent;
import zjnu.newrailway.project.system.service.IAssessmentService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;
import zjnu.newrailway.project.system.service.IRentService;

/**
 * 年度考核 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-24
 */
@Controller
@RequestMapping("/system/assessment")
public class AssessmentController extends BaseController
{
    private String prefix = "system/assessment";
	
	@Autowired
	private IAssessmentService assessmentService;

	@Autowired
	private IRentService rentService;
	
	@RequiresPermissions("system:assessment:view")
	@GetMapping()
	public String assessment()
	{
	    return prefix + "/assessment";
	}

	/**
	 * 查询承租项点列表
	 */
	@RequiresPermissions("system:assessment:list")
	@PostMapping("/listTest")
	@ResponseBody
	public TableDataInfo listTest(Rent rent)
	{
		startPage();
		List<Rent> listTest = rentService.selectRentListTest(rent);
		return getDataTable(listTest);
	}
	
	/**
	 * 查询年度考核列表
	 */
	@RequiresPermissions("system:assessment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Assessment assessment)
	{
		startPage();
        List<Assessment> list = assessmentService.selectAssessmentList(assessment);
		return getDataTable(list);
	}
	
	/**
	 * 新增年度考核
	 */
	@GetMapping("/add")
	public String add(ModelMap map)
	{
		map.put("rents", rentService.selectRentAll());
		return prefix + "/add";
	}
	
	/**
	 * 新增保存年度考核
	 */
	@RequiresPermissions("system:assessment:add")
	@Log(title = "年度考核", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Assessment assessment)
	{		
		return toAjax(assessmentService.insertAssessment(assessment));
	}

	/**
	 * 修改年度考核
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Assessment assessment = assessmentService.selectAssessmentById(id);
		mmap.put("assessment", assessment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存年度考核
	 */
	@RequiresPermissions("system:assessment:edit")
	@Log(title = "年度考核", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Assessment assessment)
	{
		return toAjax(assessmentService.updateAssessment(assessment));
	}

	/**
	 * 年度考核
	 */
	@GetMapping("/check/{id}")
	public String check(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Rent rent = rentService.selectRentById(id);
		mmap.put("rent", rent);
		Assessment assessment = assessmentService.selectAssessmentById(id);
		mmap.put("assessment",assessment);
		return prefix + "/check";
	}

	/**
	 * 保存年度考核
	 */
	@RequiresPermissions("system:assessment:edit")
	@Log(title = "年度考核", action = BusinessType.UPDATE)
	@PostMapping("/saveCheck")
	@ResponseBody
	public AjaxResult saveCheck(Assessment assessment)
	{
		return toAjax(assessmentService.updateAssessment(assessment));
	}



	/**
	 * 删除年度考核
	 */
	@RequiresPermissions("system:assessment:remove")
	@Log(title = "年度考核", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(assessmentService.deleteAssessmentByIds(ids));
	}
	
}
