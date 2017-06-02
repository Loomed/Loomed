<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>ユーザ情報変更</title>

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
	src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Validation-Engine/2.6.4/jquery.validationEngine.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Validation-Engine/2.6.4/languages/jquery.validationEngine-ja.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<style>
table>tbody>tr>td, .table>tbody>tr>th {
	border-style: none !important;
}

table>td>input {
	width: 100px;
}
</style>
<script>
	$(function() {
		jQuery("#changeForm").validationEngine();
	});
</script>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<!-- href内はセッションにより変わる
                    1.セッションに値がなければindex
                    2.セッションに値があればそれぞれのhome
                    今回はルートなのでroothome.jspとする
            　  -->
				<a class="navbar-brand" href="roothome.jsp"> </a>
				<p class="navbar-text navbar-right">
					<a href="index.jsp" class="navbar-link">研修教室名一覧</a> <a
						type="button" class="btn btn-info navbar-btn navbar-btn-modify"
						onclick="$('#logout-modal').modal();">ログアウト</a>
				</p>
			</div>
		</div>
	</nav>
	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">ユーザ情報変更</h3>
					</div>
					<div class="panel-body">
						<form id="changeForm" class="form-horizontal"
							action="userinfo.jsp">
							<div class="form-group">
								<label for="intputUserId" class="col-sm-2 control-label">ユーザID</label>
								<div class="col-sm-10">
									<label for="intputUserId" class="control-label">000001</label>
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
								<label for="inputName" class="col-sm-2 control-label">氏
									名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName"
										value="田中太郎" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputCompany" class="col-sm-2 control-label">企業名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputCompany"
										value="株式会社Axiz" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputCompany" class="col-sm-2 control-label">権限</label>
								<div class="col-sm-10">
									<select class="form-control">
										<option selected>ルートユーザ</option>
										<option>講師</option>
										<option>担当者</option>
										<option>研修生</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputTraining" class="col-sm-2 control-label">配属研修教室</label>
								<div class="col-sm-10">
									<select class="form-control">
										<option>研修教室選択なし</option>
										<option selected>研修教室管理</option>
										<option>経験者Java品川教室</option>
										<option>未経験者Java品川教室</option>
										<option>経験者C#田町教室</option>
										<option>未経験者C#品川教室</option>
										<option>経験者C#品川教室</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="button" class="btn btn-default"
										onclick="location.href='userinfo.jsp';">前の画面に戻る</button>
									<button type="button" class="btn btn-primary pull-right"
										onclick="$('#change-modal').modal();">変更</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ログアウト確認ダイアログ -->
	<div class="modal fade" id="logout-modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header modal-header-modify">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">ログアウト確認</h4>
				</div>
				<div class="modal-body">
					ログアウトしますか？<br>[OK]ボタンを押すとログアウトされ、ログイン画面に移動します
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						onclick="location.href='login.jsp';">OK</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 変更確認ダイアログ -->
	<div class="modal fade" id="change-modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header modal-header-modify">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">変更確認</h4>
				</div>
				<div class="modal-body">
					以下の内容で変更します<br>...<br>お間違いがなければ[OK]ボタンを押してください
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						onclick="location.href='userinfo.jsp';">OK</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>