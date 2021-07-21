<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 5/27/2021
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            width: 550px;
            height: 550px;
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h1>Danh sách khách hàng</h1>
    <table>
        <tr>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birthday} </td>
                <td>${customer.address}</td>
                <td><img height="100px " src="${customer.image} " alt=""></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
