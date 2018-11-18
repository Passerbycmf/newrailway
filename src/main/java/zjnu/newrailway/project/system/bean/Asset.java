package zjnu.newrailway.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.newrailway.framework.aspectj.lang.annotation.Excel;
import zjnu.newrailway.framework.web.BaseEntity;

/**
 * 资产管理表 sys_asset_management
 *
 * @author cmf
 * @date 2018-11-01
 */
public class Asset extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资产IDid */
    @Excel(name = "资产ID")
    private Integer id;
    /** 资产名称 */
    @Excel(name = "资产名称")
    private String assetName;
    /** 资产编号 */
    @Excel(name = "资产编号")
    private Integer assetNumber;
    /** 资产所属片区 */
    @Excel(name = "资产所属片区")
    private String assetTranslation;
    /** 资产面积(平方米) */
    @Excel(name = "资产面积(平方米)")
    private String assetArea;
    /** 资产位置 */
    @Excel(name = "资产位置")
    private String assetLocation;
    /** 所属派出所 */
    @Excel(name = "所属派出所")
    private String policeStation;
    /** 所属消防队 */
    @Excel(name = "所属消防队")
    private String fireBrigade;
    /** 资产类别 */
    @Excel(name = "资产类别")
    private String assetType;
    /** 侵占违建情况 */
    @Excel(name = "侵占违建情况")
    private String squatterHouse;
    /** 历史遗留问题 */
    @Excel(name = "历史遗留问题")
    private String legacy;
    /** 资产移交手续清单（文件） */
    @Excel(name = "资产移交手续清单（文件）")
    private String assetDeliver;
    /** 卫星定位（文件） */
    @Excel(name = "卫星定位（文件）")
    private String sateliteFix;
    /** 房产证（文件） */
    @Excel(name = "房产证（文件）")
    private String ownershipCertificate;
    /** 航拍图（文件） */
    @Excel(name = "航拍图（文件）")
    private String aerialMap;
    /** 现场照片（文件） */
    @Excel(name = "现场照片（文件）")
    private String livePic;
    /** 安全结构证明（文件） */
    @Excel(name = "安全结构证明（文件）")
    private String safeCertificate;
    /** 资产类型（0房屋/1土地） */
    @Excel(name = "资产类型（0房屋/1土地）")
    private Integer assetDifference;

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
    public void setAssetNumber(Integer assetNumber)
    {
        this.assetNumber = assetNumber;
    }

    public Integer getAssetNumber()
    {
        return assetNumber;
    }
    public void setAssetTranslation(String assetTranslation)
    {
        this.assetTranslation = assetTranslation;
    }

    public String getAssetTranslation()
    {
        return assetTranslation;
    }
    public void setAssetArea(String assetArea)
    {
        this.assetArea = assetArea;
    }

    public String getAssetArea()
    {
        return assetArea;
    }
    public void setAssetLocation(String assetLocation)
    {
        this.assetLocation = assetLocation;
    }

    public String getAssetLocation()
    {
        return assetLocation;
    }
    public void setPoliceStation(String policeStation)
    {
        this.policeStation = policeStation;
    }

    public String getPoliceStation()
    {
        return policeStation;
    }
    public void setFireBrigade(String fireBrigade)
    {
        this.fireBrigade = fireBrigade;
    }

    public String getFireBrigade()
    {
        return fireBrigade;
    }
    public void setAssetType(String assetType)
    {
        this.assetType = assetType;
    }

    public String getAssetType()
    {
        return assetType;
    }
    public void setSquatterHouse(String squatterHouse)
    {
        this.squatterHouse = squatterHouse;
    }

    public String getSquatterHouse()
    {
        return squatterHouse;
    }
    public void setLegacy(String legacy)
    {
        this.legacy = legacy;
    }

    public String getLegacy()
    {
        return legacy;
    }
    public void setAssetDeliver(String assetDeliver)
    {
        this.assetDeliver = assetDeliver;
    }

    public String getAssetDeliver()
    {
        return assetDeliver;
    }
    public void setSateliteFix(String sateliteFix)
    {
        this.sateliteFix = sateliteFix;
    }

    public String getSateliteFix()
    {
        return sateliteFix;
    }
    public void setOwnershipCertificate(String ownershipCertificate)
    {
        this.ownershipCertificate = ownershipCertificate;
    }

    public String getOwnershipCertificate()
    {
        return ownershipCertificate;
    }
    public void setAerialMap(String aerialMap)
    {
        this.aerialMap = aerialMap;
    }

    public String getAerialMap()
    {
        return aerialMap;
    }
    public void setLivePic(String livePic)
    {
        this.livePic = livePic;
    }

    public String getLivePic()
    {
        return livePic;
    }
    public void setSafeCertificate(String safeCertificate)
    {
        this.safeCertificate = safeCertificate;
    }

    public String getSafeCertificate()
    {
        return safeCertificate;
    }
    public void setAssetDifference(Integer assetDifference)
    {
        this.assetDifference = assetDifference;
    }

    public Integer getAssetDifference()
    {
        return assetDifference;
    }

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("assetName", getAssetName())
                .append("assetNumber", getAssetNumber())
                .append("assetTranslation", getAssetTranslation())
                .append("assetArea", getAssetArea())
                .append("assetLocation", getAssetLocation())
                .append("policeStation", getPoliceStation())
                .append("fireBrigade", getFireBrigade())
                .append("assetType", getAssetType())
                .append("squatterHouse", getSquatterHouse())
                .append("legacy", getLegacy())
                .append("assetDeliver", getAssetDeliver())
                .append("sateliteFix", getSateliteFix())
                .append("ownershipCertificate", getOwnershipCertificate())
                .append("aerialMap", getAerialMap())
                .append("livePic", getLivePic())
                .append("safeCertificate", getSafeCertificate())
                .append("assetDifference", getAssetDifference())
                .toString();
    }
}
