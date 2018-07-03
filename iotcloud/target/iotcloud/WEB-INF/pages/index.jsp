<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.migen.iotcloud.dto.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>米根物联云平台</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="include/header.jsp"></c:import>
    <style type="text/css">
        .divTmp { position:absolute;top:0px;left:0px;width:100%;height:34%;border-top:1px solid #000;}
        .div1 {	width:auto;height:auto;border-top:1px solid #000; border-left:1px solid #000; border-right:1px solid #000; border-bottom:1px solid #000; margin-top:20px;}
        .div2 {	width:auto;height:auto;border-top:1px solid #000; border-left:1px solid #000; border-right:1px solid #000; border-bottom:1px solid #000; margin-top:20px;}
        .div3 { width:auto;height:auto;border-top:1px solid #000; border-left:1px solid #000; border-right:1px solid #000; border-bottom:1px solid #000; margin-top:20px;}
        .xline{border-bottom:solid 2px #000000; height:5px;}
    </style>
</head>
<body class="easyui-layout" style="overflow-y:hidden" scroll="no">
<div region="north" split="true" border="false"
     style="overflow: hidden; height: 40px;
        background: url(/resources/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 38px;color: #fff; font-family: Verdana, 微软雅黑,黑体">

    <span style="padding-left:10px; font-size: 14px; ">
        <img src="/resources/images/blocks.gif" width="20" height="20" align="absmiddle" />
		<font style="padding-top: 15px">	米根物联云-${user.company}</font>
    </span>
<span style="float:right; padding-right:20px;" class="head">

			<i  class="fa fa-user-circle-o" style="font-size:15px;color:#FFFACD">${user.uname}</i>
			<a href="javascript:void(0)" id="editpass"><span style="color:#FFFACD">修改密码</span></a>
			<a href="javascript:void(0)" id="loginOut"><span style="color:#FFFACD">安全退出</span></a>
</span>

</div>
<div region="west" hide="true" split="true" title="&nbsp;"
     style="width:180px;" id="west">
    <div id="t1" class="easyui-accordion" fit="true" border="false">
        <!--  导航内容 -->
    </div>
</div>

<div id="mainPanle" region="center"
     style="background: #eee; overflow-y:hidden;">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
    </div>
</div>
<div region="south" split="true"
     style="height: 20px; background: #D2E0F2; ">
    <div class="footer" align="center"></div>
</div>
<div id="mm" class="easyui-menu" style="width:150px;">
    <div id="refresh">刷新</div>
    <div class="menu-sep"></div>
    <div id="close">关闭</div>
    <div id="closeall">全部关闭</div>
    <div id="closeother">除此之外全部关闭</div>
    <div class="menu-sep"></div>
    <div id="closeright">当前页右侧全部关闭</div>
    <div id="closeleft">当前页左侧全部关闭</div>
    <div class="menu-sep"></div>
    <div id="exit">退出</div>
</div>
</body>
<script type="text/javascript">
    var flag;
    $(function() {
        $("#t1").tree({
            url : "/home/getUserMenu",
            animate : true,//展开和折叠菜单时会伴随着动画
            dnd : false,//启动菜单项的拖拽功能
            //checkbox:true,//菜单项前面是否显示复选框
            onLoadSuccess:function(data){
                addTab("信息展示", "/home/first");
            },

            onClick : function(node) {
                if (node.url != "") {
                    addTab(node.text, node.url);
                }
            }
        });
        //修改密码
        $('#editpass').click(function() {
            $.layer({
                scrolling: 'auto',
                type: 2,
                title: '密码修改',
                iframe: { src: "/user/editPwd" },
                area: ['400', '300px']
            });
        });

        $('#loginOut').click(function() {
            $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
                if (r) {
                    //location.href = 'loginOut.jsp';
                    $.post('/home/logout',function(result){
                        if (result.success)
                        {
                            window.location.href='/home/login';
                        }
                    },'json');
                }
            });
        });


        //绑定tabs的右键菜单
        $("#tabs").tabs({
            onContextMenu:function(e, title,index){
                e.preventDefault();
                if(index>0){
                    $('#mm').menu('show', {
                        left: e.pageX,
                        top: e.pageY
                    }).data("tabTitle", title);
                }
            },
            onSelect: function (title) {
                //loadHtmlFile(title);
            },
            onBeforeClose: function(title,index){
                if (title == '信息展示')
                {
                    return false;  // 阻止关闭
                }
            }
        });

        //实例化menu的onClick事件
        $("#mm").menu({
            onClick : function(item) {
                closeTab(item.id);
            }
        });
    });
    //---------


    function closeTab(action)
    {
        var alltabs = $('#tabs').tabs('tabs');
        var currentTab =$('#tabs').tabs('getSelected');
        var allTabtitle = [];
        $.each(alltabs,function(i,n){
            allTabtitle.push($(n).panel('options').title);
        })
        switch (action) {
            case "refresh":
                var iframe = $(currentTab.panel('options').content);
                var src = iframe.attr('src');
                $('#tabs').tabs('update', {
                    tab: $(currentTab),
                    options: {
                        content: createFrame(src)
                    }
                })
                break;
            case "close":
                var currtab_title = currentTab.panel('options').title;
                $('#tabs').tabs('close', currtab_title);
                break;
            case "closeall":
                $.each(allTabtitle, function (i, n) {
                    $('#tabs').tabs('close', n);
                });
                break;
            case "closeother":
                var currtab_title = currentTab.panel('options').title;
                $.each(allTabtitle, function (i, n) {
                    if (n != currtab_title)
                    {
                        $('#tabs').tabs('close', n);
                    }
                });
                break;
            case "closeright":
                var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
                if (tabIndex == alltabs.length - 1){
                    return false;
                }
                $.each(allTabtitle, function (i, n) {
                    if (i > tabIndex) {
                        $('#tabs').tabs('close', n);
                    }
                });
                break;
            case "closeleft":
                var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
                if (tabIndex == 1) {
                    return false;
                }
                $.each(allTabtitle, function (i, n) {
                    if (i < tabIndex) {
                        $('#tabs').tabs('close', n);
                    }
                });
                break;
            case "exit":
                $('#closeMenu').menu('hide');
                break;
            default:
                $('#tabs').tabs('close',action);
                break;
        }
    }

    function append() {
        flag = "add";
        $("#dialogMenu").form("clear");
        $("#dialog").dialog("open");
    }

    //在右边center区域打开菜单，新增tab
    function addTab(text, url) {
        if ($("#tabs").tabs('exists', text)) {
            $('#tabs').tabs('select', text);
            var selTab = $('#tabs').tabs('getSelected');
            $('#tabs').tabs('update', {
                tab: selTab,
                options: {
                    content : createFrame(url)
                }
            });
            selTab.panel('refresh');
        } else {
            var taboption={title : text, content : createFrame(url)};
            if(text=='信息展示'){
                taboption.closable=false;
            }else{
                taboption.closable=true;
            }
            $('#tabs').tabs('add',taboption);
        }
    }

    function createFrame(url) {
        var s = "<iframe name=\"mainFrame\" scrolling=\"auto\" frameborder=\"0\"  src=\""
            + url + "\" style=\"width:100%;height:100%;\"></iframe>";
        return s;
    }

    function reloadTab(text, url) {
        $('#tabs').tabs('select', text);
        var selTab = $('#tabs').tabs('getSelected');
        $('#tabs').tabs('update', {
            tab: selTab,
            options: {
                content: genData(url)
            }
        });
        selTab.panel('refresh');
    }
</script>
</html>
