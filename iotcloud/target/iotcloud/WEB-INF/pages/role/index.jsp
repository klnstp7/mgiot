<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
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
                        <td style="font-size: 12px">角色名称:</td>
                        <td><input type="text" id="rname" name="rname" class="easyui-doc-textbox"  /></td>
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
               url="/role/getPaging"
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
                <th field="rname" width="50" >角色名称</th>
                <th field="company" width="100" >所属公司</th>
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
            url: '/role/getPaging?'+paras,
            onLoadError: function (data) {
                $.messager.alert("系统错误",data);
            }
        });
    }

    function  formatOperate(value, row) {
        var tmp='<a href="javascript:void(0)" onclick="editRole('+row.cid+',\''+row.company+'\','+row.rid+')">修改</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="removeRole('+row.rid+')">删除</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="allotUser('+row.cid+',\''+row.company+'\','+row.rid+',\''+row.rname+'\')">分配用户</a>&nbsp;';
        tmp+='<a href="javascript:void(0)" onclick="allotPri('+row.cid+',\''+row.company+'\','+row.rid+',\''+row.rname+'\')">功能菜单</a>';
        return tmp;
    }

    function add(){
        if($("#t1").tree('getSelected')==null){
            $.messager.alert("系统提示","请选择所在公司");
            return;
        }
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '角色新增',
            iframe: { src: "/role/edit?cid="+$("#t1").tree('getSelected').id+"&company="+$("#t1").tree('getSelected').text+"&rid=0" },
            area: ['500', '300']
        });
    }

    function editRole(cid,company,rid){
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '角色修改',
            iframe: { src: "/role/edit?cid="+cid+"&company="+company+"&rid="+rid },
            area: ['500', '300']
        });
    }

    function removeRole(rid){
        $.messager.confirm('系统提示','确定删除？',function(r){
            if (r){
                $.post('/role/delete',{rid:rid},function(data){
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

    function allotUser(cid,company,rid,rname){
        $.layer({
         scrolling: 'auto',
         type: 2,
         title: '功能菜单',
         iframe: { src: "/role/allotuser?cid="+cid+"&company="+company+"&rid="+rid +"&rname="+rname},
         area: ['700', '500']
         });
    }

    function allotPri(cid,company,rid,rname){
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '功能菜单',
            iframe: { src: "/role/allotpri?cid="+cid+"&company="+company+"&rid="+rid +"&rname="+rname},
            area: ['700', '500']
        });

      /* var url = "/role/allotpri?cid="+cid+"&company="+company+"&rid="+rid +"&rname="+rname;
        parent.addTab("功能菜单", url);*/
    }

</script>
</html>
