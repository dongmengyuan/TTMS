<%@ page pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="./view/system_manager/Bootstrap/bs.css">
    <link rel="stylesheet" href="./view/system_manager/css/login.css">
</head>

<body>
<div class="container">
    <h1>欢迎使用FZN影院管理系统</h1>
    <div id="login">
        <%--<div id="alert">${desc}</div>--%>
        <form action="Login" method="post">
            <div id="alert">${desc}</div>
            <div class="form-group">
                <p align="center">帐名</p>
                <input type="text" class="form-control" id="name" name = "name" placeholder="请输入账号"  autofocus>
            </div>
            <div class="form-group">
                <p align="center">密码</p>
                <input type="password" class="form-control" id="pass" name = "pass" placeholder="请输入密码" >
            </div>
            <div id="but">
                <button type="submit" class="btn btn-primary  btn-block">登陆</button>
            </div>
        </form>
    </div>
</div>

<%--<script src="./view/system_manager/javascript/login.js"></script>--%>
</body>
</html>
