package zjnu.newrailway.project.system.service;

import zjnu.newrailway.project.system.bean.Contract;

import java.util.List;

/**
 * 租凭合同 服务层
 * 
 * @author cmf
 * @date 2018-11-22
 */
public interface IContractService 
{
	/**
     * 查询租凭合同信息
     * 
     * @param id 租凭合同ID
     * @return 租凭合同信息
     */
	public Contract selectContractById(Integer id);
	
	/**
     * 查询租凭合同列表
     * 
     * @param contract 租凭合同信息
     * @return 租凭合同集合
     */
	public List<Contract> selectContractList(Contract contract);
	
	/**
     * 新增租凭合同
     * 
     * @param contract 租凭合同信息
     * @return 结果
     */
	public int insertContract(Contract contract);
	
	/**
     * 修改租凭合同
     * 
     * @param contract 租凭合同信息
     * @return 结果
     */
	public int updateContract(Contract contract);
		
	/**
     * 删除租凭合同信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteContractByIds(String ids);

	/**
	 * 查询租凭合同列表
	 *
	 * @param contract 租凭合同信息
	 * @return 租凭合同集合
	 */
    List<Contract> selectPContractList(Contract contract);
}
