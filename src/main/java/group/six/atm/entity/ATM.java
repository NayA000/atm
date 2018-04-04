package group.six.atm.entity;

/**
 * 
 */
public class ATM {
    // ATM编号
    private Long ATM_ID;

    // 余额
    private Long balance;

    // 金额上限
    private Long balanceLimit;

    // 是否可存款，1：是，0：否，默认1
    private Integer depositable;

    // 是否可取款，1：是，0：否，默认1
    private Integer withdrawable;

    // 单次存款上限
    private Long depositLimit;

    // 单次取款上限
    private Long withdrawLimit;

    // 单次转账上限
    private Long transferLimit;

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
     * 余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * @param balance 余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 金额上限
     */
    public Long getBalanceLimit() {
        return balanceLimit;
    }

    /**
     * @param balanceLimit 金额上限
     */
    public void setBalanceLimit(Long balanceLimit) {
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
    public Long getDepositLimit() {
        return depositLimit;
    }

    /**
     * @param depositLimit 单次存款上限
     */
    public void setDepositLimit(Long depositLimit) {
        this.depositLimit = depositLimit;
    }

    /**
     * 单次取款上限
     */
    public Long getWithdrawLimit() {
        return withdrawLimit;
    }

    /**
     * @param withdrawLimit 单次取款上限
     */
    public void setWithdrawLimit(Long withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    /**
     * 单次转账上限
     */
    public Long getTransferLimit() {
        return transferLimit;
    }

    /**
     * @param transferLimit 单次转账上限
     */
    public void setTransferLimit(Long transferLimit) {
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
}