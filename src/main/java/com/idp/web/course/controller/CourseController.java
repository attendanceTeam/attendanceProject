package com.idp.web.course.controller;
import com.idp.web.course.entity.Course;
import com.idp.web.course.service.CourseService;
import com.idp.web.courseUser.entity.CourseUser;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;

import net.sf.json.JSONObject;

/**
 * 
 * 课程信息controller
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
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {

	private Logger logger = Logger.getLogger(CourseController.class);

	@Resource
	private CourseService courseService;
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "course/courseSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param course
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list.do" , method = RequestMethod.POST )
	@ResponseBody
	public List<Course> list(@RequestBody CourseUser course,HttpServletRequest request){
		
		List<Course> courseList = courseService.findByUser(course);
		return courseList;
	}

	@RequestMapping(value = "/listNoJoin.do" , method = RequestMethod.POST )
	@ResponseBody
	public List<Course> listNoJoin(@RequestBody CourseUser course,HttpServletRequest request){
		
		List<Course> courseList = courseService.findNoJoin(course);
		return courseList;
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/course")
	public String course(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				Course course = courseService.getById(id);
				request.setAttribute("course", course);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "course/course";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	保存
	 * </pre>
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/save.do" , method = RequestMethod.POST )
	@ResponseBody
	public String save(@RequestBody Course course){
		
		JSONObject json = new JSONObject();
		try {
			// 修改
			if(ValidateUtils.isNotEmpty(course.getId())){
				courseService.update(course);
			}
			// 新增
			else{
				courseService.add(course);
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
	 * 	2017-06-12 lsj
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete.do" , method = RequestMethod.POST )
	@ResponseBody
	public String delete(@RequestBody Course course,HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		
		try {
			
			courseService.delete(course.getId());
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
