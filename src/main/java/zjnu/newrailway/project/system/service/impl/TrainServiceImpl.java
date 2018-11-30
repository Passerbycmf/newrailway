package zjnu.newrailway.project.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.utils.Convert;
import zjnu.newrailway.project.system.bean.Train;
import zjnu.newrailway.project.system.mapper.TrainMapper;
import zjnu.newrailway.project.system.service.ITrainService;

import java.util.List;

/**
 * 培训 服务层实现
 * 
 * @author cmf
 * @date 2018-11-30
 */
@Service
public class TrainServiceImpl implements ITrainService 
{
	@Autowired
	private TrainMapper trainMapper;

	/**
     * 查询培训信息
     * 
     * @param trainId 培训ID
     * @return 培训信息
     */
    @Override
	public Train selectTrainById(Integer trainId)
	{
	    return trainMapper.selectTrainById(trainId);
	}
	
	/**
     * 查询培训列表
     * 
     * @param train 培训信息
     * @return 培训集合
     */
	@Override
	public List<Train> selectTrainList(Train train)
	{
	    return trainMapper.selectTrainList(train);
	}
	
    /**
     * 新增培训
     * 
     * @param train 培训信息
     * @return 结果
     */
	@Override
	public int insertTrain(Train train)
	{
	    return trainMapper.insertTrain(train);
	}
	
	/**
     * 修改培训
     * 
     * @param train 培训信息
     * @return 结果
     */
	@Override
	public int updateTrain(Train train)
	{
	    return trainMapper.updateTrain(train);
	}

	/**
     * 删除培训对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTrainByIds(String ids)
	{
		return trainMapper.deleteTrainByIds(Convert.toStrArray(ids));
	}
	
}
