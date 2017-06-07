<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>研修教室管理</title>

<%@ include file="common/head.jsp"%>

<script>
	$(function() {
		$('.delete').click(function() {
			var id = $(this).attr('id');
			var strarray = id.split(':');
			var param = strarray[1];
			$('#param').text(param);

			$('#deleteModal').modal();
		});

		$('.change').click(function() {
			//Javasctiptからの遷移？（「.jsp」消した）
			var id = $(this).attr('id');
			var array = id.split(':');

			location.href = "trainingChange?page=" + array[1];
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

								<%
								%>
								<c:forEach var="AllRooms" items="${sessionScope.AllTrainings}">
									<c:set var="count" value="${count+1}" />
									<c:set var="page" value="${AllRooms.trainingId}" />
									<%
										// スクリプトレットでpageスコープのpageContextにアクセスし変数を取得.
										int pageNum = (int) pageContext.findAttribute("page");
									%>

									<c:if test="${AllRooms.trainingId==1}">
										<c:set var="count" value="${count-1}" />
									</c:if>

									<c:if test="${AllRooms.trainingId!=1}">
										<tr>
											<td>${count}</td>
											<td><fmt:formatNumber value="${AllRooms.trainingId}" pattern="000000" /></td>
											<td><a href="home?page=<%=pageNum%>">${AllRooms.trainingName}</a></td>
											<td><button id="change:<%=pageNum%>" class="btn btn-primary change">変更</button></td>
											<td><button id="delete:<%=pageNum%>" class="btn btn-danger delete">削除</button></td>
										</tr>
									</c:if>


								</c:forEach>


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

					<input type="button" class="btn btn-danger" onclick="location.href='trainingDelete';">削除</button>

 					<button type="button" class="btn btn-danger" onclick="location.href='trainingDelete';">削除</button>

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
					<button type="button" class="btn btn-primary" >削除</button>
				</div>
			</div>
		</div>
	</div>

</body>

</html>