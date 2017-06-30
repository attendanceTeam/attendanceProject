<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>学校编号</th>
				<th>学校名称</th>
				<th>课程名称</th>
				<th>上课时间</th>
				<th>第几次课</th>
				<th>课程班级座位共几行</th>
				<th>课程班级座位共几列</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="course" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${course.orgId}</td>
					<td>${course.orgName}</td>
					<td>${course.courseName}</td>
					<td>${course.courseTime}</td>
					<td>${course.courseCount}</td>
					<td>${course.classRaw}</td>
					<td>${course.classLie}</td>
					<td>${course.courseInfo}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/course/course?id=${course.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/course/delete?id=${course.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>