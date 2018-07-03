<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>功能菜单</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
</head>
<body class="easyui-layout">
<form id="form1" style="margin:10px;">
    <input type="hidden" id="rid" name="rid" value="${rid}"/>
    <table style="margin-top:10px;" class="easyui-doc-table" >
        <tr>
            <td>所属公司</td>
            <td>
                <input type="hidden" id="cid" name="cid" value="${cid}" />
                <input type="text" id="company" name="company" class="easyui-doc-textbox" value="${company}"  data-options="editable:false" style="width:200px;"/>
            </td>
            <td>角色名称</td>
            <td>
                <input type="text" id="rname" name="rname" class="easyui-doc-textbox" value="${rname}"  style="width:200px;" data-options="editable:false"/>
            </td>
        </tr>
    </table>
</form>

<div class="easyui-doc-padding">
    <table width="100%">
        <tr>
            <td>
                <table id="mTb" class="easyui-treegrid" width="100%" toolbar="#toolbar" >
                </table>
            </td>
        </tr>
        <tr>
            <td  style="text-align: center; margin-top: 20px">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  id="btnSubmit" onclick="saveRolePri()">确定</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" id="btnCancel()" onclick="cancel()" >取消</a>
            </td>
        </tr>
    </table>
    </table>
</div>

</body>

<script type="text/javascript">
    $(function () {
        $("input[type=text]").validatebox();
        loadtreegrid();
    });

    function loadtreegrid(){
        $("#mTb").treegrid({
            url: "/role/getrolepri?rid="+$("#rid").val(),
            method: 'post',
            idField: 'mid',
            treeField: 'mname',
           // rownumbers:true,//行号
            fitColumns : true,
            singleSelect : false,
            checkOnSelect : true,
            selectOnCheck : true,
            columns: [[
                {title : 'mid', field : 'mid', checkbox : true, align : 'center', width : 60},
                {field: 'mname', title: '菜单名称',  width: 300},
                {field: 'url', title: '衔接 ', width: 150},
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
                {field: 'pricode', title: '权限标识', width: 150}
            ]],
            onLoadSuccess:function(row,data) {
                $("#mTb").treegrid("collapseAll");
                $("span.tree-icon").removeClass("tree-folder");
                $("span.tree-icon").removeClass("tree-file");
                if(data){
                    $.each(data.rows, function(index, item){
                        if(item.ck){
                            $('#mTb').treegrid('select', item.mid);
                        }
                    });
                }

            }
        });
    }

    function saveRolePri() {
        var checkedItems = $('#mTb').treegrid('getSelections');
        var mids = [];
        $.each(checkedItems, function (index, item) {
            mids.push(item.mid);
        });
        $.ajax({
            type: "POST",
            url: "/role/saverolepri",
            dataType: "json",
            async: true,
            data: {rid:$("#rid").val(),mids:mids},
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