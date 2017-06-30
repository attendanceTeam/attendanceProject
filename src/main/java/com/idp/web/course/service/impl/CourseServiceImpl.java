package com.idp.web.course.service.impl;
import com.idp.web.course.service.CourseService;
import com.idp.web.courseUser.dao.CourseUserDao;
import com.idp.web.courseUser.entity.CourseUser;
import com.idp.web.courseUser.service.CourseUserService;
import com.idp.web.course.dao.CourseDao;
import com.idp.web.course.entity.Course;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ConstProject;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 课程信息service实现类
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
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseDao courseDao;
	
	@Resource
	private CourseUserService courseUserService;
	
	@Override
	public Page<Course> findByPage(Course course, Page<Course> page) {

		page.setResult(courseDao.find(course, page));
		
		return page;
	}
	
	@Override
	public List<Course> findBySearch(Course course) {

		return courseDao.find(course);
	}
	
	@Override
	public Course getById(String id) {

		return courseDao.getById(id);
	}

	@Override
	public void add(Course course) {

		course.setId(ResourceUtils.getUUID());
		courseDao.add(course);
	}
	
	@Override
	public void update(Course course) {

		courseDao.update(course);
	}

	@Override
	public void delete(String id) {

		courseDao.delete(id);
	}

	@Override
	public List<Course> findByUser(CourseUser courseUser) {
		if( ConstProject.ROLE_ADMIN_ID.equals(courseUser.getRoleId())){
			return findBySearch(null);
		}else{
		
			List<CourseUser> courseUserList = courseUserService.findBySearch(courseUser);
			List<Course> courseList = new ArrayList<Course>();
			for(CourseUser course:courseUserList){
				Course one = this.getById(course.getCourseId());			
				courseList.add(one);
			}
			return courseList;
		}
		
		
	}

	@Override
	public int countCourseNumbers(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Course> findNoJoin(CourseUser courseUser) {
		
		List<Course> courses = findBySearch(null);
		List<CourseUser> courseUserList = courseUserService.findBySearch(courseUser);
		List<Course> courseNewList = new ArrayList<Course>();
		
	s:	for(Course course:courses){
			for(CourseUser cu:courseUserList){
				if( cu.getCourseId().equals(course.getId()))
					continue s;
			}
			courseNewList.add(course);
		}
		
		return courseNewList;
	}
 	
}