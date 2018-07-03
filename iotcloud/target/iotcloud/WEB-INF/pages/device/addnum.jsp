<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>增加产量</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<form id="form1">
    <table style="margin:20px 0px" class="easyui-doc-table" >
        <tr>
            <td style="text-align: right">产量数</td>
            <td>
                <input id="addNum" name="addNum" class="easyui-numberbox" required="true" >
            </td>
        </tr>
        <tr>
            <td></td>
            <td style="text-align: left">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="saveNums()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="btnCancel" onclick="cancel()" >取消</a>
            </td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    var did='<%=request.getParameter("did")%>'
    function saveNums(){
        if (!$("#form1").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/device/saveNums",
            dataType: "json",
            async: true,
            data: {"did":did,"addNum":$("#addNum").val()},
            beforeSend:loadTips.showLoading(),
            success: function (data) {
                loadTips.hideLoadind();
                if (data.success) {
                    $.messager.alert("系统提示","操作成功！","info",function () {
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