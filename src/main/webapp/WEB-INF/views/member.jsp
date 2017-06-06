<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザ管理</title>

<%@ include file="common/head.jsp"%>

</head>

<body>
	<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">参加者一覧</h3>
					</div>
					<div class="panel-body">
						<div class="panel panel-default">
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>氏名</th>
										<th>研修名</th>
										<th>企業名</th>
									</tr>
								</thead>
								<tbody>
								<c:set var="nowRoom" value="${request.getAttribute(ScopeKey.LOGINROOM.getScopeKey())}" />
									<c:forEach var="member" items="${request.getAttribute(ScopeKey.MEMBERS.getScopeKey())}">
										<c:set var="count" value="${count+1}" />
										<out value="${count}" />
										<tr>
											<th>${count}</th>
											<th>${member.userName}</th>
											<th>${nowRoom.trainingName}</th>
											<th>会社名どうする？</th>
										</tr>
									</c:forEach>

									<tr>
										<th>1</th>
										<th>山田太郎</th>
										<th>経験者Java品川教室</th>
										<th>株式会社Axiz</th>
									</tr>
									<tr>
										<th>2</th>
										<th>鈴木太郎</th>
										<th>経験者Java品川教室</th>
										<th>コンピュータ・ハイテックホールディングスジャパン株式会社</th>
									</tr>
									<tr>
										<th>3</th>
										<th>高橋太郎</th>
										<th>経験者Java品川教室</th>
										<th>コンピュータ・ハイテックホールディングスジャパン株式会社</th>
									</tr>
									<tr>
										<th>4</th>
										<th>田中太郎</th>
										<th>経験者Java品川教室</th>
										<th>株式会社プリウス</th>
									</tr>
									<tr>
										<th>5</th>
										<th>渡辺太郎</th>
										<th>経験者Java品川教室</th>
										<th>株式会社フィット</th>
									</tr>
									<tr>
										<th>6</th>
										<th>中村次郎</th>
										<th>経験者Java品川教室</th>
										<th>株式会社ヴェルファイア</th>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>