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
    <h1>Create Contract</h1>
    <a href="/">Back to home</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form action="/contract?action=add" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">Employee Id</label>
                <input type="text" value="${contract.employeeId}" name="employeeId" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Id</label>
                <input type="text" value="${contract.customerId}" name="customerId" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Service Id</label>
                <input type="text" class="form-control" name="serviceId" value="${contract.serviceId}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput4">Contract Start Date</label>
                <input type="text" class="form-control" name="contractStartDate" value="${contract.contractStartDate}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Contract End Date</label>
                <input type="text" class="form-control" name="contractEndDate" value="${contract.contractEndDate}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput6">Contract Deposit</label>
                <input type="text" class="form-control" name="contractDeposit" value="${contract.contractDeposit}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput7">Contract Total Money</label>
                <input type="text" class="form-control" name="contractTotalMoney" value="${contract.contractTotalMoney}"
                       id="formGroupExampleInput7"
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
