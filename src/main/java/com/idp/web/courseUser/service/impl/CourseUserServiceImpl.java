package com.idp.web.courseUser.service.impl;
import com.idp.web.courseUser.service.CourseUserService;
import com.idp.web.system.dao.SysUserDao;
import com.idp.web.system.entity.SysUser;
import com.idp.web.system.service.SysUserService;
import com.idp.web.course.entity.Course;
import com.idp.web.courseUser.dao.CourseUserDao;
import com.idp.web.courseUser.entity.CourseUser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ConstProject;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 课程用户信息service实现类
 * 
 * <pre>
 * 	历史记录：
 * 	2017-06-12 lsj
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	lsj
 * PG
 *	lsj
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
@Service("courseUserService")
public class CourseUserServiceImpl implements CourseUserService {

	@Resource
	private CourseUserDao courseUserDao;
	
	@Resource
	private SysUserDao sysUserDao;
	
	@Override
	public Page<CourseUser> findByPage(CourseUser courseUser, Page<CourseUser> page) {

		page.setResult(courseUserDao.find(courseUser, page));
		
		return page;
	}
	
	@Override
	public List<CourseUser> findBySearch(CourseUser courseUser) {

		return courseUserDao.find(courseUser);
	}
	
	@Override
	public CourseUser getById(String id) {

		return courseUserDao.getById(id);
	}

	@Override
	public void add(CourseUser courseUser) {

		courseUser.setId(ResourceUtils.getUUID());
		courseUserDao.add(courseUser);
	}
	
	@Override
	public void update(CourseUser courseUser) {

		courseUserDao.update(courseUser);
	}

	@Override
	public void delete(String id) {

		courseUserDao.delete(id);
	}

	/**
	 * 由用户课程表统计出该课程的学生人数
	 * @param courseUser
	 * @return
	 */
	@Override
	public Course countCourseNumbers(CourseUser courseUser) {
		int countNumbers =0;
		Course course = new Course();
		CourseUser cu = new CourseUser();
		cu.setCourseId(courseUser.getCourseId());
		cu.setRoleId(courseUser.getRoleId());
		List<CourseUser> courseUsers = findBySearch(cu);
		course.setCourseNumber(courseUsers.size());
		return course;
	}

	@Override
	public List<SysUser> getCourseStudent(String courseId) {
		CourseUser cu = new CourseUser();
		cu.setCourseId(courseId);
		cu.setRoleId(ConstProject.ROLE_STUDENT_ID);
		List<CourseUser> courseUsers = findBySearch(cu);
		List<SysUser> sys = new ArrayList<SysUser>();
		for(CourseUser cou :courseUsers){
			SysUser user = sysUserDao.getById(cou.getUseId());
			sys.add(user);
		}
		return sys;
	}
 	
}