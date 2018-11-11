package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;
import java.util.Date;

/**
 * 修缮项目表 sys_repair_projects
 *
 * @author cmf
 * @date 2018-11-06
 */
public class RepairProjects extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;
	/** 资产名称 */
	private String assetName;
	/** 资产编号 */
	private Integer repairNumber;
	/** 改造修缮名称 */
	private String repairName;
	/** 改造修缮方案 */
	private String repairPlan;
	/** 开始时间 */
	private Date startTime;
	/** 结束时间 */
	private Date finshTime;
	/** 施工单位 */
	private String constructionUnit;
	/** 预决算 */
	private String budget;
	/** 改造前照片 */
	private String prePicture;
	/** 改造后照片 */
	private String picture;
	/** 资产类别 */
	private Integer difference;
	/** 类别名称 */
	private String lable;

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
	public void setAssetName(String assetName)
	{
		this.assetName = assetName;
	}

	public String getAssetName()
	{
		return assetName;
	}
	public void setRepairNumber(Integer repairNumber)
	{
		this.repairNumber = repairNumber;
	}

	public Integer getRepairNumber()
	{
		return repairNumber;
	}
	public void setRepairName(String repairName)
	{
		this.repairName = repairName;
	}

	public String getRepairName()
	{
		return repairName;
	}
	public void setRepairPlan(String repairPlan)
	{
		this.repairPlan = repairPlan;
	}

	public String getRepairPlan()
	{
		return repairPlan;
	}
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getStartTime()
	{
		return startTime;
	}
	public void setFinshTime(Date finshTime)
	{
		this.finshTime = finshTime;
	}

	public Date getFinshTime()
	{
		return finshTime;
	}
	public void setConstructionUnit(String constructionUnit)
	{
		this.constructionUnit = constructionUnit;
	}

	public String getConstructionUnit()
	{
		return constructionUnit;
	}
	public void setBudget(String budget)
	{
		this.budget = budget;
	}

	public String getBudget()
	{
		return budget;
	}
	public void setPrePicture(String prePicture)
	{
		this.prePicture = prePicture;
	}

	public String getPrePicture()
	{
		return prePicture;
	}
	public void setPicture(String picture)
	{
		this.picture = picture;
	}

	public String getPicture()
	{
		return picture;
	}
	public void setDifference(Integer difference)
	{
		this.difference = difference;
	}

	public Integer getDifference()
	{
		return difference;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("assetName", getAssetName())
				.append("repairNumber", getRepairNumber())
				.append("repairName", getRepairName())
				.append("repairPlan", getRepairPlan())
				.append("startTime", getStartTime())
				.append("finshTime", getFinshTime())
				.append("constructionUnit", getConstructionUnit())
				.append("budget", getBudget())
				.append("prePicture", getPrePicture())
				.append("picture", getPicture())
				.append("difference", getDifference())
				.append("lable", getLable())
				.toString();
	}
}