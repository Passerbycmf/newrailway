package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.RegularSecurityInformation;
import java.util.List;	

/**
 * 常规安全 数据层
 * 
 * @author cmf
 * @date 2018-10-23
 */
public interface RegularSecurityInformationMapper 
{
	/**
     * 查询常规安全信息
     * 
     * @param id 常规安全ID
     * @return 常规安全信息
     */
	public RegularSecurityInformation selectRegularSecurityInformationById(Integer id);
	
	/**
     * 查询常规安全列表
     * 
     * @param regularSecurityInformation 常规安全信息
     * @return 常规安全集合
     */
	public List<RegularSecurityInformation> selectRegularSecurityInformationList(RegularSecurityInformation regularSecurityInformation);
	
	/**
     * 新增常规安全
     * 
     * @param regularSecurityInformation 常规安全信息
     * @return 结果
     */
	public int insertRegularSecurityInformation(RegularSecurityInformation regularSecurityInformation);
	
	/**
     * 修改常规安全
     * 
     * @param regularSecurityInformation 常规安全信息
     * @return 结果
     */
	public int updateRegularSecurityInformation(RegularSecurityInformation regularSecurityInformation);
	
	/**
     * 删除常规安全
     * 
     * @param id 常规安全ID
     * @return 结果
     */
	public int deleteRegularSecurityInformationById(Integer id);
	
	/**
     * 批量删除常规安全
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRegularSecurityInformationByIds(String[] ids);
	
}