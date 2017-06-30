<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>学生学号</th>
				<th>学生姓名</th>
				<th>课程编号</th>
				<th>课程名称</th>
				<th>考勤第几次</th>
				<th>学生坐在第几行</th>
				<th>操作</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="attendance" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${attendance.studentId}</td>
					<td>${attendance.studentName}</td>
					<td>${attendance.courseId}</td>
					<td>${attendance.courseName}</td>
					<td>${attendance.attendanceNo}</td>
					<td>${attendance.row}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/attendance/attendance?id=${attendance.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/attendance/delete?id=${attendance.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>