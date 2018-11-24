package zjnu.newrailway.project.system.bean.model;

import zjnu.newrailway.framework.aspectj.lang.annotation.Excel;

import java.util.Date;

/**
 * @classname:
 * @description:
 * @author: daimiao
 * @date: 2018/11/24 10:44
 * @version: 1.0
 **/
public class TestContract {
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
    private String beginTime;
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
    private String  createTime;
    /** 更新时间 */
    private String updateTime;
    /** 合同状态(0完成 1未完成)*/
    @Excel(name = "合同状态(0完成 1未完成)")
    private String status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public String getThirdValue() {
        return thirdValue;
    }

    public void setThirdValue(String thirdValue) {
        this.thirdValue = thirdValue;
    }

    public String getForthValue() {
        return forthValue;
    }

    public void setForthValue(String forthValue) {
        this.forthValue = forthValue;
    }

    public String getFifthValue() {
        return fifthValue;
    }

    public void setFifthValue(String fifthValue) {
        this.fifthValue = fifthValue;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
