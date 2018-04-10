package group.six.atm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.six.atm.dao.BussLogMapper;
import group.six.atm.service.IBussLogService;

@Service("bussLogService")
public class BussLogServiceImpl implements IBussLogService {
	
	@Autowired
	private BussLogMapper bussLogMapper;

	public void setBussLogMapper(BussLogMapper bussLogMapper) {
		this.bussLogMapper = bussLogMapper;
	}
	
}
