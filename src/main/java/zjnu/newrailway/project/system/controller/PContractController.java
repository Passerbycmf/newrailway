package zjnu.newrailway.project.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import zjnu.newrailway.common.utils.ExcelUtil;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.project.system.bean.Contract;
import zjnu.newrailway.project.system.bean.model.TestContract;
import zjnu.newrailway.project.system.service.IContractService;

import java.util.List;

/**
 * 租凭合同 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-22
 */
@Controller
@RequestMapping("/system/pcontract")
public class PContractController extends BaseController
{
    private String prefix = "system/pcontract";
	
	@Autowired
	private IContractService contractService;
	
	@RequiresPermissions("system:contract:view")
	@GetMapping()
	public String contract()
	{
	    return prefix + "/contract";
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
		List<TestContract> list = contractService.selectTestPContractList(contract);
		int value_1,value_2,value_3,value_4,value_5;
		for(TestContract tc : list){
			value_1 = Integer.parseInt(tc.getFirstValue());
			value_2 = Integer.parseInt(tc.getSecondValue());
			value_3 = Integer.parseInt(tc.getThirdValue());
			value_4 = Integer.parseInt(tc.getForthValue());
			value_5 = Integer.parseInt(tc.getFifthValue());
			String value = String.valueOf(value_1+value_2+value_3+value_4+value_5);
			tc.setValue(value);
		}
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
			List<Contract> list = contractService.selectPContractList(contract);
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

	/**
	 * 添加备注
	 *
	 * @param id
	 * @param map
	 * @return
	 */
	@GetMapping("/remark/{id}")
	public String remark(@PathVariable("id") Integer id, ModelMap map) {
		Contract contract = contractService.selectContractById(id);
		map.put("contract", contract);
		return prefix + "/remark";
	}
	
}
