package com.idp.web.test.service;
import com.idp.web.test.entity.Student;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 学生表service接口
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
public interface StudentService{
	
 	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	分页查询
	 * </pre>
	 * 
	 * @param student
	 * @param page
	 * @return
	 */
	public Page<Student> findByPage(Student student,Page<Student> page);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	查询
	 * </pre>
	 * 
	 * @param student
	 * @return
	 */
	public List<Student> findBySearch(Student student);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param Student
	 * @return
	 */
	public Student getById(Integer id);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	新增
	 * </pre>
	 * 
	 * @param student
	 */
	public void add(Student student);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	修改
	 * </pre>
	 * 
	 * @param student
	 */
	public void update(Student student);
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(Integer id);
}
