package com.lc.platform.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lc.platform.web.login.entity.SysUser;
import com.lc.platform.web.login.service.SysUserService;
import com.lc.platform.mybatis.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lc
 * @since 2018-11-27
 */
@Controller
@RequestMapping("/login/sysUser")
public class SysUserController extends BaseController<SysUserService,SysUser> {

}
