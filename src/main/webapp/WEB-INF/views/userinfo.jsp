<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザ情報</title>

<%@ include file="common/head.jsp"%>

</head>

<body>

	<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">ユーザ情報</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="intputUserId" class="col-sm-2 control-label">ユーザID</label>
								<div class="col-sm-10">
									<label for="intputUserId" class="control-label"><fmt:formatNumber
											pattern="000000" value="${user.userId}" /></label>
								</div>
							</div>
							<div class="form-group">
								<label for="intputUserName" class="col-sm-2 control-label">氏名</label>
								<div class="col-sm-10">
									<label for="intputUserName" class="control-label"><c:out
											value="${user.userName}" /></label>
								</div>
							</div>
							<c:if test="${loginuser.authority <= 1}">
								<div class="form-group">
									<label class="col-sm-2 control-label">権限</label>
									<div class="col-sm-10">
										<label class="control-label"><c:out
												value="${user.authName}" /></label>
									</div>
								</div>
							</c:if>
							<div class="form-group">
								<label for="inputCompany" class="col-sm-2 control-label">企業名</label>
								<div class="col-sm-10">
									<label for="inputCompany" class="control-label"><c:out
											value="${user.companyName}" /></label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">所属研修教室</label>
								<div class="col-sm-10">
									<ul>
										<c:forEach var="room" items="${user.trainings}">
											<li class="h4"><c:out value="${room.trainingName }" /></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="button" class="btn btn-default"
										onclick="javascript:history.back();">前の画面に戻る</button>
									<button type="button" class="btn btn-primary pull-right"
										onclick="location.href = 'userchange';">ユーザ情報を変更する</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>