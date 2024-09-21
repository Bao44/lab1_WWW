<%@ page import="vn.edu.iuh.fit.lab_01.entyties.Account" %>
<%@ page import="vn.edu.iuh.fit.lab_01.entyties.Role" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/21/2024
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListRole</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<% Account account = (Account) session.getAttribute("accountLogin");
    List<Role> listRole = (List<Role>) session.getAttribute("listRole");
    String grant_accessLogin = session.getAttribute("grant_accessLogin").toString();
%>
<h1>Xin Chao Admin: <%= account.getFullName() %>
</h1>
<div class="menu">
    <ul>
        <li><a href="dashboard_user.jsp">Home</a></li>
        <% if (grant_accessLogin.equals("admin")) {%>
        <li><a href="add_account.jsp">Add account</a></li>
        <li><a href="action?action=listAccount">List Account</a></li>
        <%}%>
        <li><a href="index.jsp">Log out</a></li>
    </ul>
</div>
<!-- Nội dung chính -->
<div class="container-dashboard">
    <h1>List Role Of Your Account</h1>
    <table>
        <thead>
        <tr>
            <th>Role ID</th>
            <th> Name</th>
            <th>Description</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Role r : listRole) {
        %>
        <tr>
            <td><%=r.getRoleId()%>
            </td>
            <td><%=r.getRoleName()%>
            </td>
            <td><%=r.getDescription()%>
            </td>
            <td><%=r.getStatus()%>
            </td>
        </tr>
        <%}%>

        </tbody>
    </table>
</div>
</body>
</html>
