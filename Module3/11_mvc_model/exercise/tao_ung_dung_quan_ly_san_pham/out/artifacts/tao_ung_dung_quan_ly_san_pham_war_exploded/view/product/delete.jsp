
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/">Back to list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td ><input type="text" name="id" id="Id" hidden></td>
            </tr>
            <tr>
                <td>Tên: </td>
                <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td><input type="text" name="price" id="price" value="${product.getPrice()}"></td>
            </tr>
            <tr>
                <td>Mô tả: </td>
                <td><input type="text" name="description" id="describe"value="${product.getDescription()}"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td><input type="text" name="manufacture" id="producer"value="${product.getProducer()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
