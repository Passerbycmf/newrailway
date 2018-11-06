package zjnu.newrailway.project.system.bean.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

import java.util.Date;

/**
 * 修缮项目表 sys_repair_projects
 * 
 * @author cmf
 * @date 2018-11-01
 */
public class TestRepair extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 序号 */
	private Integer id;
	/** 资产名称*/
	private String assetName;
	/** 资产编号 */
	private Integer repairNumber;
	/** 改造修缮名称 */
	private String repairName;
	/** 改造修缮方案 */
	private String repairPlan;
	/** 开始时间 */
	private String  startTime;
	/** 结束时间 */
	private String  finshTime;
	/** 施工单位 */
	private String constructionUnit;
	/** 预决算 */
	private String budget;
	/** 改造前照片 */
	private String prePicture;
	/** 改造后照片 */
	private String picture;
	/**资产类型*/
	private Integer difference;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Integer getId()
	{
		return id;
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
	public void setStartTime(String  startTime)
	{
		this.startTime = startTime;
	}

	public String  getStartTime()
	{
		return startTime;
	}
	public void setFinshTime(String  finshTime)
	{
		this.finshTime = finshTime;
	}

	public String  getFinshTime()
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

	public Integer getDifference() {
		return difference;
	}

	public void setDifference(Integer difference) {
		this.difference = difference;
	}
}
