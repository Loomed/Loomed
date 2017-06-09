<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザ管理</title>

<%@ include file="common/head.jsp"%>

<script>
	$(function() {
		$('.change').click(function() {
			//Javasctiptからの遷移？
			location.href = "userchange";
		});
		$('.combobox').combobox();

		$('#trainingId').multiselect(
				{
					buttonWidth : '400px',
					//buttonClass: '',
					nonSelectedText : '選択してください',
					filterPlaceholder : '検索',
					includeSelectAllOption : true,
					enableFiltering : true,
					selectAllText : 'すべて選択',
					selectedClass : '',
					enableClickableOptGroups : true,
					enableCollapsibleOptGroups : true,
					buttonText : function(options, select) {

						// First consider the simple cases, i.e. disabled and empty.
						if (this.disabledText.length > 0
								&& (this.disableIfEmpty || select
										.prop('disabled'))
								&& options.length == 0) {

							return this.disabledText;
						} else if (options.length === 0) {
							return this.nonSelectedText;
						}

						var $select = $(select);
						var $optgroups = $('optgroup', $select);

						var delimiter = this.delimiterText;
						var text = '';

						// Go through groups.
						$optgroups.each(function() {
							var $selectedOptions = $('option:selected', this);
							var $options = $('option', this);

							if ($selectedOptions.length == $options.length) {
								text += $(this).attr('label') + delimiter;
							} else {
								$selectedOptions.each(function() {
									text += $(this).text() + delimiter;
								});
							}
						});

						var $remainingOptions = $('option:selected', $select)
								.not('optgroup option');
						$remainingOptions.each(function() {
							text += $(this).text() + delimiter;
						});

						return text.substr(0, text.length - 2);
					}
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
						<h3 class="panel-title">ユーザ管理</h3>
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
											ユーザ追加はこちらから </a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">




										<form:form id="changeForm" modelAttribute="userConfigForm"
											class="form-horizontal" method="POST" submit-flag="false">
											<div class="form-group">
												<label for="userId" class="col-sm-2 control-label">ユーザID</label>
												<div class="col-sm-10">
													<input id="userId" class="form-control" value="自動採番"
														readonly>
												</div>
											</div>
											<div class="form-group">
												<label for="password" class="col-sm-2 control-label">パスワード</label>
												<div class="col-sm-10">
													<input type="password" id="password" name="password"
														class="form-control" />
												</div>
											</div>

											<div class="form-group">
												<label for="userName" class="col-sm-2 control-label">氏
													名</label>
												<div class="col-sm-10">
													<input id="userName" name="userName" class="form-control"
														required />
												</div>
											</div>


											<div class="form-group">
												<label for="companyId" class="col-sm-2 control-label">企業名</label>
												<div class="col-sm-10 select-container">
													<input type="text" class="form-control" id="companyName"
														name="companyName" list="companies">
													<datalist id="companies">
														<c:forEach var="company" items="${companies}">
															<c:choose>
																<c:when test="${company.companyId == user.companyId }">
																	<option
																		value="<c:out value="${company.companyName }" />"
																		selected></option>
																</c:when>
																<c:otherwise>
																	<option
																		value="<c:out
																value="${company.companyName }" />"></option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</datalist>
												</div>
											</div>

											<div class="form-group">
												<label class="col-sm-2 control-label">権限</label>
												<div class="col-sm-10">
													<select id="authority" name="authority"
														class="form-control">
														<c:forEach var="authority" items="ルートユーザ, 講師, 担当者, 研修生"
															varStatus="status">
															<option value="${status.index}"><c:out
																	value="${authority}" /></option>

														</c:forEach>
													</select>
												</div>
											</div>

											<div class="form-group">
												<label for="trainingId" class="col-sm-2 control-label">配属研修教室</label>
												<div class="col-sm-10">
													<select id="trainingId" name="trainingId" multiple size="4">
														<c:forEach var="room" items="${rooms}">
															<option value="${room.trainingId}">
																<c:out value="${room.trainingName}" />
															</option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-offset-1 col-sm-10">
													<input type="submit" class="btn btn-primary btn-block"
														value="登録" />
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>ID</th>
									<th>氏名</th>
									<th>研修教室名</th>
									<th>権限</th>
									<th>変更</th>
									<th>削除</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="user" items="${users}" varStatus="status">
									<tr>
										<td><c:out value="${status.index }" /></td>
										<td><fmt:formatNumber pattern="000000"
												value="${user.userId}" /></td>
										<td><form:form modelAttribute="userForm"
												action="userinfo" method="GET">
												<input type="hidden" value="${user.userId }" id="userId"
													name="userId" />
												<button type="submit" class="btn btn-link">
													<c:out value="${user.userName }" />
												</button>
											</form:form></td>
										<td>
											<ul>
												<c:forEach var="training" items="${user.trainings}"
													varStatus="status">
													<li><c:out value="${training.trainingName}" /></li>
												</c:forEach>
											</ul>
										</td>
										<td><c:out value="${user.authName }" /></td>
										<td><form:form modelAttribute="userForm"
												action="userchange">
												<input type="hidden" value="${user.userId }" id="userId"
													name="userId" />
												<input type="submit" class="btn btn-primary change"
													value="変更" />
											</form:form></td>
										<td><form:form modelAttribute="deleteForm"
												id="deleteForm${status.index}" submit-flag="false">
												<input type="hidden" value="${user.userId }" id="userId"
													name="userId" />
												<input type="submit" class="btn btn-danger delete"
													value="削除" />
											</form:form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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
					以下の内容で登録します。<br>入力内容にお間違いがなければ[OK]ボタンを押してください。
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-primary">登録</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="configModal" tabindex="-1">
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
					<a href="userdelete">
						<button type="button" class="btn btn-danger">削除</button>
					</a>
				</div>
			</div>
		</div>
	</div>

	<!-- モーダル・ダイアログ -->
	<div class="modal fade" id="sampleModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">削除確認</h4>
				</div>
				<div class="modal-body">
					元に戻すことは出来ません <br>削除しますか？
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button type="button" class="btn btn-danger" id="delBtn">削除</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		$("[ id ^= 'deleteForm' ]").submit(function() {

			id = "#" + $(this).attr("id");
			console.log("test " + $(id).attr('submit-flag'));

			$('#sampleModal').modal('toggle');
			if ($(this).attr('submit-flag') == 'false') {
				console.log("comming");
				return false;
			}
		});

		$('#delBtn').click(function() {
			console.log(id);
			$(id).attr('submit-flag', 'true');
			$(id).submit();
		});

		$('#deleteModal').on('show.bs.modal', function(e) {
			$(id).attr('submit-flag', 'false');
		});
	</script>
</body>

</html>