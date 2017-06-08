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
		$('.delete').click(function() {
			$('#configModal').modal();
		});
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




										<form:form id="changeForm" modelAttribute="userChangeForm"
											class="form-horizontal" action="userinfo" method="POST"
											submit-flag="false">
											<div class="form-group">
												<label for="userId" class="col-sm-2 control-label">ユーザID</label>
												<div class="col-sm-10">
													<input name="userId" id="userId" class="form-control"
														value="自動採番" readonly>
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
															<c:choose>
																<c:when test="${status.index == user.authority }">
																	<option value="${status.index}" selected><c:out
																			value="${authority}" /></option>
																</c:when>
																<c:otherwise>
																	<option value="${status.index}"><c:out
																			value="${authority}" /></option>
																</c:otherwise>
															</c:choose>
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
													<button type="submit" class="btn btn-primary btn-block">登録</button>
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
								<tr>
									<td>1</td>
									<td>000001</td>
									<td><a href="userinfo">山田太郎</a></td>
									<td>経験者Java品川教室</td>
									<td><select class="form-control">
											<option>ルートユーザ</option>
											<option>講師</option>
											<option>担当者</option>
											<option>研修生</option>
									</select></td>
									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>2</td>
									<td>000002</td>
									<td><a href="#">鈴木太郎</a></td>
									<td>経験者Java品川教室</td>
									<td><select class="form-control">
											<option selected>ルートユーザ</option>
											<option>講師</option>
											<option>担当者</option>
											<option>研修生</option>
									</select></td>

									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>3</td>
									<td>000003</td>
									<td><a href="#">高橋太郎</a></td>
									<td>経験者Java品川教室</td>
									<td><select class="form-control">
											<option>ルートユーザ</option>
											<option selected>講師</option>
											<option>担当者</option>
											<option>研修生</option>
									</select></td>

									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>4</td>
									<td>000004</td>
									<td><a href="root#">田中太郎</a></td>
									<td>経験者Java品川教室</td>
									<td><select class="form-control">
											<option>ルートユーザ</option>
											<option selected>講師</option>
											<option>担当者</option>
											<option>研修生</option>
									</select></td>

									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>5</td>
									<td>000005</td>
									<td><a href="#">伊藤太郎</a></td>
									<td>未経験者Java品川教室</td>
									<td><select class="form-control">
											<option>ルートユーザ</option>
											<option selected>講師</option>
											<option>担当者</option>
											<option>研修生</option>
									</select></td>

									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
								<tr>
									<td>6</td>
									<td>000006</td>
									<td><a href="#">山本太郎</a></td>
									<td>未経験者Java品川教室</td>
									<td><select class="form-control">
											<option>ルートユーザ</option>
											<option selected>講師</option>
											<option>担当者</option>
											<option>研修生</option>
									</select></td>

									<td><button class="btn btn-primary change">変更</button></td>
									<td><button class="btn btn-danger delete">削除</button></td>
								</tr>
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
</body>

</html>