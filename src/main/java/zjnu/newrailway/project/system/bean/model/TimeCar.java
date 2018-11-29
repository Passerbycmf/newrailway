package zjnu.newrailway.project.system.bean.model;

import zjnu.newrailway.framework.aspectj.lang.annotation.Excel;

public class TimeCar {
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "汽车ID")
    private Integer id;
    /** 创建时间 */
    @Excel(name = "创建时间")
    private String  crTime;
    /**  */
    private String  upTime;
    /** 汽车到达数 */
    @Excel(name = "汽车到达数量")
    private Integer numberArrive;
    /** 汽车服务费 */
    @Excel(name = "汽车服务费")
    private Integer serviceCharge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrTime() {
        return crTime;
    }

    public void setCrTime(String crTime) {
        this.crTime = crTime;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public Integer getNumberArrive() {
        return numberArrive;
    }

    public void setNumberArrive(Integer numberArrive) {
        this.numberArrive = numberArrive;
    }

    public Integer getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Integer serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
