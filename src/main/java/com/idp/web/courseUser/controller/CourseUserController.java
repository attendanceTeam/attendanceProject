package com.idp.web.courseUser.controller;
import com.idp.web.courseUser.entity.CourseUser;
import com.idp.web.courseUser.service.CourseUserService;
import com.idp.web.system.entity.SysUser;

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
 * 课程用户信息controller
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
@RequestMapping("/courseUser")
public class CourseUserController extends BaseController {

	private Logger logger = Logger.getLogger(CourseUserController.class);

	@Resource
	private CourseUserService courseUserService;
	
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
		
		return "courseUser/courseUserSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param courseUser
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list.do" , method = RequestMethod.POST)
	public @ResponseBody List<SysUser> list(@RequestBody String courseId,HttpServletRequest request){
		List<SysUser> classes = courseUserService.getCourseStudent(courseId);
		return classes;
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
	@RequestMapping("/courseUser")
	public String courseUser(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				CourseUser courseUser = courseUserService.getById(id);
				request.setAttribute("courseUser", courseUser);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "courseUser/courseUser";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	保存
	 * </pre>
	 * 
	 * @param courseUser
	 * @return
	 */
	@RequestMapping(value = "/save.do" , method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody CourseUser courseUser){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(courseUser.getId())){
				
				courseUserService.update(courseUser);
			}
			// 新增
			else{
				
				courseUserService.add(courseUser);
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
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		
		JSONObject json = new JSONObject();
		
		try {
			
			courseUserService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
