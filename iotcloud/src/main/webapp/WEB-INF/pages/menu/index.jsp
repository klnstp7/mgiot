<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>菜单管理</title>
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
                    <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btnAdd"  onclick="editMenu(0,null,null)">添加</a></td>
                    <td><a class="easyui-linkbutton" iconCls="icon-reload" class="u-inpt u-inpt-lg" id="btnReset"
                           href="javascript:void(0)" onclick="refresh()">刷新</a></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div class="easyui-doc-padding">
    <table id="mTb" class="easyui-treegrid" width="100%" toolbar="#toolbar" >
    </table>
</div>

</body>

<script type="text/javascript">
    $(function () {
        loadtreegrid();
    });

    function loadtreegrid(){
        $("#mTb").treegrid({
            url:'/menu/gettreegrid',
            method: 'post',
            idField: 'mid',
            treeField: 'mname',
            rownumbers:true,//行号
            fitColumns:true,
            columns: [[
                {field: 'mname', title: '菜单名称',  width: 400},
                {field: 'url', title: '衔接 ', width: 150},
                {field: 'ordernum', title: '排序 ', width: 50},
                {field: 'mtype', title: '类型 ', width: 50,formatter : function(value, row){
                    if (value == '1')
                    {
                        return '<span>菜单</span>';
                    }
                    else
                    {
                        return '<span>权限</span>';
                    }
                }},
                {field: 'pricode', title: '权限标识', width: 150},
                {field: 'visible', title: '显示', width: 50,formatter : function(value, row){
                    if (value == true)
                    {
                        return '<span>可见</span>';
                    }
                    else
                    {
                        return '<span>隐藏</span>';
                    }
                }},
                {field: 'mid', title: '操作 ', width: 150,formatter : function(value, row){
                    var tmp='<a href="javascript:void(0)" onclick="editMenu('+row.mid+','+row.parentid+',\''+row.parentname+'\')">修改</a>&nbsp;';
                    tmp+='<a href="javascript:void(0)" onclick="removeMenu('+row.mid+')">删除</a>&nbsp;';
                    tmp+='<a href="javascript:void(0)" onclick="editMenu(0,'+row.mid+',\''+row.mname+'\')">新增子菜单</a>';
                    return tmp;
                }}
            ]],
            onLoadSuccess: function () {
                $("#mTb").treegrid("collapseAll");
                $("span.tree-icon").removeClass("tree-folder");
                $("span.tree-icon").removeClass("tree-file");
            }
        });
    }

    //查询
    function Search() {
        var queryParams = $('#mTb').datagrid('options').queryParams;
        queryParams.menu = $("#menu").val();
        queryParams.ctype = $("#ctype").combobox("getValue");
        $('#mTb').treegrid('options').queryParams=queryParams;
        $("#mTb").treegrid('reload');
    }

    function editMenu(mid,parentid,parentname){
        var operate='',url='';
        if(mid=='0'){
            operate='新增';
        }else{
            operate='修改';
        }
       if(parentid==undefined || parentid==null){
            parentid='';
       }
        if(parentname==undefined || parentname==null){
            parentname='';
        }
        $.layer({
            scrolling: 'auto',
            type: 2,
            title: '菜单'+operate,
            iframe: { src: "/menu/edit?mid="+mid+"&parentid="+parentid+"&parentname="+parentname},
            area: ['600', '350']
        });
    }

    function removeMenu(mid){
        $.messager.confirm('系统提示','确定删除？',function(r){
            if (r){
                $.post('/menu/delete',{mid:mid},function(data){
                    if (data.success) {
                        $.messager.alert("系统提示","删除成功！","info",function () {
                            self.refresh();
                            parent.layer.closeAll();
                        });
                    }else{
                        $.messager.alert("系统提示",data.message);
                    }
                },'json');
            }
        });
    }

    function refresh(){
        self.location.href=self.location.toString();
    }
</script>
</html>