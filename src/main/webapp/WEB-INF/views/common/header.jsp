<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ヘッダーナビゲーションバー -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<!-- href内はセッションにより変わる
                    1.セッションに値がなければindex
                    2.セッションに値があればそれぞれのhome
                    今回はルートなのでroothome.jspとする
            　  -->
			<a class="navbar-brand" href=""> </a>
			<p class="navbar-text navbar-right">
				<a href="index" class="navbar-link">研修教室名一覧</a> <a type="button"
					class="btn btn-defaul btn-info navbar-btn navbar-btn-modify"
					onclick="$('#logout-modal').modal();">ログアウト</a>
			</p>
		</div>
	</div>
</nav>

<!-- ログアウト確認ダイアログ -->
<div class="modal fade" id="logout-modal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header modal-header-modify">
				<button type="button" class="close" data-dismiss="modal">
					<span>×</span>
				</button>
				<h4 class="modal-title">ログアウト確認</h4>
			</div>
			<div class="modal-body">
				ログアウトしますか？<br>[OK]ボタンを押すとログアウトされ、ログイン画面に移動します
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					onclick="location.href='login';">OK</button>
			</div>
		</div>
	</div>
</div>

