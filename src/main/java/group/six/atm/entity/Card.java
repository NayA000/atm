package group.six.atm.entity;

/**
 * 
 */
public class Card {
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
}