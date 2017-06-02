<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>研修教室管理</title>

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


</body>

</html>