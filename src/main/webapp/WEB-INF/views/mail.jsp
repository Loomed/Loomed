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
		$('#multiSelectSample1').multiselect(
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
										<form id="changeForm" class="form-horizontal" action="#">
											<div class="form-group has-feedback">
												<label for="inputName" class="control-label"> <span
													class="label label-danger"></span> 宛先
												</label><br>
												<!--<input type="text" class="form-control" placeholder="宛先" data-required-error="宛先が未入力です" required>-->
												<select id="multiSelectSample1" multiple size="7">
													<optgroup label="講師">
														<option value="option1">項目1</option>
														<option value="option2">項目2</option>
														<option value="option3">項目3</option>
													</optgroup>
													<optgroup label="生徒">
														<option value="option4">項目4</option>
														<option value="option5">項目5</option>
														<option value="option6">項目6</option>
														<option value="option7">項目7</option>
													</optgroup>
												</select> <span class="glyphicon form-control-feedback"
													aria-hidden="true"></span>
												<div class="help-block with-errors"></div>
											</div>

											<div class="form-group has-feedback">
												<label for="inputName" class="control-label"> <span
													class="label label-danger"></span> 件名
												</label> <input type="text" class="form-control" placeholder="件名"
													data-required-error="件名が未入力です" required> <span
													class="glyphicon form-control-feedback" aria-hidden="true"></span>
												<div class="help-block with-errors"></div>
											</div>

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
														<textarea rows="10" type="text" class="form-control"
															id="inputName" placeholder="本文"
															data-required-error="本文が未入力です" required></textarea>
													</div>
													<div class="tab-pane fade" id="tab2">

														<div class="form-group">
															<label for="inputTime" class="col-sm-2 control-label">到着時間</label>
															<div class="col-sm-7">
																<input type="text" class="form-control" id="inputTime"
																	value="10分" required>
															</div>
														</div>
														<div class="form-group">
															<label for="inputReason" class="col-sm-2 control-label">理由</label>
															<div class="col-sm-7">
																<input type="text" class="form-control" id="inputReason"
																	value="電車遅延のため" required>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="tab3">
														<div class="form-group">
															<label for="inputReason2" class="col-sm-2 control-label">理由</label>
															<div class="col-sm-7">
																<input type="text" class="form-control"
																	id="inputReason2" value="体調不良のため" required>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="tab4">
														<div class="form-group">
															<label for="inputTime2" class="col-sm-2 control-label">残業時間</label>
															<div class="col-sm-7">
																<input type="text" class="form-control" id="inputTime2"
																	value="10分" required>
															</div>
														</div>
														<div class="form-group">
															<label for="inputReason3" class="col-sm-2 control-label">理由</label>
															<div class="col-sm-7">
																<input type="text" class="form-control"
																	id="inputReason3" value="進捗遅れの対応のため" required>
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


												<div class="form-group">
 												<form:form action="mail" method="post">
													<button type="submit" class="btn btn-primary">送信</button>
 												</form:form>
												</div>

											<!--　入力フォーム -->
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									受信ボックス
									<div class="btn-group" data-toggle="buttons">
										<label class="btn btn-default active"> <input
											type="radio" name="options" id="option1" autocomplete="off">
											マイボックス
										</label> <label class="btn btn-default"> <input type="radio"
											name="options" id="option2" autocomplete="off">
											すべてのメール
										</label>
									</div>
								</h3>
							</div>
							<div class="panel-body">

								<!--　アコーディオン用パネルグループ -->
								<div class="panel-group" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="heading01">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapse01"
													aria-expanded="true" aria-controls="collapse01">
													<!-- フレームワーク課題、list.jspを参考に -->
<%-- 													<c:out value="${fn:escapeXml(mail.transmissionUserId)}" /> --%>
<%-- 													<c:out value="${fn:escapeXml(mail.mailTitle)}" /> --%>
<%-- 													<c:out value="${fn:escapeXml(mail.mailContents)}" /> --%>
													宛先:高橋太郎 件名:週報提出しました </a>
												<button class="btn btn-danger delete" data-toggle="modal"
													data-target="#modal-example">削除</button>
											</h4>
										</div>
										<div id="collapse01" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="heading01">
											<div class="panel-body">
												<br>To) 教育事業部 飯田さん <br>cc) 管理部 長野さん 井戸さん <br>
												<br> <br>今週の週報を提出いたします。 <br> <br> <br>以上、よろしくお願い致します。
											</div>
										</div>
									</div>
								</div>


								<div class="panel-group" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-default">
										<div class="panel-heading" role="tab">
											<h4 class="panel-title">
												<a role="button" data-toggle="collapse"
													data-parent="#accordion" href="#collapse01"
													aria-expanded="true" aria-controls="collapse01">
													宛先:伊藤太郎 件名:週報提出しました </a>
												<button class="btn btn-danger delete" data-toggle="modal"
													data-target="#modal-example">削除</button>
											</h4>
										</div>
										<div class="panel-collapse collapse" role="tabpanel"
											aria-labelledby="heading01">
											<div class="panel-body">
												<br>To) 教育事業部 飯田さん <br>cc) 管理部 長野さん 井戸さん <br>
												<br> <br>今週の週報を提出いたします。 <br> <br> <br>以上、よろしくお願い致します。
											</div>
										</div>
									</div>
								</div>


							</div>
						</div>

					</div>
				</div>
			</div>
		</div>


		<!-- 2.モーダルの配置 -->
		<div class="modal" id="modal-example" tabindex="-1">
			<div class="modal-dialog">

				<!-- 3.モーダルのコンテンツ -->
				<div class="modal-content">
					<!-- 4.モーダルのヘッダ -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modal-label">削除確認</h4>
					</div>
					<!-- 5.モーダルのボディ -->
					<div class="modal-body">
						元に戻すことは出来ません <br>削除しますか？
					</div>
					<!-- 6.モーダルのフッタ -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
						<a href="messageDelete">
							<button type="button" class="btn btn-danger">削除</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>