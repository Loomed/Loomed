<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザ変更 </title>

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
		$('.combobox').combobox();
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
						<form:form id="changeForm" modelAttribute="userChangeForm" class="form-horizontal"
							action="userinfo" method="POST" submit-flag="false">
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">ユーザID</label>
								<div class="col-sm-10">
									<input name="userId" id="userId" class="form-control"
										value="000001" readonly>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">パスワード</label>
								<div class="col-sm-10">
									<input id="password" name="password" class="form-control"
										value="●●●●●●" />
								</div>
							</div>
							<div class="form-group">
								<label for="userName" class="col-sm-2 control-label">氏 名</label>
								<div class="col-sm-10">
									<input id="userName" name="userName" class="form-control"
										value="田中太郎" required />
								</div>
							</div>
							<div class="form-group">
								<label for="companyId" class="col-sm-2 control-label">企業名</label>
								<div class="col-sm-10 select-container">
									<select id="companyId" name="companyId"
										class="combobox form-control">
										<option value=""></option>
										<option value="1">株式会社Axiz</option>
										<option value="2">株式会社コンピュータ・ハイテック・ビジュアルソリューション・グローバルパワー</option>
										<option value="3">株式会社プリウス</option>
										<option value="4">クラウン株式会社</option>
										<option value="5">ソニーグループ株式会社</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">権限</label>
								<div class="col-sm-10">
									<select id="authority" name="authority" class="form-control">
										<option value="0" selected>ルートユーザ</option>
										<option value="1">講師</option>
										<option value="2">担当者</option>
										<option value="3">研修生</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="trainingId" class="col-sm-2 control-label">配属研修教室</label>
								<div class="col-sm-10">
									<select id="training" name="training" class="form-control">
										<option>研修教室選択なし</option>
										<option value="1" selected>研修教室管理</option>
										<option value="2">経験者Java品川教室</option>
										<option value="3">未経験者Java品川教室</option>
										<option value="4">経験者C#田町教室</option>
										<option value="5">未経験者C#品川教室</option>
										<option value="6">経験者C#品川教室</option>
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
						</form:form>
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
					<button id="modal-ok" type="button" class="btn btn-primary"
						data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>

	<script>
	$('#changeForm').submit(function() {
		$('#change-modal').modal('toggle');
		if ($('#changeForm').attr('submit-flag') == 'false') {
			return false;
		}
	});

	$('#modal-ok').click(function() {
		$('#changeForm').attr('submit-flag', 'true');
		$('#changeForm').submit();
	});

	$('#change-modal').on('show.bs.modal', function(e) {
		$('form').attr('submit-flag', 'false');
	});
	</script>
</body>

</html>