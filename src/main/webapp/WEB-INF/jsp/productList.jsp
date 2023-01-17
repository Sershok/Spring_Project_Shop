<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Success</title>
    <style>
        body {
            font-family: Verdana;
            width: 1240px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div align="center">
    <button><a href="/">Main</a></button>
    <br>
    <h2>Add Succeeded!</h2>
    <table border="3" align="center">
        <tr>
            <td>Price</td>
            <td>Product</td>
            <td></td>
        </tr>
        <c:forEach items="${product}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
