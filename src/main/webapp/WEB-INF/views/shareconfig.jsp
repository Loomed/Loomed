<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>ファイルアップロード</title>

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
														</label> <input type="text" class="form-control" readonly="">
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
									<button type="button" class="btn btn-default"
										data-dismiss="modal">キャンセル</button>
									<button type="button" class="btn btn-primary"
										data-dismiss="modal" onclick="location.href='login.jsp';">OK</button>
								</div>
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
</body>

</html>