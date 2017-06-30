package com.idp.web.course.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 课程信息实体类.
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
public class Course extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**ID*/
	private String id;
	/**orgID*/
	private String orgId;
	/**orgName*/
	private String orgName;
	/**课程名称*/
	private String courseName;
	/**上课时间*/
	private String courseTime;
	/**上课人数*/
	private Integer courseNumber;
	/**上课地点*/
	private String courseWhere;
	/**第几次课*/
	private Integer courseCount;
	/**课程班级座位共几行*/
	private Integer classRaw;
	/**课程班级座位共几列*/
	private Integer classLie;
	/**备注*/
	private String courseInfo;
	/**创建人ID*/
	private String createUser;
	/**创建时间*/
	private Date createDate;
	/**更新人ID*/
	private String updateUser;
	/**更新时间*/
	private Date updateDate;
	
	
	/**
	 *方法: 取得String
	 *@return: String  ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  ID
	 */
	public void setId(String id){
		this.id = id;
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
	 *@return: String  上课时间
	 */
	public String getCourseTime(){
		return this.courseTime;
	}

	/**
	 *方法: 设置String
	 *@param: String  上课时间
	 */
	public void setCourseTime(String courseTime){
		this.courseTime = courseTime;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  上课人数
	 */
	public Integer getCourseNumber(){
		return this.courseNumber;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  上课人数
	 */
	public void setCourseNumber(Integer courseNumber){
		this.courseNumber = courseNumber;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  上课地点
	 */
	public String getCourseWhere(){
		return this.courseWhere;
	}

	/**
	 *方法: 设置String
	 *@param: String  上课地点
	 */
	public void setCourseWhere(String courseWhere){
		this.courseWhere = courseWhere;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  第几次课
	 */
	public Integer getCourseCount(){
		return this.courseCount;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  第几次课
	 */
	public void setCourseCount(Integer courseCount){
		this.courseCount = courseCount;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  课程班级座位共几行
	 */
	public Integer getClassRaw(){
		return this.classRaw;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  课程班级座位共几行
	 */
	public void setClassRaw(Integer classRaw){
		this.classRaw = classRaw;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  课程班级座位共几列
	 */
	public Integer getClassLie(){
		return this.classLie;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  课程班级座位共几列
	 */
	public void setClassLie(Integer classLie){
		this.classLie = classLie;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  备注
	 */
	public String getCourseInfo(){
		return this.courseInfo;
	}

	/**
	 *方法: 设置String
	 *@param: String  备注
	 */
	public void setCourseInfo(String courseInfo){
		this.courseInfo = courseInfo;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  创建人ID
	 */
	public String getCreateUser(){
		return this.createUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  创建人ID
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
	 *@return: String  更新人ID
	 */
	public String getUpdateUser(){
		return this.updateUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  更新人ID
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

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
}
