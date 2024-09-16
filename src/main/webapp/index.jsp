<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div id="container">
    <form action="action?action=checkLogin" method="post" id="formLogin">
        <h1>Đăng nhập</h1>
        <input type="text" name="email" placeholder="Enter email"/> <br>
        <input type="password" name="password" placeholder="Enter password"/> <br>
        <button type="submit" id="loginBtn">Đăng nhập</button>
    </form>
</div>
</body>
</html>