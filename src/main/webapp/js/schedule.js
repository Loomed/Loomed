$(function() {
	console.log($('#loginUserAuthority').val());

	// 削除クリック
	$('.delete').click(function() {
		$('#configDeleteModal').modal();
	});

	// 変更クリック
	$('.change')
			.click(
					function() {
						console.log("change click");
						var id = $(this).attr("id");
						var changeId = id.split(':');
						console.log(changeId[1]);
						var array = $('#timeScheduleTable' + changeId[1])
								.text().split(':');
						console.log(array[0]);
						console.log(array[1]);
						$('#hourChangeModal').val(array[0]);
						$('#minuteChangeModal').val(array[1]);
						$('#contentChangeModal')
								.val(
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

	// 予約クリック
	$('.reserve').click(function() {
		console.log($('#timeTable2').text());
		$('#timeModal').text($('#timeTable2').text());
		$('#projectorModal').text($('#projectorTable2').text());
		$('#configReserveModal').modal();
	});

	// プロジェクタ非同期通信
	$("#selectTime").change(function() {
		// プロジェクタ予約状況を空に初期化
		$("#projectorBody").html("");
		// セレクトボックスで選んだ値のtextを取得
		var time = $("[name=selectTime] option:selected").text();

		// urlから日付を取得
		var date = 'default';
		var match = location.search.match(/date=(.*?)(&|$)/);
		if (match) {
			date = decodeURIComponent(match[1]);
		}

		console.log(time);
		console.log(date);
		$.ajax({
			url : "json",
			dataType : "json",
			data : {
				// key : value
				// "time" : 変数timeと同義
				time : time,
				date : date
			},
			success : function(data) {
				success(data);
			},
			error : function() {
				error();
			}
		});
	});

});

// Ajax通信成功時処理(未完成)
function success(data) {
	console.log(data);
	for (var cnt = 0; cnt < data.length; cnt++) {
		$("#projectorBody")
				.html(
						$("#projectorBody").html()
								+ '<tr>'
								+ '<td>'
								+ data[cnt].time
								+ '</td>'
								+ '<td>'
								+ data[cnt].projectorNumber
								+ '</td>'
								+ '<td>'
								+ data[cnt].userName
								+ '</td>'
								+ '<td><button class="btn btn-primary reserve" name="#" disabled>予約する</button></td>'
								+ "</tr>");
	}
}
// Ajax通信失敗時処理
function error() {
	// alert("通信失敗");
}