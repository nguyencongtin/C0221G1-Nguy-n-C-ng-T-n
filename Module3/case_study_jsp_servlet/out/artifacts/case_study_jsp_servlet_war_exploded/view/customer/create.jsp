<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../css/bootstrap.min.js"></script>
    <script src="../../css/jquery-3.6.0.min.js"></script>
    <style>
        body{
            background-image: url("https://mondaycareer.com/wp-content/uploads/2020/11/background-%C4%91%E1%BA%B9p-3-1024x682.jpg");
        }
        div {
            color: white;
            margin-bottom: 10px;
        }
        input{
            border-radius: 4px;
        }
    </style>
</head>
</body>
<body>
<div class="container-fluid justify-content-center te" >
    <h1>Create Customer</h1>
    <a href="/">Back to home</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form action="/customer?action=add" method="post">
            <div class="form-group">
                <label> Customer Type : </label>
                <select class="form-control" name="id">
                    <c:forEach var="typeCustomer" items="${typeCustomer}">
                        <option value="${typeCustomer.idTypeCustomer}">${typeCustomer.typeCustomerName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" class="form-control"
                       placeholder="Input your name">
            </div>
            <div class="form-group">
                <label>Birthday</label>
                <input type="text" class="form-control" name="birthday"
                       placeholder="Input your birthday">
            </div>
            <div class="form-group">
                <label>Sex</label>
                <select class="form-control "  name="sex" aria-label="Default select example">
                    <option selected>Choose gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            <div class="form-group">
                <label>IdCard</label>
                <input type="text" class="form-control" name="idCard"
                       placeholder="Input your Id card">
            </div>
            <div class="form-group">
                <label>Phone</label>
                <input type="text" class="form-control" name="phone"
                       placeholder="Input your phone">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="text" class="form-control" name="email"
                       placeholder="Input your email">
            </div>
            <div class="form-group">
                <label>Address</label>
                <input type="text" class="form-control" name="address"
                       placeholder="Input your address">
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="create">
            </div>
        </form>
    </div>
</div>
</body>
</html>
