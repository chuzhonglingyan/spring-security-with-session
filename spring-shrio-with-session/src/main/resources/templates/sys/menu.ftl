<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/head.ftl">
    <link href="${request.contextPath}/static/css/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
</head>
<body class="gray-bg" >
<div id="app" style="text-align: center;margin:0 auto;width: 1000px; ">
    <h1>菜单页面</h1>
    <div class="ibox-content">
        <form role="form" class="form-inline">
            <label> 用户[<@shiro.principal/>]</label>
            <@shiro.hasPermission name="menu:add">
                <button class="btn btn-primary" type="button" id="addMenu" @click="addMenu()">新增</button>
            </@shiro.hasPermission>
            <button class="btn btn-primary" type="button" id="addMenu" @click="addMenu()">新增</button>
        </form>

        <form class="form-horizontal" role="form" id="addForm" style="margin-top: 10px">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">菜单名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入菜单名称">
                </div>
            </div>
            <div class="form-group">
                <label for="path" class="col-sm-2 control-label">菜单路径</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="path" name="path" placeholder="请输入菜单路径">
                </div>
            </div>
        </form>

    </div>
</div>

<script src="${request.contextPath}/static/js/backend/menu.js"></script>

</body>

</html>