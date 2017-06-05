<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>研修教室一覧</title>

<%@ include file="common/head.jsp"%>

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

<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">

		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">山田太郎さん、こんにちは</h3>
					</div>
					<div class="panel-body">
						<h2>
							<a href="roothome">全体管理</a>
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
												<a href="home">経験者Java(品川教室)</a>
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
</body>

</html>