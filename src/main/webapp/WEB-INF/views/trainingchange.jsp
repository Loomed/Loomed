<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>研修教室変更</title>

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
// 		jQuery("#changeForm").validationEngine();
		$('#change')
		.click(
				function() {
					// セレクトボックスで選んだ値のtextを取得
					var pro = $("[name=proNum] option:selected").val();
					$('#pro').text(pro);

					var roomName = $("[name=roomName]").val();
					$('#roomName').text(roomName);

					$('#change-modal').modal();
				});

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
						<h3 class="panel-title">研修教室情報変更</h3>
					</div>

					<c:set var="LookRoom" value="${sessionScope.LookRoom}" />

					<div class="panel-body">
						<form id="changeForm" class="form-horizontal"
							action="trainingconfig">
							<div class="form-group">
								<label for="intputUserId" class="col-sm-3 control-label">教室ID</label>
								<div class="col-sm-9">
									<label for="intputUserId" class="control-label" id="roomId" name="roomId"><fmt:formatNumber value="${LookRoom.trainingId}" pattern="000000" /></label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputTrainingName" class="col-sm-3 control-label">研修教室名</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="inputTrainingName" name="roomName"
										value="${LookRoom.trainingName}" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputProNum" class="col-sm-3 control-label">プロジェクタ数</label>
								<div class="col-sm-9">
									<select class="form-control" id="inputProNum" name="proNum"
										style="width: auto;">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
									</select>
									<!--<input type="text" class="form-control" id="inputProNum" value="田中太郎" readonly>-->
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="button" class="btn btn-default"
										onclick="location.href='trainingConfig';">前の画面に戻る</button>
									<button type="button" class="btn btn-primary pull-right"
										id="change">変更</button>
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
					以下の内容で変更します<br><br>
					<div>
						研修教室ID：<span>${LookRoom.trainingId}</span>
					</div>
					<div>
						研修教室名：<span id="roomName"></span>
					</div>
					<div>
						プロジェクタ数：<span id="pro"></span>
					</div>
					<br>
					お間違いがなければ[OK]ボタンを押してください
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-default btn-primary"
						data-dismiss="modal" onclick="location.href='trainingConfig';">OK</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>