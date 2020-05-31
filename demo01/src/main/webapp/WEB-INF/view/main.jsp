<%@ page import="java.util.List,java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="#"></script>
    <script>
        function changeImg(obj) {
            obj.src = "${pageContext.request.contextPath}/#?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<header>
    <%--<%@include file="/" %>--%>
</header>

<div>
    <form action="${pageContext.request.contextPath}/" method="post">
        <input type="text" placeholder="username" name="username"> <br/>
        <input type="password" placeholder="password" name="password"> <br/>
        <input type="text" placeholder="check code" name="checkCode">
        <a href="javascript:void(0);"><img src="#" alt="checkCode" onclick="changeImg(this);"></a> <br/>
        <input type="submit" value="submit"> <br/>
        <span style="color: red">${requestScope.msg}</span>
    </form>
</div>

<footer>
    <%--<%@include file="/" %>--%>
</footer>
</body>
<script>
    // 页面加载后执行
    $(function () {

    });

    function functionName() {
        $.ajax({
            url: "${pageContext.request.contextPath}/#",
            type: "get",
            // 设置响应体数据类型. 让浏览器以json的解析格式解析响应体内容
            dataType: "json",
            data: {id: 1, name: "zhangsan"},
            async: false,
            // 发送请求之前(open和send之前)将执行以下代码. 参数是当前异步对象
            beforeSend: function (xhr) {
                console.log("发送请求之前:", xhr);
            },
            success: function (result) {
                console.log(result);
            },
            error: function (result) {
                console.log(result);
            },
            // 请求完成后执行下面的代码, 无论请求是否成功都会执行. 参数是当前异步对象
            complete: function (xhr) {
                console.log("请求完成:", xhr);
            }
        });
    }
</script>
</html>