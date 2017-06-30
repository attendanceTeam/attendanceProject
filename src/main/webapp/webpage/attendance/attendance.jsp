<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>出勤管理
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="attendanceForm" class="form-horizontal form-bordered" action="/attendance/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">学生学号:</label>
        <div class="col-md-4">
	          <input type="text" name="studentId" class="form-control" value="${attendance.studentId}"  maxlength="32"/>
        </div>
        
      </div>   
  		<div class="form-group">
        <label class="col-md-3 control-label">学生姓名:</label>
        <div class="col-md-4">
	          <input type="text" name="studentName" class="form-control" value="${attendance.studentName}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">课程编号:</label>
        <div class="col-md-4">
	          <input type="text" name="courseId" class="form-control" value="${attendance.courseId}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">课程名称:</label>
        <div class="col-md-4">
	          <input type="text" name="courseName" class="form-control" value="${attendance.courseName}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">考勤第几次:</label>
        <div class="col-md-4">
	          <input type="text" name="attendanceNo" class="form-control" value="${attendance.attendanceNo}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">学生坐在第几行:</label>
        <div class="col-md-4">
	          <input type="text" name="row" class="form-control" value="${attendance.row}"  maxlength="10"/>
        </div>
      </div>
      <div class="form-actions">
        <div class="col-md-9 col-md-offset-3">
          <button type="button" class="btn btn-primary" onclick="save(this)">
          	<spring:message code="btn.save"></spring:message>
          </button>
          <button type="reset" class="btn btn-default" onclick="cancel()">
          	<spring:message code="btn.return"></spring:message>
          </button>
        </div>
      </div>
      <input type="hidden" name="id" value="${attendance.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#attendanceForm').validate();
	});
</script>