package zjnu.newrailway.project.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;
import zjnu.newrailway.project.system.bean.Dept;
import zjnu.newrailway.project.system.mapper.DeptMapper;
import zjnu.newrailway.project.system.service.IDeptService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 部门 信息操作处理
 * 
 * @author cmf
 * @date 2018-08-12
 */
@Controller
@RequestMapping("/system/dept")
public class DeptController extends BaseController
{
    private String prefix = "system/dept";
	
	@Autowired
	private IDeptService deptService;

	@Autowired
	private DeptMapper deptMapper;
	

	@GetMapping()
	public String dept(ModelMap modelMap)
	{
	    return prefix + "/dept";
	}
	
	/**
	 * 查询部门列表
	 */

	@GetMapping("/list")
	@ResponseBody
	public List<Dept> list(Dept dept, String deptName, ModelMap map)
	{

		List<Dept> deptList = deptService.selectDeptList(dept);
		map.put("deptName",deptName);
		return deptList;
	}


	/**
	 * 查询详情
	 * @param dictId
	 * @param mmap
	 * @return
	 */

	@GetMapping("/detail/{deptId}")
	public String detail(@PathVariable("deptId") Integer dictId, ModelMap mmap)
	{

		return prefix + "/success";
	}

	
	/**
	 * 新增部门
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") Integer parentId, ModelMap map)
	{
	    //回显父部门
		map.put("dept",deptService.selectDeptById(parentId));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存部门
	 */

	@Log(title = "部门", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Dept dept)
	{		
		return toAjax(deptService.insertDept(dept));
	}

	/**
	 * 修改部门
	 */
	@GetMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Integer deptId, ModelMap mmap)
	{
		//数据回显
		Dept dept = deptService.selectDeptById(deptId);
		mmap.put("dept", dept);
	    return prefix + "/edit";
	}
	
	/**
	 * 保存修改部门
	 */

	@Log(title = "部门", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Dept dept)
	{		
		return toAjax(deptService.updateDept(dept));
	}
	
	/**
	 * 删除部门
	 */

	@Log(title = "部门", action = BusinessType.DELETE)
	@PostMapping( "/remove/{deptId}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("deptId") Integer deptId )
	{
		if (deptService.selectDeptCount(deptId) > 0){
			return error(1,"存在下级部门，不允许删除！");
		}
		if(deptService.checkDeptExistUser(deptId)){
			return error(1,"部门存在用户，不允许删除！");
		}
		return toAjax(deptService.deleteDeptById(deptId));
	}

	/**
	 * 选择部门树(回显部门)
	 */
	@GetMapping("/selectDeptTree/{deptId}")
	public String selectDeptTree(@PathVariable("deptId") Integer deptId, ModelMap mmap)
	{
		mmap.put("treeName", deptService.selectDeptById(deptId).getDeptName());
		return prefix + "/tree";
	}

	/**
	 * 加载部门列表树
	 * @return
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Map<String,Object>> treeData(){
		List<Map<String,Object>> tree = new ArrayList<>();
		List<Dept> deptList = deptMapper.selectDeptAll();
		//遍历
		for(Dept dept : deptList){
			//部门正常状态
			if(UserConstants.DEPT_NORMAL.equals(dept.getStatus())){
				Map<String,Object> deptMap = new HashMap<>();
				deptMap.put("id", dept.getDeptId());
				deptMap.put("pId", dept.getParentId());
				deptMap.put("name", dept.getDeptName());
				deptMap.put("title", dept.getDeptName());
				tree.add(deptMap);
			}
		}
		return tree;
	}

	/**
	 * 校验部门名称
	 * @param dept
	 * @return
	 */
	@PostMapping("/checkDeptNameUnique")
	@ResponseBody
	public String checkDeptNameUnique(Dept dept){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(dept)){
			uniqueFlag = deptService.checkDeptNameUnique(dept);
		}
		return uniqueFlag;
	}



	@GetMapping("/find/{deptId}")
	public String find(@PathVariable("deptId") Integer deptId, ModelMap mmap)
	{
		//数据回显
		Dept dept = deptService.selectDeptById(deptId);
		mmap.put("dept", dept);
		return prefix + "/edit";
	}

}
