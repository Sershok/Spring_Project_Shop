<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

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
        <th>ID</th>
        <th>Name Product</th>
        <th>Price</th>

        </thead>
        <c:forEach items="${allProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>

                <td>
                    <form action="${pageContext.request.contextPath}/salesman/Aproduct" method="post">
                        <input type="hidden" name="productId" value="${product.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
</div>
</body>
</html>