package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.Assessment;

import java.util.List;

/**
 * 年度考核 数据层
 * 
 * @author cmf
 * @date 2018-11-24
 */
public interface AssessmentMapper 
{
	/**
     * 查询年度考核信息
     * 
     * @param assessmentId 年度考核ID
     * @return 年度考核信息
     */
	public Assessment selectAssessmentById(Integer assessmentId);
	
	/**
     * 查询年度考核列表
     * 
     * @param assessment 年度考核信息
     * @return 年度考核集合
     */
	public List<Assessment> selectAssessmentList(Assessment assessment);
	
	/**
     * 新增年度考核
     * 
     * @param assessment 年度考核信息
     * @return 结果
     */
	public int insertAssessment(Assessment assessment);
	
	/**
     * 修改年度考核
     * 
     * @param assessment 年度考核信息
     * @return 结果
     */
	public int updateAssessment(Assessment assessment);
	
	/**
     * 删除年度考核
     * 
     * @param assessmentId 年度考核ID
     * @return 结果
     */
	public int deleteAssessmentById(Integer assessmentId);
	
	/**
     * 批量删除年度考核
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAssessmentByIds(String[] ids);


}