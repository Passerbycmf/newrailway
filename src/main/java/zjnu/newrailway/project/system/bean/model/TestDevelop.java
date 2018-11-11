package zjnu.newrailway.project.system.bean.model;

import zjnu.newrailway.framework.web.BaseEntity;

public class TestDevelop extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;
    /**资产名称*/
    private String assetName;
    /** 开发名称 */
    private String developName;
    /** 开始时间 */
    private String stratTime;
    /** 结束时间 */
    private String endTime;
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
    /**资产类别*/
    private Integer difference;

    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }

    public String getApprovalDocuments() {
        return approvalDocuments;
    }

    public void setApprovalDocuments(String approvalDocuments) {
        this.approvalDocuments = approvalDocuments;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public String getSupervisionUnit() {
        return supervisionUnit;
    }

    public void setSupervisionUnit(String supervisionUnit) {
        this.supervisionUnit = supervisionUnit;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getDesignUnit() {
        return designUnit;
    }

    public void setDesignUnit(String designUnit) {
        this.designUnit = designUnit;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStratTime() {
        return stratTime;
    }

    public void setStratTime(String stratTime) {
        this.stratTime = stratTime;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getDevelopName() {
        return developName;
    }

    public void setDevelopName(String developName) {
        this.developName = developName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
