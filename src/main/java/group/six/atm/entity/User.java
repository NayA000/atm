package group.six.atm.entity;

import java.util.Date;

public class User {
    // 主键，自增长
    private Long id;

    // 姓名
    private String name;

    // 出生日期
    private Date birthdate;

    // 性别 0：女1：男
    private Integer gender;

    // 手机号
    private String phone;

    // 身份证号
    private String ID_Card;

    // 卡号
    private String cardNumber;

    /**
     * 主键，自增长
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id 主键，自增长
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 出生日期
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate 出生日期
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 性别 0：女1：男
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender 性别 0：女1：男
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 身份证号
     */
    public String getID_Card() {
        return ID_Card;
    }

    /**
     * @param ID_Card 身份证号
     */
    public void setID_Card(String ID_Card) {
        this.ID_Card = ID_Card == null ? null : ID_Card.trim();
    }

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
}