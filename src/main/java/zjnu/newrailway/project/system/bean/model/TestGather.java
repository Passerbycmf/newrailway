package zjnu.newrailway.project.system.bean.model;

import java.util.Date;

/**
 * @classname:
 * @description:
 * @author: daimiao
 * @date: 2018/11/28 15:52
 * @version: 1.0
 **/
public class TestGather {
    private static final long serialVersionUID = 1L;

    /** 收款ID */
    private Integer id;
    /** 合同ID */
    private Integer contractId;
    /** 金额 */
    private String total;
    /** 凭证号 */
    private Integer gatherNumber;
    /** 收款时间 */
    private String gatherTime;
    /** 创建时间 */
    private String createTime;
    /** 更新时间 */
    private String updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getGatherNumber() {
        return gatherNumber;
    }

    public void setGatherNumber(Integer gatherNumber) {
        this.gatherNumber = gatherNumber;
    }

    public String getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(String gatherTime) {
        this.gatherTime = gatherTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
