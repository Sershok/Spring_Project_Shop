<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        body {
            font-family: Verdana;
            width: 1240px;
            margin: 0 auto;

        }


    </style>
    <meta charset="ISO-8859-1">
    <title>Add Success</title>

</head>
<body>
<div align="center">
    <button><a href="/">Main</a></button>
    <br>
    <h2>Add Succeeded!</h2>
    <table style="border-radius: 10px;  " border="3" align="center">
        <tr>
            <td>Shop Name</td>
            <td>Product</td>
        </tr>
        <c:forEach items="${shop}" var="shop">
            <tr>
                <td>${shop.name}</td>
                <td>${shop.product}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
