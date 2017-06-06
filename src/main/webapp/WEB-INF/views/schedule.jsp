<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>スケジュール</title>

<%@ include file="common/head.jsp"%>

<!-- 研修教室管理と同じ -->
<style>
.mycontainer {
	margin-top: 75px;
}

.navbar-brand {
	background: url("images/logo_alpha.png") no-repeat left center;
	background-size: contain;
	height: 60px;
	width: 180px;
}

.navbar-header {
	margin-left: 3px;
	width: 100%;
}

.navbar-btn-modify {
	margin-top: 0;
	margin-bottom: 0;
	margin-right: 30px;
	margin-left: 30px;
}

/*データベースのimportantがtrueだった場合 */
.importanttrue {
	color: RED;
}

td {
	word-wrap: break-word;
}
</style>
</head>

<body>

	<%@ include file="common/header.jsp"%>

	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">スケジュール</h3>
					</div>
					<div class="panel-body">
						<div class="panel panel-default">
							<table class="table" style="table-layout: fixed; width: 100%;">
								<thead>
									<tr>
										<th class="col-xs-1">時間</th>
										<th class="col-xs-7">内容</th>
										<th class="col-xs-1">変更</th>
										<th class="col-xs-1">削除</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${list}" varStatus="status">
										<tr>
											<td id="timeScheduleTable${status.index}"
												class="important${fn:escapeXml(list.important) }">${fn:escapeXml(list.time) }</td>
											<td id="contentScheduleTable${status.index}"
												class="important${fn:escapeXml(list.important) }">${fn:escapeXml(list.content) }</td>
											<td><button id="change:${status.index}"
													class="btn btn-primary change">変更</button></td>
											<td><button id="delete:${status.index}"
													class="btn btn-danger delete">削除</button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">スケジュール追加</h3>
					</div>
					<form action="schedule">
						<div class="panel-body">
							<div class="panel panel-default">
								<table class="table">
									<thead>
										<tr>
											<th class="col-xs-2">時間</th>
											<th class="col-xs-8">内容</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="number" name="#" size="2" min="0"
												max="23" required style="text-align: right;">時<input
												type="number" name="#" size="2" min="0" max="59" required
												style="text-align: right;">分</td>
											<td>
												<!--<input type="text" name="#" placeholder="ここに内容を入れて下さい。" required>-->
												<textarea name="#" class="col-xs-10"
													placeholder="ここに内容を入力してください" required></textarea>
											</td>
										</tr>
									</tbody>
								</table>

							</div>
							<label for="normal"><input type="radio" id="normal"
								name="important" value="normal" checked />通常</label> <label
								for="important"><input type="radio" id="important"
								name="important" value="important" />重要</label> <br> <br> <input
								type="submit" class="btn btn-primary" name="" value="追加">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<!-- プロジェクタの権限がある場合セレクトボックス表示 -->
						<!--<c:if test="${fn:escapeXml(projectorAuthority) }">-->
							<h3 class="panel-title">プロジェクタ予約状況</h3>
							<br> 閲覧したい時間 <select id="selectTime" name="selectTime" >
								<option></option>
								<option value="9:00">9:00</option>
								<option value="9:30">9:30</option>
								<option value="10:00">10:00</option>
								<option value="10:30">10:30</option>
								<option value="11:00">11:00</option>
								<option value="11:30">11:30</option>
								<option value="12:00">12:00</option>
								<option value="12:30">12:30</option>
								<option value="13:00">13:00</option>
								<option value="13:30">13:30</option>
								<option value="14:00">14:00</option>
								<option value="14:30">14:30</option>
								<option value="15:00">15:00</option>
								<option value="15:30">15:30</option>
								<option value="16:00">16:00</option>
								<option value="16:30">16:30</option>
								<option value="17:00">17:00</option>
								<option value="17:30">17:30</option>
								<option value="18:00">18:00</option>
								<option value="18:30">18:30</option>
								<option value="19:00">19:00</option>
								<option value="19:30">19:30</option>
								<option value="0:00">All</option>
							</select>
						<!--</c:if>-->
					</div>
					<div class="panel-body">
						<div class="panel panel-default">
							<table class="table">
								<thead>
									<tr>
										<th>予約時間</th>
										<th>プロジェクタ</th>
										<th>予約ユーザ</th>
										<th>予約</th>
									</tr>
								</thead>
								<tbody id="projectorBody">
								</tbody>
							</table>
						</div>
					</div>
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
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-danger">削除</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="configChangeModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="schedule">
					<div class="modal-header modal-header-modify">
						<button type="button" class="close" data-dismiss="modal">
							<span>×</span>
						</button>
						<h4 class="modal-title">変更内容</h4>
					</div>
					<div class="modal-body">
						変更する項目を編集してください<br> <br>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">時間</h3>
							</div>
							<div class="panel-body">
								<input id="hourChangeModal" type="number" name="#" size="2"
									min="0" max="23" required style="text-align: right;">時
								<input id="minuteChangeModal" type="number" name="#" size="2"
									min="0" max="59" required style="text-align: right;">分
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">内容</h3>
							</div>
							<div class="panel-body">
								<!--<input id="contentChangeModal" size="70" type="text" value="" required>-->
								<textarea id="contentChangeModal" class="col-xs-10" value="#"
									required></textarea>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">重要</h3>
							</div>
							<div class="panel-body">
								<label for="normalModal"><input type="radio"
									id="normalModal" name="importantModal" value="normalModal" />通常</label>
								<label for="importantModal"><input type="radio"
									id="importantModal" name="importantModal"
									value="importantModal" />重要</label>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
						<input type="submit" id="changeModalCommit"
							class="btn btn-primary" value="変更">
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="configReserveModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header modal-header-modify">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">予約確認</h4>
				</div>
				<div class="modal-body">
					これでよろしいですか?<br> <br>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">時間</h3>
						</div>
						<div class="panel-body">
							<div id="timeModal"></div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">プロジェクタ</h3>
						</div>
						<div class="panel-body">
							<div id="projectorModal"></div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">予約目的</h3>
						</div>
						<div class="panel-body">
							<textarea class="col-xs-10"></textarea>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-primary">予約</button>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="/js/schedule.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

