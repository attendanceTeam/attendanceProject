package com.idp.web.test.entity;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.idp.common.base.BaseEntity;

/**
 * 
 * 学生表实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2017-06-04 jm
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	jm
 * PG
 *	jm
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class Student extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**name*/
	private String name;
	/**age*/
	private Integer age;
	/**phone*/
	private String phone;
	
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  name
	 */
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置String
	 *@param: String  name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  age
	 */
	public Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  age
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  phone
	 */
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置String
	 *@param: String  phone
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	
}
