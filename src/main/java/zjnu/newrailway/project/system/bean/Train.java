package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

import java.util.Date;

/**
 * 培训表 sys_train
 * 
 * @author cmf
 * @date 2018-11-30
 */
public class Train extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 培训表ID */
	private Integer trainId;
	/** 承租项点ID */
	private Integer rentId;
	/** 培训内容 */
	private String trainContent;
	/** 培训类别 */
	private String trainCategory;
	/** 培训开始时间 */
	private Date startTime;
	/** 培训结束时间 */
	private Date endTime;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
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

	public void setTrainId(Integer trainId) 
	{
		this.trainId = trainId;
	}

	public Integer getTrainId() 
	{
		return trainId;
	}
	public void setRentId(Integer rentId) 
	{
		this.rentId = rentId;
	}

	public Integer getRentId() 
	{
		return rentId;
	}
	public void setTrainContent(String trainContent) 
	{
		this.trainContent = trainContent;
	}

	public String getTrainContent() 
	{
		return trainContent;
	}
	public void setTrainCategory(String trainCategory) 
	{
		this.trainCategory = trainCategory;
	}

	public String getTrainCategory() 
	{
		return trainCategory;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
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

	@Override
	public String toString() {
		return "Train{" +
				"trainId=" + trainId +
				", rentId=" + rentId +
				", trainContent='" + trainContent + '\'' +
				", trainCategory='" + trainCategory + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", rent=" + rent +
				'}';
	}
}
