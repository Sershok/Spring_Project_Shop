<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>product</title>
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
    <h2>Product Registration</h2>

    <form:form action="/salesman/create" method="post" modelAttribute="product">
        <form:label path="name">Name:</form:label>
        <form:input placeholder="apple" path="name"/><br/>

        <form:label path="price">Price:</form:label>
        <form:input maxlength="15" placeholder="15.23" path="price"/><br/>

        <form:button
                style="font-size: 18px;border-radius: 10px; margin-top: 20px;background-color: coral">Add Product</form:button>
        <input style="font-size: 18px;border-radius: 10px; margin-top: 20px;background-color: gold" type="reset"
               value="Reset"/>
    </form:form>
</div>
</form>
</body>
</html>

