<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>请假管理
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="leavesForm" class="form-horizontal form-bordered" action="/leaves/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">课程编号:</label>
        <div class="col-md-4">
	          <input type="text" name="courseId" class="form-control" value="${leaves.courseId}"  maxlength="32"/>
        </div>
      </div>
      
  		<div class="form-group">
        <label class="col-md-3 control-label">课程名称:</label>
        <div class="col-md-4">
	          <input type="text" name="courseName" class="form-control" value="${leaves.courseName}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">学生学号:</label>
        <div class="col-md-4">
	          <input type="text" name="userId" class="form-control" value="${leaves.userId}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">学生姓名:</label>
        <div class="col-md-4">
	          <input type="text" name="userName" class="form-control" value="${leaves.userName}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">请假时间:</label>
        <div class="col-md-4">
	          <input type="text" name="leaveTime" class="form-control" value="${leaves.leaveTime}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">请第几次课程:</label>
        <div class="col-md-4">
	          <input type="text" name="leaveNo" class="form-control" value="${leaves.leaveNo}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">审批状态:</label>
        <div class="col-md-4">
	          <input type="text" name="reason" class="form-control" value="${leaves.reason}"  maxlength="256"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">请假理由:</label>
        <div class="col-md-4">
	          <input type="text" name="leaveStatus" class="form-control" value="${leaves.leaveStatus}"  maxlength="32"/>
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
      <input type="hidden" name="id" value="${leaves.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#leavesForm').validate();
	});
</script>