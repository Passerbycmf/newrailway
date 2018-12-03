package zjnu.newrailway.project.system.controller;

import java.util.List;
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
import zjnu.newrailway.common.utils.ExcelUtil;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.project.system.bean.Asset;
import zjnu.newrailway.project.system.bean.RepairProjects;
import zjnu.newrailway.project.system.service.IDevelopProjectsService;
import zjnu.newrailway.project.system.service.ILandService;
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
@RequestMapping("/system/land")
public class LandController extends BaseController
{
    private String prefix = "system/land";
	
	@Autowired
	private ILandService landService;

	@Autowired
	private IRepairProjectsService repairProjectsService;

    @Autowired
	private IDevelopProjectsService developProjectsService;
	
	@RequiresPermissions("system:land:view")
	@GetMapping()
	public String land()
	{
	    return prefix + "/land";
	}
	
	/**
	 * 查询资产管理列表
	 */
	@RequiresPermissions("system:land:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Asset land, ModelMap map, String assetName)
	{
		startPage();
        List<Asset> list = landService.selectLandList(land);
        map.put("assetName",assetName);
		return getDataTable(list);
	}

	@Log(title = "土地资产管理", action = BusinessType.EXPORT)
	@RequiresPermissions("system:staff:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Asset land) throws Exception
	{
		try
		{
			List<Asset> list = landService.selectLandList(land);
			ExcelUtil<Asset> util = new ExcelUtil<>(Asset.class);
			return util.exportExcel(list, "land");
		}
		catch (Exception e)
		{
			return error("导出Excel失败，请联系网站管理员！");
		}
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
	@RequiresPermissions("system:land:add")
	@Log(title = "资产管理", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Asset land)
	{		
		return toAjax(landService.insertLand(land));
	}

	/**
	 * 修改资产管理
	 */
	@GetMapping("/edit/{assetId}")
	public String edit(@PathVariable("assetId") Integer assetId, ModelMap mmap)
	{
		Asset land = landService.selectLandById(assetId);
		mmap.put("land", land);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存资产管理
	 */
	@RequiresPermissions("system:land:edit")
	@Log(title = "资产管理", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Asset land)
	{		
		return toAjax(landService.updateLand(land));
	}
	
	/**
	 * 删除资产管理
	 */
	@RequiresPermissions("system:land:remove")
	@Log(title = "资产管理", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(landService.deleteLandByIds(ids));
	}

	/**
	 * 查看资产管理
	 */
	@GetMapping("/check/{assetId}")
	public String check(@PathVariable("assetId") Integer assetId, ModelMap mmap)
	{
		Asset land = landService.selectLandById(assetId);
		mmap.put("land", land);
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
			flag = landService.checkAssetName(land);
		}
		return flag;
	}

	/**
	 *校检资产编号
	 */
	@PostMapping("/checkAssetNumber")
	@ResponseBody
	public String checkAssetNumber(Asset land){
		String flag = "0";
		if(StringUtils.isNotNull(land)){
			flag = landService.checkAssetNumber(land);
		}
		return flag;
	}

	/**
	 * 查看修缮信息
	 * @param assetId
	 * @param map
	 * @return
	 */
	@GetMapping("/repair/{assetId}")
	public String repair(@PathVariable("assetId") Integer assetId,ModelMap map){
		if (repairProjectsService.selectRepairProjectsById(assetId)==null){
			map.put("repair",new RepairProjects());
		}else {
			map.put("repair",repairProjectsService.selectRepairProjectsById(assetId));
		}
        map.put("assetList",repairProjectsService.selectRepairProjectsAll());
		return "system/land/repairList";
	}

	/**
	 * 查看开发项目信息
	 * @param id
	 * @param map
	 * @return
	 */
	@GetMapping("/develop/{id}")
	public String develop(@PathVariable("id")Integer id,ModelMap map){
		map.put("develop",developProjectsService.selectDevelopProjectsById(id));
		map.put("developList",developProjectsService.selectDevelopProjectsAll());
		return "system/land/developList";
	}

}
