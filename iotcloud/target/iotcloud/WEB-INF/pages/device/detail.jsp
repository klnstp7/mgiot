<%@ page import="org.omg.CORBA.Request" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>设备详情</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
    <style type="text/css">
        ul.btn li{ display: inline; margin: 2px}
    </style>
</head>
<body class="easyui-layout" style="overflow-y:hidden;" scroll="no">

<div id="toolbar">
    <ul  class="btn">
        <li> <a href="javascript:void(0)" class="easyui-linkbutton" onclick="issueLock()">锁定机器</a></li>
        <li><a href="javascript:void(0)" class="easyui-linkbutton" onclick="issueUnlock()" >一键解锁</a></li>
        <li> <a href="javascript:void(0)" class="easyui-linkbutton" onclick="issueNums()" >增加产量</a></li>
        <li><a href="javascript:void(0)" class="easyui-linkbutton" onclick="issueSpwd()">更换超级密码</a></li>
        <li><a href="javascript:void(0)" class="easyui-linkbutton" onclick="issueModule()">更换智盒</a></li>
        <li><a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateVer()">更新智盒版本</a></li>
        <li><a href="javascript:void(0)" class="easyui-linkbutton" onclick="refresh()">刷新</a></li>
    </ul>
</div>
<div class="easyui-panel " title="设备信息" style="height: 120px; width: 100%;padding:4px 10px;" id="div1" >
    <form id="form1">
        <input type="hidden" id="socket" name="socket"/>
        <table id="tbcustomer" class="easyui-doc-filter sm" style="width: 100%;border-collapse:separate; border-spacing:3px;">
            <tr>
                <td>机器名</td>
                <td>
                    <input type="text" id="useCom" name="useCom" class="easyui-doc-textbox"    data-options="editable:false" style="width:200px;">
                </td>
                <td>机器编码</td>
                <td>
                    <input  type="text" id="didShow" name="didShow" class="easyui-doc-textbox"  data-options="editable:false"  style=" width:200px;"/>
                </td>
                <td>智盒编码</td>
                <td>
                    <input  type="text" id="moduleId" name="moduleId" class="easyui-doc-textbox"  data-options="editable:false" style="width: 200px;">
                </td>
            </tr>
            <tr>
                <td>机器型号</td>
                <td>
                    <input  type="text"id="name" name="name" class="easyui-doc-textbox"   data-options="editable:false" style="width:200px;">
                </td>
                <td>PLC型号</td>
                <td>
                    <input  type="text" id="plcName" name="plcName" class="easyui-doc-textbox"   data-options="editable:false" style="width:200px;">
                </td>
                <td>机器生产地址</td>
                <td>
                    <input  type="text" id="address" name="address" class="easyui-doc-textbox" maxlength="200"   data-options="editable:false" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td>预设产量</td>
                <td>
                    <input type="text" id="installYield" name="installYield" class="easyui-doc-textbox"   data-options="editable:false" style="width:200px;">
                </td>
                <td>产量计数</td>
                <td>
                    <input type="text" id="realYield" name="realYield" class="easyui-doc-textbox"   data-options="editable:false" style="width:200px;">
                </td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </form>
</div>

<div class="easyui-panel " title="当前位置" style="height: 100px; width: 100%;padding:5px 10px;" id="div2">
    <table id="mTbLot" class="easyui-datagrid" width="100%" url="/device/getLocationRightByDid?did=<%=request.getParameter("did")%>"
           data-options="rownumbers:true,singleSelect:true,pagination:false,method:'post',height:'auto',width:'auto'">
        <thead>
        <tr>
            <th field="longitude" width="20%">经度</th>
            <th field="latitude" width="20%">纬度</th>
            <th field="address" width="20%">位置</th>
            <th field="status" width="20%" formatter="formatLStatus">状态</th>
            <th field="strDt" width="20%">定位日期</th>
        </tr>
        </thead>
    </table>
</div>
<div class="easyui-panel " title="锁定信息" style="height: 100px; width:100%;padding:5px 10px;" id="div3">
    <table id="mTbLock" class="easyui-datagrid" width="100%" url="/device/getLockByDeviceId?did=<%=request.getParameter("did")%>"
           data-options="rownumbers:true,singleSelect:true,pagination:false,method:'post',height:'auto',width:'auto'">
        <thead>
        <tr>
            <th field="ltype" width="35%" formatter="formatLtype">锁定原因</th>
            <th field="strDt" width="35%">锁定日期</th>
            <th field="status" width="30%" formatter="formatStatus">状态</th>

        </tr>
        </thead>
    </table>
</div>
<div class="easyui-panel " title="运行时长" style="width: 100%;padding:5px 10px;" id="div4">
    <table id="mTbRunning"
           class="easyui-datagrid" width="100%"
           url="/device/getWorkTimePaging?did=<%=request.getParameter("did")%>"
           pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true"
           pageSize="5"
           pageList="[5,10,20,50,100]"
    >
        <thead>
        <tr>
            <th field="strStartTime" width="35%">开始时间</th>
            <th field="strEndTime" width="35%">结束时间</th>
            <th field="dts" width="30%">运行时长（分钟）</th>
        </tr>
        </thead>
    </table>
</div>

<script type="text/javascript">
    var did='<%=request.getParameter("did")%>'
    $(function () {
        $("input[type=text]").validatebox();
        loadDeviceData();
    });

    function loadDeviceData(){
        $.ajax({
            type: "Get",
            url: "/device/getById",
            dataType: "json",
            data: { did: did },
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

    //锁定机器
    function issueLock() {
        if($("#socket").val() != '1')
        {
            $.messager.alert('系统提示',"连接关闭，无法操作");
            return;
        }
        $.messager.confirm('系统提示','确定锁定机器？',function(r){
            if (r){
                $.ajax({
                    type : "post",
                    url : "/device/issueLock",
                    dataType : 'json',
                    data: { did: did },
                    beforeSend:loadTips.showLoading(),
                    success : function(result) {
                        loadTips.hideLoadind();
                        if(result.success){
                            $.messager.alert('系统提示',"操作成功");
                        }else{
                            $.messager.alert('系统提示',result.message);
                        }
                    },
                    error: function (result) {
                        loadTips.hideLoadind();
                        $.messager.alert("系统错误",result);
                    }
                });
            }
        });
    }

    //锁定机器
    function issueUnlock() {
        if($("#socket").val() != '1')
        {
            $.messager.alert('系统提示',"连接关闭，无法操作");
            return;
        }
        $.messager.confirm('系统提示','确定解除锁定？',function(r){
            if (r){
                $.ajax({
                    type : "post",
                    url : "/device/issueUnlock",
                    dataType : 'json',
                    data: { did: did },
                    beforeSend:loadTips.showLoading(),
                    success : function(result) {
                        loadTips.hideLoadind();
                        if(result.success){
                            $.messager.alert('系统提示',"操作成功");
                        }else{
                            $.messager.alert('系统提示',result.message);
                        }
                    },
                    error: function (result) {
                        loadTips.hideLoadind();
                        $.messager.alert("系统错误",result);
                    }
                });
            }
        });
    }

    //更新智盒版本
    function updateVer(){
        if($("#socket").val() != '1')
        {
            $.messager.alert('系统提示',"连接关闭，无法操作");
            return;
        }
        $.messager.confirm('系统提示','确定升级智盒版本？',function(r){
            if (r){
                $.ajax({
                    type : "post",
                    url : "/device/updateVer",
                    dataType : 'json',
                    data: { did: did },
                    beforeSend:loadTips.showLoading(),
                    success : function(result) {
                        loadTips.hideLoadind();
                        if(result.success){
                            $.messager.alert('系统提示',"操作成功");
                        }else{
                            $.messager.alert('系统提示',result.message);
                        }
                    },
                    error: function (result) {
                        loadTips.hideLoadind();
                        $.messager.alert("系统错误",result);
                    }
                });
            }
        });
    }

    function formatLStatus(value, row)
    {
        if (value == '1')
        {
            return '<span style="color:green">安全位置</span>';
        }
        else if (value == '2')
        {
            return '<span style="color:blue">锁定位置</span>';
        }
    }

    function formatLtype(value, row)
    {
        if (value == 'i108' || value == '20003')
        {
            return '<span style="color:red">生产已完成</span>';
        }
        else if (value == 'i109' || value == '20004')
        {
            return '<span style="color:red">租用到期</span>';
        }
        else if (value == 'i110' || value == '20005')
        {
            return '<span style="color:red">管理员强制</span>';
        }
        else if (value == 'i111' || value == '20006')
        {
            //return '<span style="color:red">位置移动==>请先设置安全位置再解锁</span>';
            return '<span style="color:red">位置移动</span>';
        }
        else if (value == 'f101')
        {
            return '<span style="color:red">请解锁设备</span>';
        }
    }

    function formatStatus(value, row)
    {
        if (value == '1')
        {
            return '<span style="color:green">正常</span>';
        }
        else if (value == '2')
        {
            return '<span style="color:red">锁定</span>';
        }
        else if (value == '3')
        {
            return '<span style="color:orange">正在解锁中</span>';
        }
        else if (value == '4')
        {
            return '<span style="color:purple">正在锁定中</span>';
        }
    }

    function issueSpwd(){
        if($("#socket").val() != '1')
        {
            $.messager.alert('系统提示',"连接关闭，无法操作");
            return;
        }
        $.messager.confirm('系统提示','确定更换超级密码？',function(r){
            if (r){
                $.ajax({
                    type : "post",
                    url : "/device/issuespwd",
                    dataType : 'json',
                    data: { did: did },
                    beforeSend:loadTips.showLoading(),
                    success : function(result) {
                        loadTips.hideLoadind();
                        if(result.success){
                            $.messager.alert('系统提示',"操作成功");
                        }else{
                            $.messager.alert('系统提示',result.message);
                        }
                    },
                    error: function (result) {
                        loadTips.hideLoadind();
                        $.messager.alert("系统错误",result);
                    }
                });
            }
        });
    }

    //增加产量
    function  issueNums() {
        if($("#socket").val() != '1')
        {
            $.messager.alert('系统提示',"连接关闭，无法操作");
            return;
        }
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '增加产量',
            iframe: { src: "/device/addnum?did="+did },
            area: ['350', '250']
        });
    }

    //更换智盒
    function  issueModule() {
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '更换智盒',
            iframe: { src: "/device/upmodule?did="+did },
            area: ['400', '250']
        });
    }

    //刷新
    function refresh(){
        self.location.href=self.location.href.toString();
    }
</script>
</html>