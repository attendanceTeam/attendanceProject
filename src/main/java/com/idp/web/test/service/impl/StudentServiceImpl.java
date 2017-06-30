package com.idp.web.test.service.impl;
import com.idp.web.test.service.StudentService;
import com.idp.web.test.dao.StudentDao;
import com.idp.web.test.entity.Student;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 学生表service实现类
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
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDao studentDao;
	
	@Override
	public Page<Student> findByPage(Student student, Page<Student> page) {

		page.setResult(studentDao.find(student, page));
		
		return page;
	}
	
	@Override
	public List<Student> findBySearch(Student student) {

		return studentDao.find(student);
	}
	
	@Override
	public Student getById(Integer id) {

		return studentDao.getById(id);
	}

	@Override
	public void add(Student student) {

		student.setId(ResourceUtils.getUUID());
		studentDao.add(student);
	}
	
	@Override
	public void update(Student student) {

		studentDao.update(student);
	}

	@Override
	public void delete(Integer id) {

		studentDao.delete(id);
	}
 	
}