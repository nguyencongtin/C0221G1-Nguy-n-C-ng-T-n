
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
        <form method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">Id</label>
                <input type="text" value="${customer.id}" name="id" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Name</label>
                <input type="text" value="${customer.name}" name="name" class="form-control" id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Birthday</label>
                <input type="text" class="form-control" name="birthday" value="${customer.birthday}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput4">Gender</label>
                <input type="text" class="form-control" name="gender" value="${customer.gender}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">IdCard</label>
                <input type="text" class="form-control" name="idCard" value="${customer.idCard}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Phone</label>
                <input type="text" class="form-control" name="phone" value="${customer.phone}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Email</label>
                <input type="text" class="form-control" name="email" value="${customer.email}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">TypeId</label>
                <input type="text" class="form-control" name="typeId" value="${customer.typeId}"
                       id="formGroupExampleInput8"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Address</label>
                <input type="text" class="form-control" name="address" value="${customer.address}"
                       id="formGroupExampleInput9"
                       placeholder="Another input placeholder">
            </div>

            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="create">
            </div>
        </form>
    </div>
</div>
</body>
</html>
