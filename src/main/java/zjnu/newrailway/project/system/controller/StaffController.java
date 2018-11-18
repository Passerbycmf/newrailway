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
import zjnu.newrailway.project.system.bean.Staff;
import zjnu.newrailway.project.system.service.IPostService;
import zjnu.newrailway.project.system.service.IStaffService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 公司员工 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-16
 */
@Controller
@RequestMapping("/system/staff")
public class StaffController extends BaseController
{
    private String prefix = "system/staff";
	
	@Autowired
	private IStaffService staffService;

	@Autowired
	private IPostService postService;
	
	@RequiresPermissions("system:staff:view")
	@GetMapping()
	public String staff()
	{
	    return prefix + "/staff";
	}
	
	/**
	 * 查询公司员工列表
	 */
	@RequiresPermissions("system:staff:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Staff staff)
	{
		startPage();
        List<Staff> list = staffService.selectStaffList(staff);
		return getDataTable(list);
	}
	
	/**
	 * 新增公司员工
	 */
	@GetMapping("/add")
	public String add(ModelMap map)
	{
		map.put("posts", postService.selectPostAll());
		return prefix + "/add";
	}
	
	/**
	 * 新增保存公司员工
	 */
	@RequiresPermissions("system:staff:add")
	@Log(title = "公司员工", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Staff staff)
	{		

		return toAjax(staffService.insertStaff(staff));
	}

	/**
	 * 修改公司员工
	 */
	@GetMapping("/edit/{staffId}")
	public String edit(@PathVariable("staffId") Integer staffId, ModelMap mmap)
	{
		Staff staff = staffService.selectStaffById(staffId);
		mmap.put("staff", staff);
		mmap.put("posts", postService.selectPostsByStaffId(staffId));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公司员工
	 */
	@RequiresPermissions("system:staff:edit")
	@Log(title = "公司员工", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Staff staff)
	{		
		return toAjax(staffService.updateStaff(staff));
	}
	
	/**
	 * 删除公司员工
	 */
	@RequiresPermissions("system:staff:remove")
	@Log(title = "公司员工", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(staffService.deleteStaffByIds(ids));
	}
	
}
