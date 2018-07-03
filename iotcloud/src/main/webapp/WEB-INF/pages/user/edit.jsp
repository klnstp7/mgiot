<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>用户修改</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<form id="form1" style="margin-left:35px;">
    <input type="hidden" id="usrid" name="usrid" value="${usrid}"/>
    <table style="margin-top:10px;" class="easyui-doc-table" >

        <tr>
            <td>所属公司</td>
            <td>
                <input type="hidden" id="cid" name="cid" value="${cid}" />
                <input type="text" id="company" name="company" class="easyui-doc-textbox" value="${company}"  data-options="editable:false" style="width:200px;"/>
            </td>
        </tr>

        <tr>
            <td>用户名</td>
            <td>
                <input type="text" id="uname" name="uname" class="easyui-doc-textbox" required=" true" style="width:200px;"
                <c:if test="${usrid > 0}">
                    data-options="editable:false"
                </c:if>/>
            </td>
        </tr>
        <tr id="pwdrow">
            <td>密码</td>
            <td>
                <input type="text" id="pwd" name="pwd" class="easyui-doc-textbox" required=" true" style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <select class="easyui-combobox" id="status" name="status" data-options="editable:false" style="width:200px;">
                    <option value="1">正常</option>
                    <option value="2">禁用</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>邮件</td>
            <td>
                <input  id="mail" name="mail" class="easyui-doc-textbox"   style="width: 200px"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="saveUser()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="btnCancel()" onclick="cancel()" >取消</a>
            </td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    $(function () {
        $("input[type=text]").validatebox();
        var id = $("#usrid").val();
        if (id > 0) {
            $("#pwdrow").hide();
            $.ajax({
                type: "Get",
                url: "/user/getById",
                dataType: "json",
                async: true,
                data: { usrid: id },
                success: function (data) {
                    if (data) {
                        $("#form1").form("load", data);
                    }
                },
                error: function (data) {
                    $.messager.alert("系统错误",data);
                }
            });
        }
    });

    function saveUser() {
        if (!$("#form1").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/user/save",
            dataType: "json",
            async: true,
            data: $("#form1").serialize(),
            beforeSend:loadTips.showLoading(),
            success: function (data) {
                loadTips.hideLoadind();
                if (data.success) {
                    $.messager.alert("系统提示","保存成功！","info",function () {
                        parent.Search();
                        parent.layer.closeAll();
                    });
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

    function cancel(){
        parent.layer.closeAll();
    }
</script>
</html>