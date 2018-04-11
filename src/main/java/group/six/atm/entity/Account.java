package group.six.atm.entity;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.type.Alias;

@Alias("Account")
public class Account extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// id，自增长
    private Long id;

    // 密码
    private String password;

    // 账户状态,0:正常1:锁定2:注销
    private Integer status;

    // 账户余额，默认为0
    private Double balance;

    // 用户
    private User user;

    // 冻结时间戳，三次输入密码错误，修改此字段值为最后输入密码错误时间，冻结时间为24小时
    private Date freezeTimeStamp;
    
    /**
     * 是否被临时冻结
     */
    public boolean isFreezed() {
    	if (freezeTimeStamp != null) {
			long difference = DateUtils.toCalendar(freezeTimeStamp).getTimeInMillis()
					- DateUtils.toCalendar(new Date()).getTimeInMillis();
			// 相差天数
			long day = difference / (3600 * 24 * 1000);
			if (day < 1) {
				return true;
			}
		}
    	return false;
    }
    
    /**
     * 判断账户是否正常
     */
    public boolean isUsable() {
    	return status == 0;
    }
    
    /**
     * 判断是否被锁定
     */
    public boolean isLocked() {
    	return status == 1;
    }
    
    /**
     * 判断是否已注销 
     */
    public boolean isDeleted() {
    	return status == 2;
    }
    
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", status=" + status + ", balance=" + balance
				+ ", freezeTimeStamp=" + freezeTimeStamp + "]";
	}
    
}