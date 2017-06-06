<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Examples</title>
    <meta name="description" content="此頁面可用來協尋或認養寵物">
    <meta name="keywords" content="協尋 認養 寵物">
    <link href="" rel="stylesheet">
    <style type="text/css">
    body{
        margin: 0px auto;
        padding: 0px;
    }
    #form_frame{
        margin: 0px auto;
        border: 1px solid gray;
    }
    input,
    textarea {
        padding: 5px 10px;
        margin-bottom: 5px;
        -webkit-border-radius: 5px;
        border-radius: 5px;
        border: 1px gray solid;
    }
    
    input[type="text"],
    input[type="email"] {
        width: 100%;
    }
    
    input:focus,
    textarea:focus {
        background-color: lightblue;
    }
    
    textarea {
        width: 100%;
        height: 5em;
        resize: none;
    }
    </style>
    <script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
</head>

<body>
    <div id="form_frame">
    <p>先抓取表單種類值 在變化項目 最後在抓資料</p>
    <label>表單種類顯示</label>
    <form>
        <table>      	
            <tr>
                <td>姓名：</td>
                <td>顯示姓名</td>
            </tr>
            <tr>
                <td>種類：</td>
                <td>顯示種類</td>
            </tr>
            <tr>
                <td>品種：</td>
                <td>顯示品種</td>
            </tr>
            <tr>
                <td>特徵：</td>
                <td>顯示特徵</td>
            </tr>
            <tr>
                <td>走失地點：</td>
                <td>顯示走失地點</td>
            </tr>
            <tr>
                <td>走失日期：</td>
                <td>顯示走失日期</td>
            </tr>
            <tr>
                <td>晶片號碼：</td>
                <td>顯示晶片號碼</td>
            </tr>
            <tr>
                <td>E-mail：</td>
                <td>顯示EMAIL</td>
            </tr>
            <tr>
                <td>性別：</td>
                <td>顯示性別</td>
            </tr>
            <tr>
                <td>上傳圖片：</td>
                <td>顯示圖片</td>
            </tr>
            <tr>
                <td>備註：</td>
                <td>顯示被註</td>
        </table>
    </form>
    </div>
</body>

</html>