
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Product List</h1>
    <p><a href="product?action=create">Create</a></p>
    <form action="product?action=search" method="post">
        <input type="text" name="name" placeholder="Search product" >
        <input type="submit" value="Search">
    </form>
    <table class="table table-striped">
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Producer</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${product}" var ="product">
            <tr>
                <td><a href="product?action=view&id=${product.getId()}">${product.getId()}</a></td>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.producer}</td>
                <td><a href="product?action=edit&id=${product.id}">Edit</a></td>
                <td><a href="product?action=delete&id=${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
