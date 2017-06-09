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
			var pro = $(':hidden[name="updateid"]').val();
			$(':hidden[name="deleteid"]').val(pro);
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
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("insert").disabled = true;
		document.getElementBy
	}
	function selectFile() {
		if (document.getElementById("upload_file").value === "") {
			document.getElementById("insert").disabled = true;
		} else {
			document.getElementById("insert").disabled = false;
		}
	}
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

							alert(data);
							setInterval(function() {
								location.reload();
							}, 1000);
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
												<label for="inputName" class="col-sm-2 control-label">ファイル名</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="inputName"
														name="inputName" required>
												</div>
											</div>
											<div class="form-group">
												<label for="inputFile" class="col-sm-2 control-label">ファイル</label>
												<div class="col-sm-10">
													<div class="input-group">
														<label>ファイル種類：</label> <select id="select_file_type"
															name="select_file_type">
															<option value=".xlsx">エクセル</option>
															<option value=".pptx">パワーポイント</option>
															<option value=".docx">ワード</option>
															<option value=".txt">テキスト</option>
															<!-- アップロードするファイルを定義していく -->
														</select>
														<p>※ファイルサイズは1MBまでです。</p>
														<label class="input-group-btn"> <span
															class="btn btn-default"> ファイル選択<input type="file"
																id="upload_file" name="upload_file"
																onchange="selectFile()" style="display: none">
														</span>
														</label>
														<!--<input type="text" class="form-control" readonly>-->
													</div>
												</div>
											</div>
											<div class="form-group">
												<p class="col-sm-2 control-label">
													<b>表示/非表示</b>
												</p>
												<div class="col-sm-10">
													<div class="radio-inline">
														<input type="radio" value="1" name="rad"> <label
															for="man">表示</label>
													</div>
													<div class="radio-inline">
														<input type="radio" value="2" name="rad" checked> <label
															for="woman">非表示</label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-offset-1 col-sm-10">
													<input type="hidden" name="dummy">
													<button type="submit" id="insert"
														class="btn btn-primary btn-block">登録</button>
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

										<c:forEach var="list" items="${sessionScope.list}"
											varStatus="status">
											<tr>

												<th>${list.shareId}</th>
												<th><a>${list.title}</a></th>
												<th>${list.uploadDate}</th>
												<th>
													<div class="form-group">
														<form action="sharechange" method="post">
															<c:choose>
																<c:when test="${list.visible == 'true'}">
																	<c:set var="r1">checked</c:set>
																</c:when>
																<c:otherwise>
																	<c:set var="r2">checked</c:set>
																</c:otherwise>
															</c:choose>

															<input type="radio" id="0" name="r1" value="1"
																<c:out value="${r1}" />> 表示 <input type="radio"
																id="1" name="r1" value="2" <c:out value="${r2}" />>
															非表示 <input type="hidden" name="updateid"
																value="${list.shareId}">
															<button type="submit" name="btn" value="1"
																class="btn btn-primary">更新</button>
														</form>
													</div>

												</th>
												<th>
													<button type="submit" name="btn" value="2"
														class="btn btn-danger delete">削除</button>
												</th>
											</tr>
										</c:forEach>
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
										<input type="hidden" name="deleteid" value="">
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