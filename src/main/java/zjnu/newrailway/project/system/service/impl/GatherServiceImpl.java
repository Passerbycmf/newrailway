package zjnu.newrailway.project.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.project.system.bean.model.ListGather;
import zjnu.newrailway.project.system.bean.model.TestGather;
import zjnu.newrailway.project.system.mapper.GatherMapper;
import zjnu.newrailway.project.system.bean.Gather;
import zjnu.newrailway.project.system.service.IGatherService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 收款 服务层实现
 * 
 * @author cmf
 * @date 2018-11-28
 */
@Service
public class GatherServiceImpl implements IGatherService 
{
	@Autowired
	private GatherMapper gatherMapper;

	/**
     * 查询收款信息
     * 
     * @param id 收款ID
     * @return 收款信息
     */
    @Override
	public Gather selectGatherById(Integer id)
	{
	    return gatherMapper.selectGatherById(id);
	}
	
	/**
     * 查询收款列表
     * 
     * @param gather 收款信息
     * @return 收款集合
     */
	@Override
	public List<ListGather> selectGatherList(Gather gather)
	{
	    return gatherMapper.selectGatherList(gather);
	}
	
    /**
     * 新增收款
     * 
     * @param gather 收款信息
     * @return 结果
     */
	@Override
	public int insertGather(TestGather gather)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		gather.setCreateTime(dateFormat.format(new Date()));
		return gatherMapper.insertGather(gather);
	}
	
	/**
     * 修改收款
     * 
     * @param testGather 收款信息
     * @return 结果
     */
	@Override
	public int updateGather(TestGather testGather)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		testGather.setUpdateTime(df.format(new Date()));
		return gatherMapper.updateGather(testGather);
	}

	/**
     * 删除收款对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGatherByIds(String ids)
	{
		return gatherMapper.deleteGatherByIds(Convert.toStrArray(ids));
	}

	/**
	 * 校验合同ID
	 * @param gather
	 * @return
	 */
    @Override
    public String checkContractID(Gather gather) {
       Gather management = gatherMapper.checkContractID(gather.getContractId());
       if (StringUtils.isNotNull(management)){
       	return UserConstants.TYPE_NOT_UNIQUE;
	   }
	   return UserConstants.TYPE_UNIQUE;
    }


}
