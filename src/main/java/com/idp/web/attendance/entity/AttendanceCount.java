package com.idp.web.attendance.entity;

import java.util.List;

import com.idp.web.system.entity.SysUser;

public class AttendanceCount {
	
	private int no; //标记第几次课
	
	private int attendanceNum; //出勤人数
	
	public int getAttendanceNum() {
		return attendanceNum;
	}

	public void setAttendanceNum(int attendanceNum) {
		this.attendanceNum = attendanceNum;
	}

	public int getLeaveNum() {
		return leaveNum;
	}

	public void setLeaveNum(int leaveNum) {
		this.leaveNum = leaveNum;
	}

	public int getAbsenceNum() {
		return absenceNum;
	}

	public void setAbsenceNum(int absenceNum) {
		this.absenceNum = absenceNum;
	}

	public List<Attendance> getLeaveStudents() {
		return leaveStudents;
	}

	public void setLeaveStudents(List<Attendance> leaveStudents) {
		this.leaveStudents = leaveStudents;
	}

	public List<Attendance> getAbsenceStudents() {
		return absenceStudents;
	}

	public void setAbsenceStudents(List<Attendance> absenceStudents) {
		this.absenceStudents = absenceStudents;
	}

	private int leaveNum;  //请假人数
	
	private int absenceNum; //缺勤人数
	
	private List<Attendance> leaveStudents; //请假学生具体信息
	
	private List<Attendance> absenceStudents; //缺勤学生具体信息

	public int getNo() {
		return no;
	}

	public void setNo(int No) {
		this.no = No;
	}
}
