<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout" style="overflow-y:hidden;" scroll="no">
<div region="west" split="true" border="false" style="width: 200px">
    <div id="t1" class="easyui-trees" fit="true" border="false">
    </div>
</div>
<div region="center" split="true" border="false">
    <div id="toolbar">
        <div class="easyui-filter">
            <form id="form1">
                <table >
                    <tr>
                        <td style="font-size: 12px">账号:</td>
                        <td><input type="text" id="uname" name="uname" class="easyui-doc-textbox"  /></td>
                        <td style="font-size: 12px">状态:</td>
                        <td>
                            <select class="easyui-combobox" id="status" name="status"  style="width:142px;height: 28px;">
                                <option value="0"></option>
                                <option value="1">正常</option>
                                <option value="2">禁用</option>
                            </select>
                        </td>
                        <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="Search()">查询</a></td>
                        <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btnAdd"  onclick="add()">添加</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="easyui-doc-padding">
        <table id="mTb"
               class="easyui-datagrid"
               width="100%"
               url="/user/getPaging"
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
                <th field="uname" width="50" >账号</th>
                <th field="company" width="100" >所属公司</th>
                <th field="mail" width="100">邮箱</th>
                <th field="status" width="50" formatter="formatUsr" sortable="true">状态</th>
              <%--  <th field="dt" width="100" sortable="true">创建日期</th>--%>
                <th field="usrid" width="60" formatter="formatOperate">操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function() {
        $("#t1").tree({
            url: "/company/gettree",
            animate: true,//展开和折叠菜单时会伴随着动画
            dnd: false,//启动菜单项的拖拽功能
            onClick: function (node) {
                 Search();
            }
        });
    });

    //查询
    function Search() {
        var paras=$("#form1").serialize();
        if($("#t1").tree('getSelected')!=null){
            paras+="&cid="+$("#t1").tree('getSelected').id;
        }
        $("#mTb").datagrid({
            url: '/user/getPaging?'+paras,
            onLoadError: function (data) {
                $.messager.alert("系统错误",data);
            }
        });
    }

    function  formatOperate(value, row) {
        var tmp='<a href="javascript:void(0)" onclick="editUser('+row.cid+',\''+row.company+'\','+row.usrid+')">修改</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="removeUser('+row.usrid+')">删除</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="allotrole('+row.cid+',\''+row.company+'\','+row.usrid+')">分配角色</a>';
        return tmp;
    }

    function formatUsr(value, row) {
        if (value == '1')
        {
            return '<span style="color:green">正常</span>';
        }
        else
        {
            return '<span style="color:red">禁用</span>';
        }
    }

    function add(){
        if($("#t1").tree('getSelected')==null){
            $.messager.alert("系统提示","请选择所在公司");
            return;
        }
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '用户新增',
            iframe: { src: "/user/edit?cid="+$("#t1").tree('getSelected').id+"&company="+$("#t1").tree('getSelected').text+"&usrid=0" },
            area: ['500', '300']
        });
    }

    function editUser(cid,company,usrid){
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '用户修改',
            iframe: { src: "/user/edit?cid="+cid+"&company="+company+"&usrid="+usrid },
            area: ['500', '300']
        });
    }

    function removeUser(usrid){
        $.messager.confirm('系统提示','确定删除？',function(r){
            if (r){
                $.post('/user/delete',{usrid:usrid},function(data){
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

    function allotrole(cid,company,usrid){
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '分配角色',
            iframe: { src: "/user/allotrole?cid="+cid+"&company="+company+"&usrid="+usrid },
            area: ['700', '500']
        });
    }
</script>
</html>
