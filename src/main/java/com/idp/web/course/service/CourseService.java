package com.idp.web.course.service;
import com.idp.web.course.entity.Course;
import com.idp.web.courseUser.entity.CourseUser;

import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 课程信息service接口
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
public interface CourseService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param course
	 * @param page
	 * @return
	 */
	public Page<Course> findByPage(Course course,Page<Course> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	查询
	 * </pre>
	 * 
	 * @param course
	 * @return
	 */
	public List<Course> findBySearch(Course course);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param Course
	 * @return
	 */
	public Course getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	新增
	 * </pre>
	 * 
	 * @param course
	 */
	public void add(Course course);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	修改
	 * </pre>
	 * 
	 * @param course
	 */
	public void update(Course course);
	
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
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 *  根据角色查询课程
	 * </pre>
	 * 
	 * @param course
	 * @return
	 */
	public List<Course> findByUser(CourseUser courseUser);

	/**
	 * 找出学生未参加的所有课程
	 * @param course
	 * @return
	 */
	public List<Course> findNoJoin(CourseUser course);
	
	/**
	 * 统计这门课程下的所有学生人数
	 * @param course
	 * @return
	 */
	public int countCourseNumbers(Course course);
}
