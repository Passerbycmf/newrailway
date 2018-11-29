package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;
import java.util.Date;

/**
 * 收款表 sys_gather
 * 
 * @author cmf
 * @date 2018-11-28
 */
public class Gather extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 收款ID */
	private Integer id;
	/** 合同ID */
	private Integer contractId;
	/** 金额 */
	private String total;
	/** 凭证号 */
	private Integer gatherNumber;
	/** 收款时间 */
	private Date gatherTime;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setContractId(Integer contractId) 
	{
		this.contractId = contractId;
	}

	public Integer getContractId() 
	{
		return contractId;
	}
	public void setTotal(String total) 
	{
		this.total = total;
	}

	public String getTotal() 
	{
		return total;
	}
	public void setGatherNumber(Integer gatherNumber) 
	{
		this.gatherNumber = gatherNumber;
	}

	public Integer getGatherNumber() 
	{
		return gatherNumber;
	}
	public void setGatherTime(Date gatherTime) 
	{
		this.gatherTime = gatherTime;
	}

	public Date getGatherTime() 
	{
		return gatherTime;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contractId", getContractId())
            .append("total", getTotal())
            .append("gatherNumber", getGatherNumber())
            .append("gatherTime", getGatherTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
