<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html lang="ja">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>メール</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/common.css">

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- マルチセレクト関連 -->

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.multiselect.filter.js"></script>
<script type="text/javascript" src="js/jquery.multiselect.js"></script>
<script type="text/javascript" src="js/prettify.js"></script>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/jquery.multiselect.filter.css">
<link rel="stylesheet" href="css/jquery.multiselect.css">
<link rel="stylesheet" href="css/prettify.css">
<link rel="stylesheet" href="css/multiselectstyle.css">
<link rel="stylesheet" href="css/jquery-ui.theme.css">
<link rel="stylesheet" href="css/jquery-ui.structure">

<script>
	$(function() {

		jQuery("#multiSelectSample1").multiselect({
			selectedList : 100,
			checkAllText : "全選択",
			uncheckAllText : "全選択解除",
			noneSelectedText : "未選択です",
			selectedText : "# 個選択"
		}).multiselectfilter();
	});
</script>

</head>

<body>

	<!-- 	<div class="panel panel-default"> -->
	<!-- 		<div class="panel-heading">ミニメール</div> -->
	<!-- 		<div class="panel-body"> -->

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
						<h3 class="panel-title">ミニメール</h3>
					</div>
					<div class="panel-body">
						<!--　アコーディオン用パネルグループ -->
						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingOne">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne"> メール作成 </a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
										<form id="changeForm" class="form-horizontal" action="#">
											<div class="form-group has-feedback">
												<label for="inputName" class="control-label"> <span
													class="label label-danger"></span> 宛先
												</label><br>
												<!--<input type="text" class="form-control" placeholder="宛先" data-required-error="宛先が未入力です" required>-->
												<select id="multiSelectSample1" multiple="multiple" size="7"
													style="width: 800px; display: none">
													<optgroup label="講師">
														<option value="option1">項目1</option>
														<option value="option2">項目2</option>
														<option value="option3">項目3</option>
													</optgroup>
													<optgroup label="生徒">
														<option value="option4">項目4</option>
														<option value="option5">項目5</option>
														<option value="option6">項目6</option>
														<option value="option7">項目7</option>
													</optgroup>
												</select> <span class="glyphicon form-control-feedback"
													aria-hidden="true"></span>
												<div class="help-block with-errors"></div>
											</div>

											<div class="form-group has-feedback">
												<label for="inputName" class="control-label"> <span
													class="label label-danger"></span> 件名
												</label> <input type="text" class="form-control" placeholder="件名"
													data-required-error="件名が未入力です" required> <span
													class="glyphicon form-control-feedback" aria-hidden="true"></span>
												<div class="help-block with-errors"></div>
											</div>

											<div class="form-group has-feedback">
												<ul class="nav nav-tabs">
													<li class="active"><a href="#tab1" data-toggle="tab">本文記入</a></li>
													<li><a href="#tab2" data-toggle="tab">遅刻</a></li>
													<li><a href="#tab3" data-toggle="tab">欠席</a></li>
													<li><a href="#tab4" data-toggle="tab">残業</a></li>
												</ul>
												<!-- / タブ-->
												<div id="myTabContent" class="tab-content">
													<div class="tab-pane fade in active" id="tab1">
														<label for="inputName" class="control-label"> <span
															class="label label-danger"></span> 本文
														</label>
														<textarea rows="10" type="text" class="form-control"
															id="inputName" placeholder="本文"
															data-required-error="本文が未入力です" required></textarea>
													</div>
													<div class="tab-pane fade" id="tab2">

														<div class="form-group">
															<label for="inputTime" class="col-sm-2 control-label">到着時間</label>
															<div class="col-sm-7">
																<input type="text" class="form-control" id="inputTime"
																	value="10分" required>
															</div>
														</div>
														<div class="form-group">
															<label for="inputReason" class="col-sm-2 control-label">理由</label>
															<div class="col-sm-7">
																<input type="text" class="form-control" id="inputReason"
																	value="電車遅延のため" required>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="tab3">
														<div class="form-group">
															<label for="inputReason2" class="col-sm-2 control-label">理由</label>
															<div class="col-sm-7">
																<input type="text" class="form-control"
																	id="inputReason2" value="体調不良のため" required>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="tab4">
														<div class="form-group">
															<label for="inputTime2" class="col-sm-2 control-label">残業時間</label>
															<div class="col-sm-7">
																<input type="text" class="form-control" id="inputTime2"
																	value="10分" required>
															</div>
														</div>
														<div class="form-group">
															<label for="inputReason3" class="col-sm-2 control-label">理由</label>
															<div class="col-sm-7">
																<input type="text" class="form-control"
																	id="inputReason3" value="進捗遅れの対応のため" required>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group">


												<span class="glyphicon form-control-feedback"
													aria-hidden="true"></span>
												<div class="help-block with-errors"></div>
											</div>


											<div class="form-group">
												<button type="submit" class="btn btn-primary">送信</button>
											</div>

											<!--　入力フォーム -->
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									受信ボックス
									<div class="btn-group" data-toggle="buttons">
										<label class="btn btn-default active"> <input
											type="radio" name="options" id="option1" autocomplete="off">
											マイボックス
										</label> <label class="btn btn-default"> <input type="radio"
											name="options" id="option2" autocomplete="off">
											すべてのメール
										</label>
									</div>
								</h3>
							</div>
							<div class="panel-body">

								<!--　アコーディオン用パネルグループ -->
								<div class="panel-group" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="heading01">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapse01"
													aria-expanded="true" aria-controls="collapse01">
													宛先:高橋太郎 件名:週報提出しました </a>
												<button class="btn btn-danger delete" data-toggle="modal"
													data-target="#modal-example">削除</button>
											</h4>
										</div>
										<div id="collapse01" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="heading01">
											<div class="panel-body">
												<br>To) 教育事業部 飯田さん <br>cc) 管理部 長野さん 井戸さん <br>
												<br> <br>今週の週報を提出いたします。 <br> <br> <br>以上、よろしくお願い致します。
											</div>
										</div>
									</div>
								</div>


								<div class="panel-group" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-default">
										<div class="panel-heading" role="tab">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapse01"
													aria-expanded="true" aria-controls="collapse01">
													宛先:伊藤太郎 件名:週報提出しました </a>
												<button class="btn btn-danger delete" data-toggle="modal"
													data-target="#modal-example">削除</button>
											</h4>
										</div>
										<div class="panel-collapse collapse" role="tabpanel"
											aria-labelledby="heading01">
											<div class="panel-body">
												<br>To) 教育事業部 飯田さん <br>cc) 管理部 長野さん 井戸さん <br>
												<br> <br>今週の週報を提出いたします。 <br> <br> <br>以上、よろしくお願い致します。
											</div>
										</div>
									</div>
								</div>


							</div>
						</div>

					</div>
				</div>
			</div>
		</div>


		<!-- 2.モーダルの配置 -->
		<div class="modal" id="modal-example" tabindex="-1">
			<div class="modal-dialog">

				<!-- 3.モーダルのコンテンツ -->
				<div class="modal-content">
					<!-- 4.モーダルのヘッダ -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modal-label">削除確認</h4>
					</div>
					<!-- 5.モーダルのボディ -->
					<div class="modal-body">
						元に戻すことは出来ません <br>削除しますか？
					</div>
					<!-- 6.モーダルのフッタ -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
						<button type="button" class="btn btn-danger">削除</button>
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