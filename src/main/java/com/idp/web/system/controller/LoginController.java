package com.idp.web.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.constant.SessionAttr;
import com.idp.common.util.MenuUtils;
import com.idp.web.system.entity.SysMenu;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysMenuService;
import com.idp.web.system.service.SysUserService;

import net.sf.json.JSONObject;

@Controller 
@RequestMapping("/login")
public class LoginController extends BaseController {

	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysMenuService sysMenuService;
	
	/**
	 * 验证用户
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/checkUser.do",method = RequestMethod.POST)
	@ResponseBody
	public String checkUser(@RequestBody SysUser user,HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		try {
			SysUser u = sysUserService.findByUsername(user);
			if(u != null){
				
				if( !u.getPassword().equals(user.getPassword())){
					logger.info("login failed : password error");
					json.put("result", "password_error");
				}else{
					HttpSession session = request.getSession();
					session.setAttribute(SessionAttr.USER_LOGIN.getValue(), u);
					List<String> userMenus = sysUserService.findMenuIdByUserId(u.getId());
					List<SysMenu> menuList = sysMenuService.getByParentId("0");
					session.setAttribute(SessionAttr.USER_MENUS.getValue(), MenuUtils.getMenu(menuList, userMenus));
					String menus = MenuUtils.getMenu(menuList, userMenus);
					
					logger.info("login success");
					json.put("result", "login_success");
					json.put("user", u);
					json.put("menulist", menus);
				}
			}else{
				logger.info("login failed: account_error");
				json.put("result", "account_error");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return json.toString();
	}
	
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
		session.removeAttribute(SessionAttr.USER_ROLES.getValue());
		session.removeAttribute(SessionAttr.USER_MENUS.getValue());
		
		return "login/login";
	}
	
}
