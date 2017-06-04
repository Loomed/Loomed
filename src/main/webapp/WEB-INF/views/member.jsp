<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <title>ユーザ管理</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
        crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Validation-Engine/2.6.4/jquery.validationEngine.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Validation-Engine/2.6.4/languages/jquery.validationEngine-ja.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>


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
                <a class="navbar-brand" href="roothome.jsp">
                </a>
                <p class="navbar-text navbar-right">
                    <a href="index.jsp" class="navbar-link">研修教室名一覧</a>
                    <a type="button" class="btn btn-info navbar-btn navbar-btn-modify" onclick="$('#logout-modal').modal();">ログアウト</a>
                </p>
            </div>
        </div>
    </nav>

    <div class="container mycontainer">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            参加者一覧
                        </h3>
                    </div>
                    <div class="panel-body">
                        <div class="panel panel-default">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>氏名</th>
                                        <th>研修名</th>
                                        <th>企業名</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>1</th>
                                        <th>山田太郎</th>
                                        <th>経験者Java品川教室</th>
                                        <th>株式会社Axiz</th>
                                    </tr>
                                    <tr>
                                        <th>2</th>
                                        <th>鈴木太郎</th>
                                        <th>経験者Java品川教室</th>
                                        <th>コンピュータ・ハイテックホールディングスジャパン株式会社</th>
                                    </tr>
                                    <tr>
                                        <th>3</th>
                                        <th>高橋太郎</th>
                                        <th>経験者Java品川教室</th>
                                        <th>コンピュータ・ハイテックホールディングスジャパン株式会社</th>
                                    </tr>
                                    <tr>
                                        <th>4</th>
                                        <th>田中太郎</th>
                                        <th>経験者Java品川教室</th>
                                        <th>株式会社プリウス</th>
                                    </tr>
                                    <tr>
                                        <th>5</th>
                                        <th>渡辺太郎</th>
                                        <th>経験者Java品川教室</th>
                                        <th>株式会社フィット</th>
                                    </tr>
                                    <tr>
                                        <th>6</th>
                                        <th>中村次郎</th>
                                        <th>経験者Java品川教室</th>
                                        <th>株式会社ヴェルファイア</th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ログアウト確認ダイアログ -->
    <div class="modal fade" id="logout-modal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-header-modify">
                    <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
                    <h4 class="modal-title">ログアウト確認</h4>
                </div>
                <div class="modal-body">
                    ログアウトしますか？<br>[OK]ボタンを押すとログアウトされ、ログイン画面に移動します
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="location.href='login.jsp';">OK</button>
                </div>
            </div>
        </div>
    </div>


</body>

</html>