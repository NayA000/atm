package group.six.atm.dto;

import java.util.Date;

import group.six.atm.entity.User;

public class AccountDTO {

    // 账户状态,0:正常1:锁定2:注销
    private Integer status;

    // 账户余额，默认为0
    private Double balance;

    // 用户
    private User user;

    // 冻结时间戳，三次输入密码错误，修改此字段值为最后输入密码错误时间，冻结时间为24小时
    private Date freezeTimeStamp;


    /**
     * 账户状态,0:正常1:锁定2:注销
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 账户状态,0:正常1:锁定2:注销
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 账户余额，默认为0
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance 账户余额，默认为0
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * 用户
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user 用户
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 冻结时间戳，三次输入密码错误，修改此字段值为最后输入密码错误时间，冻结时间为24小时
     */
    public Date getFreezeTimeStamp() {
        return freezeTimeStamp;
    }

    /**
     * @param freezeTimeStamp 冻结时间戳，三次输入密码错误，修改此字段值为最后输入密码错误时间，冻结时间为24小时
     */
    public void setFreezeTimeStamp(Date freezeTimeStamp) {
        this.freezeTimeStamp = freezeTimeStamp;
    }
	
}
