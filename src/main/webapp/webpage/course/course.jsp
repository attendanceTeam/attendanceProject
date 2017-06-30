<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>课程信息
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="courseForm" class="form-horizontal form-bordered" action="/course/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">学校编号:</label>
        <div class="col-md-4">
	          <input type="text" name="orgId" class="form-control" value="${course.orgId}"  maxlength="32"/>
        </div>
        
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">学校名称:</label>
        <div class="col-md-4">
	          <input type="text" name="orgName" class="form-control" value="${course.orgName}"  maxlength="64"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">课程名称:</label>
        <div class="col-md-4">
	          <input type="text" name="courseName" class="form-control" value="${course.courseName}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">上课时间:</label>
        <div class="col-md-4">
	          <input type="text" name="courseTime" class="form-control" value="${course.courseTime}"  maxlength="128"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">第几次课:</label>
        <div class="col-md-4">
	          <input type="text" name="courseCount" class="form-control" value="${course.courseCount}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">课程班级座位共几行:</label>
        <div class="col-md-4">
	          <input type="text" name="classRaw" class="form-control" value="${course.classRaw}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">课程班级座位共几列:</label>
        <div class="col-md-4">
	          <input type="text" name="classLie" class="form-control" value="${course.classLie}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">备注:</label>
        <div class="col-md-4">
	          <input type="text" name="courseInfo" class="form-control" value="${course.courseInfo}"  maxlength="128"/>
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
      <input type="hidden" name="id" value="${course.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#courseForm').validate();
	});
</script>