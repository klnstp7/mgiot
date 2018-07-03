<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>角色修改</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<form id="form1" style="margin-left:35px;">
    <input type="hidden" id="rid" name="rid" value="${rid}"/>
    <table style="margin-top:10px;" class="easyui-doc-table" >

        <tr>
            <td>所属公司</td>
            <td>
                <input type="hidden" id="cid" name="cid" value="${cid}" />
                <input type="text" id="company" name="company" class="easyui-doc-textbox" value="${company}"  data-options="editable:false" style="width:200px;"/>
            </td>
        </tr>

        <tr>
            <td>角色名称</td>
            <td>
                <input type="text" id="rname" name="rname" class="easyui-doc-textbox" required=" true" style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td >
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="saveRole()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="btnCancel()" onclick="cancel()" >取消</a>
            </td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    $(function () {
        $("input[type=text]").validatebox();
        var id = $("#rid").val();
        if (id > 0) {
            $.ajax({
                type: "Get",
                url: "/role/getById",
                dataType: "json",
                async: true,
                data: { rid: id },
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

    function saveRole() {
        if (!$("#form1").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/role/save",
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