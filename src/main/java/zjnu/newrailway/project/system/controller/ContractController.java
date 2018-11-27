package zjnu.newrailway.project.system.controller;

import java.util.List;

import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zjnu.newrailway.common.utils.ExcelUtil;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.project.system.bean.Contract;
import zjnu.newrailway.project.system.bean.model.TestContract;
import zjnu.newrailway.project.system.service.IContractService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 租凭合同 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-22
 */
@Controller
@RequestMapping("/system/contract")
public class ContractController extends BaseController
{
    private String prefix = "system/contract";
	
	@Autowired
	private IContractService contractService;
	
	@RequiresPermissions("system:contract:view")
	@GetMapping()
	public String contract()
	{
		return prefix + "/contract";
	}

	/**
	 * 跳转到test页面
	 * @return
	 */
	@RequiresPermissions("system:contract:view")
	@GetMapping("/test")
	public String test()
	{
		return prefix + "/test";
	}
	
	/**
	 * 查询租凭合同列表
	 */
	@RequiresPermissions("system:contract:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Contract contract)
	{
		startPage();
		List<Contract> list = contractService.selectContractList(contract);
		return getDataTable(list);
	}





	@Log(title = "承租合同管理", action = BusinessType.EXPORT)
	@RequiresPermissions("system:contract:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Contract  contract) throws Exception
	{
		try
		{
			List<Contract> list = contractService.selectContractList(contract);
			ExcelUtil<Contract> util = new ExcelUtil<>(Contract.class);
			return util.exportExcel(list, "contract");
		}
		catch (Exception e)
		{
			return error("导出Excel失败，请联系网站管理员！");
		}
	}

	/**
	 * 查看详情
	 */
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Contract contract = contractService.selectContractById(id);
		mmap.put("contract", contract);
		return prefix + "/detail";
	}

	/**
	 * 添加备注
	 * @param id
	 * @param mmap
	 * @return
	 */
	@GetMapping("/remark/{id}")
	public String remark(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Contract contract = contractService.selectContractById(id);
		mmap.put("contract", contract);
		return prefix + "/remark";
	}
	/**
	 * 新增租凭合同
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	@GetMapping("/richtext/{id}")
	public String richtext (@PathVariable("id")Integer id, Model model){
		model.addAttribute("message",id);
		model.addAttribute("name", "thymeleaf");
		return prefix+"/rich";
	}


	@GetMapping("/showRichtext/{id}")
	@ResponseBody
	public String showRichtext (@PathVariable("id")Integer id, Model model){

		return "success";
	}
	/**
	 * 新增保存租凭合同
	 */
	@RequiresPermissions("system:contract:add")
	@Log(title = "租凭合同", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TestContract testContract)
	{		
		return toAjax(contractService.insertContract(testContract));
	}

	/**
	 * 修改租凭合同
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Contract contract = contractService.selectContractById(id);
		mmap.put("contract", contract);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存租凭合同
	 */
	@RequiresPermissions("system:contract:edit")
	@Log(title = "租凭合同", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TestContract testContract)
	{
		return toAjax(contractService.updateContract(testContract));
	}
	
	/**
	 * 删除租凭合同
	 */
	@RequiresPermissions("system:contract:remove")
	@Log(title = "租凭合同", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(contractService.deleteContractByIds(ids));
	}

	@GetMapping("/hello")
	public String hello (Model model){
		System.out.println("hello");

		model.addAttribute("message","hello");
		return prefix+"/hello";
	}

	/**
	 *校检合同名称
	 */
	@PostMapping("/checkContractName")
	@ResponseBody
	public String checkContractName(Contract contract){
		String flag = "0";
		if(StringUtils.isNotNull(contract)){
			flag = contractService.checkContractName(contract);
		}
		return flag;
	}

	/**
	 *校检合同编号
	 */
	@PostMapping("/checkContractNumber")
	@ResponseBody
	public String checkAssetNumber(Contract contract){
		String flag = "0";
		if(StringUtils.isNotNull(contract)){
			flag = contractService.checkContractNumber(contract);
		}
		return flag;
	}
}
