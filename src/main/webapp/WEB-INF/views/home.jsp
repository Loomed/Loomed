<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ホーム</title>

<%@ include file="common/head.jsp"%>

<link rel="stylesheet" href="css/home.css">

<style>
.class-sunday {
	color: red !important;
}

.class-saturday {
	color: blue !important;
}

.datepicker, .table-condensed {
	width: 100%;
}
</style>
<script>
	var downloadAsFile = function(content) {
		var fileName = document.getElementById("");
		var a = document.createElement('a');
		a.download = fileName;
		a.href = 'data:application/octet-stream,' + encodeURIComponent(content);
		a.click();
	};
</script>
</head>

<body>
	<%@ include file="common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation"><a aria-controls="home" role="tab"
							data-toggle="tab">${fn:escapeXml(sessionScope.user.userName)}
								さん</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<h4>
							<div class="col-xs-3">
								<label>教室</label>
							</div>
							<div class="col-xs-9">
								<label>${fn:escapeXml(loginroom.trainingName)}</label>
							</div>
						</h4>
						<p>
							<form:form modelAttribute="userForm" action="userinfo">
								<input type="hidden" id="userId" name="userId"
									value="${loginuser.userId }">
								<button type="submit" class="btn btn-primary btn-block"
									value="userinfo">ユーザ情報</button>
							</form:form>
						</p>
						<p>
							<button type="submit" class="btn btn-primary btn-block"
								onclick="location.href='member'" value="member">研修参加者一覧ページへ</button>
						</p>
						<c:if
							test="${loginuser.authority == 0 || loginuser.authority == 1 }">
							<p>
								<button type="submit" class="btn btn-primary btn-block"
									onclick="location.href='shareconfig'">共有ファイルアップロード</button>
							</p>
						</c:if>
					</div>
					<div class="card">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a aria-controls="home" role="tab"
								data-toggle="tab"><i class="fa fa-envelope-o fa-5x"
									style="margin-right: 20px; margin-left: 20px;"></i></a></li>
							<p class="announcement-heading" style="margin-top: 10px;">
								<span class="badge">${cnt}</span>
							</p>
						</ul>
						<a href="mail">
							<div class="tab-content">
								<div class="row">
									<div class="col-xs-6">メールボックス</div>
									<div class="col-xs-6 text-right">
										<i class="fa fa-arrow-circle-right fa-2x"></i>
									</div>
								</div>
							</div>
						</a>
						</div>
					</div>
					<div class="card">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a href="schedule"
								aria-controls="home" role="tab"><i
									class="fa fa-calendar fa-2x" style="margin-right: 10px;"></i>スケジュール</a>
							</li>
						</ul>
						<div class="tab-content tab-content-extends">
							<!-- カレンダー -->
							<div id="datepicker"></div>
							<a id="scheduledate"></a>
							<!-- #カレンダー -->
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="card">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation"><a aria-controls="home" role="tab"
								data-toggle="tab">重要スケジュール</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="home">
								<!--<h2 class="page-header">Search Results</h2>-->
								<section class="comment-list">
									<!-- First Comment -->
									<article class="row">
										<div class="col-md-10 col-sm-10">
											<div class="panel panel-default arrow left">
												<c:forEach var="list" items="${list}" varStatus="status">
													<div class="panel-body">
														<header class="text-left">
															<div class="comment-user">
																<i></i>
															</div>
															<time class="comment-date"
																datetime="${list.uploadDatetime}">
																<i class="fa fa-clock-o"></i>${list.uploadDatetime}
															</time>
														</header>
														<div class="comment-post">
															<p>連絡内容:${list.scheduleContents}</p>
														</div>
													</div>
												</c:forEach>
											</div>
										</div>
									</article>
								</section>
							</div>
						</div>
					</div>
					<!-- tabs -->
					<div class="card">
						<ul class="nav nav-tabs" role="tablist1">
							<li role="presentation"><a href="shareconfig"
								aria-controls="file" role="tab" data-toggle="tab">ファイル共有</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel2" class="tab-pane active" id="file">
								<!--<h2 class="page-header">Search Results</h2>-->
								<section class="comment-list">
									<!-- First Comment -->
									<article class="row">
										<div class="col-md-10 col-sm-10">
											<div class="panel panel-default arrow left">
											<c:forEach var="map" items="${usermap}" varStatus="staus">
												<c:forEach var="sl" items="${sl}" varStatus="status">
												    <c:if test="${map.trainingId == loginroom.trainingId }">
													<div class="panel-body">
														<header class="text-left">
															<time class="comment-date" datetime="2017:05:30">
																<i class="fa fa-clock-o"></i>作成日:${sl.uploadDate}
															</time>
														</header>

														<div class="comment-post">
															<p>
																<input type="hidden" name="title"
																	value="${sl.shareContents}"> <a
																	href="file:///c:${sl.shareContents}"
																	download="${sl.shareContents}">${sl.title}</a>
															</p>
														</div>
													</div>
													</c:if>
													</c:forEach>
												</c:forEach>
											</div>
										</div>
									</article>
								</section>
							</div>
							<div role="tabpanel2" class="tab-pane">共有ファイル</div>
						</div>
					</div>
					<!-- tabs -->
					<div class="card">
						<ul class="nav nav-tabs" role="tablist1">
							<li role="presentation"><a href="#training"
								aria-controls="training" role="tab" data-toggle="tab">研修情報</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel1" class="tab-pane active" id="training">
								<!--<h2 class="page-header">Search Results</h2>-->
								<section class="comment-list">
									<!-- First Comment -->
									<article class="row">
										<div class="col-md-10 col-sm-10">
											<div class="panel panel-default arrow left">
												<div class="panel-body">
													<header class="text-left">
														<div class="comment-user">
															<i class="fa fa-graduation-cap"></i>研修情報
														</div>
													</header>
													<div class="comment-post">
														<p>研修内容：${fn:escapeXml(loginroom.trainingInfo)}</p>
													</div>
												</div>
											</div>
										</div>
									</article>
								</section>
							</div>
							<div role="tabpanel1" class="tab-pane" id="traning">研修情報</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {
				$('#datepicker').datepicker({
					inline : true,
					format : "yyyy/mm/dd",
					todayHighlight : true,
					language : 'ja',
					toggleActive : true,
					beforeShowDay : function(date) {
						var myDate = new Object();
						if (date.getDay() == 0) {
							myDate.enabled = true;
							myDate.classes = 'class-sunday';
							myDate.tooltip = '日曜日';
						} else if (date.getDay() == 6) {
							myDate.enabled = true;
							myDate.classes = 'class-saturday';
							myDate.tooltip = '土曜日';
						} else {
							myDate.enabled = true;
							myDate.classes = 'class-weekday';
							myDate.tooltip = '平日';
						}
						return myDate;
					}
				});
			});
			$('#datepicker').on(
					'changeDate',
					function() {
						//遷移？
						location.href = 'schedule.jsp?date='
								+ $('#datepicker').datepicker(
										'getFormattedDate');
					});
		</script>
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
							onclick="location.href='login';">OK</button>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {
				$('#datepicker').datepicker({
					inline : true,
					format : "yyyy/mm/dd",
					todayHighlight : true,
					language : 'ja',
					toggleActive : true,
					beforeShowDay : function(date) {
						var myDate = new Object();
						if (date.getDay() == 0) {
							myDate.enabled = true;
							myDate.classes = 'class-sunday';
							myDate.tooltip = '日曜日';
						} else if (date.getDay() == 6) {
							myDate.enabled = true;
							myDate.classes = 'class-saturday';
							myDate.tooltip = '土曜日';
						} else {
							myDate.enabled = true;
							myDate.classes = 'class-weekday';
							myDate.tooltip = '平日';
						}
						return myDate;
					}
				});
			});
			$('#datepicker').on(
					'changeDate',
					function() {
						location.href = 'schedule?date='
								+ $('#datepicker').datepicker(
										'getFormattedDate');
					});
		</script>
</body>

</html>