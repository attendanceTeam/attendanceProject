package com.idp.web.leaves.controller;
import com.idp.web.course.entity.Course;
import com.idp.web.leaves.entity.Leaves;
import com.idp.web.leaves.service.LeavesService;
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
 * 请假管理controller
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
@Controller
@RequestMapping("/leaves")
public class LeavesController extends BaseController {

	private Logger logger = Logger.getLogger(LeavesController.class);

	@Resource
	private LeavesService leavesService;
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-13 lsj
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "leaves/leavesSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-13 lsj
	 * 	分页查询
	 * </pre>
	 * 
	 * @param leaves
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/list.do" , method = RequestMethod.POST)
	@ResponseBody
	public List<Leaves> list(@RequestBody SysUser user,HttpServletRequest request){
		List<Leaves> leavelist = leavesService.findByUser(user);
		return leavelist;
	}

	/**
	 * 
	 * <pre>
	 * 	2017-06-13 lsj
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/leaves")
	public String leaves(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				Leaves leaves = leavesService.getById(id);
				request.setAttribute("leaves", leaves);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "leaves/leaves";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2017-06-13 lsj
	 * 	保存
	 * </pre>
	 * 
	 * @param leaves
	 * @return
	 */
	@RequestMapping(value = "/save.do" , method = RequestMethod.POST )
	@ResponseBody
	public String save(@RequestBody Leaves leaves){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(leaves.getId())){
				
				leavesService.update(leaves);
			}
			// 新增
			else{
				System.out.println("2222222222");
				leavesService.add(leaves);
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
	 * 	2017-06-13 lsj
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete.do" , method = RequestMethod.POST )
	@ResponseBody
	public String delete(@RequestBody Leaves leaves,HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		
		try {
			
			leavesService.delete(leaves.getId());
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
	
	@RequestMapping(value ="/find.do" , method = RequestMethod.POST)
	@ResponseBody
	public List<Leaves> find(@RequestBody String userId,HttpServletRequest request){
		Leaves leaves = new Leaves();
		leaves.setUserId(userId);
		List<Leaves> leavelist = leavesService.findBySearch(leaves);
		return leavelist;
	}
}
