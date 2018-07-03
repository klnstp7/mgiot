<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>设备管理</title>
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
                <td>智盒编码:</td>
                <td><input type="text" id="moduleId" name="moduleId" class="easyui-doc-textbox"  /></td>
                <td>机器名:</td>
                <td><input type="text" id="useCom" name="useCom" class="easyui-doc-textbox" /></td>
                <td>机器锁定状态:</td>
                <td>
                    <select id="status" name="status" class="easyui-combobox">
                        <option value="0" selected="selected">&nbsp;</option>
                        <option value="1">正常</option>
                        <option value="2">锁定</option>
                        <option value="3">正在解锁中</option>
                        <option value="4">正在锁定中</option>
                    </select>
                </td>
                <td>机器运行状态:</td>
                <td>
                    <select id="runStatus" name="runStatus" class="easyui-combobox">
                        <option value="0" selected="selected">&nbsp;</option>
                        <option value="1">运行</option>
                        <option value="2">关机</option>
                        <option value="3">未配置</option>
                    </select>
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
       url="/device/getPaging"
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
        <th field="moduleId" width="70">智盒编码</th>
        <th field="didShow" width="30" data-options="hidden: true">机器编码</th>
        <th field="useCom" width="80">机器名</th>
        <th field="name" width="40" >机器型号</th>
        <th field="plcName" width="40" >PLC型号</th>
        <th field="status" width="60" formatter="formatStatus" >机器锁定状态</th>
        <th field="runStatus" width="60" formatter="formatRunStatus" >机器运行状态</th>
        <th field="socket" width="40" formatter="formatSocket" >连接状态</th>
        <th field="spwd" width="40">超级密码</th>
        <th field="commac" width="60">机器生产厂家</th>
        <th field="comage" width="60">机器代理厂家</th>
        <th field="comuse" width="60">机器使用厂家</th>
        <th field="compoi" width="60">贷款银行</th>
        <th field="address" width="60">机器生产地址</th>
        <th field="did" width="60" formatter="formatOperate">操作</th>
    </tr>
    </thead>
</table>
</div>

</body>
<script type="text/javascript" >
    var url;
    $(function() {
        $('#mTb').datagrid({
            //双击事件
            onDblClickRow: function (index, row) {
                mngDevice(row.did,row.genCom,row.moduleId);
            }
        });
    });
    //查询
    function Search() {
        $("#mTb").datagrid({
            url: '/device/getPaging?'+$("#form1").serialize(),
            onLoadError: function (data) {
                $.messager.alert("系统错误",data);
            }
        });
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
    function formatRunStatus(value, row)
    {
        if (value == '1')
        {
            return '<span style="color:green">运行</span>';
        }
        else if (value == '2')
        {
            return '<span style="color:red">关机</span>';
        }
        else if (value == '3')
        {
            return '<span style="color:purple">未配置</span>';
        }
    }
    function formatSocket(value, row)
    {
        if (value == '1')
        {
            return '<span style="color:green">连接正常</span>';
        }
        else if (value == '2')
        {
            return '<span style="color:red">连接关闭</span>';
        }
        else if (value == '3')
        {
            return '<span style="color:blue">未知</span>';
        }
    }

    function formatOperate(value, row)
    {
        var tmp='<a href="javascript:void(0)" onclick="editDevice('+row.did+')">修改</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="removeDevice('+row.did+')">删除</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="mngDevice('+row.did+',\''+row.genCom+'\',\''+row.moduleId+'\')">详情</a>';
        return tmp;
        return true;
    }

    function editDevice(did){
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '设备修改',
            iframe: { src: "/device/edit?did="+did },
            area: ['600', '450']
        });
    }

    function removeDevice(did){
        $.messager.confirm('系统提示','确定删除？',function(r){
            if (r){
                $.ajax({
                    type: "POST",
                    url: "/device/delete",
                    dataType: "json",
                    async: true,
                    data:{did:did},
                    beforeSend:loadTips.showLoading(),
                    success: function (data) {
                        loadTips.hideLoadind();
                        if (data.success) {
                            $.messager.alert("系统提示","操作成功！","info",function () {
                                Search();
                                layer.closeAll();
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
        });
    }

    function mngDevice(did,userCom,moduleId){
        var url = "/device/detail?did=" + did
        var title = userCom; //"设备详情";//
        if (null == title || '' == title)
        {
            title = moduleId;
        }
        parent.addTab(title, url);
    }
</script>
</html>
