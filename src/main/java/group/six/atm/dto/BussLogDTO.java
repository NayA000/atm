package group.six.atm.dto;

import java.util.Date;

import group.six.atm.entity.BussLog;
import group.six.atm.utils.CommonUtil;

public class BussLogDTO {
	
	// id，自增长
    private Long id;

    // 操作类型，0：取款，1：存款，2：转账
    private String opType;

    // 时间戳
    private Date timeStamp;

    // 用户银行卡
    private String userCardNumber;

    // 收款人银行卡，业务类型为转账时有效
    private String payeeCardNumber;

    // 操作金额
    private Double amount;
    
    /**
     * 封装BussLogDTO
     * @param bussLog
     */
    public static BussLogDTO copy(BussLog bussLog) {
    	BussLogDTO bussLogDTO = new BussLogDTO();
    	bussLogDTO.setAmount(bussLog.getAmount());
    	bussLogDTO.setId(bussLog.getId());
    	bussLogDTO.setUserCardNumber(CommonUtil.fuzzyCardNumber(bussLog.getUserCard().getCardNumber()));
    	switch (bussLog.getOpType()) {
		case 0:
			bussLogDTO.setOpType("取款");
			break;
		case 1:
			bussLogDTO.setOpType("存款");
			break;
		case 2:
			bussLogDTO.setOpType("转账");
			bussLogDTO.setPayeeCardNumber(CommonUtil.fuzzyCardNumber(bussLog.getPayeeCard().getCardNumber()));
			break;
		default:
			break;
		}
    	return bussLogDTO;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUserCardNumber() {
		return userCardNumber;
	}

	public void setUserCardNumber(String userCardNumber) {
		this.userCardNumber = userCardNumber;
	}

	public String getPayeeCardNumber() {
		return payeeCardNumber;
	}

	public void setPayeeCardNumber(String payeeCardNumber) {
		this.payeeCardNumber = payeeCardNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
