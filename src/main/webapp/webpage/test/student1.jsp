<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>test
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="student1Form" class="form-horizontal form-bordered" action="/student1/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">name:</label>
        <div class="col-md-4">
	          <input type="text" name="name" class="form-control" value="${student1.name}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">age:</label>
        <div class="col-md-4">
	          <input type="text" name="age" class="form-control" value="${student1.age}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">phone:</label>
        <div class="col-md-4">
	          <input type="text" name="phone" class="form-control" value="${student1.phone}"  maxlength="255"/>
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
      <input type="hidden" name="id" value="${student1.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#student1Form').validate();
	});
</script>