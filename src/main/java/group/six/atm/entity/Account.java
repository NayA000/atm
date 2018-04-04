package group.six.atm.entity;

import java.util.Date;

public class Account {
    // id，自增长
    private Long id;

    // 密码
    private String password;

    // 账户状态,0:正常1:冻结
    private Integer status;

    // 账户余额，默认为0
    private Double balance;

    // 用户id
    private Long userID;

    // 冻结时间戳，三次输入密码错误，修改此字段值为最后输入密码错误时间，冻结时间为24小时
    private Date freezeTimeStamp;

    /**
     * id，自增长
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id id，自增长
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 账户状态,0:正常1:冻结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 账户状态,0:正常1:冻结
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
     * 用户id
     */
    public Long getUserID() {
        return userID;
    }

    /**
     * @param userID 用户id
     */
    public void setUserID(Long userID) {
        this.userID = userID;
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