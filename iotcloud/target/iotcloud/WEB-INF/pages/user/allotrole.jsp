<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>分配角色</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout">
<form id="form1" style="margin:10px;">
    <input type="hidden" id="usrid" name="usrid" value="${usrid}"/>
    <table style="margin-top:10px;" class="easyui-doc-table" >
        <tr>
            <td>所属公司</td>
            <td>
                <input type="hidden" id="cid" name="cid" value="${cid}" />
                <input type="text" id="company" name="company" class="easyui-doc-textbox" value="${company}"  data-options="editable:false" style="width:200px;"/>
            </td>
            <td>用户名</td>
            <td>
                <input type="text" id="uname" name="uname" class="easyui-doc-textbox" required=" true" style="width:200px;" data-options="editable:false"/>
            </td>
        </tr>

    </table>
</form>

<div class="easyui-doc-padding">
<table width="100%">
    <tr>
        <td >
            <table id="mTb"
                   class="easyui-datagrid"
                   width="100%"
                   pagination="false"
                   rownumbers="true"
                   fitColumns="true"
                   selectOnCheck="true"
                   checkOnSelect="true"
            >
                <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>
                    <th data-options="field:'rname',width:200" >角色名称</th>
                </tr>
                </thead>
            </table>
        </td>
    </tr>
    <tr>
        <td  style="text-align: center; margin-top: 20px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="saveUserRole()">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="btnCancel()" onclick="cancel()" >取消</a>
        </td>
    </tr>
</table>
</div>
</body>

<script type="text/javascript">
    $(function () {
        $("input[type=text]").validatebox();
        var id = $("#usrid").val();
        if (id > 0) {
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

        $("#mTb").datagrid({
            url:  "/user/getuserrole?cid="+$("#cid").val()+"&usrid="+$("#usrid").val(),
            onLoadSuccess:function(data){
                if(data){
                    $.each(data.rows, function(index, item){
                        if(item.ck){
                            $('#mTb').datagrid('checkRow', index);
                        }
                    });
                }
            },
            onLoadError: function (data) {
                $.messager.alert("系统错误",data);
            }
        });

    });

    function saveUserRole() {
        var checkedItems = $('#mTb').datagrid('getChecked');
        var rids = [];
        $.each(checkedItems, function (index, item) {
            rids.push(item.rid);
        });


        $.ajax({
            type: "POST",
            url: "/user/saveuserrole",
            dataType: "json",
            async: true,
            data: {usrid:$("#usrid").val(),rids:rids},
            beforeSend:loadTips.showLoading(),
            success: function (data) {
                loadTips.hideLoadind();
                if (data.success) {
                    $.messager.alert("系统提示","保存成功！");
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