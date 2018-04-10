package group.six.atm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.six.atm.dao.CardMapper;
import group.six.atm.service.ICardService;

@Service("cardService")
public class CardServiceImpl implements ICardService {
	
	@Autowired
	private CardMapper cardMapper;

	public void setCardMapper(CardMapper cardMapper) {
		this.cardMapper = cardMapper;
	}
	
}
