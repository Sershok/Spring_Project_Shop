<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <style>
        body {
            font-family: Verdana;
            width: 1240px;
            margin: 0 auto;
        }
    </style>
</head>

<body>
<div>
    <table>
        <thead>
        <th>UserName</th>
        <th>Product</th>
        <th>Sum</th>
        </thead>
        <c:forEach items="${getCart}" var="cart">
            <tr>
                <td>${cart.username}</td>
                <td>${cart.product}</td>
                <td>${cart.sum}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Main</a>
</div>
</body>
</html>