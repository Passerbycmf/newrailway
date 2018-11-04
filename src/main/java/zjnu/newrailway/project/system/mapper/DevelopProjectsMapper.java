package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.DevelopProjects;
import java.util.List;	

/**
 * 开发项目 数据层
 * 
 * @author cmf
 * @date 2018-11-01
 */
public interface DevelopProjectsMapper 
{
	/**
     * 查询开发项目信息
     * 
     * @param id 开发项目ID
     * @return 开发项目信息
     */
	public DevelopProjects selectDevelopProjectsById(Integer id);
	
	/**
     * 查询开发项目列表
     * 
     * @param developProjects 开发项目信息
     * @return 开发项目集合
     */
	public List<DevelopProjects> selectDevelopProjectsList(DevelopProjects developProjects);
	
	/**
     * 新增开发项目
     * 
     * @param developProjects 开发项目信息
     * @return 结果
     */
	public int insertDevelopProjects(DevelopProjects developProjects);
	
	/**
     * 修改开发项目
     * 
     * @param developProjects 开发项目信息
     * @return 结果
     */
	public int updateDevelopProjects(DevelopProjects developProjects);
	
	/**
     * 删除开发项目
     * 
     * @param id 开发项目ID
     * @return 结果
     */
	public int deleteDevelopProjectsById(Integer id);
	
	/**
     * 批量删除开发项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDevelopProjectsByIds(String[] ids);
	
}