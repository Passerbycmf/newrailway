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
import zjnu.newrailway.project.system.bean.AssetManagement;
import zjnu.newrailway.project.system.service.IAssetManagementService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 资产管理 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/system/assetManagement")
public class AssetManagementController extends BaseController
{
    private String prefix = "system/assetManagement";
	
	@Autowired
	private IAssetManagementService assetManagementService;
	
	@RequiresPermissions("system:assetManagement:view")
	@GetMapping()
	public String assetManagement()
	{
	    return prefix + "/assetManagement";
	}
	
	/**
	 * 查询资产管理列表
	 */
	@RequiresPermissions("system:assetManagement:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AssetManagement assetManagement,ModelMap map,String assetName)
	{
		startPage();
        List<AssetManagement> list = assetManagementService.selectAssetManagementList(assetManagement);
        /*是否再写一个重载方法来实现查询，还是直接改这个方法？若直接改这个方法， 传入参数为String?

		*/
        map.put("assetName",assetName);
		return getDataTable(list);
	}
	
	/**
	 * 新增资产管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存资产管理
	 */
	@RequiresPermissions("system:assetManagement:add")
	@Log(title = "资产管理", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AssetManagement assetManagement)
	{		
		return toAjax(assetManagementService.insertAssetManagement(assetManagement));
	}

	/**
	 * 修改资产管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		AssetManagement assetManagement = assetManagementService.selectAssetManagementById(id);
		mmap.put("assetManagement", assetManagement);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资产管理
	 */
	@RequiresPermissions("system:assetManagement:edit")
	@Log(title = "资产管理", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AssetManagement assetManagement)
	{		
		return toAjax(assetManagementService.updateAssetManagement(assetManagement));
	}
	
	/**
	 * 删除资产管理
	 */
	@RequiresPermissions("system:assetManagement:remove")
	@Log(title = "资产管理", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(assetManagementService.deleteAssetManagementByIds(ids));
	}
	/**
	 * 查看资产管理
	 */
	@GetMapping("/check/{id}")
	public String check(@PathVariable("id") Integer id, ModelMap mmap)
	{
		AssetManagement assetManagement = assetManagementService.selectAssetManagementById(id);
		mmap.put("assetManagement", assetManagement);
		return prefix + "/check";
	}

	/**
	 *校检资产名称
	 */
	@PostMapping("/checkAssetName")
	@ResponseBody
	public String checkAssetName(AssetManagement assetManagement){
		String flag = "0";
		if(StringUtils.isNotNull(assetManagement)){
			flag = assetManagementService.checkAssetName(assetManagement);
		}
		return flag;
	}


	/**
	 *校检资产编号
	 */
	@PostMapping("/checkAssetNumber")
	@ResponseBody
	public String checkAssetNumber(AssetManagement assetManagement){
		String flag = "0";
		if(StringUtils.isNotNull(assetManagement)){
			flag = assetManagementService.checkAssetNumber(assetManagement);
		}
		return flag;
	}
}
