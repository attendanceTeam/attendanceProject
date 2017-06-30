package com.idp.web.leaves.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 请假管理实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2017-06-13 lsj
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
public class Leaves extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**请假ID*/
	private String id;
	/**课程编号*/
	private String courseId;
	/**课程名称*/
	private String courseName;
	/**学生学号*/
	private String userId;
	/**学生姓名*/
	private String userName;
	/**请假时间*/
	private String leaveTime;
	/**请第几次课程*/
	private Integer leaveNo;
	/**审批状态*/
	private String reason;
	/**请假理由*/
	private String leaveStatus;
	/**创建人*/
	private String createUser;
	/**创建时间*/
	private Date createDate;
	/**更新人*/
	private String updateUser;
	/**更新时间*/
	private Date updateDate;
	
	
	/**
	 *方法: 取得String
	 *@return: String  请假ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  请假ID
	 */
	public void setId(String id){
		this.id = id;
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
	 *方法: 取得String
	 *@return: String  学生学号
	 */
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置String
	 *@param: String  学生学号
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  学生姓名
	 */
	public String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置String
	 *@param: String  学生姓名
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  请假时间
	 */
	public String getLeaveTime(){
		return this.leaveTime;
	}

	/**
	 *方法: 设置String
	 *@param: String  请假时间
	 */
	public void setLeaveTime(String leaveTime){
		this.leaveTime = leaveTime;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  请第几次课程
	 */
	public Integer getLeaveNo(){
		return this.leaveNo;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  请第几次课程
	 */
	public void setLeaveNo(Integer leaveNo){
		this.leaveNo = leaveNo;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  审批状态
	 */
	public String getReason(){
		return this.reason;
	}

	/**
	 *方法: 设置String
	 *@param: String  审批状态
	 */
	public void setReason(String reason){
		this.reason = reason;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  请假理由
	 */
	public String getLeaveStatus(){
		return this.leaveStatus;
	}

	/**
	 *方法: 设置String
	 *@param: String  请假理由
	 */
	public void setLeaveStatus(String leaveStatus){
		this.leaveStatus = leaveStatus;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  创建人
	 */
	public String getCreateUser(){
		return this.createUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  创建人
	 */
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  创建时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  更新人
	 */
	public String getUpdateUser(){
		return this.updateUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  更新人
	 */
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  更新时间
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  更新时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	
	
}
