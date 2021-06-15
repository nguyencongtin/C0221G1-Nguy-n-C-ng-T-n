<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Product</title>
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
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                       height="60" width="60"/></div>
</div>
<div class="container">
    <h1>Edit Product</h1>
    <a href="/">Back to home</a> </br>
    <a href="/product">Back to list</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post" action="/product?action=update&id=${product.productId}">
            <div class="form-group">
                <label for="formGroupExampleInput2">Name</label>
                <input type="text" value="${product.name}" name="name" class="form-control" id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Cost</label>
                <input type="text" class="form-control" name="cost" value="${product.dayOfBirth}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Amount</label>
                <input type="text" class="form-control" name="amount" value="${product.dayOfBirth}"
                       id="formGroupExampleInput10"
                       placeholder="Another input placeholder">
            </div>

            <div class="form-group">
                <label for="formGroupExampleInput5">Color</label>
                <input type="text" class="form-control" name="color" value="${product.idCard}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput6">Description</label>
                <input type="text" class="form-control" name="description" value="${product.phoneNumber}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label>Category</label>
                <select class="form-control" name="categoryId">
                    <c:forEach var="categoryList" items="${categoryList}">
                        <option value="${categoryList.categoryId}" ${categoryList.categoryId==product.productId?"selected":""}>${categoryList.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="update">
            </div>
        </form>
    </div>
</div>
</body>
</html>
