package com.idp.web.attendance.service;
import com.idp.web.attendance.entity.Attendance;
import com.idp.web.attendance.entity.AttendanceCount;
import com.idp.web.attendance.entity.AttendanceSite;

import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 出勤管理service接口
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
public interface AttendanceService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param attendance
	 * @param page
	 * @return
	 */
	public Page<Attendance> findByPage(Attendance attendance,Page<Attendance> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	查询
	 * </pre>
	 * 
	 * @param attendance
	 * @return
	 */
	public List<Attendance> findBySearch(Attendance attendance);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param Attendance
	 * @return
	 */
	public Attendance getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	新增
	 * </pre>
	 * 
	 * @param attendance
	 */
	public void add(Attendance attendance);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	修改
	 * </pre>
	 * 
	 * @param attendance
	 */
	public void update(Attendance attendance);
	
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
	 * 根据学生id和课程id 查询学生该次课程的出勤情况
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public boolean findByStudentId(Attendance attendance);
	
	/**
	 * 根据课程id 查询no次的出勤情况
	 * @param courseId
	 * @param no
	 * @return
	 */
	public int findByCourseId(Attendance attendance);
	
	/**
	 * 根据课程id 和第几次课 来生成座位表的拓扑图
	 * @param courseId
	 * @param no
	 * @return
	 */
	public String[][] getLocation(Attendance attendance);
	
	/**
	 * 根据课程id和上课次数来判断签到位置是否冲突
	 * true为冲突，false为不冲突
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public boolean PositionConflict(Attendance attendance);
	
	/**
	 * 判断该学生是否重复签到
	 * true表示学生重复签到 false 为学生没有重复签到
	 * @param attendance
	 * @return
	 */
	public boolean SuccessSign(Attendance attendance);
	
	/**
	 * 判断是否是在周*签到
	 * true表示可以签到 日期条件满足
	 * @param attendance
	 * @return
	 */
	public boolean DateCanSign(Attendance attendance);
	
	/**
	 * 判断是否可以签到（判断有没有重复签到 ，日期是否可以签到，签到位置是否冲突）
	 * true 表示可以签到 false表示不可以签到
	 * @param attendance
	 * @return
	 */
	public boolean CanSign(Attendance attendance);
	
	/**
	 * 根据学生id和课程id查询该学生该门课程的出勤情况
	 * @param attendance
	 * @return
	 */
	public int countStudentAttendance(Attendance attendance);
	
	/**
	 * 根据课程id 来查询 出勤的人数
	 * @param attendance
	 * @return
	 */
	public int countAttendanceNumbers(Attendance attendance);
	
	/**
	 * 根据课程ID，查出目前课程的出勤情况
	 * @param courseId
	 * @return
	 */
	public List<AttendanceCount> getAttendanceCounts(String courseId);

	/**
	 * 根据课程ID获取当前课程的出勤座位表
	 * @param courseId
	 * @return
	 */
	List<AttendanceSite> getAttendanceSites(String courseId);
}
