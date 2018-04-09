package group.six.atm.service;

import group.six.atm.entity.ATM;

public interface IATMService {
	
	ATM findATMById(Long ATM_ID);
	
}
