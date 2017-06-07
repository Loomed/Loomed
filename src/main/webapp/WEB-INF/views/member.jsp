<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザ管理</title>

<%@ include file="common/head.jsp"%>

</head>

<body>
	<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">参加者一覧</h3>
					</div>
					<div class="panel-body">
						<div class="panel panel-default">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>氏名</th>
										<th>研修名</th>
										<th>企業名</th>
									</tr>
								</thead>
								<tbody>


									<%
									session.setAttribute("nowRoom",request.getAttribute("loginroom"));
									session.setAttribute("members",request.getAttribute("members"));
									session.setAttribute("membersComp",request.getAttribute("memberscomp"));

									%>
									<c:forEach var="members" items="${sessionScope.members}">
										<c:set var="count" value="${count+1}" />

										<c:forEach var="membersComp" items="${sessionScope.membersComp}">

											<c:if test="${members.companyId==membersComp.companyId}">
												<c:set var="comName" value="${membersComp.companyName}" />

											</c:if>
										</c:forEach>
										<tr>
										<th>${count}</th>
										<th>${members.userName}</th>
										<th>${nowRoom.trainingName}</th>
										<th>${comName}</th>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>