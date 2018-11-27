package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

/**
 * 承租项点与年度考核表 sys_rent_assessment
 * 
 * @author cmf
 * @date 2018-11-24
 */
public class RentAssessment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 承租项点ID */
	private Integer rentId;
	/** 年度考核ID */
	private Integer assessmentId;

	public void setRentId(Integer rentId)
	{
		this.rentId = rentId;
	}

	public Integer getRentId(Integer integer)
	{
		return rentId;
	}
	public void setAssessmentId(Integer assessmentId)
	{
		this.assessmentId = assessmentId;
	}

	public Integer getAssessmentId()
	{
		return assessmentId;
	}

	@Override
	public String toString() {
		return "RentAssessment{" +
				"rentId=" + rentId +
				", assessmentId=" + assessmentId +
				'}';
	}
}
