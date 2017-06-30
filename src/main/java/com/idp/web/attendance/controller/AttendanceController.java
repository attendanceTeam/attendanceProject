package com.idp.web.attendance.controller;
import com.idp.web.attendance.entity.Attendance;
import com.idp.web.attendance.entity.AttendanceCount;
import com.idp.web.attendance.entity.AttendanceSite;
import com.idp.web.attendance.service.AttendanceService;

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
 * 出勤管理controller
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
@RequestMapping("/attendance")
public class AttendanceController extends BaseController {

	private Logger logger = Logger.getLogger(AttendanceController.class);

	@Resource
	private AttendanceService attendanceService;
	
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
		
		return "attendance/attendanceSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param attendance
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Attendance attendance,Page<Attendance> page,HttpServletRequest request){
//		boolean temp = attendanceService.CanSign(attendance);
//		System.out.println("1111111111"+temp);
	
		try {
			
			request.setAttribute("page", attendanceService.findByPage(attendance, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "attendance/attendanceList";
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
	@RequestMapping("/attendance")
	public String attendance(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				Attendance attendance = attendanceService.getById(id);
				request.setAttribute("attendance", attendance);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "attendance/attendance";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-12 lsj
	 * 	保存
	 * </pre>
	 * 
	 * @param attendance
	 * @return
	 */
	@RequestMapping(value = "/save.do" , method = RequestMethod.POST )
	@ResponseBody
	public String save(@RequestBody Attendance attendance){
		
//		List<Attendance> a =attendanceService.findByCourseId("22", 11);
//		System.out.println("445"+a.size());
		boolean temp =attendanceService.PositionConflict(attendance);
		System.out.println("sfdsaf"+temp);
		JSONObject json = new JSONObject();
		
		try {
			
		
			if(ValidateUtils.isNotEmpty(attendance.getId())){
				
				attendanceService.update(attendance);
			}
			// 新增
			else{
				attendanceService.add(attendance);
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
			
			attendanceService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
	
	@RequestMapping(value = "/attendanceCount.do" , method = RequestMethod.POST )
	@ResponseBody
	public List<AttendanceCount> getAttendanceCounts(@RequestBody String courseId){
		return attendanceService.getAttendanceCounts(courseId);
	}
	
	@RequestMapping(value = "/attendanceSite.do" , method = RequestMethod.POST )
	@ResponseBody
	public List<AttendanceSite> getAttendanceSites(@RequestBody String courseId){
		return attendanceService.getAttendanceSites(courseId);
	}
}
