<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザ変更</title>

<%@ include file="common/head.jsp"%>

<style>
table>tbody>tr>td, .table>tbody>tr>th {
	border-style: none !important;
}

table>td>input {
	width: 100px;
}

.combo_wrapper div {
	position: relative;
	margin-right: 30px;
	top: -34px;
}

.combo_text {
	position: absolute;
	top: 0;
	left: 0;
	border-right: 0px !important;
	border-top-right-radius: 0px !important;
	border-bottom-right-radius: 0px !important;
}
</style>

<script>
	$(function() {
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

		$('#companyName').val($('#companies option:selected').val());

	});
</script>
</head>

<body>
	<%@ include file="common/header.jsp"%>
	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">ユーザ情報変更</h3>
					</div>
					<div class="panel-body">
						<form:form id="changeForm" modelAttribute="userChangeForm"
							class="form-horizontal" action="userinfo" method="POST"
							submit-flag="false">
							<div class="form-group">
								<label for="userId" class="col-sm-2 control-label">ユーザID</label>
								<div class="col-sm-10">
									<input name="userId" id="userId" class="form-control"
										value="<fmt:formatNumber
											pattern="000000" value="${user.userId}" />"
										readonly>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">パスワード</label>
								<div class="col-sm-10">
									<input type="password" id="password" name="password"
										class="form-control" value="${ fn:escapeXml(user.password) }" />
								</div>
							</div>

							<div class="form-group">
								<label for="userName" class="col-sm-2 control-label">氏 名</label>
								<div class="col-sm-10">
									<c:choose>
										<c:when test="${loginuser.authority <= 1}">
											<input id="userName" name="userName" class="form-control"
												value="${ fn:escapeXml(user.userName) }" required />
										</c:when>
										<c:otherwise>
											<input id="userName" name="userName" class="form-control"
												value="${ fn:escapeXml(user.userName) }" readonly />
										</c:otherwise>
									</c:choose>
								</div>
							</div>

							<c:if test="${loginuser.authority <= 1}">
								<div class="form-group">
									<label for="companyId" class="col-sm-2 control-label">企業名</label>
									<div class="col-sm-10 select-container">
										<input type="text" class="form-control" id="companyName"
											name="companyName" list="companies">
										<datalist id="companies">
											<c:forEach var="company" items="${companies}">
												<c:choose>
													<c:when test="${company.companyId == user.companyId }">
														<option value="<c:out value="${company.companyName }" />"
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
										<select id="authority" name="authority" class="form-control">
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
												<c:choose>
													<c:when test="${maps.contains(room.trainingId)}">
														<option value="${room.trainingId}" selected>
															<c:out value="${room.trainingName}" />
														</option>
													</c:when>
													<c:otherwise>
														<option value="${room.trainingId}">
															<c:out value="${room.trainingName}" />
														</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>
								</div>
							</c:if>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="button" class="btn btn-default"
										onclick="javascript:history.back();">前の画面に戻る</button>
									<button type="button" class="btn btn-primary pull-right"
										onclick="changeSubmit();">変更</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 変更確認ダイアログ -->
	<div class="modal fade" id="change-modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header modal-header-modify">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">変更確認</h4>
				</div>
				<div class="modal-body">
					以下の内容で変更します<br> <br>
					<div class="form-group">
						<label>ユーザID:</label><span id="idModal"></span>
					</div>
					<div class="form-group">
						<label>パスワード:</label><span id="passwordModal"></span>
					</div>
					<div class="form-group">
						<label>名前:</label><span id="nameModal"></span>
					</div>
					<div class="form-group">
						<label>企業名:</label><span id="companyModal"></span>
					</div>
					<div class="form-group">
						<label>権限:</label><span id="authorityModal"></span>
					</div>
					<div class="form-group">
						<label>所属研修教室:</label><span id="trainingModal"></span>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
					<button id="modal-ok" type="button" class="btn btn-primary"
						data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${loginuser.authority == 1 && loginuser.userId != user.userId}">
		<script>
			$(function () {
				$("#password").attr("readonly", true);
			});
		</script>
	</c:if>

	<script>
		function changeSubmit() {
			console.log("changeSubmit: submit");
			$('#idModal').text($('#userId').val());
			$('#passwordModal').text($('#password').val());
			$('#nameModal').text($('#userName').val());
			$('#companyModal').text($('#companyName').val());
			$('#authorityModal').text($('#authority').val());
			$('#trainingModal').text(
					$('[name=trainingId] option:selected').text());

			$('#change-modal').modal();
		}

		$('#changeForm').submit(function() {

			$('#change-modal').modal('toggle');
			if ($('#changeForm').attr('submit-flag') == 'false') {
				return false;
			}
		});

		$('#modal-ok').click(function() {
			$('#changeForm').attr('submit-flag', 'true');
			$('#changeForm').submit();
		});

		$('#change-modal').on('show.bs.modal', function(e) {
			$('form').attr('submit-flag', 'false');
		});

		$('.combo_select').change(
				function() {
					currentCombo = $(this).parents('.combo_wrapper');
					$('.combo_text', currentCombo).val(
							$('.combo_select option:selected').text());
					$('.combo_select', currentCombo).blur();
				});
	</script>
</body>

</html>