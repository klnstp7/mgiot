<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>菜单修改</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<form id="form1" style="margin-left:35px;">
    <input type="hidden" id="mid" name="mid" value="${mid}"/>
    <table style="margin-top:10px;" class="easyui-doc-table" >

        <tr>
            <td>上级菜单</td>
            <td>
                <input type="hidden" id="parentid" name="parentid" value="${parentid}" />
                <input type="text" id="parentname" name="parentname" class="easyui-doc-textbox" value="${parentname}"  data-options="editable:false" style="width:200px;"/>
            </td>
            <td>节点类型</td>
            <td>
                <select class="easyui-combobox" id="mtype" name="mtype"  style="width:200px;">
                    <option value="1">菜单</option>
                    <option value="2">权限</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>菜单名称</td>
            <td>
                <input type="text" id="mname" name="mname" class="easyui-doc-textbox" required=" true" style="width:200px;"/>
            </td>
            <td>图标</td>
            <td>
                <input type="text" id="icon" name="icon" class="easyui-doc-textbox"  style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td>衔接</td>
            <td>
                <input type="text" id="url" name="url" class="easyui-doc-textbox"  style="width:200px;"/>
            </td>
            <td>权限标识</td>
            <td>
                <input type="text" id="pricode" name="pricode" class="easyui-doc-textbox"  style="width:200px;"/>
            </td>
        </tr>
        <tr>
            <td>显示</td>
            <td>
                <select class="easyui-combobox" id="visible" name="visible" style="width:200px;">
                    <option value="1">可见</option>
                    <option value="0">隐藏</option>
                </select>
            </td>
            <td>排序</td>
            <td>
                <input  id="ordernum" name="ordernum" class="easyui-numberbox" required="true"  style="width: 200px"/>
            </td>
        </tr>
        <tr>

            <td  colspan="4" style="text-align: center; margin-top: 20px">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="saveMenu()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="btnCancel()" onclick="cancel()" >取消</a>
            </td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    $(function () {
        $("input[type=text]").validatebox();
        var id = <%=request.getParameter("mid")%>;

        if (id > 0) {
            $.ajax({
                type: "Get",
                url: "/menu/getById",
                dataType: "json",
                async: true,
                data: { mid: id },
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

    function saveMenu() {
        if (!$("#form1").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/menu/save",
            dataType: "json",
            async: true,
            data: $("#form1").serialize(),
            beforeSend:loadTips.showLoading(),
            success: function (data) {
                loadTips.hideLoadind();
                if (data.success) {
                    $.messager.alert("系统提示","保存成功！","info",function () {
                        parent.refresh();
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