package com.idp.web.system.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.idp.web.system.entity.SysRole;
import com.idp.web.system.service.SysRoleService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;
import com.idp.web.system.entity.SysMenu;
import com.idp.web.system.entity.SysRole;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysMenuService;
import com.idp.web.system.service.SysRoleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;





/**
 * 
 * 角色管理controller
 * 
 * <pre>
 * 	历史记录：
 * 	2016-08-01 22:42 King
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	King
 * PG
 *	King
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {

	private Logger logger = Logger.getLogger(SysRoleController.class);

	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysMenuService sysMenuService;
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "system/role/sysRoleSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	分页查询
	 * </pre>
	 * 
	 * @param sysRole
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/list.do", method = RequestMethod.POST)
	@ResponseBody
	public List<SysRole> list(HttpServletRequest request){
		
		List<SysRole>  sysRoles = sysRoleService.findBySearch(null);
		return sysRoles;
	}

	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/sysRole")
	public String sysRole(String id,HttpServletRequest request){
		
		try {
			
			SysRole sysRole = null;
			List<String> menuIds = null;
			
			if(ValidateUtils.isNotEmpty(id)){
				
				sysRole = sysRoleService.getById(id);
				request.setAttribute("sysRole", sysRole);
				
				menuIds = sysRoleService.findByRoleId(id);
			}
			
			// 菜单信息
			JSONArray json = new JSONArray();
			List<SysMenu> menuList = sysMenuService.find(new SysMenu());
			if(menuList != null && menuList.size() > 0){
				for(SysMenu menu : menuList){
					Map<String, Object> map = new HashMap<String,Object>();
					map.put("id", menu.getId());
					map.put("name", menu.getMenuName());
					map.put("pId", menu.getParentId());
					
					// 选中角色拥有的菜单权限 
					if(menuIds != null && menuIds.contains(menu.getId())){
						map.put("checked", true);
					}
					else{
						map.put("checked", false);
					}
					
					json.add(map);
				}
			}
			request.setAttribute("menuList", json.toString());
			
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "system/role/sysRole";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	保存
	 * </pre>
	 * 
	 * @param sysRole
	 * @return
	 */
	@RequestMapping(value = "/save.do" , method = RequestMethod.POST )
	@ResponseBody
	public String save(@RequestBody SysRole sysRole){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(sysRole.getId())){
				
				sysRoleService.update(sysRole);
			}
			// 新增
			else{
				
				sysRoleService.add(sysRole);
			}
			json.put("result", "save_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}
		
		return json.toString();
	}
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete.do" , method = RequestMethod.POST )
	@ResponseBody
	public String delete(@RequestBody SysRole sysRole, HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		
		try {
			
			sysRoleService.delete(sysRole.getId());
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
