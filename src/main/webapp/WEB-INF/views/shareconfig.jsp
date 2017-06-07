<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ファイルアップロード</title>

<%@ include file="common/head.jsp"%>
<script>
	$(function() {
		$('.delete').click(function() {
			$('#configDeleteModal').modal();
		});
		$('.change').click(function() {
			//Javasctiptからの遷移？
			location.href = "userchange.jsp";
		});
		$('.reserve').click(function() {
			$('#configReserveModal').modal();
		});
	});
</script>
<script>
	//主処理部
	$(function() {

		// アップロードボタンを押下した
		$("#data_upload_form").submit(
				function(event) {
					// 要素規定の動作をキャンセルする
					event.preventDefault();

					var ajaxUrl = "file/upload?";
					// ファイル種類
					ajaxUrl += "filetype="
							+ $("#select_file_type option:selected").val();

					if (window.FormData) {
						var formData = new FormData($(this)[0]);

						$.ajax({
							type : "POST", // HTTP通信の種類
							url : ajaxUrl, // リクエストを送信する先のURL
							dataType : "text", // サーバーから返されるデータの型
							data : formData, // サーバーに送信するデータ
							processData : false,
							contentType : false,
						}).done(function(data) { // Ajax通信が成功した時の処理
							alert("アップロードが完了しました。");
						}).fail(
								function(XMLHttpRequest, textStatus,
										errorThrown) { // Ajax通信が失敗した時の処理
									alert("アップロードが失敗しました。");
								});
					} else {
						alert("アップロードに対応できていないブラウザです。");
					}
				});
	});
</script>
</head>

<font size="6">ファイル処理</font>
<br>
<br>

<body>
	<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">ファイル管理</h3>
					</div>
					<div class="panel-body">

						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingOne">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">
											ファイル追加はこちらから </a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
										<form id="data_upload_form" enctype="multipart/form-data"
											method="post">
												<div class="form-group">
													<label for="inputName" class="col-sm-2 control-label">表示名</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" id="inputName"
															required>
													</div>
												</div>
												<div class="form-group">
													<label for="inputFile" class="col-sm-2 control-label">ファイル</label>
													<div class="col-sm-10">
														<div class="input-group">
															<label class="input-group-btn"> <span
																class="btn btn-default"> ファイル選択<input type="file"id="upload_file" name="upload_file"
																	style="display: none">
															</span>
															</label> <input type="text" class="form-control" readonly>
														</div>
													</div>
												</div>
												<div class="form-group">
													<p class="col-sm-2 control-label">
														<b>表示/非表示</b>
													</p>
													<div class="col-sm-10">
														<div class="radio-inline">
															<input type="radio" value="1" name="rad1" value="visible" id="man"
																checked> <label for="man">表示</label>
														</div>
														<div class="radio-inline">
															<input type="radio" value="2" name="rad1" value="invisible" id="woman">
															<label for="woman">非表示</label>
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-offset-1 col-sm-10">
														<button type="submit" class="btn btn-primary btn-block">登録</button>
													</div>
												</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">アップロード完了ファイル</h3>
							</div>
							<div class="panel-body">
								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>ファイル名</th>
											<th>アップロード日</th>
											<th>表示/非表示</th>
											<th>削除</th>
										</tr>
									</thead>
									<tbody>
										<!-- ここからリスト処理 -->

										<tr>

											<th>1</th>
											<th><a>04月11日_Webサイト制作_HTML/CSS</a></th>
											<th>4月11日</th>
											<th>
												<div class="form-group">
													<form action="shareupdate" method="post">
														<input type="radio" name="r1" value="表示" checked>
														表示 <input type="radio" name="r1" value="非表示"> 非表示
														<input type="hidden" name="updateid" value="">
														<button class="btn btn-primary">更新</button>
													</form>
												</div>
											</th>
											<th>
												<button class="btn btn-danger delete">削除</button>
											</th>

										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="modal fade" id="configDeleteModal" tabindex="-1">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header modal-header-modify">
									<button type="button" class="close" data-dismiss="modal">
										<span>×</span>
									</button>
									<h4 class="modal-title">削除確認</h4>
								</div>
								<div class="modal-body">
									元に戻すことは出来ません<br> 削除しますか？
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">キャンセル</button>
									<form action="sharedelete" method="post">
										<button type="submit" name="delete" value="delete"
											class="btn btn-danger">削除</button>
									</form>
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