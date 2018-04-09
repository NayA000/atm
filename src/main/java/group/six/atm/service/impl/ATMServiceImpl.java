package group.six.atm.service.impl;

import org.springframework.stereotype.Service;

import group.six.atm.entity.ATM;
import group.six.atm.service.IATMService;

@Service("ATMService")
public class ATMServiceImpl implements IATMService {

	@Override
	public ATM findATMById(Long ATM_ID) {
		return null;
	}

}
