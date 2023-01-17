<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <style type="text/css">
        body {
            background: rgba(32, 54, 45, 0.6);
            font-family: Verdana;
            width: 1240px;
            margin: 0 auto;

        }

        button {
            border-radius: 15px;
            background: burlywood;
            font-size: 20px;
            border: 5px solid rgba(0, 0, 0, 0.5);
        }

        button:hover {
            padding: 5px;
            font-size: 25px;
            border-radius: 0px;
            background-color: crimson;
            transition-duration: 0.5s;
        }

        table {
            align-content: center;
            background-color: rgba(123, 43, 153, 0.5);
            border: 3px solid;
            margin: 20px;
            padding: 10px;
            border-radius: 4px;
        }

        td {
            border: 2px solid;
            font-size: 25px;
        }

        h1 {
            padding-bottom: 5px;
            border-bottom: dotted;
            font-size: 2em;
        }

        p {
            padding-top: 10px;
            margin-top: 10px;
            font-size: 20px;
        }

        p:hover {
            font-size: 25px;
            transition-duration: 0.5s;
            display: inline-block;
            border: 3px dotted;
        }

    </style>
</head>
<body>
<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasAnyAuthority('ROLE_ADMIN','ROLE_SALESMAN')"><h4><a href="/salesman/Shopcreate">Create
            Shop</a></h4></sec:authorize>
        <sec:authorize access="hasAnyAuthority('ROLE_ADMIN','ROLE_SALESMAN')"><h4><a href="/salesman/add_product">Add
            Product to Shop</a></h4></sec:authorize>

        <h4><a href="/shop/get">Shop</a></h4>

    </sec:authorize>

</div>
</body>
</html>