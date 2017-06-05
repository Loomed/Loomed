<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザ変更</title>

<%@ include file="common/head.jsp"%>

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
	<%@ include file="common/header.jsp"%>
	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">ユーザ情報変更</h3>
					</div>
					<div class="panel-body">
						<form id="changeForm" class="form-horizontal"
							action="userinfo">
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
										onclick="location.href='userinfo';">前の画面に戻る</button>
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
						onclick="location.href='userinfo';">OK</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>