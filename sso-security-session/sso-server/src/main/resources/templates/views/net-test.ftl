<!DOCTYPE html>
<html lang="en">
<head >
    <#include "../common/head.ftl">
    <title>测试网络</title>
</head>

<style>
    .col-center-block {
        float: none;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
</style>

<body>

<div class="container" id="app">
    <div class="row ">
        <div class="col-xs-6 col-md-4 col-center-block">
            <div id="box1" style="margin-top: 10px">
                <input type="button" @click="getForm()" value="点我异步获取数据(getForm)">
            </div>

            <div id="box2" style="margin-top: 10px">
                <input type="button" @click="postForm()" value="点我异步获取数据(postForm)">
            </div>

            <div id="box3" style="margin-top: 10px">
                <input type="button" @click="postJson()" value="点我异步获取数据(postJson)">
            </div>
        </div>
    </div>

</div>

<script src="../../static/js/test/net-test.js"></script>
</body>


</html>