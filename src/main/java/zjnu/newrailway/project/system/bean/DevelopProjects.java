package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;
import java.util.Date;

/**
 * 开发项目表 sys_develop_projects
 * 
 * @author cmf
 * @date 2018-11-01
 */
public class DevelopProjects extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Integer id;
	/** 开发名称 */
	private String developName;
	/** 开始时间 */
	private Date stratTime;
	/** 结束时间 */
	private Date endTime;
	/** 设计单位 */
	private String designUnit;
	/** 施工单位 */
	private String constructionUnit;
	/** 监理单位 */
	private String supervisionUnit;
	/** 会议纪要 */
	private String meeting;
	/** 批复文件 */
	private String approvalDocuments;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setDevelopName(String developName) 
	{
		this.developName = developName;
	}

	public String getDevelopName() 
	{
		return developName;
	}
	public void setStratTime(Date stratTime) 
	{
		this.stratTime = stratTime;
	}

	public Date getStratTime() 
	{
		return stratTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setDesignUnit(String designUnit) 
	{
		this.designUnit = designUnit;
	}

	public String getDesignUnit() 
	{
		return designUnit;
	}
	public void setConstructionUnit(String constructionUnit) 
	{
		this.constructionUnit = constructionUnit;
	}

	public String getConstructionUnit() 
	{
		return constructionUnit;
	}
	public void setSupervisionUnit(String supervisionUnit) 
	{
		this.supervisionUnit = supervisionUnit;
	}

	public String getSupervisionUnit() 
	{
		return supervisionUnit;
	}
	public void setMeeting(String meeting) 
	{
		this.meeting = meeting;
	}

	public String getMeeting() 
	{
		return meeting;
	}
	public void setApprovalDocuments(String approvalDocuments) 
	{
		this.approvalDocuments = approvalDocuments;
	}

	public String getApprovalDocuments() 
	{
		return approvalDocuments;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("developName", getDevelopName())
            .append("stratTime", getStratTime())
            .append("endTime", getEndTime())
            .append("designUnit", getDesignUnit())
            .append("constructionUnit", getConstructionUnit())
            .append("supervisionUnit", getSupervisionUnit())
            .append("meeting", getMeeting())
            .append("approvalDocuments", getApprovalDocuments())
            .toString();
    }
}
