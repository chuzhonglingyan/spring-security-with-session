<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title></title>
</head>
<body>

<h2>${user.name}</h2>
<table>
    <tr>
        <th>name</th>
    </tr>
    <#if userList?? && (userList?size > 0) >
        <#list userList as item >
            <tr>
                <td>${item.name}</td>
            </tr>
        </#list>
    <#else>
        <li>无数据<a href="javascript:void(0)" id="add">立即创建</a></li>
    </#if>
</table>
</body>
</html>