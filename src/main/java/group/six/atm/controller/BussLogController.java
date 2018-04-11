package group.six.atm.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import group.six.atm.dto.Result;
import group.six.atm.service.IBussLogService;

@RestController
@RequestMapping("/bussLog")
@RequiresRoles("USER")
public class BussLogController {
	
	@Autowired
	private IBussLogService bussLogService;

	public void setBussLogService(IBussLogService bussLogService) {
		this.bussLogService = bussLogService;
	}
	
	/**
	 * 返回最新一条业务记录
	 */
	@RequestMapping(method=RequestMethod.GET)
	public Result getBussLog() {
		return null;
	}
}
