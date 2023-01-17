<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>person</title>
    <style>
        body {
            background: rgba(32, 54, 45, 0.6);
            font-family: Verdana;
            width: 1240px;
            margin: 0 auto;

        }

        label {
            display: inline-block;
            width: 230px;
            vertical-align: top;
            text-align: left;
            margin: 5px;
            padding: 3px;
        }

        input {
            margin: 7px;
            padding: 3px;
        }

        button {
            margin: 7px;
            font-size: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body>

<div align="center">
    <h2>Add Cart</h2>
    <form:form action="/shop/add_product" method="post" modelAttribute="shop">

        <form:label path="name">Shop name:</form:label>
        <form:input placeholder="Sport Market" path="name"/><br/>

        <form:label path="productName">Product name</form:label>
        <form:input placeholder="apple" path="productName"/><br>

        <form:button
                style="font-size: 18px;border-radius: 10px; margin-top: 20px;background-color: coral">Cart add</form:button>

        <input style="font-size: 18px;border-radius: 10px; margin-top: 20px;background-color: gold" type="reset"
               value="Reset"/>
    </form:form>
</div>
</form>
</body>
</html>
