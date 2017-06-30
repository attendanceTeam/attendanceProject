package com.idp.common.util;

public class ConstProject {
	public static final String ROLE_ADMIN_ID ="001";	
	public static final String ROLE_TEACHER_ID ="002";
	public static final String ROLE_STUDENT_ID ="003";
	//设置最初的日期（开学日期）用以计算当前时间是第几周
	public static final String BEGIN_DATE ="2017-1-1";
	

//	public static final String BEGIN_CLASS_TIME ="8:00";
//	public static final String END_CLASS_TIME ="10:00";
	
	//设置周几可以签到
	public static final int WEEK = 1;
	
	//考勤--未标记
	public static final String ATTENDANCE_NO_MARK = "0";
	//考勤--成功
	public static final String ATTENDANCE_SUCCESS = "1";
	//考勤--迟到
	public static final String ATTENDANCE_LATER = "2";
	//考勤--缺勤
	public static final String ATTENDANCE_ABSENCE = "3";
	//考勤--请假
	public static final String ATTENDANCE_LEAVE = "4";
	
}
