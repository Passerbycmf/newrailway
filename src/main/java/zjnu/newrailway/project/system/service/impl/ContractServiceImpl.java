package zjnu.newrailway.project.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.utils.DateUtil;
import zjnu.newrailway.project.system.bean.model.TestContract;
import zjnu.newrailway.project.system.mapper.ContractMapper;
import zjnu.newrailway.project.system.bean.Contract;
import zjnu.newrailway.project.system.service.IContractService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 租凭合同 服务层实现
 * 
 * @author cmf
 * @date 2018-11-22
 */
@Service
public class ContractServiceImpl implements IContractService 
{
	@Autowired
	private ContractMapper contractMapper;

	/**
     * 查询租凭合同信息
     * 
     * @param id 租凭合同ID
     * @return 租凭合同信息
     */
    @Override
	public Contract selectContractById(Integer id)
	{
	    return contractMapper.selectContractById(id);
	}
	
	/**
     * 查询租凭合同列表
     * 
     * @param contract 租凭合同信息
     * @return 租凭合同集合
     */
	@Override
	public List<Contract> selectContractList(Contract contract)
	{
	    return contractMapper.selectContractList(contract);
	}
	
    /**
     * 新增租凭合同
     * 
     * @param testContract 租凭合同信息
     * @return 结果
     */
	@Override
	public int insertContract(TestContract testContract)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		testContract.setBeginTime(df.format(new Date()));
	    return contractMapper.insertContract(testContract);
	}

	/**
	 * 修改租凭合同
	 *
	 * @param testContract 租凭合同信息
	 * @return 结果
	 */
	@Override
	public int updateContract(TestContract testContract)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		testContract.setBeginTime(df.format(new Date()));
		return contractMapper.updateContract(testContract);
	}

	/**
     * 删除租凭合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteContractByIds(String ids)
	{
		return contractMapper.deleteContractByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询租凭合同列表
	 *
	 * @param contract 租凭合同信息
	 * @return 租凭合同集合
	 */
	@Override
	public List<Contract> selectPContractList(Contract contract) {

		return contractMapper.selectPContractList(contract);
	}



}
