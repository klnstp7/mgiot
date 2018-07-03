<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>设备修改</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<form id="form1" style="margin-left:45px;">
    <input type="hidden" id="did" name="did"/>

    <table style="margin-top:10px;" class="easyui-doc-table" >
        <tr>
            <td>机器名</td>
            <td>
                <input  type="text" id="userCom" name="useCom" class="easyui-doc-textbox" required="true" style="width:200px;">
            </td>
        </tr>
        <tr>
            <td>机器编码</td>
            <td>
                <input type="text" id="divShow" name="didShow" class="easyui-doc-textbox" required="true" data-options="editable:false"  style=" width:200px;"/>
            </td>
        </tr>
        <tr>
            <td>智盒编码</td>
            <td>
                <input type="text" id="moduleId" name="moduleId" class="easyui-doc-textbox" required="true" data-options="editable:false" style="width: 200px;">
            </td>
        </tr>
        <tr>
            <td>机器型号</td>
            <td>
                <input  type="text" id="name" name="name" class="easyui-doc-textbox" required="true" style="width:200px;">
            </td>
        </tr>
        <tr>
            <td>PLC型号</td>
            <td>
                <input type="text" id="plcName" name="plcName" class="easyui-doc-textbox" required="true" style="width:200px;">
            </td>
        </tr>
        <tr>
            <td>机器生产厂家</td>
            <td>
                <select class="easyui-combobox" id="cidmac" name="cidmac" style="width: 200px"   data-options="
    					url:'/company/getByType?ctype=mac',
    					method:'post',
    					valueField:'cid',
    					textField:'company',
    					multiple:false,
    					panelHeight:'auto',
    					editable:false
    			"></select>
            </td>
        </tr>
        <tr>
            <td>机器代理厂家</td>
            <td>
                <select class="easyui-combobox" id="cidage" name="cidage"  style="width:200px"   data-options="
    					url:'/company/getByType?ctype=age',
    					method:'post',
    					valueField:'cid',
    					textField:'company',
    					multiple:false,
    					panelHeight:'auto',
    					editable:false
    			"></select>
            </td>
        </tr>
        <tr>
            <td>机器使用厂家</td>
            <td>
                <select class="easyui-combobox" id="ciduse" name="ciduse"  style="width: 200px"   data-options="
    					url:'/company/getByType?ctype=use',
    					method:'post',
    					valueField:'cid',
    					textField:'company',
    					multiple:false,
    					panelHeight:'auto',
    					editable:false
    			"></select>
            </td>
        </tr>
        <tr>
            <td>贷款银行</td>
            <td>
                <select class="easyui-combobox" id="cidpoi" name="cidpoi" style="width: 200px"   data-options="
    					url:'/company/getByType?ctype=poi',
    					method:'post',
    					valueField:'cid',
    					textField:'company',
    					multiple:false,
    					panelHeight:'auto',
    					editable:false
    			" ></select>
            </td>
        </tr>
        <tr>
            <td>机器生产地址</td>
            <td>
                <input type="text" id="address" name="address" class="easyui-doc-textbox" required="true" maxlength="200" style="width:200px;">
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center; margin-top: 20px">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="saveDevice()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="btnCancel()" onclick="cancel()" >取消</a>
            </td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    $(function () {
        $("input[type=text]").validatebox();
        $.ajax({
            type: "Get",
            url: "/device/getById",
            dataType: "json",
            async: true,
            data: { did: <%=request.getParameter("did")%> },
            success: function (data) {
                if (data) {
                    $("#form1").form("load", data);
                }
            },
            error: function (data) {
                $.messager.alert("系统错误",data);
            }
        });
    });

    function saveDevice() {
        if (!$("#form1").form('validate')) {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/device/save",
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