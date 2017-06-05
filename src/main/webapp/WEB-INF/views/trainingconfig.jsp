<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>研修教室管理</title>

<%@ include file="common/head.jsp"%>

<script>
	$(function() {
		$('.delete').click(function() {
			$('#deleteModal').modal();
		});

		$('.change').click(function() {
			location.href = "trainingchange.jsp";
		});
	});
</script>
</head>

<body>

<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">研修教室管理</h3>
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
											研修教室追加はこちらから </a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
										<form class="form-horizontal insert">
											<div class="form-group">
												<label for="intputUserId" class="col-sm-3 control-label">教室ID</label>
												<div class="col-sm-9">
													<label for="intputUserId" class="control-label">自動採番</label>
												</div>
											</div>
											<div class="form-group">
												<label for="inputPassword" class="col-sm-3 control-label">研修教室名</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="inputPassword"
														required>
												</div>
											</div>
											<div class="form-group">
												<label for="inputProNum" class="col-sm-3 control-label">プロジェクタ数</label>
												<div class="col-sm-9">
													<select class="form-control" id="inputProNum"
														style="width: auto;">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
														<option>6</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-offset-1 col-sm-10">
													<button type="submit" class="btn btn-default btn-block">新規研修教室立ち上げ</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>


						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>教室ID</th>
									<th>研修教室名</th>
									<th>変更</th>
									<th>削除</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>000001</td>
									<td><a href="home.jsp">経験者Java品川教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>2</td>
									<td>000002</td>
									<td><a href="#">未経験者Java品川教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>3</td>
									<td>000003</td>
									<td><a href="#">経験者C#田町教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>4</td>
									<td>000004</td>
									<td><a href="#">未経験者C#品川教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>5</td>
									<td>000005</td>
									<td><a href="#">経験者C#品川教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>6</td>
									<td>000006</td>
									<td><a href="#">未経験者Java江戸川教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>7</td>
									<td>000007</td>
									<td><a href="#">経験者Java江戸川教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>8</td>
									<td>000008</td>
									<td><a href="#">経験者C#練馬教室</a></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="deleteModal" tabindex="-1">
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
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-danger">削除</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="insertModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header modal-header-modify">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">登録確認</h4>
				</div>
				<div class="modal-body">
					以下の内容で登録します<br> お間違いはありませんか？
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-primary">削除</button>
				</div>
			</div>
		</div>
	</div>

</body>

</html>