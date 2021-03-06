package zjnu.newrailway.project.monitor.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import zjnu.newrailway.common.utils.ExcelUtil;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.project.monitor.bean.DictType;
import zjnu.newrailway.project.monitor.service.IDictTypeService;


import java.util.List;

/**
 * 数据字典信息
 * 
 * @author cmf
 */
@Controller
@RequestMapping("/monitor/dict")
public class DictTypeController extends BaseController
{
    private String prefix = "monitor/dict/type";

    @Autowired
    private IDictTypeService dictTypeService;

    @RequiresPermissions("monitor:dict:view")
    @GetMapping()
    public String dictType()
    {
        return prefix + "/type";
    }

    @PostMapping("/list")
    @RequiresPermissions("monitor:dict:list")
    @ResponseBody
    public TableDataInfo list(DictType dictType)
    {
        startPage();
        List<DictType> list = dictTypeService.selectDictTypeList(dictType);
        return getDataTable(list);
    }

    @Log(title = "字典类型", action = BusinessType.EXPORT)
    @RequiresPermissions("monitor:dict:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DictType dictType) throws Exception
    {
        try
        {
            List<DictType> list = dictTypeService.selectDictTypeList(dictType);
            ExcelUtil<DictType> util = new ExcelUtil<DictType>(DictType.class);
            return util.exportExcel(list, "dictType");
        }
        catch (Exception e)
        {
            return error("导出Excel失败，请联系网站管理员！");
        }
    }

    /**
     * 新增字典类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字典类型
     */
    @Log(title = "字典类型", action = BusinessType.INSERT)
    @RequiresPermissions("monitor:dict:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DictType dict)
    {
        return toAjax(dictTypeService.insertDictType(dict));
    }

    /**
     * 修改字典类型
     */
    @GetMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Integer dictId, ModelMap mmap)
    {
        mmap.put("dict", dictTypeService.selectDictTypeById(dictId));
        return prefix + "/edit";
    }

    /**
     * 修改保存字典类型
     */
    @Log(title = "字典类型", action = BusinessType.UPDATE)
    @RequiresPermissions("monitor:dict:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DictType dict)
    {
        return toAjax(dictTypeService.updateDictType(dict));
    }

    @Log(title = "字典类型", action = BusinessType.DELETE)
    @RequiresPermissions("monitor:dict:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(dictTypeService.deleteDictTypeByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 查询字典详细
     */
    @RequiresPermissions("monitor:dict:list")
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") Integer dictId, ModelMap mmap)
    {
        mmap.put("dict", dictTypeService.selectDictTypeById(dictId));
        mmap.put("dictList", dictTypeService.selectDictTypeAll());
        return "monitor/dict/data/data";
    }

    /**
     * 校验字典类型
     */
    @PostMapping("/checkDictTypeUnique")
    @ResponseBody
    public String checkDictTypeUnique(DictType dictType)
    {
        String uniqueFlag = "0";
        if (StringUtils.isNotNull(dictType))
        {
            uniqueFlag = dictTypeService.checkDictTypeUnique(dictType);
        }
        return uniqueFlag;
    }
}
