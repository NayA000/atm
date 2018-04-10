package group.six.atm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.six.atm.dao.ATMMapper;
import group.six.atm.entity.ATM;
import group.six.atm.service.IATMService;

@Service("ATMService")
public class ATMServiceImpl implements IATMService {
	
	@Autowired
	private ATMMapper ATMMapper;
	
	public void setATMMapper(ATMMapper aTMMapper) {
		ATMMapper = aTMMapper;
	}

	@Override
	public ATM findATMById(Long ATM_ID) {
		return ATMMapper.selectByPrimaryKey(ATM_ID);
	}

}
