<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../css/bootstrap.min.js"></script>
    <script src="../../css/jquery-3.6.0.min.js"></script>
    <style>
        body {
            background-image: url("https://mondaycareer.com/wp-content/uploads/2020/11/background-%C4%91%E1%BA%B9p-3-1024x682.jpg");
        }

        div {
            color: white;
            margin-bottom: 10px;
        }

        input {
            border-radius: 4px;
        }
    </style>
</head>
</body>
<body>
<div class="container-fluid justify-content-center te">
    <h1>Create Service</h1>
    <a href="/">Back to home</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form action="/service?action=add" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">serviceName</label>
                <input type="text" value="${service.serviceName}" name="serviceName" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">serviceArea</label>
                <input type="text" value="${service.serviceArea}" name="serviceArea" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">numberOfFloor</label>
                <input type="text" class="form-control" name="numberOfFloor" value="${service.numberOfFloor}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput4">serviceMaxPeople</label>
                <input type="text" class="form-control" name="serviceMaxPeople" value="${service.serviceMaxPeople}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">serviceCost</label>
                <input type="text" class="form-control" name="serviceCost" value="${service.serviceCost}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput6">rentTypeId</label>
                <input type="text" class="form-control" name="rentTypeId" value="${service.rentTypeId}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput7">serviceTypeId</label>
                <input type="text" class="form-control" name="serviceTypeId" value="${service.serviceTypeId}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput8">standardRoom</label>
                <input type="text" class="form-control" name="standardRoom" value="${service.standardRoom}"
                       id="formGroupExampleInput8"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput9">descriptionOtherConverience</label>
                <input type="text" class="form-control" name="descriptionOtherConverience" value="${service.descriptionOtherConverience}"
                       id="formGroupExampleInput9"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput10">poolArea</label>
                <input type="text" class="form-control" name="poolArea" value="${service.poolArea}"
                       id="formGroupExampleInput10"
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
