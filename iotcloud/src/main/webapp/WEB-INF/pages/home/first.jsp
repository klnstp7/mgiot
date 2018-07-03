<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.migen.iotcloud.entity.FirstMachine" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.migen.iotcloud.entity.WarnShow" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>信息展示</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <c:import url="../include/header.jsp"></c:import>
    <style type="text/css">

    .bg0{background-color:RGB(242,242,242); color:RGB(127,127,127); width:380px; height:130px; margin-top:15px; margin-left:20px; }
    .bg0:hover{background:RGB(242,242,242); color:RGB(127,127,127); width:380px; height:130px; margin-top:15px; margin-left:20px; }

    .cssprov{font-size:18px; font-weight:bold; color:#0a0a0a; margin-left:20px;margin-top:32px; }
    .cssname{font-size:16px; font-weight:bold; color:#0a0a0a; margin-left:20px;margin-top:5px;}
    .cssinfo{font-size:12px; font-weight:normal; color:#0a0a0a; margin-left:20px;margin-top:5px;}

    .cssline{}
    .csslineOK{border-bottom:solid 2px #666666; height:5px;}
    .csshide{font-size:4px; visibility:hidden;}

    .csssear{background-color:RGB(217,217,217); width:1180px; height:65px;margin-left:20px; margin-top: 10px}
    .csssinr{font-size:16px; font-weight:normal; color:#0a0a0a; margin-left:20px;padding-top: 20px;}

    .csswarn{font-size:16px; font-weight:bold; color:#0a0a0a; margin-left:20px;margin-top:5px;}
    .csswarn span{ font-size: 12px;font-weight: normal }
    .bgw{background-color:red; width:16px; height:16px;pading:0px; border:0px;padding-top: 13px; }
    .bgw:hover{background:#a9d18e; width:16px; height:16px;pading:0px; border:0px;padding-top: 13px; }
    .cssitem li{ display: inline;float:left;}
    </style>
</head>
<body style="background:white">
<div id="whywhy" style="overflow:hidden;">
    <!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="myrefresh()"><font color="purple" size="3" style="font-weight:bold">刷新</font></a><br> -->
    <div class="csssear">
        <form id="searForm" method="post">
            <table>
                <tr>
                    <h1 class="csssinr">
                        您所搜索设备：<input id="searStr" name="searStr" type="text" style="height:26px;width:300px;border:0px;" value="${searStr}">&nbsp;&nbsp;&nbsp;
                        <input type="button" style='cursor:hand; width:64px; height:26px; background-color:#427eab; pading:0px; border:0px;color:white;font-size:16px;font-weight:bold;vertical-align: bottom;' onClick="doSearch()" value="查询" id="btndel"/>
                        <input type="button" style='cursor:hand; width:64px; height:26px; background-color:#427eab; pading:0px; border:0px;color:white;font-size:16px;font-weight:bold;vertical-align: bottom;' onClick="doSearch()" value="返回" id="sx"/>
                    </h1>
                </tr>
            </table>
        </form>
    </div>
<c:forEach items="${data}" var="province">
    <c:forEach items="${province.value}" var="city">
        <h1 class="cssprov">${province.key}-${city.key}</h1>
        <div class="cssline"></div>
        <ul class="cssitem">
        <c:forEach items="${city.value}" var="firstMachine" >
            <li>
                <div class="bg0" onclick="dtail('${firstMachine.machineName}','${firstMachine.did}')">
                    <img src="/resources/images/fpicline.jpg" style="display: block" />
                    <h1 class="cssname">${firstMachine.machineName }</h1>
                    <h1 class="cssinfo">机械状态： ${firstMachine.machineStatus}</h1>
                    <h1 class="cssinfo">智盒状态： ${firstMachine.linkStatus}</h1>
                    <h1 class="csswarn">弹出警告：
                    <c:choose>
                        <c:when test="${fn:length(firstMachine.warnList)>0}">
                            <c:forEach items="${firstMachine.warnList}" var="wi1">
                                <input type="button" class="bgw" onClick="" value="" id="btndel" title="${wsb1.info}" />
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                           <span>无</span>
                        </c:otherwise>
                    </c:choose>
                    </h1>
                </div>
            </li>
        </c:forEach>
        </ul>
    </c:forEach>
</c:forEach>
</div>
</body>
<script type="text/javascript">
    function addTab(text, url) {
        var parent$ = self.parent.$;
        if (parent$('#tabs').tabs('exists', text)) {
            parent$('#tabs').tabs('select', text);
        } else {
            parent$('#tabs').tabs('add', {
                title : text,
                closable : true,
                content : genData(url)
            });
        }
    }

    function genData(url)
    {
        var s = "<iframe name=\"mainFrame\" scrolling=\"auto\" frameborder=\"0\"  src=\""
            + url + "\" style=\"width:100%;height:100%;\"></iframe>";
        return s;
    }

    function dtail(title,value)
    {
        var url = "/device/detail?did=" + value;
        addTab(title, url);
    }

    function doSearch()
    {
        var value=document.getElementById("searStr").value;
        var url = '/home/first?searStr='+value;
        window.location.href=url;
    }

    document.onkeydown = function(e) {
        var e = e || event;
        if(e.keyCode == 13) {
            setTimeout(function(){
                doSearch();
            },0);
            e.preventDefault ? e.preventDefault() : (e.returnValue = false);
        }
    }
</script>
</html>
