<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>告警监控</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" >
<div id="toolbar">
    <div class="easyui-filter" style="width: 95%">
        <form id="form1">
        <table >
            <tr>
                <td>使用厂家:</td>
                <td><input type="text" id="scompany" name="scompany" class="easyui-doc-textbox"  /></td>
                <td>机器名称:</td>
                <td><input type="text" id="device" name="device" class="easyui-doc-textbox" /></td>
                <td>开始时间:</td>
                <td>
                    <input id="startTime" name="startTime" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,editable:false" style="height: 26px !important;">
                </td>
                <td>结束时间:</td>
                <td>
                    <input id="endTime" name="endTime"  class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,editable:false" style="height: 26px !important;">
                </td>
                <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="Search()">查询</a></td>
            </tr>
        </table>
        </form>
    </div>
</div>
<div class="easyui-doc-padding">
<table id="mTb"
       class="easyui-datagrid"
       width="100%"
       url="/warn/getPaging"
       toolbar="#toolbar"
       nowrap="false"
       pagination="true"
       rownumbers="true"
       fitColumns="true"
       singleSelect="true"
       pageSize="10"
       pageList="[10,20,50,100]"
>
    <thead>
    <tr>
        <th field="company" width="50" >使用厂家</th>
        <th field="usecom" width="50">机器名称</th>
        <th field="moduleid" width="50" >智盒编码</th>
        <th field="errpri" width="50"  formatter="formaterrpri" >告警级别</th>
        <th field="wtname" width="50">告警原因</th>
        <th field="strdt" width="50">告警时间</th>
    </tr>
    </thead>
</table>
</div>

</body>
<script type="text/javascript" >
    var url;

    //查询
    function Search() {
        $("#mTb").datagrid({
            url: '/warn/getPaging?'+$("#form1").serialize(),
            onLoadError: function (data) {
                $.messager.alert("系统错误",data);
            }
        });
    }

    function formaterrpri(value, row)
    {
        if (value == '1')
        {
            return '严重告警';
        }
        else if (value == '2')
        {
            return '主要告警';
        }
        else if (value == '3')
        {
            return '次要告警';
        }
        else if (value == '4')
        {
            return '警告告警';
        }
    }
</script>
</html>
