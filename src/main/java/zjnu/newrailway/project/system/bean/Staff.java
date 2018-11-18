package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.aspectj.lang.annotation.Excel;
import zjnu.newrailway.framework.web.BaseEntity;

import java.util.Arrays;
import java.util.Date;

/**
 * 公司员工表 sys_staff
 * 
 * @author cmf
 * @date 2018-11-16
 */
public class Staff extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 员工staffId */
	@Excel(name = "员工序号")
	private Integer staffId;
	/** 员工编号 */
	@Excel(name = "员工编号")
	private Integer staffNumber;
	/** 员工姓名 */
	@Excel(name ="员工姓名")
	private String staffName;
	/** 员工性别 */
	@Excel(name = "员工性别")
	private String staffSex;
	/** 联系电话 */
	@Excel(name = "员工电话")
	private String staffPhone;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 部门编号 */
	private Integer deptId;
	/** 员工状态（0正常 1停用） */
	@Excel(name = "员工状态")
	private String status;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;
	/** 备注 */
	@Excel(name = "备注")
	private String remark;
	/** 岗位组 */
	private Integer[] postIds;
	/** 部门父ID */
	private Integer parentId;
	/** 部门对象 */
	private Dept dept;

	public void setStaffId(Integer staffId)
	{
		this.staffId = staffId;
	}

	public Integer getStaffId()
	{
		return staffId;
	}
	public void setStaffNumber(Integer staffNumber) 
	{
		this.staffNumber = staffNumber;
	}

	public Integer getStaffNumber() 
	{
		return staffNumber;
	}
	public void setStaffName(String staffName) 
	{
		this.staffName = staffName;
	}

	public String getStaffName() 
	{
		return staffName;
	}
	public void setStaffSex(String staffSex) 
	{
		this.staffSex = staffSex;
	}

	public String getStaffSex() 
	{
		return staffSex;
	}
	public void setStaffPhone(String staffPhone) 
	{
		this.staffPhone = staffPhone;
	}

	public String getStaffPhone() 
	{
		return staffPhone;
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
	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}

	public Integer getDeptId() 
	{
		return deptId;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

	public Dept getDept()
	{
		return dept;
	}

	public void setDept(Dept dept)
	{
		this.dept = dept;
	}
	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public Integer[] getPostIds()
	{
		return postIds;
	}

	public void setPostIds(Integer[] postIds)
	{
		this.postIds = postIds;
	}

	@Override
	public String toString() {
		return "Staff{" +
				"staffId=" + staffId +
				", staffNumber=" + staffNumber +
				", staffName='" + staffName + '\'' +
				", staffSex='" + staffSex + '\'' +
				", staffPhone='" + staffPhone + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", deptId=" + deptId +
				", status='" + status + '\'' +
				", delFlag='" + delFlag + '\'' +
				", remark='" + remark + '\'' +
				", postIds=" + Arrays.toString(postIds) +
				", parentId=" + parentId +
				", dept=" + dept +
				'}';
	}
}
