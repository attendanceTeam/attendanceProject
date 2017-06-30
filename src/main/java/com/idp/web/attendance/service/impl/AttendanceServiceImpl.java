package com.idp.web.attendance.service.impl;
import com.idp.web.attendance.service.AttendanceService;
import com.idp.web.course.entity.Course;
import com.idp.web.course.service.CourseService;
import com.idp.web.attendance.dao.AttendanceDao;
import com.idp.web.attendance.entity.Attendance;
import com.idp.web.attendance.entity.AttendanceCount;
import com.idp.web.attendance.entity.AttendanceSite;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ConstProject;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 出勤管理service实现类
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
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

	@Resource
	private AttendanceDao attendanceDao;
	
	@Resource
	private CourseService courseService;
	
	@Override
	public Page<Attendance> findByPage(Attendance attendance, Page<Attendance> page) {

		page.setResult(attendanceDao.find(attendance, page));
		
		return page;
	}
	
	@Override
	public List<Attendance> findBySearch(Attendance attendance) {

		return attendanceDao.find(attendance);
	}
	
	@Override
	public Attendance getById(String id) {

		return attendanceDao.getById(id);
	}

	@Override
	public void add(Attendance attendance) {

		attendance.setId(ResourceUtils.getUUID());
		attendanceDao.add(attendance);
	}
	
	@Override
	public void update(Attendance attendance) {

		attendanceDao.update(attendance);
	}

	@Override
	public void delete(String id) {

		attendanceDao.delete(id);
	}
		
	/**
	 * 根据学生id和课程id 查询学生该次课程的出勤情况
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@Override
	public boolean findByStudentId(Attendance attendance) {
		int count =0;
		Attendance atten = new Attendance();
		atten.setStudentId(attendance.getStudentId());
		atten.setCourseId(attendance.getCourseId());
		atten.setAttendanceNo(attendance.getAttendanceNo());
		List<Attendance> attendances = attendanceDao.find(atten);
		for(Attendance att:attendances)
		{
			count++;
		}
		if(count ==0)
			return false;
		else {
			return true;

		}
	}
	

	
	/**
	 * 根据课程id 查询no次的出勤情况
	 * @param courseId
	 * @param no
	 * @return
	 */
	@Override
	public int findByCourseId(Attendance attendance) {
		int count =0;
		Attendance atten = new Attendance();
		atten.setCourseId(attendance.getCourseId());
		atten.setAttendanceNo(attendance.getAttendanceNo());
		List<Attendance> attendances2 = attendanceDao.find(atten);
		for(Attendance att:attendances2)
		{
			count++;
		}
		
		return count;
	}

	/**
	 * 根据课程id 和第几次课 来生成座位表的拓扑图
	 * @param courseId
	 * @param no
	 * @return
	 */
	@Override
	public String[][] getLocation(Attendance attendance) {
		Course course = courseService.getById(attendance.getCourseId());
		int raw = course.getClassRaw();
		int lie = course.getClassLie();
		String[][] locations = new String[raw][lie];
		for(int i=0;i<raw;i++){
			for(int j=0 ;j<lie;j++){
				locations[i][j]=new String("空");
			}
		}
		Attendance attendance2 =new Attendance();
		attendance2.setCourseId(attendance.getCourseId());
		attendance2.setAttendanceNo(attendance.getAttendanceNo());
		List<Attendance> attendances=findBySearch(attendance2);
		for(Attendance a:attendances)
		{
			locations[a.getRow()][a.getLie()]=a.getStudentName();
		}
		
		
		return locations;
	}

	
	@Override
	public boolean PositionConflict(Attendance attendance) {
		Attendance a1 = new Attendance();
		a1.setCourseId(attendance.getCourseId());
		a1.setAttendanceNo(attendance.getAttendanceNo());
		a1.setRow(attendance.getRow());
		a1.setLie(attendance.getLie());
		List<Attendance> attendances = findBySearch(a1);
		if(attendances == null){
			return false;
		}
		return true;
	}

	/**
	 * 判断该学生是否重复签到
	 * true表示学生重复签到, false 为学生没有重复签到
	 * @param attendance
	 * @return
	 */
	@Override
	public boolean SuccessSign(Attendance attendance) {
		Attendance ad =new Attendance();
		ad.setCourseId(attendance.getCourseId());
		ad.setAttendanceNo(attendance.getAttendanceNo());
		List<Attendance> attendances = findBySearch(ad);
		if(attendances == null){
			return false;
		}
		return true;
		
	}

	/**
	 * 判断是否是在周*签到
	 * true表示可以签到 日期条件满足
	 * @param attendance
	 * @return
	 */
	@Override
	public boolean DateCanSign(Attendance attendance) {
	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = df.format(new Date()); 
			
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		 Date d =null;
		 Date e=null;
		try {
			d = f.parse(dateNowStr);
			e = f.parse(attendance.getAttendanceTime().toString());
		} catch (ParseException e1) {
		
			e1.printStackTrace();
		}
		 long intervalMilli = d.getTime() - e.getTime();
		 int t= (int) (intervalMilli / (24 * 60 * 60 * 1000));
				if(t%7 ==0){
					return true;
			}
			
			
		return false;
	}

	

	/**
	 * 判断是否可以签到（判断有没有重复签到 ，日期是否可以签到，签到位置是否冲突）
	 * true 表示可以签到 false表示不可以签到
	 * @param attendance
	 * @return
	 */
	@Override
	public boolean CanSign(Attendance attendance) {
		if(SuccessSign(attendance) == false && DateCanSign(attendance) == true && PositionConflict(attendance)  ==false ){
			return true;
		}
		return false;
	}

	
	/**
	 * 根据学生id和课程id查询该学生该们课程的出勤情况
	 * @param attendance
	 * @return
	 */
	@Override
	public int countStudentAttendance(Attendance attendance) {
		int count=0;
		Attendance at = new Attendance();
		at.setCourseId(attendance.getCourseId());
		at.setAttendanceNo(attendance.getAttendanceNo());
		at.setStudentId(attendance.getStudentId());
		List<Attendance> attendances = findBySearch(at);
		for(Attendance a:attendances)
		{
			count++;
		}
		return count;
	}

	@Override
	public int countAttendanceNumbers(Attendance attendance) {
		attendance.setAttendanceStatus(ConstProject.ATTENDANCE_SUCCESS);
		List<Attendance> attendances = findBySearch(attendance);
		return attendances.size();
	}
	
	public List<Attendance> getLeaveNumber(Attendance attendance){
		attendance.setAttendanceStatus(ConstProject.ATTENDANCE_LEAVE);
		List<Attendance> attendances = findBySearch(attendance);
		return attendances;
	}
	
	public List<Attendance> getAbsenceNumber(Attendance attendance){
		attendance.setAttendanceStatus(ConstProject.ATTENDANCE_ABSENCE);
		List<Attendance> attendances = findBySearch(attendance);
		return attendances;
	}

	@Override
	public List<AttendanceCount> getAttendanceCounts(String courseId) {
		int courseCount = courseService.getById(courseId).getCourseCount(); //获取课程出勤次数
		List<AttendanceCount> attendanceCounts = new ArrayList<AttendanceCount>();
		for(int no = 1 ; no <= courseCount ; no++ ){
			Attendance a = new Attendance();
			a.setCourseId(courseId);
			a.setAttendanceNo(no);
			AttendanceCount at = new AttendanceCount();
			at.setNo(no);
			at.setAttendanceNum(countAttendanceNumbers(a));
			List<Attendance> leaves = getLeaveNumber(a);
			at.setLeaveNum(leaves.size());
			List<Attendance> absence = getAbsenceNumber(a);
			at.setAbsenceNum(absence.size());
			at.setAbsenceStudents(absence);
			at.setLeaveStudents(leaves);
			attendanceCounts.add(at);
		}
		return attendanceCounts;
	}
	
	@Override
	public List<AttendanceSite> getAttendanceSites(String courseId) {
		
		Course course = courseService.getById(courseId);
		int courseCount = course.getCourseCount(); //获取课程出勤次数
		int raw = course.getClassRaw() + 1;
		int lie = course.getClassLie() + 1;
		
		List<AttendanceSite> attendanceSites = new ArrayList<AttendanceSite>();
		for(int no = 1 ; no <= courseCount ; no++ ){
			Attendance condition = new Attendance();
			condition.setCourseId(courseId);
			condition.setAttendanceNo(no);	
			AttendanceSite at = new AttendanceSite();
			at.setNo(no);
			at.setCourseId(courseId);
			at.setCourseName(course.getCourseName());
			String[][] locations = new String[raw][lie];
			for(int i=0;i < raw;i++){
				for(int j=0 ;j< lie;j++){
					locations[i][j] = new String("空");
				}
			}
			List<Attendance> attendances = findBySearch(condition);
			for(Attendance a:attendances)
			{
				locations[a.getRow()][a.getLie()]=a.getStudentName();
			}
			at.setSites(locations);
			attendanceSites.add(at);
		}
		
		return attendanceSites;
	
	}
}