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
		.click(function() {

				});


	});
	function hoge() {
		// セレクトボックスで選んだ値のtextを取得
		var pro = $("[name=proNum] option:selected").val();
		$('#newPros').val(pro);
		$('#newPros_01').text(pro);

		var roomName = $('#inputTrainingName').val();
		$('#roomNames').val(roomName);
		$('#newNames_01').text(roomName);

		var info = $('#inputInfo').val();
		$('#newInfo').val(info);
		$('#newInfo_01').text(info);

		$('#change-modal').modal();
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
						<h3 class="panel-title">研修教室情報変更</h3>
					</div>

					<c:set var="LookRoom" value="${sessionScope.LookRoom}" />

					<div class="panel-body">
<!-- 						<form id="changeForm" class="form-horizontal" -->
<!-- 							action="trainingconfig"> -->
						<form action="javascript:hoge()">
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
								<label for="inputInfo" class="col-sm-3 control-label">教室情報</label>
								<div class="col-sm-9">
									<textarea class="form-control" id="inputInfo" name="inputInfo" required>${LookRoom.trainingInfo }</textarea>
									<!--<input type="text" class="form-control" id="inputTrainingName" name="roomName"
										value="${LookRoom.trainingName}" required>-->
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="button" class="btn btn-default"
										onclick="location.href='trainingConfig';">前の画面に戻る</button>
									<button type="submit" class="btn btn-primary pull-right"
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
						研修教室名：<span id="newNames_01"></span>
					</div>
					<div>
						プロジェクタ数：<span id="newPros_01"></span>
					</div>
					<div>
						教室情報：<span id="newInfo_01"></span>
					</div>
					<br>
					お間違いがなければ[OK]ボタンを押してください
				</div>
				<div class="modal-footer">
					<form action="trainingChangeInsert">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>

						<input type="hidden" id="newInfo" value="#" name="newInfo">
						<input type="hidden" id="roomNames" value="aaa" name="roomName">
						<input type="hidden" id="newPros" value="aaa" name="newPro">
						<input type="submit" class="btn btn-primary" id="update"
							value="OK">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>