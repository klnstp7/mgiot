<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>修改密码</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>

</head>
<body>
<div class="easyui-layout" fit="true">
    <div region="center" border="false"
         style="padding: 10px; background: #fff; border: 1px solid #ccc;">
        <table style="border-collapse:separate; border-spacing:10px 10px;"  width="350">
            <tr>
                <td>新密码</td>
                <td><input id="txtNewPass" name="txtNewPass" type="Password" class="easyui-doc-textbox" data-options="required:true"  style="width: 200px" /></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input id="txtRePass" name="txtRePass" type="Password" class="easyui-doc-textbox" data-options="required:true"  style="width: 200px" /></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; margin-top: 20px">
                    <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)"> 确定</a>
                    <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
<script type="text/javascript">

    $(function() {
        $('#btnEp').click(function() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');
            if ($newpass.val() == '') {
                $.messager.alert('系统提示','请输入新密码');
                return;
            }
            if ($rePass.val() == '') {
                $.messager.alert('系统提示','请输入确认密码');
                return;
            }

            if ($newpass.val() != $rePass.val()) {
                $.messager.alert('系统提示','两次密码不一致!请重新输入');
                return;
            }

            $.post('/user/updPwd?newpass=' + $newpass.val(),function(result){
                if (result.success)
                {
                    $.messager.alert("系统提示","修改密码成功!","info",function () {
                        parent.layer.closeAll();
                    });
                }
                else
                {
                    $.messager.alert("系统提示","修改密码失败!")
                }
            },'json');
        });

        $('#btnCancel').click(function() {
            parent.layer.closeAll();
        });
    });
</script>
</html>
