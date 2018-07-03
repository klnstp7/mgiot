<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.migen.iotcloud.utils.UserInfoUtil" %>
<%@ page import="com.migen.iotcloud.dto.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserInfo user=UserInfoUtil.getCurrentUser();
    String utype=String.format("%d",user.getUtype());
    String ctype=String.format("%d",user.getCtype());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>数据范围</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<div id="toolbar">
    <div class="easyui-filter" style="width: 95%">
        <form id="form1">
            <table >
                <tr>
                    <td>企业名称:</td>
                    <td><input type="text" id="company" name="company" class="easyui-doc-textbox"  /></td>
                    <td>企业类型:</td>
                    <td>
                        <select class="easyui-combobox" id="ctype" name="ctype" data-options="editable:false" style="width:142px;height: 28px;">
                            <option value="0">&nbsp;</option>
                            <% if (utype.equals("10")) {%>
                            <option value="10">服务机构</option>
                            <option value="12">机械厂</option>
                            <% }%>
                            <% if ((utype.equals("10") || utype.equals("13") || utype.equals("11")) && (ctype.equals("10") || ctype.equals("12") || ctype.equals("15"))) {%>
                            <option value="15">代理厂</option>
                            <option value="11">金融机构</option>
                            <option value="13">标签厂</option>
                            <option value="14">洗车厂</option>
                            <% }%>
                        </select>
                    </td>
                    <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="Search()">查询</a></td>
                    <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btnAdd"  onclick="editCompany('0')">添加</a></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div class="easyui-doc-padding">
    <table id="mTb" class="easyui-datagrid" width="100%"
           url="/company/getPaging" toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true" pageSize="10" pageList="[10,20,50,100]">
        <thead>
        <tr>
           <th field="company" width="50" >公司</th>
            <th field="ctype" width="50" formatter="formatType" >类型</th>
            <th field="status" width="50" formatter="formatStatus" >状态</th>
            <th field="address" width="50">地址</th>
            <th field="cid" width="80" formatter="formatOperate">操作</th>
        </tr>
        </thead>
    </table>
</div>

</body>

<script type="text/javascript">

    //查询
    function Search() {
        $("#mTb").datagrid({
            url: '/company/getPaging?'+$("#form1").serialize(),
            onLoadError: function (data) {
                $.messager.alert("系统错误",data);
            }
        });
    }

    function formatType(value, row)
    {
        if (value == '10')
        {
            return '<span style="color:red">服务机构</span>';
        } else if (value == '11')
        {
            return '<span style="color:purple">金融机构</span>';
        } else if (value == '12')
        {
            return '<span style="color:orange">机械厂</span>';
        } else if (value == '13')
        {
            return '<span style="color:green">标签厂</span>';
        } else if (value == '14')
        {
            return '<span style="color:blue">洗车厂</span>';
        } else if (value == '15')
        {
            return '<span style="color:blue">代理厂</span>';
        }
        else
        {
            return '<span style="color:black">其它</span>';
        }
    }

    function formatStatus(value, row)
    {
        if (value == '1')
        {
            return '<span style="color:green">正常</span>';
        }
        else
        {
            return '<span style="color:red">禁用</span>';
        }
    }

    function formatOperate(value, row)
    {
        var tmp='<a href="javascript:void(0)" onclick="editCompany('+row.cid+')">修改</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="removeCompany('+row.cid+')">删除</a>&nbsp;';
        return tmp;
    }

    function editCompany(cid){
        var operate='';
        if(cid=='0'){
            operate='新增';
        }else{
            operate='修改';
        }
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '企业'+operate,
            iframe: { src: "/company/edit?cid="+cid },
            area: ['500', '300']
        });
    }

    function removeCompany(cid){
        $.messager.confirm('系统提示','确定删除？',function(r){
            if (r){
                $.post('/company/delete',{cid:cid},function(data){
                    if (data.success) {
                        $.messager.alert("系统提示","删除成功！","info",function () {
                            self.Search();
                            parent.layer.closeAll();
                        });
                    }else{
                        $.messager.alert("系统提示",data.message);
                    }
                },'json');
            }
        });
    }
</script>
</html>