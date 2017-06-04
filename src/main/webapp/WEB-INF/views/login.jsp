<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>ログイン</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/common.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


</head>
<div class="login">

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">ログイン</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" action="index.jsp">
							<div class="form-group">
								<label for="intputUserId" class="col-sm-2 control-label">ユーザID</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputId"
										value="000001" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">パスワード</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPassword"
										value="●●●●●●" required>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="submit" class="btn btn-info btn-block">ログイン</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ログイン失敗ダイアログ -->
	<div class="modal fade" id="deleteModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header modal-header-modify">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">ログイン失敗</h4>
				</div>
				<div class="modal-body">
					ログインに失敗しました<br>IDもしくはPasswordに誤りがあります
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
</div>

</html>