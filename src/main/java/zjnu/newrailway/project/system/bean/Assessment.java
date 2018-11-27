package zjnu.newrailway.project.system.bean;

import zjnu.newrailway.framework.web.BaseEntity;

import java.util.Arrays;

/**
 * 年度考核表 sys_assessment
 * 
 * @author cmf
 * @date 2018-11-24
 */
public class Assessment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 年度考核ID */
	private Integer assessmentId;
	/** 承租项点营业额评分 */
	private Integer businessSituation;
	/** 承租方信誉度评分 */
	private Integer credit;
	/** 承租项点受损情况 */
	private Integer damage;
	/** 承租项点组ID */
	private Integer[] rentIds;

	public void setAssessmentId(Integer assessmentId)
	{
		this.assessmentId = assessmentId;
	}

	public Integer getAssessmentId()
	{
		return assessmentId;
	}
	public void setBusinessSituation(Integer businessSituation) 
	{
		this.businessSituation = businessSituation;
	}

	public Integer getBusinessSituation() 
	{
		return businessSituation;
	}
	public void setCredit(Integer credit) 
	{
		this.credit = credit;
	}

	public Integer getCredit() 
	{
		return credit;
	}
	public void setDamage(Integer damage) 
	{
		this.damage = damage;
	}

	public Integer getDamage() 
	{
		return damage;
	}

	public Integer[] getRentIds() {
		return rentIds;
	}

	public void setRentIds(Integer[] rentIds) {
		this.rentIds = rentIds;
	}

	@Override
	public String toString() {
		return "Assessment{" +
				"assessmentId=" + assessmentId +
				", businessSituation=" + businessSituation +
				", credit=" + credit +
				", damage=" + damage +
				", rentIds=" + Arrays.toString(rentIds) +
				'}';
	}
}
