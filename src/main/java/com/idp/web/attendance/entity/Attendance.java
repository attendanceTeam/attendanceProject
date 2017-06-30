package com.idp.web.attendance.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 出勤管理实体类.
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
public class Attendance extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**学生学号*/
	private String studentId;
	/**学生姓名*/
	private String studentName;
	/**课程编号*/
	private String courseId;
	/**课程名称*/
	private String courseName;
	/**考勤第几次*/
	private Integer attendanceNo;
	/**学生坐在第几行*/
	private Integer row;
	/**学生做在第几列*/
	private Integer lie;
	/**考勤状态（未标记、出勤、迟到、早退、旷课）*/
	private String attendanceStatus;
	/**考勤时间*/
	private Date attendanceTime;
	/**备注*/
	private String info;
	
	
	/**
	 *方法: 取得String
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  学生学号
	 */
	public String getStudentId(){
		return this.studentId;
	}

	/**
	 *方法: 设置String
	 *@param: String  学生学号
	 */
	public void setStudentId(String studentId){
		this.studentId = studentId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  学生姓名
	 */
	public String getStudentName(){
		return this.studentName;
	}

	/**
	 *方法: 设置String
	 *@param: String  学生姓名
	 */
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  课程编号
	 */
	public String getCourseId(){
		return this.courseId;
	}

	/**
	 *方法: 设置String
	 *@param: String  课程编号
	 */
	public void setCourseId(String courseId){
		this.courseId = courseId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  课程名称
	 */
	public String getCourseName(){
		return this.courseName;
	}

	/**
	 *方法: 设置String
	 *@param: String  课程名称
	 */
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  考勤第几次
	 */
	public Integer getAttendanceNo(){
		return this.attendanceNo;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  考勤第几次
	 */
	public void setAttendanceNo(Integer attendanceNo){
		this.attendanceNo = attendanceNo;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  学生坐在第几行
	 */
	public Integer getRow(){
		return this.row;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  学生坐在第几行
	 */
	public void setRow(Integer row){
		this.row = row;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  学生做在第几列
	 */
	public Integer getLie(){
		return this.lie;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  学生做在第几列
	 */
	public void setLie(Integer lie){
		this.lie = lie;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  考勤状态（未标记、出勤、迟到、早退、旷课）
	 */
	public String getAttendanceStatus(){
		return this.attendanceStatus;
	}

	/**
	 *方法: 设置String
	 *@param: String  考勤状态（未标记、出勤、迟到、早退、旷课）
	 */
	public void setAttendanceStatus(String attendanceStatus){
		this.attendanceStatus = attendanceStatus;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  考勤时间
	 */
	public Date getAttendanceTime(){
		return this.attendanceTime;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  考勤时间
	 */
	public void setAttendanceTime(Date attendanceTime){
		this.attendanceTime = attendanceTime;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  备注
	 */
	public String getInfo(){
		return this.info;
	}

	/**
	 *方法: 设置String
	 *@param: String  备注
	 */
	public void setInfo(String info){
		this.info = info;
	}
	
	
}
