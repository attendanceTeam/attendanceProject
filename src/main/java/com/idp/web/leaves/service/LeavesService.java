package com.idp.web.leaves.service;
import com.idp.web.course.entity.Course;
import com.idp.web.leaves.entity.Leaves;
import com.idp.web.system.entity.SysUser;

import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 请假管理service接口
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
public interface LeavesService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param leaves
	 * @param page
	 * @return
	 */
	public Page<Leaves> findByPage(Leaves leaves,Page<Leaves> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	查询
	 * </pre>
	 * 
	 * @param leaves
	 * @return
	 */
	public List<Leaves> findBySearch(Leaves leaves);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param Leaves
	 * @return
	 */
	public Leaves getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	新增
	 * </pre>
	 * 
	 * @param leaves
	 */
	public void add(Leaves leaves);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	修改
	 * </pre>
	 * 
	 * @param leaves
	 */
	public void update(Leaves leaves);
	
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
	 * 根据学生id获取课程列表
	 * @param studentId
	 * @return
	 */
	public List<Leaves> getStudentLeave(String studentId);
	
	/**
	 * 根据课程id，请假状态去获取课程相关请假情况。
	 * @param courseId
	 * @param leaveStatus
	 * @return
	 */
	public List<Leaves> getCourseLeave(String courseId,String leaveStatus);
	
	/**
	 * 根据教师ID 查询 假条状态 为 已批准 未审核 拒绝的假条列表
	 * @param teacherId
	 * @param leaveStatus
	 * @return
	 */
	public List<Leaves> getTeacherLeave(String teacherId,String leaveStatus);

	/**
	 * 根据用户查找所有请假信息
	 * @param user
	 * @return
	 */
	public List<Leaves> findByUser(SysUser user);
	
	/**
	 * 根据课程id 和上课次数 统计该门课程的请假人数
	 * @param leaves
	 * @return
	 */
	public int countStudentLeaves(Leaves leaves);
	
	public List<Leaves> findByCourse(String useId);

}
