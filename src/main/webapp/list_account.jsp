<%@ page import="vn.edu.iuh.fit.lab_01.entyties.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/16/2024
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListAccount</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<% Account acc = (Account) session.getAttribute("accountLogin");
    List<Account> list = (List<Account>) session.getAttribute("listAccount");
%>
<h1>Xin Chao: <%= acc.getFullName() %>
</h1>
<div class="menu">
    <ul>
        <li><a href="dashboard.jsp">Home</a></li>
        <%--        <li><a href="login?action=listRole">List role</a></li>--%>
        <li><a href="add_account.jsp">Add account</a></li>
        <%--        <li><a href="index.jsp">Log out</a></li>--%>
    </ul>
</div>


<div class="container-dashboard">
    <h1>Danh sach account</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Status</th>
            <th>Role</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Account account : list){
        %>
        <tr>
            <td><%=account.getAccountId()%></td>
            <td><%=account.getFullName()%></td>
            <td><%=account.getEmail()%></td>
            <td><%=account.getPassword()%></td>
            <td><%=account.getPhone()%></td>
            <td><%=account.getStatus()%></td>
        </tr>
        <%}%>

        </tbody>
    </table>
</div>

</body>
</html>

