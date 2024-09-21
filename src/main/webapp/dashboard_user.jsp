<%@ page import="vn.edu.iuh.fit.lab_01.entyties.Account" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/16/2024
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InforUser</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<% Account account = (Account) session.getAttribute("accountLogin");
%>
<h1>Xin Chao User: <%= account.getFullName() %></h1>

<div class="menu">
    <ul>
        <li><a href="action?action=listRole">List role</a></li>
        <li><a href="index.jsp">Log out</a></li>
    </ul>
</div>


<div class="container-dashboard">
    <h1>Thong tin cua ban</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Full Name </th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%=account.getAccountId()%></td>
            <td><%=account.getFullName()%></td>
            <td><%=account.getEmail()%></td>
            <td><%=account.getPassword()%></td>
            <td><%=account.getPhone()%></td>
            <td><%=account.getStatus()%></td>
        </tr>

        </tbody>
    </table>
</div>

</body>
</html>
