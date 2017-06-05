<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン</title>

<%@ include file="common/head.jsp"%>

</head>
<div class="login">
	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">ログイン</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" action="index">
							<div class="form-group">
								<label for="intputUserId" class="col-sm-2 control-label">ユーザID</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputId"
										value="000001" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">パスワード</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPassword"
										value="●●●●●●" required>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="submit" class="btn btn-info btn-block">ログイン</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ログイン失敗ダイアログ -->
	<div class="modal fade" id="deleteModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header modal-header-modify">
					<button type="button" class="close" data-dismiss="modal">
						<span>×</span>
					</button>
					<h4 class="modal-title">ログイン失敗</h4>
				</div>
				<div class="modal-body">
					ログインに失敗しました<br>IDもしくはPasswordに誤りがあります
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
</div>

</html>