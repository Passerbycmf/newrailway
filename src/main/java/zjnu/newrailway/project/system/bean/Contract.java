package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.aspectj.lang.annotation.Excel;
import zjnu.newrailway.framework.web.BaseEntity;
import java.util.Date;

/**
 * 租凭合同表 sys_contract
 * 
 * @author cmf
 * @date 2018-11-22
 */
public class Contract extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 合同ID */
	@Excel(name = "合同ID")
	private Integer id;
	/** 合同编号 */
	@Excel(name = "合同编号")
	private Integer contractNumber;
	/** 合同名称 */
	@Excel(name = "合同名称")
	private String contractName;
	/** 承租项点名称 */
	@Excel(name = "承租项点名称")
	private String rentName;
	/** 合同履行保证金（元） */
	@Excel(name = "合同履行保证金（元）")
	private String margin;
	/** 第一年合同金额 */
	@Excel(name = "第一年合同金额")
	private String firstValue;
	/** 租金支付方式 */
	@Excel(name = "租金支付方式")
	private String payment;
	/** 经办部门 */
	@Excel(name = "经办部门")
	private String department;
	/** 经办人 */
	@Excel(name = "经办人")
	private String agent;
	/** 第二年合同金额 */
	@Excel(name = "第二年合同金额")
	private String secondValue;
	/** 第三年合同金额 */
	@Excel(name = "第三年合同金额")
	private String thirdValue;
	/** 第四年合同金额 */
	@Excel(name = "第四年合同金额")
	private String forthValue;
	/** 第五年合同金额 */
	@Excel(name = "第五年合同金额")
	private String fifthValue;
	/** 合同扫描件 */
	@Excel(name = "承租项点名称")
	private String file;
	/** 合同签订时间 */
	@Excel(name = "合同签订时间")
	private Date beginTime;
	/** 合同终止情况备注 */
	@Excel(name = "合同终止情况备注")
	private String terminationRemark;
	/** 租金无法如期收取备注 */
	@Excel(name = "租金无法如期收取备注")
	private String paymentRemark;
	/** 法律纠纷备注 */
	@Excel(name = "法律纠纷备注")
	private String lawRemark;
	/** 其他情况备注 */
	@Excel(name = "其他情况备注")
	private String remark;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 合同状态(0完成 1未完成)*/
	@Excel(name = "合同状态(0完成 1未完成)")
	private String status;
	/** 承租项点编号 */
	private Integer rentId;
	/** 承租项点对象 */
	private Rent rent;

	public Rent getRent()
	{
		return rent;
	}

	public void setRent(Rent rent)
	{
		this.rent = rent;
	}

	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setContractNumber(Integer contractNumber) 
	{
		this.contractNumber = contractNumber;
	}

	public Integer getContractNumber() 
	{
		return contractNumber;
	}
	public void setContractName(String contractName) 
	{
		this.contractName = contractName;
	}

	public String getContractName() 
	{
		return contractName;
	}
	public void setRentName(String rentName) 
	{
		this.rentName = rentName;
	}

	public String getRentName() 
	{
		return rentName;
	}
	public void setMargin(String margin) 
	{
		this.margin = margin;
	}

	public String getMargin() 
	{
		return margin;
	}
	public void setFirstValue(String firstValue) 
	{
		this.firstValue = firstValue;
	}

	public String getFirstValue() 
	{
		return firstValue;
	}
	public void setPayment(String payment) 
	{
		this.payment = payment;
	}

	public String getPayment() 
	{
		return payment;
	}
	public void setDepartment(String department) 
	{
		this.department = department;
	}

	public String getDepartment() 
	{
		return department;
	}
	public void setAgent(String agent) 
	{
		this.agent = agent;
	}

	public String getAgent() 
	{
		return agent;
	}
	public void setSecondValue(String secondValue) 
	{
		this.secondValue = secondValue;
	}

	public String getSecondValue() 
	{
		return secondValue;
	}
	public void setThirdValue(String thirdValue) 
	{
		this.thirdValue = thirdValue;
	}

	public String getThirdValue() 
	{
		return thirdValue;
	}
	public void setForthValue(String forthValue) 
	{
		this.forthValue = forthValue;
	}

	public String getForthValue() 
	{
		return forthValue;
	}
	public void setFifthValue(String fifthValue) 
	{
		this.fifthValue = fifthValue;
	}

	public String getFifthValue() 
	{
		return fifthValue;
	}
	public void setFile(String file) 
	{
		this.file = file;
	}

	public String getFile() 
	{
		return file;
	}
	public void setBeginTime(Date beginTime) 
	{
		this.beginTime = beginTime;
	}

	public Date getBeginTime() 
	{
		return beginTime;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public String getTerminationRemark() {
		return terminationRemark;
	}

	public void setTerminationRemark(String terminationRemark) {
		this.terminationRemark = terminationRemark;
	}

	public String getPaymentRemark() {
		return paymentRemark;
	}

	public void setPaymentRemark(String paymentRemark) {
		this.paymentRemark = paymentRemark;
	}

	public String getLawRemark() {
		return lawRemark;
	}

	public void setLawRemark(String lawRemark) {
		this.lawRemark = lawRemark;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime()
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getStatus()
	{
		return status;
	}

	@Override
	public String toString() {
		return "Contract{" +
				"id=" + id +
				", contractNumber=" + contractNumber +
				", contractName='" + contractName + '\'' +
				", rentName='" + rentName + '\'' +
				", margin='" + margin + '\'' +
				", firstValue='" + firstValue + '\'' +
				", payment='" + payment + '\'' +
				", department='" + department + '\'' +
				", agent='" + agent + '\'' +
				", secondValue='" + secondValue + '\'' +
				", thirdValue='" + thirdValue + '\'' +
				", forthValue='" + forthValue + '\'' +
				", fifthValue='" + fifthValue + '\'' +
				", file='" + file + '\'' +
				", beginTime=" + beginTime +
				", terminationRemark='" + terminationRemark + '\'' +
				", paymentRemark='" + paymentRemark + '\'' +
				", lawRemark='" + lawRemark + '\'' +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", status='" + status + '\'' +
				", rentId=" + rentId +
				", rent=" + rent +
				'}';
	}
}
