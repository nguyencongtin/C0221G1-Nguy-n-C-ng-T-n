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
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                       height="60" width="60"/></div>
</div>
<div class="container">
    <h1>Edit Employee</h1>
    <a href="/">Back to home</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post" action="/employee?action=update&id=${employee.employeeId}">
            <div class="form-group">
                <label for="formGroupExampleInput1">EmployeeName</label>
                <input type="text" value="${employee.employeeName}" name="employeeName" class="form-control"
                       id="formGroupExampleInput1"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">EmployeeBirthday</label>
                <input type="text" value="${employee.employeeBirthday}" name="employeeBirthday" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">EmployeeIdCard</label>
                <input type="text" class="form-control" name="employeeIdCard" value="${employee.employeeIdCard}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput4">EmployeeSalary</label>
                <input type="text" class="form-control" name="employeeSalary" value="${employee.employeeSalary}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">EmployeePhone</label>
                <input type="text" class="form-control" name="employeePhone" value="${employee.employeePhone}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput6">EmployeeEmail</label>
                <input type="text" class="form-control" name="employeeEmail" value="${employee.employeeEmail}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput7">EmployeeAddress</label>
                <input type="text" class="form-control" name="employeeAddress" value="${employee.employeeAddress}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label>Position</label>
                <select class="form-control" name="idPosition">
                    <c:forEach var="position" items="${position}">
                        <option value="${position.idPosition}" ${position.idPosition==employee.idPosition?"selected":""}>${position.positionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Position</label>
                <select class="form-control" name="idEducationDegree">
                    <c:forEach var="educationDegree" items="${educationDegree}">
                        <option value="${educationDegree.idEducationDegree}" ${educationDegree.idEducationDegree==employee.idEducationDegree?"selected":""}>${educationDegree.educationDegreeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Position</label>
                <select class="form-control" name="idDivision">
                    <c:forEach var="division" items="${division}">
                        <option value="${division.idDivision}" ${division.idDivision==employee.idDivision?"selected":""}>${division.divisionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput11">UserName</label>
                <input type="text" class="form-control" name="userName" value="${employee.userName}"
                       id="formGroupExampleInput11"
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
