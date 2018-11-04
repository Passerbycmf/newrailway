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
import zjnu.newrailway.project.system.bean.AssetInfo;
import zjnu.newrailway.project.system.service.IAssetInfoService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;

/**
 * 资产 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-28
 */
@Controller
@RequestMapping("/system/assetInfo")
public class AssetInfoController extends BaseController
{
    private String prefix = "system/assetInfo";
	
	@Autowired
	private IAssetInfoService assetInfoService;
	
	@RequiresPermissions("system:assetInfo:view")
	@GetMapping()
	public String assetInfo()
	{
	    return prefix + "/assetInfo";
	}
	
	/**
	 * 查询资产列表
	 */
	@RequiresPermissions("system:assetInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AssetInfo assetInfo)
	{
		startPage();
        List<AssetInfo> list = assetInfoService.selectAssetInfoList(assetInfo);
		return getDataTable(list);
	}
	
	/**
	 * 新增资产
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存资产
	 */
	@RequiresPermissions("system:assetInfo:add")
	@Log(title = "资产", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AssetInfo assetInfo)
	{		
		return toAjax(assetInfoService.insertAssetInfo(assetInfo));
	}

	/**
	 * 修改资产
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		AssetInfo assetInfo = assetInfoService.selectAssetInfoById(id);
		mmap.put("assetInfo", assetInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资产
	 */
	@RequiresPermissions("system:assetInfo:edit")
	@Log(title = "资产", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AssetInfo assetInfo)
	{		
		return toAjax(assetInfoService.updateAssetInfo(assetInfo));
	}
	
	/**
	 * 删除资产
	 */
	@RequiresPermissions("system:assetInfo:remove")
	@Log(title = "资产", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(assetInfoService.deleteAssetInfoByIds(ids));
	}

	/**
	 * 校检资产类型
	 * @param assetInfo
	 */
	@PostMapping("/checkType")
	@ResponseBody
	public String checkType(AssetInfo assetInfo){
		String uniqueFlag = "0";
		if(StringUtils.isNotNull(assetInfo)){
			uniqueFlag = assetInfoService.checkType(assetInfo);
		}
		return uniqueFlag;
	}
	
}
