package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.web.BaseEntity;

/**
 * 资产表 sys_asset_info
 * 
 * @author cmf
 * @date 2018-10-28
 */
public class AssetInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Integer id;
	/** 资产编号 */
	private Integer assetnumber;
	/** 资产名称 */
	private String assername;
	/** 所属派出所 */
	private String policestation;
	/** 所属消防队 */
	private String firehouse;
	/** 街道社区 */
	private String streetcommunity;
	/** 资产类别 */
	private String assettype;
	/** 资产移交手续 */
	private String transferofassets;
	/** 卫星定位 */
	private String satellitepositionimg;
	/** 房产证/土地证 */
	private String property;
	/** 航拍图 */
	private String aerialmap;
	/** 现场照片 */
	private String fieldphoto;
	/** 安全结构证明 */
	private String securitystructureproof;
	/** 侵占违建情况 */
	private String encroachmentinfo;
	/** 历史遗留问题 */
	private String historylegacy;
	/** 改造修缮项目（外键） */
	private Integer renovationprojectid;
	/** 开发项目（外键） */
	private Integer developmentprojectid;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setAssetnumber(Integer assetnumber) 
	{
		this.assetnumber = assetnumber;
	}

	public Integer getAssetnumber() 
	{
		return assetnumber;
	}
	public void setAssername(String assername) 
	{
		this.assername = assername;
	}

	public String getAssername() 
	{
		return assername;
	}
	public void setPolicestation(String policestation) 
	{
		this.policestation = policestation;
	}

	public String getPolicestation() 
	{
		return policestation;
	}
	public void setFirehouse(String firehouse) 
	{
		this.firehouse = firehouse;
	}

	public String getFirehouse() 
	{
		return firehouse;
	}
	public void setStreetcommunity(String streetcommunity) 
	{
		this.streetcommunity = streetcommunity;
	}

	public String getStreetcommunity() 
	{
		return streetcommunity;
	}
	public void setAssettype(String assettype) 
	{
		this.assettype = assettype;
	}

	public String getAssettype() 
	{
		return assettype;
	}
	public void setTransferofassets(String transferofassets) 
	{
		this.transferofassets = transferofassets;
	}

	public String getTransferofassets() 
	{
		return transferofassets;
	}
	public void setSatellitepositionimg(String satellitepositionimg) 
	{
		this.satellitepositionimg = satellitepositionimg;
	}

	public String getSatellitepositionimg() 
	{
		return satellitepositionimg;
	}
	public void setProperty(String property) 
	{
		this.property = property;
	}

	public String getProperty() 
	{
		return property;
	}
	public void setAerialmap(String aerialmap) 
	{
		this.aerialmap = aerialmap;
	}

	public String getAerialmap() 
	{
		return aerialmap;
	}
	public void setFieldphoto(String fieldphoto) 
	{
		this.fieldphoto = fieldphoto;
	}

	public String getFieldphoto() 
	{
		return fieldphoto;
	}
	public void setSecuritystructureproof(String securitystructureproof) 
	{
		this.securitystructureproof = securitystructureproof;
	}

	public String getSecuritystructureproof() 
	{
		return securitystructureproof;
	}
	public void setEncroachmentinfo(String encroachmentinfo) 
	{
		this.encroachmentinfo = encroachmentinfo;
	}

	public String getEncroachmentinfo() 
	{
		return encroachmentinfo;
	}
	public void setHistorylegacy(String historylegacy) 
	{
		this.historylegacy = historylegacy;
	}

	public String getHistorylegacy() 
	{
		return historylegacy;
	}
	public void setRenovationprojectid(Integer renovationprojectid) 
	{
		this.renovationprojectid = renovationprojectid;
	}

	public Integer getRenovationprojectid() 
	{
		return renovationprojectid;
	}
	public void setDevelopmentprojectid(Integer developmentprojectid) 
	{
		this.developmentprojectid = developmentprojectid;
	}

	public Integer getDevelopmentprojectid() 
	{
		return developmentprojectid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assetnumber", getAssetnumber())
            .append("assername", getAssername())
            .append("policestation", getPolicestation())
            .append("firehouse", getFirehouse())
            .append("streetcommunity", getStreetcommunity())
            .append("assettype", getAssettype())
            .append("transferofassets", getTransferofassets())
            .append("satellitepositionimg", getSatellitepositionimg())
            .append("property", getProperty())
            .append("aerialmap", getAerialmap())
            .append("fieldphoto", getFieldphoto())
            .append("securitystructureproof", getSecuritystructureproof())
            .append("encroachmentinfo", getEncroachmentinfo())
            .append("historylegacy", getHistorylegacy())
            .append("renovationprojectid", getRenovationprojectid())
            .append("developmentprojectid", getDevelopmentprojectid())
            .toString();
    }
}
