<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../css/bootstrap.min.js"></script>
    <script src="../../css/jquery-3.6.0.min.js"></script>

</head>
</body>
<body>
<div class="container-fluid justify-content-center te" >
    <h1>Create Product</h1>
    <a href="/">Back to home</a>
    <a href="/product">Back to list</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form action="/product?action=add" method="post">
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" class="form-control"
                       placeholder="Input name">
            </div>
            <div class="form-group">
                <label>Cost</label>
                <input type="text" class="form-control" name="cost"
                       placeholder="Input cost">
            </div>
            <div class="form-group">
                <label>Amount</label>
                <input type="text" class="form-control" name="amount"
                       placeholder="Input amount">
            </div>
            <div class="form-group">
                <label>Color</label>
                <input type="text" class="form-control" name="color"
                       placeholder="Input color">
            </div>
            <div class="form-group">
                <label>Description</label>
                <input type="text" class="form-control" name="description"
                       placeholder="Input description">
            </div>
            <div class="form-group">
                <label>Category</label>
                <select class="form-control" name="category">
                    <c:forEach var="categoryList" items="${categoryList}">
                        <option value="${categoryList.categoryId}">${categoryList.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="create">
            </div>
        </form>
    </div>
</div>
</body>
</html>
