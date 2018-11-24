package zjnu.newrailway.project.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.project.system.bean.RentAssessment;
import zjnu.newrailway.project.system.mapper.AssessmentMapper;
import zjnu.newrailway.project.system.bean.Assessment;
import zjnu.newrailway.project.system.mapper.RentAssessmentMapper;
import zjnu.newrailway.project.system.service.IAssessmentService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 年度考核 服务层实现
 * 
 * @author cmf
 * @date 2018-11-24
 */
@Service
public class AssessmentServiceImpl implements IAssessmentService 
{
	@Autowired
	private AssessmentMapper assessmentMapper;

	@Autowired
	private RentAssessmentMapper rentAssessmentMapper;

	/**
     * 查询年度考核信息
     * 
     * @param id 年度考核ID
     * @return 年度考核信息
     */
    @Override
	public Assessment selectAssessmentById(Integer id)
	{

	    return assessmentMapper.selectAssessmentById(id);
	}
	
	/**
     * 查询年度考核列表
     * 
     * @param assessment 年度考核信息
     * @return 年度考核集合
     */
	@Override
	public List<Assessment> selectAssessmentList(Assessment assessment)
	{
	    return assessmentMapper.selectAssessmentList(assessment);
	}
	
    /**
     * 新增年度考核
     * 
     * @param assessment 年度考核信息
     * @return 结果
     */
	@Override
	public int insertAssessment(Assessment assessment)
	{
		int rows = assessmentMapper.insertAssessment(assessment);
		// 新增承租项点年度考核关联
		insertRentAssessment(assessment);
		return rows;

	}
	
	/**
     * 修改年度考核
     * 
     * @param assessment 年度考核信息
     * @return 结果
     */
	@Override
	public int updateAssessment(Assessment assessment)
	{
		return assessmentMapper.updateAssessment(assessment);
	}

	/**
	 * 添加年度考核
	 * @param assessment
	 */
	private void insertRentAssessment(Assessment assessment) {
		List<RentAssessment> list = new ArrayList<RentAssessment>();
		for (Integer rentId : assessment.getRentIds())
		{
			RentAssessment up = new RentAssessment();
			up.setAssessmentId(assessment.getId());
			up.setRentId(rentId);
			list.add(up);
		}
		if (list.size() > 0)
		{
			rentAssessmentMapper.batchRentAssessment(list);
		}
	}


	/**
     * 删除年度考核对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAssessmentByIds(String ids)
	{
		return assessmentMapper.deleteAssessmentByIds(Convert.toStrArray(ids));
	}
	
}
