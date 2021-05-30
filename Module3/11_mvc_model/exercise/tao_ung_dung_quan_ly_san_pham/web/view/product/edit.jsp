
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
</head>x`
<body>
<div class="container">
    <h1>Edit Product</h1>
    <a href="/">Back to list</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post">
<%--            <div class="form-group">--%>
<%--                <label for="formGroupExampleInput">Id</label>--%>
<%--                <input hidden type="text" value="${product.id}" name="id" class="form-control"--%>
<%--                       id="formGroupExampleInput"--%>
<%--                       placeholder="Example input placeholder">--%>
<%--            </div>--%>
            <div class="form-group">
                <label for="formGroupExampleInput2">Name</label>
                <input type="text" value="${product.name}" name="name" class="form-control" id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Price</label>
                <input type="text" class="form-control" name="price" value="${product.price}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput4">Description</label>
                <input type="text" class="form-control" name="description" value="${product.description}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Producer</label>
                <input type="text" class="form-control" name="producer" value="${product.producer}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="update">
            </div>
        </form>
    </div>
</div>
</body>
</html>