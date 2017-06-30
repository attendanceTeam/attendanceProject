package com.idp.web.leaves.service.impl;
import com.idp.web.leaves.service.LeavesService;
import com.idp.web.system.entity.SysUser;
import com.idp.web.course.entity.Course;
import com.idp.web.course.service.CourseService;
import com.idp.web.courseUser.entity.CourseUser;
import com.idp.web.courseUser.service.CourseUserService;
import com.idp.web.leaves.dao.LeavesDao;
import com.idp.web.leaves.entity.Leaves;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ConstProject;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 请假管理service实现类
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
 * PGcourse
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
@Service("leavesService")
public class LeavesServiceImpl implements LeavesService {

	@Resource
	private LeavesDao leavesDao;
	
	@Resource
	private CourseUserService courseUserService;
	
	@Resource
	private CourseService courseService;
	
	@Override
	public Page<Leaves> findByPage(Leaves leaves, Page<Leaves> page) {

		page.setResult(leavesDao.find(leaves, page));
		
		return page;
	}
	
	@Override
	public List<Leaves> findBySearch(Leaves leaves) {

		return leavesDao.find(leaves);
	}
	
	@Override
	public Leaves getById(String id) {

		return leavesDao.getById(id);
	}

	@Override
	public void add(Leaves leaves) {

		leaves.setId(ResourceUtils.getUUID());
		leavesDao.add(leaves);
	}
	
	@Override
	public void update(Leaves leaves) {

		leavesDao.update(leaves);
	}

	@Override
	public void delete(String id) {

		leavesDao.delete(id);
	}

	@Override
	public List<Leaves> getStudentLeave(String studentId) {
		Leaves leave = new Leaves();
		leave.setUserId(studentId);
		return leavesDao.find(leave);
	}

	@Override
	public List<Leaves> getCourseLeave(String courseId, String leaveStatus) {
		Leaves leave = new Leaves();
		leave.setCourseId(courseId);
		leave.setLeaveStatus(leaveStatus);
		return leavesDao.find(leave);
	}

	@Override
	public List<Leaves> getTeacherLeave(String teacherId, String leaveStatus) {
		CourseUser courseUser = new CourseUser();
		courseUser.setCourseId(teacherId);
		courseUser.setRoleId(ConstProject.ROLE_TEACHER_ID);
		List<CourseUser> courses = courseUserService.findBySearch(courseUser);
		
		List<Leaves> leaves = new ArrayList<Leaves>();
		for(CourseUser course:courses)
		{
			Leaves leave = new Leaves();
			leave.setCourseId(course.getCourseId());
			leave.setLeaveStatus(leaveStatus);
			leaves.addAll(leavesDao.find(leave));
		}
		
		return leaves;
	}

	@Override
	public List<Leaves> findByUser(SysUser user) {
		String roleId = user.getRoleIds().split(",")[0];
		if( ConstProject.ROLE_ADMIN_ID.equals(roleId)){
			List<Leaves> leaveList2 = findBySearch(null);
			return leaveList2;
		}
		List<Leaves> leaveList = new ArrayList<Leaves>();
		//如果是老师，查询出他相关的课程，根据课程id，来查找到所有的请假信息。
		if (ConstProject.ROLE_TEACHER_ID.equals(roleId)) {
			CourseUser cUser = new CourseUser();
			cUser.setUseId(user.getId());
			//查询出和这个教师相关的课程信息列表
			List<Course> courselist = courseService.findByUser(cUser);
			for(int i=0;i<courselist.size();i++){
				List<Leaves> one = this.getCourseLeave(courselist.get(i).getId(), null);
				leaveList.addAll(one);
			}
			
		}

		return leaveList;
	}

	/**
	 * 根据学生id和课程id 查询该学生该门课程的请假次数
	 * @param leaves
	 * @return
	 */
	@Override
	public int countStudentLeaves(Leaves leaves) {
		int count =0;
		Leaves leave = new Leaves();
		leave.setCourseId(leaves.getCourseId());
		leave.setLeaveNo(leaves.getLeaveNo());
//		leave.setUserId(leaves.getUserId());
		List<Leaves> les = findBySearch(leave);
		for(Leaves  le: les){
			count++;
		}
		return count;
	}

	@Override
	public List<Leaves> findByCourse(String useId) {
		Leaves leaves = new Leaves();
		leaves.setUserId(useId);
		List<Leaves> les = leavesDao.find(leaves);
		return les;
	}
 	
	
}