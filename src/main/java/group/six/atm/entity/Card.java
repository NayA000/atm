package group.six.atm.entity;


import org.apache.ibatis.type.Alias;

@Alias("Card")
public class Card extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	// 卡号
    private String cardNumber;

    // 状态，0：有效，1：失效
    private Integer status;

    /**
     * 卡号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber 卡号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    /**
     * 状态，0：有效，1：失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态，0：有效，1：失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", status=" + status + "]";
	}
    
    
}