package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.project.system.mapper.RepairProjectsMapper;
import zjnu.newrailway.project.system.bean.RepairProjects;
import zjnu.newrailway.project.system.service.IRepairProjectsService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 修缮项目 服务层实现
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Service
public class RepairProjectsServiceImpl implements IRepairProjectsService 
{
	@Autowired
	private RepairProjectsMapper repairProjectsMapper;

	/**
     * 查询修缮项目信息
     * 
     * @param id 修缮项目ID
     * @return 修缮项目信息
     */
    @Override
	public RepairProjects selectRepairProjectsById(Integer id)
	{
	    return repairProjectsMapper.selectRepairProjectsById(id);
	}
	
	/**
     * 查询修缮项目列表
     * 
     * @param repairProjects 修缮项目信息
     * @return 修缮项目集合
     */
	@Override
	public List<RepairProjects> selectRepairProjectsList(RepairProjects repairProjects)
	{
	    return repairProjectsMapper.selectRepairProjectsList(repairProjects);
	}
	
    /**
     * 新增修缮项目
     * 
     * @param repairProjects 修缮项目信息
     * @return 结果
     */
	@Override
	public int insertRepairProjects(RepairProjects repairProjects)
	{
	    return repairProjectsMapper.insertRepairProjects(repairProjects);
	}
	
	/**
     * 修改修缮项目
     * 
     * @param repairProjects 修缮项目信息
     * @return 结果
     */
	@Override
	public int updateRepairProjects(RepairProjects repairProjects)
	{
	    return repairProjectsMapper.updateRepairProjects(repairProjects);
	}

	/**
     * 删除修缮项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRepairProjectsByIds(String ids)
	{
		return repairProjectsMapper.deleteRepairProjectsByIds(Convert.toStrArray(ids));
	}
	
}
