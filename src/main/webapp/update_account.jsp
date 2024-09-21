<%@ page import="vn.edu.iuh.fit.lab_01.entyties.Account" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/19/2024
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<% Account account = (Account) session.getAttribute("accountLogin");
%>
<h1>Xin Chao Admin: <%= account.getFullName() %>
</h1>
<div class="menu">
    <ul>
        <li><a href="dashboard.jsp">Home</a></li>
        <li><a href="action?action=listRole">List role</a></li>
        <li><a href="action?action=listAccount">List Account</a></li>
        <li><a href="add_account.jsp">Add account</a></li>
        <li><a href="index.jsp">Log out</a></li>
    </ul>
</div>

<div>
    <h1>Update thong tin Account</h1>
    <form id="formAddAcc" action="action?action=updateAccount" method="post">
        <label for="accountID">Account ID</label>
        <input type="text" id="accountID" name="accountID" placeholder="Enter id"/><br>
        <label for="fullName">FullName</label>
        <input type="text" id="fullName" name="fullName" placeholder="Enter full name"/> <br>
        <label for="email">Email</label>
        <input type="text" id="email" name="email" placeholder="Enter email"/> <br>
        <label for="phone">Password</label>
        <input type="text" id="password" name="password" placeholder="Enter password"/> <br>
        <label for="phone">Phone</label>
        <input type="text" id="phone" name="phone" placeholder="Enter your phone"/> <br>
        <button type="submit" id="addBtn">Update Account</button>
    </form>
</div>
</body>
</html>
