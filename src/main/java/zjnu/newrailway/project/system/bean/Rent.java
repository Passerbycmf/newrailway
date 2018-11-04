package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

/**
 * 承租项点表 sys_rent
 * 
 * @author cmf
 * @date 2018-11-04
 */
public class Rent extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 资产名称 */
	private String assetName;
	/** 坐落地址 */
	private String address;
	/** 承租方单位或个人名称 */
	private String rentName;
	/** 面积（平方米） */
	private String area;
	/** 承租方营业执照或个人身份证 */
	private String number;
	/** 电话号码 */
	private String telephone;
	/** 用途 */
	private String remark;

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

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assetName", getAssetName())
            .append("address", getAddress())
            .append("rentName", getRentName())
            .append("area", getArea())
            .append("number", getNumber())
            .append("telephone", getTelephone())
            .append("remark", getRemark())
            .toString();
    }
}
