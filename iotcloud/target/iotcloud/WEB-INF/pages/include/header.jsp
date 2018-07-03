<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta content="0" http-equiv="expires"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>
<meta content="no-cache,must-revalidate" http-equiv="Cache-Control"/>
<meta content="telephone=no, address=no" name="format-detection"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
<link href="<%=basePath%>/resources/css/base.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/resources/library/easyui/themes/default/easyui.css" rel="stylesheet" />
<link href="<%=basePath%>/resources/library/easyui/themes/icon.css" rel="stylesheet" />
<link href="<%=basePath%>/resources/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/resources/css/loadTips.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath%>/resources/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/library/jquery-placeholder/jquery.placeholder.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/library/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/library/help/jQuery.extends.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/library/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/library/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>/resources/library/layer/layer.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/library/help/Base.js"></script>
