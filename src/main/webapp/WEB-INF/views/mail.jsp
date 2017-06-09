<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>メール</title>

<%@ include file="common/head.jsp"%>

<script>
	$(function() {
		$('#receptionUserIds').multiselect(
				{
					buttonWidth : '200px',
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
						<h3 class="panel-title">ミニメール</h3>
					</div>
					<div class="panel-body">
						<!--　アコーディオン用パネルグループ -->
						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingOne">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne"> メール作成 </a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
										<form id="submitForm" class="form-horizontal" action="mail"
											method="post">
											<div class="form-group has-feedback">
												<label for="inputName" class="control-label"> <span
													class="label label-danger"></span> 宛先
												</label><br> <select id="receptionUserIds"
													name="receptionUserIds" multiple size="7">
													<c:if test="${auth0.size() > 0 }">
														<optgroup label="ルートユーザ">
															<c:forEach var="user" items="${auth0}">
																<option value="${user.userId}">${user.userName}</option>
															</c:forEach>
														</optgroup>
													</c:if>
													<c:if test="${auth1.size() > 0 }">
														<optgroup label="講師">
															<c:forEach var="user" items="${auth1}">
																<option value="${user.userId}">${user.userName}</option>
															</c:forEach>
														</optgroup>
													</c:if>
													<c:if test="${auth2.size() > 0 }">
														<optgroup label="担当者">
															<c:forEach var="user" items="${auth2}">
																<option value="${user.userId}">${user.userName}</option>
															</c:forEach>
														</optgroup>
													</c:if>
													<c:if test="${auth3.size() > 0 }">
														<optgroup label="研修生">
															<c:forEach var="user" items="${auth3}">
																<option value="${user.userId}">${user.userName}</option>
															</c:forEach>
														</optgroup>
													</c:if>
												</select> <span class="glyphicon form-control-feedback"
													aria-hidden="true"></span>
												<div class="help-block with-errors"></div>
											</div>


											<div class="form-group has-feedback">
												<label for="inputName" class="control-label"> <span
													class="label label-danger"></span> 件名
												</label> <input type="text" id="mailTitle" name="mailTitle"
													class="form-control" placeholder="件名"
													data-required-error="件名が未入力です" required /> <span
													class="glyphicon form-control-feedback" aria-hidden="true"></span>
												<div class="help-block with-errors"></div>
											</div>

											<input type="hidden" id="transmissionUserId"
												name="transmissionUserId"
												value="<c:out value="${loginuser.userId}" />"> <input
												type="hidden" id="mailContents" name="mailContents" value="">
										</form>
										<div class="form-group has-feedback">
											<ul class="nav nav-tabs">
												<li class="active"><a href="#tab1" data-toggle="tab">本文記入</a></li>
												<li><a href="#tab2" data-toggle="tab">遅刻</a></li>
												<li><a href="#tab3" data-toggle="tab">欠席</a></li>
												<li><a href="#tab4" data-toggle="tab">残業</a></li>
											</ul>
											<!-- / タブ-->
											<div id="myTabContent" class="tab-content">
												<div class="tab-pane fade in active" id="tab1">
													<label for="inputName" class="control-label"> <span
														class="label label-danger"></span> 本文
													</label>
													<textarea rows="10" class="form-control" id="inputContent"
														name="inputName" placeholder="本文"
														data-required-error="本文が未入力です" required /></textarea>
												</div>
												<div class="tab-pane fade" id="tab2">
													<div class="form-group">
														<label for="inputTime" class="col-sm-3 control-label">到着時間</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputTime"
																placeholder="例:9時10分" required />
														</div>
													</div>
													<br><br>
													<div class="form-group">
														<label for="inputReason" class="col-sm-3 control-label">理由</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputReason"
																placeholder="例:電車遅延のため" required />
														</div>
													</div>
												</div>
												<div class="tab-pane fade" id="tab3">
													<div class="form-group">
														<label for="inputReason2" class="col-sm-3 control-label">理由</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputReason2"
																placeholder="例:体調不良のため" required />
														</div>
													</div>
												</div>
												<div class="tab-pane fade" id="tab4">
													<div class="form-group">
														<label for="inputTime2" class="col-sm-3 control-label">残業時間</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputTime2"
																placeholder="例:1時間" required />
														</div>
													</div>
													<br><br>
													<div class="form-group">
														<label for="inputReason3" class="col-sm-3 control-label">理由</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputReason3"
																placeholder="例:進捗遅れの対応のため" required />
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<span class="glyphicon form-control-feedback"
												aria-hidden="true"></span>
											<div class="help-block with-errors"></div>
										</div>

										<input type="hidden" id="sendType" value="tab1" />
										<div class="form-group">
											<button class="btn btn-primary" id="submit">送信</button>
										</div>

										<!--　入力フォーム -->

									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									受信ボックス
									<form:form modelAttribute="watchForm" id="watchForm">
										<div class="btn-group" data-toggle="buttons">
											<label
												class="btn btn-default <c:if test="${flag == false}">active</c:if>">
												<input type="radio" name="allMail" id="myMail" value="false" />
												マイボックス
											</label> <label
												class="btn btn-default <c:if test="${flag == true}">active</c:if>">
												<input type="radio" name="allMail" id="allMail" value="true" />
												すべてのメール
											</label>
										</div>
									</form:form>
								</h3>
							</div>

							<div class="panel-body">
								<c:forEach var="mail" items="${mails}" varStatus="status">
									<!--　アコーディオン用パネルグループ -->
									<form:form modelAttribute="deleteForm"
										id="deleteForm${status.index}" submit-flag="false">
										<div class="panel-group" role="tablist"
											aria-multiselectable="true">
											<div class="panel panel-default">
												<div class="panel-heading" role="tab">
													<h4 class="panel-title">
														<a role="button" data-toggle="collapse"
															data-parent="#accordion" href="#collapse${status.index}"
															aria-expanded="true" aria-controls="collapse01"> 宛先:<c:out
																value="${mail.transmissionUserName}" /> 件名:<c:out
																value="${mail.mailTitle }" />
														</a> <input type="hidden" id="mailId" name="mailId"
															value="<c:out value="${mail.mailId }" />"> <input
															type="hidden" id="openFlag" name="openFlag"
															value="<c:out value="${mail.openFlag }" />">
														<button type="submit" class="btn btn-danger delete"
															data-toggle="modal" data-target="#deleteModal">削除</button>

													</h4>
												</div>
												<div id="collapse${status.index}"
													class="panel-collapse collapse" role="tabpanel"
													aria-labelledby="heading01">
													<div class="panel-body">
														<c:out value="${mail.mailContents }" />
													</div>
												</div>
											</div>
										</div>
									</form:form>
								</c:forEach>
							</div>
						</div>
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
	</div>
	<script>
		// 		$(function() {
		// 			$('#deleteModal').addClass("");
		// 		});

		$('input[name="allMail"]:radio').change(function() {
			$('#watchForm').submit();
		});

		$('a[href="#tab1"]').click(function() {
			$('#sendType').val("tab1");
		});

		$('a[href="#tab2"]').click(function() {
			$('#sendType').val("tab2");
		});

		$('a[href="#tab3"]').click(function() {
			$('#sendType').val("tab3");
		});

		$('a[href="#tab4"]').click(function() {
			$('#sendType').val("tab4");
		});

		$('#submit').click(
				function() {
					switch ($('#sendType').val()) {
					case 'tab1':
						$('#mailContents').val($('#inputContent').val());
						break;
					case 'tab2':
						$('#mailContents')
								.val(
										"遅刻報告 : \n到着時間 : "
												+ $('#inputTime').val()
												+ "\n遅刻理由 : "
												+ $('#inputReason').val());
						break;
					case 'tab3':
						$('#mailContents').val(
								"欠席報告 : \n欠席理由 : " + $('#inputReason2').val());
						break;
					case 'tab4':
						$('#mailContents').val(
								"残業報告 : \n残業時間 : " + $('#inputTime2').val()
										+ "\n残業理由 : "
										+ $('#inputReason3').val());
						break;
					}

					$('#submitForm').submit();
				});

		var id = "";

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