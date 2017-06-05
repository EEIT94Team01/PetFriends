<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <form:form method="POST" modelAttribute="adoptBean">
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
                        <form:input type="text" path="UserName" id="UserName"/>
                    </td>
                    <td><form:errors path="UserName" /></td>
                </tr>
                <tr>
                    <td>聯絡人手機電話：</td>
                    <td>
                        <form:input type="text" path="UserPhone" id="UserPhone" maxlength="10" placeholder="Ex:09xxxxxxxx" />
                    </td>
                    <td><form:errors path="UserPhone" /></td>
                </tr>
                <tr>
                    <td>E-mail：</td>
                    <td>
                        <form:input type="email" path="UserEmail" id="UserEmail" />
                    </td>
                    <td><form:errors path="UserEmail" /></td>
                </tr>
                <th><label>寵物資訊</label></th>
                <tr>
                    <td>寵物姓名：</td>
                    <td>
                        <form:input type="text" path="PetName" id="PetName" placeholder="若未知可不填" maxlength="20" />
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>種類：</td>
                    <td>
                    	<form:select path="PetType" id="PetType">
                    		<form:option value="">請選擇種類</form:option>
                    		<form:options items="${type}"/>
                    	</form:select>
                    </td>
                    <td><form:errors path="PetType" /></td>
                </tr>
                <tr>
                    <td>品種：</td>
                    <td>
                        <form:input type="text" path="PetBreeds" id="PetBreeds" placeholder="若未知可不填" maxlength="5" />
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>特徵：</td>
                    <td>
                        <form:input type="text" path="PetFeature" id="PetFeature" maxlength="50" />
                    </td>
                    <td><form:errors path="PetFeature" /></td>
                </tr>
                <tr>
                    <td>走失地點：</td>
                    <td>
                    	<form:select path="FindCity" id="FindCity">
                    		<form:option value="">請選擇城市</form:option>
                    		<form:options items="${city}"/>
                    	</form:select>
                        <form:select path="FindDistrict" id="FindDistrict">
                    		<form:option value="大安區">大安區</form:option>
                    	</form:select>
                        <br><form:input type="text" path="FindRoad" id="FindRoad" maxlength="50" />
                    </td>
                    <td><form:errors path="FindCity" /></td>
                </tr>
                <tr>
                    <td>走失日期：</td>
                    <td>
                        <form:input type="date" path="FindDate" id="FindDate" />
                    </td>
                    <td><form:errors path="FindCity" /></td>
                </tr>
                <tr>
                    <td>晶片號碼：</td>
                    <td>
                        <form:input type="text" path="ICNumber" id="ICNumber" placeholder="若未知可不填" maxlength="15" />
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>性別：</td>
                    <td>
                    	<form:select path="PetGender" id="PetGender">
                    		<form:option value="">請選擇性別</form:option>
                    		<form:options items="${sex}"/>
                    	</form:select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>上傳圖片：</td>
                    <td>
                        <!--  <input type="file" name="file" accept="image/*">-->                        
                    </td>
                    <td><!--  <span>${errors.PetPhotos}</span>--></td>
                </tr>
                <tr>
                    <td>備註：</td>
                    <td>
                        <form:textarea path="PetNotes" id="PetNotes" placeholder="最多500字"/>
                    </td>
                    <td></td>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="新增">
                            <input type="button" value="清除" onclick="clearForm()">
                            <input type="button" value="取消" onclick="cancelForm()">
                        </td>
                        <td></td>
                    </tr>
            </table>
        </form:form>
    </div>
</body>

</html>
