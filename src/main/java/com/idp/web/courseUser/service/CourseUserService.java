package com.idp.web.courseUser.service;
import com.idp.web.course.entity.Course;
import com.idp.web.courseUser.entity.CourseUser;
import com.idp.web.system.entity.SysUser;

import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 课程用户信息service接口
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
public interface CourseUserService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param courseUser
	 * @param page
	 * @return
	 */
	public Page<CourseUser> findByPage(CourseUser courseUser,Page<CourseUser> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	查询
	 * </pre>
	 * 
	 * @param courseUser
	 * @return
	 */
	public List<CourseUser> findBySearch(CourseUser courseUser);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param CourseUser
	 * @return
	 */
	public CourseUser getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	新增
	 * </pre>
	 * 
	 * @param courseUser
	 */
	public void add(CourseUser courseUser);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	修改
	 * </pre>
	 * 
	 * @param courseUser
	 */
	public void update(CourseUser courseUser);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 由用户课程表统计出该课程的学生人数
	 * @param courseUser
	 * @return
	 */
	public Course countCourseNumbers(CourseUser courseUser);
	
	/**
	 * 根据课程ID获取课程学生表
	 * @param courseId
	 * @return
	 */
	public List<SysUser> getCourseStudent(String courseId);
}
