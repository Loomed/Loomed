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
			location.href = "rootuserchange.jsp";
		});
		$('.combobox').combobox();
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
										<form id="changeForm" class="form-horizontal"
											action="userconfig">
											<div class="form-group">
												<label for="intputUserId" class="col-sm-2 control-label">ユーザID</label>
												<div class="col-sm-10">
													<label for="intputUserId" class="control-label">自動採番</label>
												</div>
											</div>
											<div class="form-group">
												<label for="inputPassword" class="col-sm-2 control-label">パスワード</label>
												<div class="col-sm-10">
													<input type="password" class="form-control"
														id="inputPassword" required>
												</div>
											</div>
											<div class="form-group">
												<label for="inputPassword" class="col-sm-2 control-label">権限</label>
												<div class="col-sm-10">
													<select class="form-control">
														<option selected>ルートユーザ</option>
														<option>講師</option>
														<option>担当者</option>
														<option>研修生</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label for="inputName" class="col-sm-2 control-label">氏
													名</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="inputName"
														required>
												</div>
											</div>
											<div class="form-group">
												<label for="inputCompany" class="col-sm-2 control-label">企業名</label>
												<div class="col-sm-10 select-container">
													<select class="combobox form-control">
														<option value=""></option>
														<option>株式会社Axiz</option>
														<option>株式会社コンピュータ・ハイテック・ビジュアルソリューション・グローバルパワー</option>
														<option>株式会社プリウス</option>
														<option>クラウン株式会社</option>
														<option>ソニーグループ株式会社</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label for="inputTraining" class="col-sm-2 control-label">配属研修教室</label>
												<div class="col-sm-10">
													<select class="form-control">
														<option>研修教室選択なし</option>
														<option>研修教室管理</option>
														<option>経験者Java品川教室</option>
														<option>未経験者Java品川教室</option>
														<option>経験者C#田町教室</option>
														<option>未経験者C#品川教室</option>
														<option>経験者C#品川教室</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-offset-1 col-sm-10">
													<button type="submit" class="btn btn-primary btn-block">登録</button>
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