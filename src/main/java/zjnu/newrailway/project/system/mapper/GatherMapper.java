package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.Gather;
import zjnu.newrailway.project.system.bean.model.ListGather;
import zjnu.newrailway.project.system.bean.model.TestGather;

import java.util.List;

/**
 * 收款 数据层
 * 
 * @author cmf
 * @date 2018-11-28
 */
public interface GatherMapper 
{
	/**
     * 查询收款信息
     * 
     * @param id 收款ID
     * @return 收款信息
     */
	public Gather selectGatherById(Integer id);
	
	/**
     * 查询收款列表
     * 
     * @param gather 收款信息
     * @return 收款集合
     */
	public List<ListGather> selectGatherList(Gather gather);
	
	/**
     * 新增收款
     * 
     * @param gather 收款信息
     * @return 结果
     */
	public int insertGather(TestGather gather);
	
	/**
     * 修改收款
     * 
     * @param testGather 收款信息
     * @return 结果
     */
	public int updateGather(TestGather testGather);
	
	/**
     * 删除收款
     * 
     * @param id 收款ID
     * @return 结果
     */
	public int deleteGatherById(Integer id);
	
	/**
     * 批量删除收款
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGatherByIds(String[] ids);

	/**
	 * 校验合同ID
	 * @param contractId
	 * @return
	 */
    Gather checkContractID(Integer contractId);
}