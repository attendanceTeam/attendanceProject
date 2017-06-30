<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>课程编号</th>
				<th>课程名称</th>
				<th>学生学号</th>
				<th>学生姓名</th>
				<th>请假时间</th>
				<th>请第几次课程</th>
				<th>审批状态</th>
				<th>请假理由</th>
				<th>操作</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="leaves" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${leaves.courseId}</td>
					<td>${leaves.courseName}</td>
					<td>${leaves.userId}</td>
					<td>${leaves.userName}</td>
					<td>${leaves.leaveTime}</td>
					<td>${leaves.leaveNo}</td>
					<td>${leaves.reason}</td>
					<td>${leaves.leaveStatus}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/leaves/leaves?id=${leaves.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/leaves/delete?id=${leaves.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>