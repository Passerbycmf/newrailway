package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

/**
 * 常规安全表 sys_regular_security_information
 * 
 * @author cmf
 * @date 2018-10-23
 */
public class RegularSecurityInformation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 合同id */
	private Integer contractid;
	/** 安全协议扫描件 */
	private String securityprotocolscans;
	/** 风险问题描述 */
	private String description;
	/** 安全等级 */
	private String level;
	/** 消防器材设施配备情况 */
	private String fireequipment;
	/** 用电容量 */
	private String electricalcapacity;
	/** 年度考核 */
	private String annualassessment;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setContractid(Integer contractid) 
	{
		this.contractid = contractid;
	}

	public Integer getContractid() 
	{
		return contractid;
	}
	public void setSecurityprotocolscans(String securityprotocolscans) 
	{
		this.securityprotocolscans = securityprotocolscans;
	}

	public String getSecurityprotocolscans() 
	{
		return securityprotocolscans;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setLevel(String level) 
	{
		this.level = level;
	}

	public String getLevel() 
	{
		return level;
	}
	public void setFireequipment(String fireequipment) 
	{
		this.fireequipment = fireequipment;
	}

	public String getFireequipment() 
	{
		return fireequipment;
	}
	public void setElectricalcapacity(String electricalcapacity) 
	{
		this.electricalcapacity = electricalcapacity;
	}

	public String getElectricalcapacity() 
	{
		return electricalcapacity;
	}
	public void setAnnualassessment(String annualassessment) 
	{
		this.annualassessment = annualassessment;
	}

	public String getAnnualassessment() 
	{
		return annualassessment;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contractid", getContractid())
            .append("securityprotocolscans", getSecurityprotocolscans())
            .append("description", getDescription())
            .append("level", getLevel())
            .append("fireequipment", getFireequipment())
            .append("electricalcapacity", getElectricalcapacity())
            .append("annualassessment", getAnnualassessment())
            .toString();
    }
}
