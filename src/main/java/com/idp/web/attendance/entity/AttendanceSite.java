package com.idp.web.attendance.entity;

public class AttendanceSite {
	
	private int no; //标记第几次课
	
	private String courseId;
	
	private String courseName;
	
	private String[][] sites;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String[][] getSites() {
		return sites;
	}

	public void setSites(String[][] sites) {
		this.sites = sites;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
