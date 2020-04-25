<!DOCTYPE html>
<html lang="en">
<head>

    <title>统一认证中心</title>
    <#include "../common/head.ftl">
    <link href="${request.contextPath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div id="app" class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <h3>认证中心</h3>
        <form class="m-t" role="form" id="loginForm" method="post" action=${loginAction}>
            <div class="form-group">
                <label>
                    <input type="text" name="username"  class="form-control" id="username"
                           placeholder="用户名" required="">
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input type="password" name="password" id="password" class="form-control"
                           placeholder="密码" required="">
                </label>
            </div>

            <div class="form-group">
                <label style="float:left" class="checkbox-inline i-checks">
                    <input type="checkbox" name="rememberMe"
                           id="rememberMe"
                           value="true">自动登录
                </label>
                <label class="checkbox-inline i-checks">
                    <input type="checkbox" name="rememberAccount"
                           id="rememberAccount" value="true"> 记住账号
                </label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary block full-width m-b">
                    登录
                </button>
            </div>
        </form>
    </div>
</div>

<!-- jQuery Validation plugin javascript-->
<script src="${request.contextPath}/static/js/plugins/iCheck/icheck.min.js"></script>
</body>

</html>