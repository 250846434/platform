package com.lc.platform.web.login.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lc.platform.common.util.CommonUtil;
import com.lc.platform.mybatis.base.BaseController;
import com.lc.platform.web.login.annotation.IgnoreLogin;
import com.lc.platform.web.login.entity.SysUser;
import com.lc.platform.web.login.service.SysUserService;

/**
 * 
 */
@Controller
//@RequestMapping("/login")
public class LoginController extends BaseController<SysUserService,SysUser>{
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpSession session;

	@IgnoreLogin
    @RequestMapping( value = "login",method = {RequestMethod.GET,RequestMethod.POST})
	public String login(String username,String password){
//    	Object user = this.loginService.checkUser();
		if(CommonUtil.isAllEmpty(username,password)) {
			request.setAttribute("msg",null);
			return "login/login";
		}
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
		queryWrapper.eq("user_name", username);
		queryWrapper.eq("password", password);
		SysUser userInfo = this.service.getOne(queryWrapper);
		if(CommonUtil.isNotEmpty(userInfo)) {
			session.setAttribute("user",userInfo.getId());
			session.setAttribute("userInfo",userInfo);
			request.setAttribute("msg","登录成功!");
			return "redirect:/main";
		}else {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("errmsg","用户名或密码错误!");
			return "login/login";
		}
    	
	}
    @RequestMapping( value = "main",method = {RequestMethod.GET,RequestMethod.POST})
	public String main(){
    	return "main";
	}
    @RequestMapping( value = "logout",method = RequestMethod.GET)
	public String logout(){
    	session.removeAttribute("user");
    	request.setAttribute("msg","登出成功!");
    	return "forward:/main";
	}
}