package group.six.atm.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("BussLog")
public class BussLog extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	// id，自增长
    private Long id;

    // 操作类型，0：取款，1：存款，2：转账
    private Integer opType;

    // 时间戳
    private Date timeStamp;

    // 用户银行卡
    private Card userCard;

    // 收款人银行卡，业务类型为转账时有效
    private Card payeeCard;

    // ATM
    private ATM ATM;

    // 操作金额
    private Double amount;

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
     * 操作类型，0：取款，1：存款，2：转账
     */
    public Integer getOpType() {
        return opType;
    }

    /**
     * @param opType 操作类型，0：取款，1：存款，2：转账
     */
    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    /**
     * 时间戳
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp 时间戳
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * 用户卡号
     */
    public Card getUserCard() {
        return userCard;
    }

    /**
     * @param userCardNumber 用户卡号
     */
    public void setUserCardNumber(Card userCard) {
        this.userCard = userCard == null ? null : userCard;
    }

    /**
     * 收款人卡号，业务类型为转账时有效
     */
    public Card getPayeeCard() {
        return payeeCard;
    }

    /**
     * @param payeeCardNumber 收款人卡号，业务类型为转账时有效
     */
    public void setPayeeCard(Card payeeCard) {
        this.payeeCard = payeeCard == null ? null : payeeCard;
    }

    /**
     * ATM
     */
    public ATM getATM() {
        return ATM;
    }

    /**
     * @param ATM ATM
     */
    public void setATM(ATM ATM) {
        this.ATM = ATM;
    }

    /**
     * 操作金额
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount 操作金额
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

	@Override
	public String toString() {
		return "BussLog [id=" + id + ", opType=" + opType + ", timeStamp=" + timeStamp + ", amount=" + amount + "]";
	}
    
    
}