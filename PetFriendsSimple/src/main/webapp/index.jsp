<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    body {
        margin: 0px auto;
        padding: 0px;
    }
    
    #form_frame {
        margin: 0px auto;
        width:720px;
    }
    
    input,
    textarea,select {
        padding: 5px 10px;
        margin-bottom: 5px;
        -webkit-border-radius: 5px;
        border-radius: 5px;
        border: 1px gray solid;
    }
    
    td{
    	border: 1px gray solid;
    	width:33%;
    }
    
    input:focus,
    textarea:focus {
        background-color: lightblue;
    }
    
    textarea {
        height: 5em;
        resize: none;
    }
    </style>
    <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resources/js/index.js"></script>
    <script type="text/javascript">

    $(document).ready(function(){
        $("input[name=PetForm]").change(function(){
            var x=$(this).val();
            changeForm(x);
        });
    });
    </script>
</head>

<body>
    <div id="form_frame">
        <form method="POST" action="<c:url value="/adopt.controller"/>" enctype="multipart/form-data">>
            <label>
                <input type="radio" name="PetForm" value="1" checked> 遺失</label>
            <label>
                <input type="radio" name="PetForm" value="2"> 拾獲，找原主人</label>
            <label>
                <input type="radio" name="PetForm" value="3"> 拾獲，找新主人</label>
            <label>
                <input type="radio" name="PetForm" value="4"> 不擬續養，送養</label>
            <br>
            <table>
                <th><label>連絡人資訊</label></th>
                <tr>
                    <td>聯絡人姓名：</td>
                    <td>
                        <input type="text" value="${param.UserName}" name="UserName" maxlength="10" placeholder="必填"/>
                    </td>
                    <td><span>${errors.UserName}</span></td>
                </tr>
                <tr>
                    <td>聯絡人手機電話：</td>
                    <td>
                        <input type="text" value="${param.UserPhone}" name="UserPhone" maxlength="10" placeholder="Ex:09xxxxxxxx" />
                    </td>
                    <td><span>${errors.UserPhone}</span></td>
                </tr>
                <tr>
                    <td>E-mail：</td>
                    <td>
                        <input type="email" value="${param.UserEmail}" name="UserEmail" />
                    </td>
                    <td><span>${errors.UserEmail}</span></td>
                </tr>
                <th><label>寵物資訊</label></th>
                <tr>
                    <td>寵物姓名：</td>
                    <td>
                        <input type="text" value="${param.PetName}" name="PetName" placeholder="若未知可不填" maxlength="10" />
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>種類：</td>
                    <td>
                    	<select id="PetType" name="PetType">
                    		<option value="">請選擇種類</option>
                    		<option value="1">狗狗</option>
                    		<option value="2">貓咪</option>
                    		<option value="3">兔子</option>
                    		<option value="4">鼠類</option>
                    		<option value="5">鳥類</option>
                    		<option value="6">其他</option>
                    	</select>
                    </td>
                     <td><span>${errors.PetType}</span></td>
                </tr>
                <tr>
                    <td>品種：</td>
                    <td>
                        <input type="text" value="${param.PetBreeds}" name="PetBreeds" placeholder="若未知可不填" maxlength="5" />
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>特徵：</td>
                    <td>
                        <input type="text" value="${parm.PetFeature}" name="PetFeature" maxlength="50" />
                    </td>
                    <td><span>${errors.PetFeature}</span></td>
                </tr>
                <tr>
                    <td>走失地點：</td>
                    <td>
                    	<select id="${parm.FindCity}" name="FindCity">
                    		<option value="">請選擇城市</option>
                    		<option value="台北市">台北市</option>
                    		<option value="新北市">新北市</option>
                    		<option value="台中市">台中市</option>
                    		<option value="台南市">台南市</option>
                    		<option value="高雄市">高雄市</option>
                    	</select>
                        <select id="FindDistrict">
                    		<option value="">請選擇地區<option>
                    	</select>
                        <br><input type="text" value="${parm.FindRoad}" name="FindRoad" maxlength="50" />
                    </td>
                    <td><span>${errors.FindCity}</span></td>
                </tr>
                <tr>
                    <td>走失日期：</td>
                    <td>
                        <input type="date" value="${parm.FindDate}" name="FindDate" />
                    </td>
                    <td><span>${errors.FindDate}</span></td>
                </tr>
                <tr>
                    <td>晶片號碼：</td>
                    <td>
                        <input type="text" value="${parm.ICNumber}" name="ICNumber" placeholder="若未知可不填" maxlength="15" />
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>性別：</td>
                    <td>
                    	<select value="PetGender" name="PetGender">
                    		<option value="未知">未知</option>
                    		<option value="男性">男性</option>
                    		<option value="女性">女性</option>
                    	</select>
                    </td>
                    <td><span>${errors.PetGender}</span></td>
                </tr>
                <tr>
                    <td>上傳圖片：</td>
                    <td>
                        <input type="file" name="file" accept="image/*" multiple="multiple">                     
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>備註：</td>
                    <td>
                        <textarea id="PetNotes" name="PetNotes" placeholder="最多500字"></textarea>
                    </td>
                    <td></td>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" name="insert" value="新增">
                            <input type="button" value="清除" onclick="clearForm()">
                            <input type="button" value="取消" onclick="cancelForm()">
                        </td>
                        <td></td>
                    </tr>
            </table>
        </form>
    </div>
</body>

</html>
