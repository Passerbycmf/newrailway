package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;
import java.util.Date;

/**
 * 汽车基地经营管理表 sys_car
 * 
 * @author cmf
 * @date 2018-11-23
 */
public class Car extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 创建时间 */
	private Date crTime;
	/**  */
	private Date upTime;
	/** 汽车到达数 */
	private Integer numberArrive;
	/** 汽车服务费 */
	private Integer serviceCharge;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCrTime(Date crTime) 
	{
		this.crTime = crTime;
	}

	public Date getCrTime() 
	{
		return crTime;
	}
	public void setUpTime(Date upTime) 
	{
		this.upTime = upTime;
	}

	public Date getUpTime() 
	{
		return upTime;
	}
	public void setNumberArrive(Integer numberArrive) 
	{
		this.numberArrive = numberArrive;
	}

	public Integer getNumberArrive() 
	{
		return numberArrive;
	}
	public void setServiceCharge(Integer serviceCharge) 
	{
		this.serviceCharge = serviceCharge;
	}

	public Integer getServiceCharge() 
	{
		return serviceCharge;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("crTime", getCrTime())
            .append("upTime", getUpTime())
            .append("numberArrive", getNumberArrive())
            .append("serviceCharge", getServiceCharge())
            .toString();
    }
}
