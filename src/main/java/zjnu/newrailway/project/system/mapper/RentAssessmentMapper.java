package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.RentAssessment;
import java.util.List;	

/**
 * 承租项点与年度考核 数据层
 * 
 * @author cmf
 * @date 2018-11-24
 */
public interface RentAssessmentMapper 
{
	/**
     * 查询承租项点与年度考核信息
     * 
     * @param rentId 承租项点与年度考核ID
     * @return 承租项点与年度考核信息
     */
	public RentAssessment selectRentAssessmentById(String rentId);
	
	/**
     * 查询承租项点与年度考核列表
     * 
     * @param rentAssessment 承租项点与年度考核信息
     * @return 承租项点与年度考核集合
     */
	public List<RentAssessment> selectRentAssessmentList(RentAssessment rentAssessment);
	
	/**
     * 新增承租项点与年度考核
     * 
     * @param rentAssessment 承租项点与年度考核信息
     * @return 结果
     */
	public int insertRentAssessment(RentAssessment rentAssessment);
	
	/**
     * 修改承租项点与年度考核
     * 
     * @param rentAssessment 承租项点与年度考核信息
     * @return 结果
     */
	public int updateRentAssessment(RentAssessment rentAssessment);
	
	/**
     * 删除承租项点与年度考核
     * 
     * @param rentId 承租项点与年度考核ID
     * @return 结果
     */
	public int deleteRentAssessmentById(String rentId);
	
	/**
     * 批量删除承租项点与年度考核
     * 
     * @param rentIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteRentAssessmentByIds(String[] rentIds);

	/**
	 * 添加年度考核与承租项点关联信息
	 * @param list
	 */
    int batchRentAssessment(List<RentAssessment> list);
}