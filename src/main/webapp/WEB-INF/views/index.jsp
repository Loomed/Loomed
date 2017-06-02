<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="home.css" type="text/css" />
<title>研修一覧</title>


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
		$("panel-body").css("display", "none");
		$("panel-body").click(function() {
			$(this).toggleClass("open").next().slideToggle("fast");
		});
	});

	function OnLinkClick() {
		alert("参照する権限を持ちません。");
	}
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
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">山田太郎さん、こんにちは</h3>
					</div>
					<div class="panel-body">
						<h2>
							<a href="roothome.jsp">全体管理</a>
						</h2>

						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading01">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapse01"
											aria-expanded="true" aria-controls="collapse01"> 全教室</a>
									</h4>
								</div>
								<div id="collapse01" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="heading01">
									<ul>
										<li>
											<h3>
												<a href="home.jsp">経験者Java(品川教室)</a>
											</h3>
										</li>
										<li>
											<h3>
												<a href="#">未経験者Java(品川教室)</a>
											</h3>
										</li>
										<li>
											<h3>
												<a href="#">未経験者Java(A教室)</a>
											</h3>
										</li>
										<li>
											<h3>
												<a href="#">経験者Java(B教室)</a>
											</h3>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
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