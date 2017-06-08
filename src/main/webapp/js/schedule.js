$(function() {
	// ログインユーザの権限を格納
	var userId = $('#loginUserId').val();
	var userName = $('#loginUserName').val();
	var authority = $('#loginUserAuthority').val();

	// 権限の数字を変数名と紐付け
	var root = '0';// ルート
	var lecturer = '1';// 講師
	var charge = '2';// 担当者
	var student = '3';// 生徒


	//console.log(userName);
	//console.log(authority);

	// 変更クリック
	$('.change')
			.click(
					function() {
						console.log("change click");
						var id = $(this).attr("id");
						var changeId = id.split(':');
						//console.log(changeId[1]);

						$('#scheduleIdChangeModal').val($('#scheduleId' + changeId[1]).val());
						//console.log($('#scheduleIdChangeModal').val());
						var array = $('#timeScheduleTable' + changeId[1])
								.text().split(':');
						//console.log(array[0]);
						//console.log(array[1]);
						$('#hourChangeModal').val(array[0]);
						$('#minuteChangeModal').val(array[1]);
						$('#contentChangeModal')
								.text(
										$('#contentScheduleTable' + changeId[1])
												.text());

						// 重要か通常か判定する
						console.log("if");
						if ($('#timeScheduleTable' + changeId[1]).attr("class") == 'importanttrue') {
							console.log("true");
							$('#normalModal').removeAttr('checked');
							$('#importantModal').attr('checked', 'checked');
						} else {
							console.log("false");
							$('#importantModal').removeAttr('checked');
							$('#normalModal').attr('checked', 'checked');
						}

						$('#configChangeModal').modal();
					});

	// 削除クリック
	$('#scheduleBody').on('click', '.delete', function() {
		//console.log("delete click");
		var id = $(this).attr("id");
		var deleteId = id.split(':');
		//console.log(deleteId[1]);

		$('#scheduleIdDeleteModal').val($('#scheduleId' + deleteId[1]).val());
		//console.log($('#scheduleIdDeleteModal').val());
		$('#timeDeleteModal').text($('#timeScheduleTable' + deleteId[1]).text());
		$('#contentDeleteModal').text($('#contentScheduleTable' + deleteId[1]).text());

		$('#configDeleteModal').modal();
	});

	// 予約クリック
	// $('.reserve').click(function() {
	// ここの途中
	$('#projectorBody').on('click', '.reserve', function() {
		console.log("reserve: click");

		var id = $(this).attr("id");
		//console.log(id);
		var reserveId = id.split(':');
		//console.log(reserveId[1]);

		//console.log($('#timeTable' + reserveId[1]).text());

		//モーダルに値を入力
		//権限分岐
		console.log("if: reserve authority")
		if (authority == root || authority == lecturer) {
			//ルートか講師の場合、教室内の生徒の名前をDBから取得する
			console.log("root or lecturer");
			getReserveNameList();
		} else if (authority == student){
			//生徒の場合そのまま表示
			console.log("student");
			$('#reserveUserModal').text(userName);
			$('#reserveUserIdHidden').val(userId);
		} else {
			//担当者の場合
			console.log("charge");
			console.log("error");
		}

		//予約内容
		$('#timeModal').text($('#timeTable' + reserveId[1]).text() + "#" + $('#projectorTable' + reserveId[1]).text());

		$('#reserveNumberHidden').val($('#projectorTable' + reserveId[1]).text());
		$('#reserveTimeHidden').val($('#timeTable' + reserveId[1]).text());
		//console.log($('#reserveNumberHidden').val());
		//console.log($('#reserveTimeHidden').val());
		$('#configReserveModal').modal();
	});

	// 予約解除クリック
	// $('.reserveRelease').click(function() {
	$('#projectorBody').on('click', '.reserveRelease', function() {
		console.log("reserveRelease: click");

		var id = $(this).attr("id");
		//console.log(id);
		var releaseId = id.split(':');
		//console.log(releaseId[1]);

		$('#projectorIdReleaseModal').val($('#projectorIdTable' + releaseId[1]).val());
		//console.log($('#projectorIdReleaseModal').val());
		$('#releaseTimeModal').text($('#timeTable' + releaseId[1]).text());
		$('#releaseProjectorModal').text($('#projectorTable' + releaseId[1]).text());
		$('#releaseReserveUserModal').text($('#reserveNameTable' + releaseId[1]).text());

		$('#reserveReleaseModal').modal();
	});

	$('#reserveUserModal').on('change', '#selectReserveName', function() {
		// セレクトボックスで選んだ値のvauleををhiddenに格納
		$('#reserveUserIdHidden').val($("[name=selectReserveName] option:selected").val());
		//console.log($('#reserveUserIdHidden').val());
	});

	// プロジェクタ非同期通信
	$("#selectTime").change(function() {
		console.log("selectTime: change");
		//console.log(authority);

		// セレクトボックスで選んだ値のtextを取得
		var time = $("[name=selectTime] option:selected").text();

		// urlから日付を取得
		var date = 'default';
		var match = location.search.match(/date=(.*?)(&|$)/);
		if (match) {
			date = decodeURIComponent(match[1]);
		}

		//console.log(time);
		//console.log(date);
		$.ajax({
			url : "projectorJson",
			dataType : "json",
			data : {
				// key : value
				// "time" : 変数timeと同義
				time : time,
				date : date
			},
			success : function(data) {
				// プロジェクタ予約状況を空に初期化
				$("#projectorBody").html("");
				//console.log(authority);
				projectorAjaxSuccess(data, authority);
			},
			error : function() {
				// プロジェクタ予約状況を空に初期化
				$("#projectorBody").html("");
				projectorAjaxError();
			}
		});
	});

});

// projectorAjax通信成功時処理
function projectorAjaxSuccess(data, authority) {
	console.log("success: start");
	//console.log(data);
	//console.log(typeof authority == "undefined");
	for (var cnt = 0; cnt < data.length; cnt++) {
		$("#projectorBody").html(
				$("#projectorBody").html() +
				'<tr>' +
					'<input id="projectorIdTable' + cnt + '" type="hidden" value="' + data[cnt].projectorId + '" />' +
					'<td id="timeTable' + cnt + '">' + data[cnt].time+ '</td>' +
					'<td id="projectorTable' + cnt + '">' + data[cnt].projectorNumber + '</td>' +
					'<td id="reserveNameTable' + cnt + '">' + data[cnt].userName + '</td>'+
					'<td>' + reserveButton(data[cnt], authority, cnt) + '</td>' +
				"</tr>");
		//console.log($('#projectorIdTable' + cnt).val());

	}
}
// projectorAjax通信失敗時処理
function projectorAjaxError() {
	console.log("error: start");
	// alert("通信失敗");
}

//プロジェクタ予約の際にユーザの名前を取得し、セレクトボックスで表示
function getReserveNameList() {
	console.log("getReserveNameList: start");

	//ajax通信
	$.ajax({
		url : "reserveNameJson",
		dataType : "json",
		success : function(data) {
			getReserveNameListSuccess(data);
		},
		error : function() {
			getReserveNameListError();
		}
	});
}

//getReserveNameListAjax通信成功
function getReserveNameListSuccess(data) {
	console.log("getReserveNameListSuccess: start");
	var userId = $('#loginUserId').val();
	var userName = $('#loginUserName').val();


	var selectHtml = '<select name="selectReserveName" id="selectReserveName">';

	selectHtml +=
		'<option "value=' + userId + '">' + userName + "</option>";
	$('#reserveUserIdHidden').val(userId);

	for(var index = 0; index < data.length; index++) {
		selectHtml +=
			'<option value="' + data[index].userId + '">' + data[index].userName + "</option>";
	}

	selectHtml += '</select>';

	//console.log(selectHtml);

	$('#reserveUserModal').html(selectHtml);
}

//getReserveNameListAjax通信失敗
function getReserveNameListError() {
	console.log("getReserveNameListError: start");
	console.log("error");
}

// プロジェクタ一覧のボタンの振り分け処理
// 引数...プロジェクタリストの1行分のデータ、権限、インデックス
function reserveButton(data, authority, cnt) {
	//console.log("reserveButton: start");
	//console.log(data);

	var userName = $('#loginUserName').val();

	// 権限の数字を変数名と紐付け
	var root = '0';// ルート
	var lecturer = '1';// 講師
	var charge = '2';// 担当者
	var student = '3';// 生徒


	var reserve = '<button id="reserve:' + cnt
			+ '" class="btn btn-primary reserve">予約する</button>';
	var reserveRelease = '<button id="reserveRelease:' + cnt
			+ '" class="btn btn-danger reserveRelease">予約解除</button>';
	var canNotReserve = '<p>予約できません</p>';
	var notReserve = '予約なし';

	// 権限振り分け
	//console.log(authority);
	switch (authority) {
	case root:
		// ルートの場合
		//console.log("switch--->root");

		if (data.userName == notReserve) {
			return reserve;
		} else {
			return reserveRelease;
		}

		break;
	case lecturer:
		// 講師の場合
		//console.log("switch--->lecturer");

		if (data.userName == notReserve) {
			return reserve;
		} else {
			return reserveRelease;
		}

		break;
	case student:
		// 生徒の場合
		//console.log("switch--->student");

		if (data.userName == notReserve) {
			return reserve;
		} else if (data.userName == userName) {
			return reserveRelease;
		} else {
			return canNotReserve;
		}

		break;
	case charge:
		// 担当者の場合
		//console.log("switch--->charge");
		//console.log("error");

		break;
	}
	//console.log("switch--->default");
}