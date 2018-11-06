package zjnu.newrailway.framework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.project.system.bean.RepairProjects;
import zjnu.newrailway.project.system.service.IRepairProjectsService;

import java.util.List;

/**
 * @classname:
 * @description:
 * @author:cmf
 * @data:on 2018/11/6 11:36
 * @version:1.0
 */
@Service("repair")
public class RepairService
{
    @Autowired
    private IRepairProjectsService repairService;

    /**
     * 根据资产名称查询数据信息
     *
     * @param assetName 字典类型
     * @return 参数键值
     */
    public List<RepairProjects> getAssetName(String assetName)
    {
        return repairService.selectRepairProjectsByAssetName(assetName);
    }


}
