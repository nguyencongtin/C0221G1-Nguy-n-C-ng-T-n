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
    <h1>Create Contract Detail</h1>
    <a href="/">Back to home</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form action="/contractDetail?action=add" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">contractId</label>
                <input type="text" value="${contractDetail.contractId}" name="contractId" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">attachServiceId</label>
                <input type="text" value="${contractDetail.attachServiceId}" name="attachServiceId" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">quantity</label>
                <input type="text" class="form-control" name="quantity" value="${contractDetail.quantity}"
                       id="formGroupExampleInput3"
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
