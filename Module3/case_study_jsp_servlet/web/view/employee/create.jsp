<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Create Employee</h1>
    <a href="/">Back to home</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form action="/employee?action=add" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">Employee Name</label>
                <input type="text" value="${employee.employeeName}" name="employeeName" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Birthday</label>
                <input type="date" value="${employee.employeeBirthday}" name="employeeBirthday" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Employee IdCard</label>
                <input type="text" class="form-control" name="employeeIdCard" value="${employee.employeeIdCard}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput4">Employee Salary</label>
                <input type="text" class="form-control" name="employeeSalary" value="${employee.employeeSalary}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Employee Phone</label>
                <input type="text" class="form-control" name="employeePhone" value="${employee.employeePhone}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput6">Employee Email</label>
                <input type="text" class="form-control" name="employeeEmail" value="${employee.employeeEmail}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput7">Employee Address</label>
                <input type="text" class="form-control" name="employeeAddress" value="${employee.employeeAddress}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label>Position</label>
                <select class="form-control" name="positionId">
                    <c:forEach var="position" items="${position}">
                        <option value="${position.idPosition}">${position.positionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
            <label>Education Degree</label>
            <select class="form-control" name="educationDegreeId">
                <c:forEach var="educationDegree" items="${educationDegree}">
                    <option value="${educationDegree.idEducationDegree}">${educationDegree.educationDegreeName}</option>
                </c:forEach>
            </select>
        </div>
            <div class="form-group">
                <label>Division</label>
                <select class="form-control" name="divisionId">
                    <c:forEach var="division" items="${division}">
                        <option value="${division.idDivision}">${division.divisionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput11">User Name</label>
                <input type="text" class="form-control" name="userName" value="${employee.userName}"
                       id="formGroupExampleInput11"
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
