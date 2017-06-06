<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>全体管理</title>

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
</head>

<body>

	<%@ include file="common/header.jsp"%>
<form action="roothome" method="get">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation"><a aria-controls="home" role="tab"
							data-toggle="tab">${sessionScope.user.getuserName}さん</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<h4>
							<div class="col-xs-3">
								<label>教室</label>
							</div>
							<div class="col-xs-9">
								<label>全体管理</label>
							</div>
						</h4>
						<h5>
							<div class="col-xs-9">
								<label>権限：ルート</label>
							</div>
						</h5>
						<p>
							<button type="submit" class="btn btn-primary btn-block"
								value="userinfo">ユーザ情報</button>
						</p>
						<p>
							<button type="submit" class="btn btn-primary btn-block"
								value="userconfig">ユーザ管理</button>
						</p>
						<p>
							<button type="submit" class="btn btn-primary btn-block"
								value="trainingconfig">研修管理</button>
						</p>
						<p>
							<button class="btn btn-primary btn-block"
								value="shareconfig">共有ファイルアップロード</button>
						</p>
					</div>
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
											<div class="panel-body">
												<header class="text-left">
													<div class="comment-user">
														<i></i>
													</div>
													<time class="comment-date" datetime="2017:05:31">
														<i class="fa fa-clock-o"></i>2017年05月31日15時30分
													</time>
												</header>
												<div class="comment-post">
													<p>連絡内容：テスト</p>
												</div>
												<!--<p class="text-right"><a href="#" class="btn btn-default btn-sm"><i class="fa fa-reply"></i> reply</a></p>-->
											</div>
											<div class="panel-body">
												<header class="text-left">
													<div class="comment-user">
														<i></i>
													</div>
													<time class="comment-date" datetime="2017:05:30">
														<i class="fa fa-clock-o"></i>2017年05月30日13時20分
													</time>
												</header>
												<div class="comment-post">
													<p>連絡内容：帰る前にクリアデスク</p>
												</div>
												<!--<p class="text-right"><a href="#" class="btn btn-default btn-sm"><i class="fa fa-reply"></i> reply</a></p>-->
											</div>

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
											<div class="panel-body">
												<header class="text-left">
													<div class="comment-user">
														<i class="fa fa-folder"></i>作成者:山田太郎
													</div>
													<time class="comment-date" datetime="2017:05:30">
														<i class="fa fa-clock-o"></i>作成日:2017:05:30
													</time>
												</header>
												<div class="comment-post">
													<p>
														<a href="#">研修日報_0月_株式会社Axiz_名前</a>
													</p>
												</div>
											</div>
										</div>
									</div>
								</article>
							</section>
						</div>
						<div role="tabpanel2" class="tab-pane">共有ファイル</div>
					</div>
				</div>
				<!-- tabs -->
				<!--<div class="card">
					<ul class="nav nav-tabs" role="tablist1">
						<li role="presentation"><a href="#training"
							aria-controls="training" role="tab" data-toggle="tab">研修情報</a></li>
					</ul>-->
					<!-- Tab panes -->
					<!--
					<div class="tab-content">
						<div role="tabpanel1" class="tab-pane active" id="training">-->
							<!--<h2 class="page-header">Search Results</h2>-->
							<!--
							<section class="comment-list">-->
								<!-- First Comment -->
								<!--<article class="row">
									<div class="col-md-10 col-sm-10">
										<div class="panel panel-default arrow left">
											<div class="panel-body">
												<header class="text-left">
													<div class="comment-user">
														<i class="fa fa-graduation-cap"></i>研修情報
													</div>
												</header>
												<div class="comment-post">
													<p>研修内容：経験者向けのJava研修</p>
												</div>
											</div>
										</div>
									</div>
								</article>
							</section>
						</div>
						<div role="tabpanel1" class="tab-pane" id="traning">研修情報</div>
					</div>
				</div>-->
			</div>
		</div>
	</div>
	</form>
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
					//Javasctiptからの遷移？
					location.href = 'schedule.jsp?date='
							+ $('#datepicker').datepicker('getFormattedDate');
				});
	</script>

</body>

</html>