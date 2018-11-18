package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

/**
 * 员工岗位关联表 sys_staff_post
 * 
 * @author cmf
 * @date 2018-11-16
 */
public class StaffPost extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 员工ID */
	private Integer staffId;
	/** 岗位ID */
	private Integer postId;

	public void setStaffId(Integer staffId)
	{
		this.staffId = staffId;
	}

	public Integer getStaffId()
	{
		return staffId;
	}
	public void setPostId(Integer postId)
	{
		this.postId = postId;
	}

	public Integer getPostId()
	{
		return postId;
	}

	@Override
	public String toString()
	{
		return "StaffPost [staffId=" + staffId + ", postId=" + postId + "]";
	}
}
