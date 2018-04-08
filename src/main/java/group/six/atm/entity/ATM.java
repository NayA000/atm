package group.six.atm.entity;


import org.apache.ibatis.type.Alias;

@Alias("ATM")
public class ATM extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// ATM编号,自增长
    private Long ATM_ID;

    // ATM客户端系统密码，即客户端登录之后才能使用系统
    private String password;

    // 余额
    private Double balance;

    // 金额上限
    private Double balanceLimit;

    // 是否可存款，1：是，0：否，默认1
    private Integer depositable;

    // 是否可取款，1：是，0：否，默认1
    private Integer withdrawable;

    // 单次存款上限
    private Double depositLimit;

    // 单次取款上限
    private Double withdrawLimit;

    // 单次转账上限
    private Double transferLimit;

    // 是否启用，1：是，0：否，默认1
    private Integer status;

    /**
     * ATM编号
     */
    public Long getATM_ID() {
        return ATM_ID;
    }

    /**
     * @param ATM_ID ATM编号
     */
    public void setATM_ID(Long ATM_ID) {
        this.ATM_ID = ATM_ID;
    }

    /**
     * ATM客户端系统密码，即客户端登录之后才能使用系统
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password ATM客户端系统密码，即客户端登录之后才能使用系统
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 余额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance 余额
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * 金额上限
     */
    public Double getBalanceLimit() {
        return balanceLimit;
    }

    /**
     * @param balanceLimit 金额上限
     */
    public void setBalanceLimit(Double balanceLimit) {
        this.balanceLimit = balanceLimit;
    }

    /**
     * 是否可存款，1：是，0：否，默认1
     */
    public Integer getDepositable() {
        return depositable;
    }

    /**
     * @param depositable 是否可存款，1：是，0：否，默认1
     */
    public void setDepositable(Integer depositable) {
        this.depositable = depositable;
    }

    /**
     * 是否可取款，1：是，0：否，默认1
     */
    public Integer getWithdrawable() {
        return withdrawable;
    }

    /**
     * @param withdrawable 是否可取款，1：是，0：否，默认1
     */
    public void setWithdrawable(Integer withdrawable) {
        this.withdrawable = withdrawable;
    }

    /**
     * 单次存款上限
     */
    public Double getDepositLimit() {
        return depositLimit;
    }

    /**
     * @param depositLimit 单次存款上限
     */
    public void setDepositLimit(Double depositLimit) {
        this.depositLimit = depositLimit;
    }

    /**
     * 单次取款上限
     */
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    /**
     * @param withdrawLimit 单次取款上限
     */
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    /**
     * 单次转账上限
     */
    public Double getTransferLimit() {
        return transferLimit;
    }

    /**
     * @param transferLimit 单次转账上限
     */
    public void setTransferLimit(Double transferLimit) {
        this.transferLimit = transferLimit;
    }

    /**
     * 是否启用，1：是，0：否，默认1
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 是否启用，1：是，0：否，默认1
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "ATM [ATM_ID=" + ATM_ID + ", password=" + password + ", balance=" + balance + ", balanceLimit="
				+ balanceLimit + ", depositable=" + depositable + ", withdrawable=" + withdrawable + ", depositLimit="
				+ depositLimit + ", withdrawLimit=" + withdrawLimit + ", transferLimit=" + transferLimit + ", status="
				+ status + "]";
	}
    
}