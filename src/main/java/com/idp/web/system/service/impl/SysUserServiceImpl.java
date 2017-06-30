package com.idp.web.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;
import com.idp.web.system.dao.SysRoleDao;
import com.idp.web.system.dao.SysRoleMenuDao;
import com.idp.web.system.dao.SysUserDao;
import com.idp.web.system.dao.SysUserRoleDao;
import com.idp.web.system.entity.SysRole;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.entity.SysUserRole;
import com.idp.web.system.service.SysRoleService;
import com.idp.web.system.service.SysUserService;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserDao sysUserDao;
	@Resource
	private SysUserRoleDao sysUserRoleDao;
	@Resource
	private SysRoleMenuDao sysRoleMenuDao;
	@Resource
	private SysRoleDao sysRoleDao;
	
	@Override
	public SysUser findByUsername(SysUser user) {
		SysUser u = sysUserDao.findByUsername(user.getUsername());
		SysUserRole userRole = new SysUserRole();
		userRole.setUserId(u.getId());
		List<SysUserRole> lists = sysUserRoleDao.find(userRole);
		String roleIds = "";
		for(SysUserRole sysUserRole:lists){
			SysRole role = sysRoleDao.getById(sysUserRole.getRoleId());
			roleIds += role.getRoleCode() + ",";
		}
		u.setRoleIds(roleIds);
		return u;
	}

	@Override
	public Page<SysUser> findByPage(SysUser user, Page<SysUser> page) {
		
		page.setResult(sysUserDao.find(user, page));
		
		return page;
	}

	@Override
	public SysUser getById(String id) {
		
		return sysUserDao.getById(id);
	}

	@Override
	public void add(SysUser user) {
		
		user.setId(ResourceUtils.getUUID());
		sysUserDao.add(user);
		
		if(StringUtils.isNotEmpty(user.getRoleIds())){
			List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();
			for(String roleId : user.getRoleIds().split(",")){
				if(StringUtils.isNotEmpty(roleId)){
					SysUserRole userRole = new SysUserRole();
					userRole.setId(ResourceUtils.getUUID());
					userRole.setRoleId(roleId);
					userRole.setUserId(user.getId());
					userRoleList.add(userRole);
				}
			}
			
			if(userRoleList.size() > 0){
				sysUserRoleDao.batchAdd(userRoleList);
			}
		}
	}

	@Override
	public void update(SysUser user) {
		
		sysUserDao.update(user);
		
		// 删除旧数据
//		sysUserRoleDao.deleteByUserId(user.getId());
		
		if(StringUtils.isNotEmpty(user.getRoleIds())){
			List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();
			for(String roleId : user.getRoleIds().split(",")){
				if(StringUtils.isNotEmpty(roleId)){
					SysUserRole userRole = new SysUserRole();
					userRole.setId(ResourceUtils.getUUID());
					userRole.setRoleId(roleId);
					userRole.setUserId(user.getId());
					userRoleList.add(userRole);
				}
			}
			
			if(userRoleList.size() > 0){
				sysUserRoleDao.batchAdd(userRoleList);
			}
		}
	}

	@Override
	public void delete(String id) {
		
		sysUserDao.delete(id);
		// 删除旧数据
//		sysUserRoleDao.deleteByUserId(id);
	}

	@Override
	public List<String> findByUserId(String userId) {
		
		return sysUserRoleDao.findByUserId(userId);
	}

	@Override
	public List<String> findMenuIdByUserId(String userId) {
		
		return sysRoleMenuDao.findMenuIdByUserId(userId);
	}

	
	/**
	 * 管理员查询出所有的用户列表
	 * @param sysUser
	 * @return
	 */
	@Override
	public List<SysUser> findBySearch(SysUser sysUser) {

		return sysUserDao.find(sysUser);
	}

	
}
