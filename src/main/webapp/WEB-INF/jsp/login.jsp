<%--
  Created by IntelliJ IDEA.
  User: yechao
  Date: 2018/1/15
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login JSP Page</title>
    <script src="https://cdn.bootcss.com/vue/2.2.2/vue.min.js"></script>
    <script src="login.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div id='login'>
    <div></div>
    <label for="name">登录名称</label>
    <input v-model="name" type="text" placeholder="用户姓名" class="form-control">
    <br>
    <input v-model="password" type="password" placeholder="密码" class="form-control">
    <br>
    <br> <input type="button" @click="login()" value="登录" class="btn btn-primary">
    <p>{{message}}</p>
    <br><a href="/register.html">去注册用户</a>

</div>

</body>
</html>
