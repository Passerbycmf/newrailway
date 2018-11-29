package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.aspectj.lang.annotation.Excel;
import zjnu.newrailway.framework.web.BaseEntity;

import java.util.Arrays;
import java.util.Date;

/**
 * 承租项点表 sys_rent
 * 
 * @author cmf
 * @date 2018-11-04
 */
public class Rent extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 承租项点ID*/
	@Excel(name = "承租项点ID")
	private Integer rentId;
	/** 资产名称 */
	@Excel(name = "资产名称")
	private String assetName;
	/** 坐落地址 */
	@Excel(name = "坐落地址")
	private String address;
	/** 承租方单位或个人名称 */
	@Excel(name = "承租方单位或个人名称")
	private String rentName;
	/** 面积（平方米） */
	@Excel(name = "面积（平方米）")
	private String area;
	/** 承租方营业执照或个人身份证 */
	@Excel(name = "承租方营业执照或个人身份证")
	private String number;
	/** 电话号码 */
	@Excel(name = "电话号码")
	private String telephone;
	/** 用途 */
	@Excel(name = "用途")
	private String remark;
	/** 开始时间 */
	@Excel(name = "开始时间")
	private Date createTime;
	/** 结束时间 */
	@Excel(name = "结束时间")
	private Date updateTime;
	/** 资产组 */
	private Integer[] assetIds;

	public void setRentId(Integer rentId)
	{
		this.rentId = rentId;
	}

	public Integer getRentId()
	{
		return rentId;
	}
	public void setAssetName(String assetName) 
	{
		this.assetName = assetName;
	}

	public String getAssetName() 
	{
		return assetName;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setRentName(String rentName) 
	{
		this.rentName = rentName;
	}

	public String getRentName() 
	{
		return rentName;
	}
	public void setArea(String area) 
	{
		this.area = area;
	}

	public String getArea() 
	{
		return area;
	}
	public void setNumber(String number) 
	{
		this.number = number;
	}

	public String getNumber() 
	{
		return number;
	}
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	public String getTelephone() 
	{
		return telephone;
	}

	public Integer[] getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(Integer[] assetIds) {
		this.assetIds = assetIds;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Rent{" +
				"rentId=" + rentId +
				", assetName='" + assetName + '\'' +
				", address='" + address + '\'' +
				", rentName='" + rentName + '\'' +
				", area='" + area + '\'' +
				", number='" + number + '\'' +
				", telephone='" + telephone + '\'' +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", assetIds=" + Arrays.toString(assetIds) +
				'}';
	}
}
