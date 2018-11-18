package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.aspectj.lang.annotation.Excel;
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

	/** 修缮项目ID */
	@Excel(name = "修缮项目ID")
	private Integer id;
	/** 资产名称 */
	@Excel(name = "资产名称")
	private String assetName;
	/** 资产编号 */
	@Excel(name = "资产编号")
	private Integer repairNumber;
	/** 改造修缮名称 */
	@Excel(name = "改造修缮名称")
	private String repairName;
	/** 改造修缮方案 */
	@Excel(name = "改造修缮方案")
	private String repairPlan;
	/** 开始时间 */
	@Excel(name = "开始时间")
	private Date beginTime;
	/** 结束时间 */
	@Excel(name = "结束时间")
	private Date endTime;
	/** 施工单位 */
	@Excel(name = "施工单位")
	private String constructionUnit;
	/** 预决算 */
	@Excel(name = "预决算")
	private String budget;
	/** 改造前照片 */
	@Excel(name = "改造前照片")
	private String prePicture;
	/** 改造后照片 */
	@Excel(name = "改造后照片")
	private String picture;
	/** 资产类别 */
	@Excel(name = "资产类别")
	private Integer difference;


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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("assetName", getAssetName())
				.append("repairNumber", getRepairNumber())
				.append("repairName", getRepairName())
				.append("repairPlan", getRepairPlan())
				.append("beginTime", getBeginTime())
				.append("endTime", getEndTime())
				.append("constructionUnit", getConstructionUnit())
				.append("budget", getBudget())
				.append("prePicture", getPrePicture())
				.append("picture", getPicture())
				.append("difference", getDifference())
				.toString();
	}
}