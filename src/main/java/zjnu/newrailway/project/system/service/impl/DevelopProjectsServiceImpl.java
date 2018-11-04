package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.project.system.mapper.DevelopProjectsMapper;
import zjnu.newrailway.project.system.bean.DevelopProjects;
import zjnu.newrailway.project.system.service.IDevelopProjectsService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 开发项目 服务层实现
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Service
public class DevelopProjectsServiceImpl implements IDevelopProjectsService 
{
	@Autowired
	private DevelopProjectsMapper developProjectsMapper;

	/**
     * 查询开发项目信息
     * 
     * @param id 开发项目ID
     * @return 开发项目信息
     */
    @Override
	public DevelopProjects selectDevelopProjectsById(Integer id)
	{
	    return developProjectsMapper.selectDevelopProjectsById(id);
	}
	
	/**
     * 查询开发项目列表
     * 
     * @param developProjects 开发项目信息
     * @return 开发项目集合
     */
	@Override
	public List<DevelopProjects> selectDevelopProjectsList(DevelopProjects developProjects)
	{
	    return developProjectsMapper.selectDevelopProjectsList(developProjects);
	}
	
    /**
     * 新增开发项目
     * 
     * @param developProjects 开发项目信息
     * @return 结果
     */
	@Override
	public int insertDevelopProjects(DevelopProjects developProjects)
	{
	    return developProjectsMapper.insertDevelopProjects(developProjects);
	}
	
	/**
     * 修改开发项目
     * 
     * @param developProjects 开发项目信息
     * @return 结果
     */
	@Override
	public int updateDevelopProjects(DevelopProjects developProjects)
	{
	    return developProjectsMapper.updateDevelopProjects(developProjects);
	}

	/**
     * 删除开发项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDevelopProjectsByIds(String ids)
	{
		return developProjectsMapper.deleteDevelopProjectsByIds(Convert.toStrArray(ids));
	}
	
}
