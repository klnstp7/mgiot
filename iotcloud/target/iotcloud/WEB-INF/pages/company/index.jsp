<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>企业管理</title>
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
                        <select class="easyui-combobox" id="ctype" name="ctype"  style="width:142px;height: 28px;"
                                data-options="
                             url:'/companytype/getall?infirst=true',
                            method:'post',
                            valueField:'ctid',
                            textField:'ctname',
                            multiple:false,
                            panelHeight:'auto',
                            editable:false">
                        </select>
                    </td>
                    <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="Search()">查询</a></td>
                    <td><a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btnAdd"  onclick="editCompany(0,null,null)">添加</a></td>
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
            url:'/company/gettreegrid',
            method: 'post',
            idField: 'cid',
            treeField: 'company',
            rownumbers:true,//行号
            fitColumns:true,
            columns: [[
                {field: 'company', title: '公司',  width: 400},
                {field: 'ctname', title: '类型 ', width: 150},
                {field: 'status', title: '状态 ', width: 150,formatter : function(value, row){
                    if (value == '1')
                    {
                        return '<span style="color:green">正常</span>';
                    }
                    else
                    {
                        return '<span style="color:red">禁用</span>';
                    }
                }},
                {field: 'address', title: '地址 ', width: 300},
                {field: 'cid', title: '操作 ', width: 150,formatter : function(value, row){
                    var tmp='<a href="javascript:void(0)" onclick="editCompany('+row.cid+','+row.parentid+',\''+row.parentname+'\')">修改</a>&nbsp;';
                    tmp+='<a href="javascript:void(0)" onclick="removeCompany('+row.cid+')">删除</a>&nbsp;';
                    tmp+='<a href="javascript:void(0)" onclick="editCompany(0,'+row.cid+',\''+row.company+'\')">新增子公司</a>';
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
        var queryParams = $('#mTb').treegrid('options').queryParams;
        delete queryParams.id;
        queryParams.company = $("#company").val();
        queryParams.ctype = $("#ctype").combobox("getValue")==""?0:$("#ctype").combobox("getValue");
        $('#mTb').treegrid('options').queryParams=queryParams;
        $("#mTb").treegrid('reload');
    }

    function editCompany(cid,parentid,parentname){
        var operate='',url='';
        if(cid=='0'){
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
            title: '企业'+operate,
            iframe: { src: "/company/edit?cid="+cid+"&parentid="+parentid+"&parentname="+parentname },
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