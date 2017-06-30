<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>name</th>
				<th>age</th>
				<th>phone</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="student1" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${student1.name}</td>
					<td>${student1.age}</td>
					<td>${student1.phone}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/student1/student1?id=${student1.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/student1/delete?id=${student1.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>