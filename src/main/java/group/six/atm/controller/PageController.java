package group.six.atm.controller;


import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 控制页面跳转  控制器，处理页面跳转，所有的子系统都要用
 */
@Controller
public class PageController {
	
    @SuppressWarnings("unused")
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
//    @ResponseBody
//    @RequestMapping(value = "/sign_in",method = RequestMethod.POST)
//    public Result signIn(@RequestBody TempAdmin admin) {
//        try {
//            Subject subject = ShiroUtils.getSubject();
//            UsernamePasswordToken token = new UsernamePasswordToken(admin.getAccount(),
//                    Cryptography.MD5Hash(admin.getPasswd(), admin.getAccount()));
//            subject.login(token);
//        } catch (UnknownAccountException e) {
//            return Result.error("账号不存在");
//        } catch (IncorrectCredentialsException e) {
//            return Result.error("账号或密码不正确");
//        } catch (LockedAccountException e) {
//            return Result.error("账号已被锁定,请联系管理员");
//        } catch (AuthenticationException e) {
//            return Result.error("账户验证失败");
//        }
//        return Result.ok();
//    }

    /**
     * Home页面跳转     私有
     */
    /*@RequestMapping("/home")
    public ModelAndView home() {
        Map<String,Object> map=new HashMap<>();

        map.put("LOGINER",ShiroUtils.getSubject().getPrincipal());
        //登陆校验
		//return "index";
        return new ModelAndView("index",map);
    }*/

    /**
     * Login页面跳转    公开
     */
    @RequestMapping("/login.jhtml")
    public String login() {
        return "login";
    }


    /**
     * 退出
     */
//   @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout() {
//        ShiroUtils.logout();
//        return "redirect:/login.jhtml";
//    }

    @RequestMapping("/no_access")
    public String ban() {
        return "no_access";
    }

    /**
     * 测试角色权限
     * @return
     */
    @ResponseBody
    @RequestMapping("/testRole")
    @RequiresRoles("ADMIN")
    public String tt(){
        return "仅仅管理员可见！！！";
    }
}
