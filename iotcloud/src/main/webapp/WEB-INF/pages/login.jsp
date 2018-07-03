<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>米根物联云平台-登录</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="include/header.jsp"></c:import>
    <link href="/resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="second_body">
    <form id="loginForm" method="post">
        <div class="logo"></div>
        <div class="title-zh">米根物联云平台</div>
        <div style="padding:10px 0;">
            <label for="txt_user_id">帐号:</label>
            <input type="text" id="txt_user_id" name="userAccount" class="easyui-doc-textbox" style="width:220px;" ></input>
        </div>
        <div style="padding:10px 0;">
            <label for="txt_user_pwd">密码:</label>
            <input type="password" id="txt_user_pwd" name="userPwd" class="easyui-doc-textbox" style="width:220px;"></input>
        </div>
        <div region="south" border="false" style="text-align:center;padding:10px 10px;">
            <a class="easyui-linkbutton" iconCls="icon-ok" class="u-inpt u-inpt-lg" id="btnLogin"
                    href="javascript:void(0)" onclick="doLoginByPwd()">登录</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="easyui-linkbutton" iconCls="icon-reload" class="u-inpt u-inpt-lg" id="btnReset"
                    href="javascript:void(0)" onclick="cleardata()">重置</a>

        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function(){
        $('#loginForm').form('clear');
        $("input[name='userAccount']").focus();

        $('input[type="text"],input[type="password"]').keypress(function (e) {
            if (e.keyCode == 13) {
                doLoginByPwd();
            }
        });

        $("#loginForm").validate({
            onkeyup: false,
            rules: {
                userAccount:{
                    required:true
                },
                userPwd:{
                    required:true
                }
            },
            messages: {
                userAccount:{
                    required:"请输入账号"
                },
                userPwd:{
                    required:"请输入密码"
                }
            },
            errorPlacement: function(error, element) {
                if(error[0].innerHTML!=""){
                    layer.tips(error[0].innerHTML, "#" + element[0].id, {
                        tips: [1, '#F99228']
                    });
                    $("#" + element[0].id).addClass("error");
                }
            },
            success: function(label) {
                layer.closeAll();
                $("#" + label[0].htmlFor).removeClass("error");
            }
        });
    });

    function doLoginByPwd(){
        if(!$("#loginForm").valid())
            return;
        var oData =$("#loginForm").serializeObject();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: '/home/doLogin',
            async: false,
            data: oData,
            beforeSend:loadTips.showLoading(),
            success: function(data) {
                loadTips.hideLoadind();
                if(data.success){
                    window.location.href = "/home/index";
                }else{
                    layer.tips(data.message+ "！","#txt_user_id", {
                        tips: [1, '#e84c3d'],
                        time: 4000
                    });
                }
            },
            error: function(data) {
                loadTips.hideLoadind();
            }
        });
    }

    function cleardata(){
        $('#loginForm').form('clear');
    }
</script>
</html>
