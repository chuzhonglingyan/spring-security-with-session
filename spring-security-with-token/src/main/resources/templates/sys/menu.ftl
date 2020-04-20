<!DOCTYPE html>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html lang="en" >
<head>
    <#include "../common/head.ftl">
    <link href="${request.contextPath}/static/css/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div style="text-align: center;margin:0 auto;width: 1000px; ">
    <h1>菜单页面</h1>
    <div class="ibox-content">
        <form role="form" class="form-inline">
            <@sec.authorize access="hasAuthority('menu:add')">
                <button class="btn btn-primary" type="button" id="addMenu">新增</button>
            </@sec.authorize>

            <button class="btn btn-primary" type="button" onclick="window.location.href='/logout'" >退出登录</button>
        </form>
    </div>
</div>
</body>
</html>