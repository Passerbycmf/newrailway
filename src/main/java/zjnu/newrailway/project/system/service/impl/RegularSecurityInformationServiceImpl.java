package zjnu.newrailway.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.project.system.mapper.RegularSecurityInformationMapper;
import zjnu.newrailway.project.system.bean.RegularSecurityInformation;
import zjnu.newrailway.project.system.service.IRegularSecurityInformationService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 常规安全 服务层实现
 * 
 * @author cmf
 * @date 2018-10-23
 */
@Service
public class RegularSecurityInformationServiceImpl implements IRegularSecurityInformationService 
{
	@Autowired
	private RegularSecurityInformationMapper regularSecurityInformationMapper;

	/**
     * 查询常规安全信息
     * 
     * @param id 常规安全ID
     * @return 常规安全信息
     */
    @Override
	public RegularSecurityInformation selectRegularSecurityInformationById(Integer id)
	{
	    return regularSecurityInformationMapper.selectRegularSecurityInformationById(id);
	}
	
	/**
     * 查询常规安全列表
     * 
     * @param regularSecurityInformation 常规安全信息
     * @return 常规安全集合
     */
	@Override
	public List<RegularSecurityInformation> selectRegularSecurityInformationList(RegularSecurityInformation regularSecurityInformation)
	{
	    return regularSecurityInformationMapper.selectRegularSecurityInformationList(regularSecurityInformation);
	}
	
    /**
     * 新增常规安全
     * 
     * @param regularSecurityInformation 常规安全信息
     * @return 结果
     */
	@Override
	public int insertRegularSecurityInformation(RegularSecurityInformation regularSecurityInformation)
	{
	    return regularSecurityInformationMapper.insertRegularSecurityInformation(regularSecurityInformation);
	}
	
	/**
     * 修改常规安全
     * 
     * @param regularSecurityInformation 常规安全信息
     * @return 结果
     */
	@Override
	public int updateRegularSecurityInformation(RegularSecurityInformation regularSecurityInformation)
	{
	    return regularSecurityInformationMapper.updateRegularSecurityInformation(regularSecurityInformation);
	}

	/**
     * 删除常规安全对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRegularSecurityInformationByIds(String ids)
	{
		return regularSecurityInformationMapper.deleteRegularSecurityInformationByIds(Convert.toStrArray(ids));
	}
	
}
