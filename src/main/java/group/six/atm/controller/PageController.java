package group.six.atm.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import group.six.atm.dto.Result;
import group.six.atm.exceptions.SystemException;
import group.six.atm.shiro.ShiroUtils;
import group.six.atm.utils.BussCode;
import group.six.atm.utils.Cryptography;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制页面跳转 控制器，处理页面跳转，所有的子系统都要用
 */
@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	/**
	 * 控制页面跳转
	 *
	 * @param request
	 * @param htmlName
	 * @return
	 */
	@RequestMapping("/module/{htmlName}")
	public String showPage(HttpServletRequest request, @PathVariable("htmlName") String htmlName) {
		return "/module/" + htmlName;
	}

	/**
	 * 账号登陆
	 */
	@ResponseBody
	@RequestMapping(value = "/sign_in", method = RequestMethod.POST)
	public Result signIn(@RequestParam String ATM_ID, @RequestParam String cardNumber, @RequestParam String passwd) {
		StringBuilder sb = new StringBuilder(100);
		sb.append(ATM_ID).append(">>").append(cardNumber);
		Subject subject = ShiroUtils.getSubject();
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(sb.toString(),
					Cryptography.MD5Hash(passwd, cardNumber));
			subject.login(token);
		} catch (UnknownAccountException e) {
			return Result.error("账号不存在");
		} catch (IncorrectCredentialsException e) {
			return Result.error(BussCode.NOT_LOGIN, "账号或密码不正确");
		} catch (LockedAccountException e) {
			return Result.error("账号已被锁定");
		} catch (AuthenticationException e) {
			return Result.error("账户验证失败");
		} catch (SystemException e) {
			return Result.error();
		}
		logger.info(ShiroUtils.getLoginObject().getAccount().getUser().getCard().getCardNumber() + "登录系统");
		return Result.success();
	}

	/**
	 * Home页面跳转 私有
	 */
	/*
	 * @RequestMapping("/home") public ModelAndView home() { Map<String,Object>
	 * map=new HashMap<>();
	 * 
	 * map.put("LOGINER",ShiroUtils.getSubject().getPrincipal()); //登陆校验 //return
	 * "index"; return new ModelAndView("index",map); }
	 */

	/**
	 * Login页面跳转 公开
	 */
	@ResponseBody
	@RequestMapping(value = "/not_login", method = RequestMethod.GET)
	public Result login() {
		return Result.error(BussCode.NOT_LOGIN, "账户未登录");
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:/login.jhtml";
	}

	@RequestMapping("/no_access")
	public String ban() {
		return "no_access";
	}

	/**
	 * 测试角色权限
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testRole")
	@RequiresRoles("USER")
	public Result tt() {
		return Result.success("登录用户才能看到的消息");
	}
}
