package zjnu.newrailway.project.system.mapper;

import zjnu.newrailway.project.system.bean.Contract;
import zjnu.newrailway.project.system.bean.model.TestContract;

import java.util.List;

/**
 * 租凭合同 数据层
 * 
 * @author cmf
 * @date 2018-11-22
 */
public interface ContractMapper 
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
     * @param testContract 租凭合同信息
     * @return 结果
     */
	public int insertContract(TestContract testContract);
	
	/**
     * 修改租凭合同
     * 
     * @param testContract 租凭合同信息
     * @return 结果
     */
	public int updateContract(TestContract testContract);
	
	/**
     * 删除租凭合同
     * 
     * @param id 租凭合同ID
     * @return 结果
     */
	public int deleteContractById(Integer id);
	
	/**
     * 批量删除租凭合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteContractByIds(String[] ids);

	/**
	 * 查询租凭合同列表
	 * @param contract 租凭合同信息
	 * @return 租凭合同集合
	 */
    List<Contract> selectPContractList(Contract contract);

	/**
	 *校验合同名称是否唯一
	 * @param contractName
	 * @return 结果
	 */
	public Contract checkContractName(String contractName);

	/**
	 *校验合同编号是否唯一
	 * @param contractNumber
	 * @return 结果
	 */
	public Contract checkContractNumber(Integer contractNumber);
}