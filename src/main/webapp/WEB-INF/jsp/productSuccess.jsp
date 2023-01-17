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
    <br><br>
    <h2>Add Succeeded!</h2>
    <table border="1px">
        <tr>
            <td>Name:</td>
            <td>Price:</td>
        </tr>
        <tr>
            <td>${productDto.name}</td>
            <td>${productDto.price}</td>

        </tr>
    </table>
</div>
</body>
</html>