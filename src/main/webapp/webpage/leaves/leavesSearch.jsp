<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="col-md-12">
	<div class="panel-search">
	  <form class="form-inline" action="/leaves/list">
      <div class="form-group">
          <label for="courseId" class="control-label">课程编号：</label>
          <input type="text" name="courseId" class="form-control" />
      </div>
      <div class="form-group">
          <label for="userId" class="control-label">学生学号：</label>
          <input type="text" name="userId" class="form-control" />
      </div>
	  </form>
	  
	  <div class="btn-div">
			<div class="div-left">
				<button type="button" class="btn btn-warning" onclick="add('/leaves/leaves')">
					<i class="fa fa-plus"></i> <spring:message code="btn.add"></spring:message>
				</button>
			</div>
			<div class="div-right">
				<button type="button" class="btn btn-primary" onclick="search()">
					<i class="fa fa-search"></i> <spring:message code="btn.search"></spring:message>
				</button>
		    <button type="button" class="btn btn-default" onclick="reset()">
		    	<i class="fa fa-repeat"></i> <spring:message code="btn.reset"></spring:message>	
		    </button>
			</div>
		</div>
	</div>
	<div class="panel-content"></div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		search();
	});
</script>