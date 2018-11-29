package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

/**
 * 员工岗位关联表 sys_rent_asset
 * 
 * @author cmf
 * @date 2018-11-27
 */
public class RentAsset extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 承租项点ID */
	private String rentId;
	/** 资产ID */
	private String assetId;

	public void setRentId(String rentId) 
	{
		this.rentId = rentId;
	}

	public String getRentId() 
	{
		return rentId;
	}
	public void setAssetId(String assetId) 
	{
		this.assetId = assetId;
	}

	public String getAssetId() 
	{
		return assetId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rentId", getRentId())
            .append("assetId", getAssetId())
            .toString();
    }
}
