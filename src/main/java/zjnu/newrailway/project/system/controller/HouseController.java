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
import zjnu.newrailway.framework.web.RepairService;
import zjnu.newrailway.project.system.bean.Asset;
import zjnu.newrailway.project.system.service.IHouseService;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;
import zjnu.newrailway.project.system.service.IRepairProjectsService;

/**
 * 资产管理 信息操作处理
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/system/house")
public class HouseController extends BaseController
{
    private String prefix = "system/house";
	
	@Autowired
	private IHouseService houseService;

	@Autowired
	private IRepairProjectsService repairProjectsService;
	
	@RequiresPermissions("system:house:view")
	@GetMapping()
	public String house()
	{
	    return prefix + "/house";
	}
	
	/**
	 * 查询资产管理列表
	 */
	@RequiresPermissions("system:house:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Asset house,ModelMap map,String assetName)
	{
		startPage();
        List<Asset> list = houseService.selectHouseList(house);
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
	@RequiresPermissions("system:house:add")
	@Log(title = "资产管理", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Asset house)
	{		
		return toAjax(houseService.insertHouse(house));
	}

	/**
	 * 修改资产管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Asset house = houseService.selectHouseById(id);
		mmap.put("house", house);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资产管理
	 */
	@RequiresPermissions("system:house:edit")
	@Log(title = "资产管理", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Asset house)
	{		
		return toAjax(houseService.updateHouse(house));
	}
	
	/**
	 * 删除资产管理
	 */
	@RequiresPermissions("system:house:remove")
	@Log(title = "资产管理", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(houseService.deleteHouseByIds(ids));
	}
	/**
	 * 查看资产管理
	 */
	@GetMapping("/check/{id}")
	public String check(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Asset house = houseService.selectHouseById(id);
		mmap.put("house", house);
		return prefix + "/check";
	}
	/**
	 *校检资产名称
	 */
	@PostMapping("/checkAssetName")
	@ResponseBody
	public String checkAssetName(Asset land){
		String flag = "0";
		if(StringUtils.isNotNull(land)){
			flag = houseService.checkAssetName(land);
		}
		return flag;
	}


	/**
	 *校检资产编号
	 */
	@PostMapping("/checkAssetNumberUnique")
	@ResponseBody
	public String checkAssetNumber(Asset house){
		String flag = "0";
		if(StringUtils.isNotNull(house)){
			flag = houseService.checkAssetNumber(house);
		}
		return flag;
	}

	/**
	 * 查看修缮信息
	 * @param id
	 * @param map
	 * @return
	 */
	@GetMapping("/repair/{id}")
	public String repair(@PathVariable("id") Integer id,ModelMap map){
		map.put("repair",repairProjectsService.selectRepairProjectsById(id));
		map.put("assetList",repairProjectsService.selectRepairProjectsAll());
		return "system/house/repairList";
	}

}
