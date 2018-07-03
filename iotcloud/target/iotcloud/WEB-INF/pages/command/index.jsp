<%@ page import="org.omg.CORBA.Request" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>指令调试</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
    <style type="text/css">
        ul.btn li{ display: inline; margin: 2px}
    </style>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<div class="easyui-panel " title="主连接类型,地址和端口配置" style="width: 100%;padding:4px 10px;" id="div3" >
    <form id="form3" style="margin-left:45px;">
        <table style="margin-top:10px; " class="easyui-doc-table" >
            <tr>
                <td style="width: 200px">智盒编号</td>
                <td style="width: 200px">
                    <input  type="text" id="moduleid3" name="moduleid" class="easyui-doc-textbox" required="true" style="width:200px;">
                </td>
                <td></td>
            </tr>
            <tr>
                <td>命令字符串</td>
                <td>
                    <input type="text" id="gprs" name="gprs" class="easyui-doc-textbox" required="true"   style=" width:200px;"/>
                </td>
                <td style="text-align: left">格式：[connect type],[ip addr],[port],比如:0,11.22.125.36,2011</td>
            </tr>

            <tr>
                <td></td>
                <td style="margin-top: 20px">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit3" onclick="sendGprs()">确定</a>
                </td>
                <td></td>
            </tr>
        </table>
    </form>
</div>

<div class="easyui-panel " title="心跳包注册" style=" width: 100%;padding:4px 10px;" id="div2" >
    <form id="form2" style="margin-left:45px;">
        <table style="margin-top:10px; " class="easyui-doc-table" >
            <tr>
                <td style="width: 200px">智盒编号</td>
                <td style="width: 200px">
                    <input  type="text" id="moduleid2" name="moduleid" class="easyui-doc-textbox" required="true" style="width:200px;">
                </td>
                <td></td>
            </tr>
            <tr>
                <td>命令字符串</td>
                <td>
                    <input  type="text" id="heartbeat" name="heartbeat" class="easyui-doc-textbox" required="true"   style=" width:200px;"/>
                </td>
                <td style="text-align: left">格式:[mod],[n],[date],比如：1,30,3132</td>
            </tr>

            <tr>
                <td></td>
                <td style="margin-top: 20px">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit2" onclick="sendHeartBeat()">确定</a>
                </td>
                <td></td>
            </tr>
        </table>
    </form>
</div>

<div class="easyui-panel " title="Modbus" style="width: 100%;padding:4px 10px;" id="div1" >
<form id="form1" style="margin-left:45px;">
        <table style="margin-top:10px; " class="easyui-doc-table" >
            <tr>
                <td style="width: 200px">智盒编号</td>
                <td>
                    <input type="text" id="moduleid1" name="moduleid" class="easyui-doc-textbox" required="true" style="width:200px;">
                </td>
                <td></td>
            </tr>
            <tr>
                <td>命令(16进制字符串)</td>
                <td>
                    <input type="text" id="command" name="command" class="easyui-doc-textbox" required="true"   style=" width:200px;"/>
                </td>
                <td></td>
            </tr>

            <tr>
                <td></td>
                <td style="margin-top: 20px">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="sendCommand()">确定</a>
                </td>
                <td></td>
            </tr>
        </table>
    </form>
</div>

</body>

<script type="text/javascript">
    $(function () {
        $("input[type=text]").validatebox();
    });
    function sendCommand() {
        if (!$("#form1").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/command/sendcommand",
            dataType: "json",
            async: true,
            data: $("#form1").serialize(),
            beforeSend:loadTips.showLoading(),
            success: function (data) {
                loadTips.hideLoadind();
                if (data.success) {
                    $.messager.alert("系统提示","发送成功！");
                }else{
                    $.messager.alert("系统提示",data.message);
                }
            },
            error: function (data) {
                loadTips.hideLoadind();
                $.messager.alert("系统错误",data);
            }
        });
    }

    function sendHeartBeat() {
        if (!$("#form2").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/command/sendheartbeat",
            dataType: "json",
            async: true,
            data: $("#form2").serialize(),
            beforeSend:loadTips.showLoading(),
            success: function (data) {
                loadTips.hideLoadind();
                if (data.success) {
                    $.messager.alert("系统提示","发送成功！");
                }else{
                    $.messager.alert("系统提示",data.message);
                }
            },
            error: function (data) {
                loadTips.hideLoadind();
                $.messager.alert("系统错误",data);
            }
        });
    }

    function sendGprs() {
        if (!$("#form3").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/command/sendgprs",
            dataType: "json",
            async: true,
            data: $("#form3").serialize(),
            beforeSend:loadTips.showLoading(),
            success: function (data) {
                loadTips.hideLoadind();
                if (data.success) {
                    $.messager.alert("系统提示","发送成功！");
                }else{
                    $.messager.alert("系统提示",data.message);
                }
            },
            error: function (data) {
                loadTips.hideLoadind();
                $.messager.alert("系统错误",data);
            }
        });
    }
</script>
</html>