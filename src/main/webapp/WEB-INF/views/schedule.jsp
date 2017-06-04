<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>スケジュール</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Validation-Engine/2.6.4/jquery.validationEngine.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Validation-Engine/2.6.4/languages/jquery.validationEngine-ja.js"></script>
<script type="text/javascript">
   $(function(){
    $("a[href^=#page-bottom]").click(function(){
        $('html, body').animate({
          scrollTop: $(document).height()
        },1500);
        return false;
    });
});
</script>

<script>
        $(function () {
        	<!-- モーダル表示 -->
            $('.delete').click(function () {
                $('#configDeleteModal').modal();
            });
            $('.change').click(function () {
                var array = $('#timeScheduleTable1').text().split(':');
                console.log(array[0]);
                console.log(array[1]);
                $('#hourChangeModal').val(array[0]);
                $('#minuteChangeModal').val(array[1]);
                $('#contentChangeModal').val($('#contentScheduleTable1').text());
                $('#configChangeModal').modal();
            });
            $('.reserve').click(function () {
                console.log($('#timeTable2').text());
                $('#timeModal').text($('#timeTable2').text());
                $('#projectorModal').text($('#projectorTable2').text());
                $('#configReserveModal').modal();
            });
        });
    </script>

<link rel="stylesheet" href="css/common.css">

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

.modal-header-modify {
	/*
            background-color: #FFF59D;
            color: white;
            padding: 9px 15px;
            border-bottom: 1px solid #eee;
            -webkit-border-top-left-radius: 5px;
            -webkit-border-top-right-radius: 5px;
            -moz-border-radius-topleft: 5px;
            -moz-border-radius-topright: 5px;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
            */

}

td {
	word-wrap: break-word;
}
</style>
</head>

<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<!-- href内はセッションにより変わる
                    1.セッションに値がなければindex
                    2.セッションに値があればそれぞれのhome
                    今回はルートなのでroothome.jspとする
            　  -->
				<a class="navbar-brand" href="roothome.jsp"> </a>
				<p class="navbar-text navbar-right">
					<a href="index.jsp" class="navbar-link">研修教室名一覧</a> <a
						type="button" class="btn btn-info navbar-btn navbar-btn-modify"
						onclick="$('#logout-modal').modal();">ログアウト</a>
				</p>
			</div>
		</div>
	</nav>
	<div class="container mycontainer"></div>

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
						onclick="location.href='login.jsp';">OK</button>
				</div>
			</div>
		</div>
	</div>

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
									<tr>
										<td id="timeScheduleTable1">9:00</td>
										<td id="contentScheduleTable1">レビュー</td>
										<td><button class="btn btn-primary change">変更</button></td>
										<td><button class="btn btn-danger delete">削除</button></td>
									</tr>
									<tr>
										<td>12:30</td>
										<td>昼休み</td>
										<td><button class="btn btn-primary change">変更</button></td>
										<td><button class="btn btn-danger delete">削除</button></td>
									</tr>
									<tr>
										<td>15:00</td>
										<td>演習課題提出</td>
										<td><button class="btn btn-primary change">変更</button></td>
										<td><button class="btn btn-danger delete">削除</button></td>
									</tr>
									<tr>
										<td style="color: RED">16:00</td>
										<td style="color: RED">プロジェクタ予約</td>
										<td><button class="btn btn-primary change">変更</button></td>
										<td><button class="btn btn-danger delete">削除</button></td>
									</tr>
									<tr>
										<td>終日</td>
										<td>発表練習</td>
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
	</div>
	<div class="container mycontainer">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">スケジュール追加</h3>
					</div>
					<form action="schedule.jsp">
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
								name="important" value="important" />重要</label> <br>
							<br> <input type="submit" class="btn btn-primary" name=""
								value="追加">
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
						<h3 class="panel-title">プロジェクタ予約状況</h3>
						<br> 閲覧したい時間 <select
							onchange="location=this.options[this.selectedIndex].value"
							selected="-1">
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
							<option value="0:00">全て</option>
						</select>
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
								<tbody>
									<tr>
										<td>9:00</td>
										<td>プロジェクタ１</td>
										<td>山田太郎</td>
										<td><button class="btn btn-primary reserve" name="#"
												disabled>予約する</button></td>
									</tr>
									<tr>
										<td id="timeTable2">9:00</td>
										<td id="projectorTable2">プロジェクタ2</td>
										<td>なし</td>
										<td><button class="btn btn-primary reserve" name="#">予約する</button></td>
									</tr>
									<tr>
										<td>9:00</td>
										<td>プロジェクタ3</td>
										<td>なし</td>
										<td><button class="btn btn-primary reserve" name="#">予約する</button></td>
									</tr>
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
				<form action="schedule.jsp">
					<div class="modal-header modal-header-modify">
						<button type="button" class="close" data-dismiss="modal">
							<span>×</span>
						</button>
						<h4 class="modal-title">変更内容</h4>
					</div>
					<div class="modal-body">
						変更する項目を編集してください<br>
						<br>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">時間</h3>
							</div>
							<div class="panel-body">
								<input id="hourChangeModal" type="number" name="#" size="2"
									min="0" max="23" required style="text-align: right;">時
								<input id="minuteChangeModal" type="number" name="#" size="2"
									min="0" max="59" required style="text-align: right;">分
								</td>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">内容</h3>
							</div>
							<div class="panel-body">
								<!--<input id="contentChangeModal" size="70" type="text" value="" required>-->
								<textarea id="contentChangeModal" class="col-xs-10" value=""
									required></textarea>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">重要</h3>
							</div>
							<div class="panel-body">
								<label for="normalModal"><input type="radio"
									id="normalModal" name="importantModal" value="normalModal"
									checked />通常</label> <label for="importantModal"><input
									type="radio" id="importantModal" name="importantModal"
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
					これでよろしいですか?<br>
					<br>
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

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

