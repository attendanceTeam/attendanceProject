package com.idp.web.test.controller;
import com.idp.web.test.entity.Student;
import com.idp.web.test.service.StudentService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;

import net.sf.json.JSONObject;

/**
 * 
 * 学生表controller
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
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

	private Logger logger = Logger.getLogger(StudentController.class);

	@Resource
	private StudentService studentService;
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "test/studentSearch";
	}
	
	
	@RequestMapping("/list1")
	public  @ResponseBody List<Student> list1(){
		return studentService.findBySearch(null);
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	分页查询
	 * </pre>
	 * 
	 * @param student
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Student student,Page<Student> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", studentService.findByPage(student, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "test/studentList";
	}

	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/student")
	public String student(Integer id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				Student student = studentService.getById(id);
				request.setAttribute("student", student);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "test/student";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	保存
	 * </pre>
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(Student student){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(student.getId())){
				
				studentService.update(student);
			}
			// 新增
			else{
				
				studentService.add(student);
			}
			json.put("result", "save_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}
		
		return json.toString();
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-04 jm
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id){
		
		JSONObject json = new JSONObject();
		
		try {
			
			studentService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
