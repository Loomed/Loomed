<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			location.href = "userchange.jsp";
		});
		$('.reserve').click(function() {
			$('#configReserveModal').modal();
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
										<form id="changeForm" class="form-horizontal" action="#">
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
															class="btn btn-default"> ファイル選択<input type="file"
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
														<input type="radio" value="1" name="gender" id="man"
															checked> <label for="man">表示</label>
													</div>
													<div class="radio-inline">
														<input type="radio" value="2" name="gender" id="woman">
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
										<tr>
											<th>1</th>
											<th><a>04月11日_Webサイト制作_HTML/CSS</a></th>
											<th>4月11日</th>
											<th>
												<div class="form-group">
													<input type="radio" name="r1" value="表示" checked>
													表示 <input type="radio" name="r1" value="非表示"> 非表示
													<button class="btn btn-primary">更新</button>
												</div>
											</th>
											<th>
												<button class="btn btn-danger delete">削除</button>
											</th>
										</tr>
										<tr>
											<th>2</th>
											<th><a>04月12日_Webサイト制作_タグ/プロパティ/フォーム部品</a></th>
											<th>4月12日</th>
											<th>
												<div class="form-group">
													<input type="radio" name="r2" value="表示" checked>
													表示 <input type="radio" name="r2" value="非表示"> 非表示
													<button class="btn btn-primary">更新</button>
												</div>
											</th>
											<th>
												<button class="btn btn-danger delete">削除</button>
											</th>
										</tr>
										<tr>
											<th>3</th>
											<th><a>04月13日_Webサイト制作_JavaScript/jQuery</a></th>
											<th>4月13日</th>
											<th>
												<div class="form-group">
													<input type="radio" name="r3" value="表示" checked>
													表示 <input type="radio" name="r3" value="非表示"> 非表示
													<button class="btn btn-primary">更新</button>
												</div>
											</th>
											<th>
												<button class="btn btn-danger delete">削除</button>
											</th>
										</tr>
										<tr>
											<th>4</th>
											<th><a>Webサイト制作_確認テスト</a></th>
											<th>4月14日</th>
											<th>
												<div class="form-group">
													<input type="radio" name="r4" value="表示" checked>
													表示 <input type="radio" name="r4" value="非表示"> 非表示
													<button class="btn btn-primary">更新</button>
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
									<button type="button" class="btn btn-danger">削除</button>
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