package zjnu.newrailway.project.system.service;

import zjnu.newrailway.project.system.bean.Train;
import zjnu.newrailway.project.system.bean.model.TestTrain;

import java.util.List;

/**
 * 培训 服务层
 * 
 * @author cmf
 * @date 2018-11-30
 */
public interface ITrainService 
{
	/**
     * 查询培训信息
     * 
     * @param trainId 培训ID
     * @return 培训信息
     */
	public Train selectTrainById(Integer trainId);
	
	/**
     * 查询培训列表
     * 
     * @param train 培训信息
     * @return 培训集合
     */
	public List<TestTrain> selectTrainList(Train train);
	
	/**
     * 新增培训
     * 
     * @param train 培训信息
     * @return 结果
     */
	public int insertTrain(TestTrain train);
	
	/**
     * 修改培训
     * 
     * @param train 培训信息
     * @return 结果
     */
	public int updateTrain(TestTrain train);
		
	/**
     * 删除培训信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTrainByIds(String ids);
	
}
