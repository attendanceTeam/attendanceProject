package com.idp.web.courseUser.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 课程用户信息实体类.
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
public class CourseUser extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**用户课程信息表ID*/
	private String id;
	/**用户ID*/
	private String useId;
	/**课程ID*/
	private String courseId;
	/**角色id*/
	private String roleId;
	/**createUser*/
	private String createUser;
	/**createDate*/
	private Date createDate;
	/**updateUser*/
	private String updateUser;
	/**updateDate*/
	private Date updateDate;
	
	
	/**
	 *方法: 取得String
	 *@return: String  用户课程信息表ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  用户课程信息表ID
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  用户ID
	 */
	public String getUseId(){
		return this.useId;
	}

	/**
	 *方法: 设置String
	 *@param: String  用户ID
	 */
	public void setUseId(String useId){
		this.useId = useId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  课程ID
	 */
	public String getCourseId(){
		return this.courseId;
	}

	/**
	 *方法: 设置String
	 *@param: String  课程ID
	 */
	public void setCourseId(String courseId){
		this.courseId = courseId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  角色id
	 */
	public String getRoleId(){
		return this.roleId;
	}

	/**
	 *方法: 设置String
	 *@param: String  角色id
	 */
	public void setRoleId(String roleId){
		this.roleId = roleId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  createUser
	 */
	public String getCreateUser(){
		return this.createUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  createUser
	 */
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  createDate
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  createDate
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  updateUser
	 */
	public String getUpdateUser(){
		return this.updateUser;
	}

	/**
	 *方法: 设置String
	 *@param: String  updateUser
	 */
	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  updateDate
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  updateDate
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	
	
}
