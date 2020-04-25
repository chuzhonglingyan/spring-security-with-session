<!DOCTYPE html>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html lang="en" >
<head>
    <#include "../common/head.ftl">
    <link href="${request.contextPath}/static/css/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div style="text-align: center;margin:0 auto;width: 1000px; ">
    <h1>认证中心授权页面</h1>
    <div class="ibox-title">
        <div class="title-right">OAUTH-BOOT 授权</div>
        <div class="title-left">
            <a href="#help">帮助</a>
        </div>
    </div>
    <div class="ibox-content">
        <h3 >${clientId} 请求授权，该应用将获取你的以下信息</h3>
        <p>昵称，头像和性别</p>
        授权后表明你已同意 <a  href="#boot" style="color: red">OAUTH-BOOT 服务协议</a>
        <form style="margin-top: 20px" method="post" action=${oauthAuthorize}>
            <input type="hidden" name="user_oauth_approval" value="true">
            <button class="btn" type="submit"> 同意/授权</button>
        </form>
    </div>
</div>
</body>
</html>