package oop;

/**
 * 停车场客户
 *
 * @author hupan
 * @date 2018/09/27
 */
public class Parker {
    /** 客户名称 */
    private String parkerName;
    /** 是否是vip客户 */
    private boolean isVip;
    /** vip等级 */
    private Integer vipLevel;

    public String getParkerName() {
        return parkerName;
    }

    public void setParkerName(String parkerName) {
        this.parkerName = parkerName;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Integer vipLevel) {
        this.vipLevel = vipLevel;
    }

    @Override
    public String toString() {
        return "Parker{" + "parkerName='" + parkerName + '\'' + ", isVip=" + isVip + ", vipLevel=" + vipLevel + '}';
    }
}
