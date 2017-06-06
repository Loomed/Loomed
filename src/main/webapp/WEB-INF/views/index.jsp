<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>研修教室一覧 </title>

<%@ include file="common/head.jsp"%>

<script>
	$(function() {
		$("panel-body").css("display", "none");
		$("panel-body").click(function() {
			$(this).toggleClass("open").next().slideToggle("fast");
		});
	});

	function OnLinkClick() {
		alert("参照する権限を持ちません。");
	}
</script>
</head>

<body>

<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${fn:escapeXml(sessionScope.loginuser.userName)}さん、こんにちは</h3>
					</div>
					<div class="panel-body">
					<c:choose>
						<c:when test="${(sessionScope.loginroom)==0}">
							<h2><a href="roothome">全体管理</a></h2>
						</c:when>
						<c:when test="${(sessionScope.loginroom)!=0}">
							<c:forEach var="room" items="${sessionScope.AllTrainings}">
								<c:if test="${(sessionScope.loginroom)==room.trainingId}">
									<h2><a href="home">${room.trainingName}</a></h2>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>

						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading01">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapse01"
											aria-expanded="true" aria-controls="collapse01"> 全教室一覧</a>
									</h4>
								</div>
								<div id="collapse01" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="heading01">
									<ul>
										<c:forEach var="rooms" items="${sessionScope.AllTrainings}">
											<c:if test="${(sessionScope.loginroom)!=rooms.trainingId && (rooms.trainingId)!=0}">
<%-- 												<c:set var="page" value=rooms.trainingId /> --%>
												<li>
													<h3><a href="home">${rooms.trainingName}</a></h3>
<%-- 													<h3>${page}</h3> --%>
												</li>
											</c:if>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>