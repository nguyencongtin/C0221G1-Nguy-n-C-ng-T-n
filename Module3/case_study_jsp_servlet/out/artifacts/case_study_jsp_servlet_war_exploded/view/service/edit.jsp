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
    <h1>Edit Service</h1>
    <a href="/">Back to home</a> </br>
    <a href="/service">Back to list</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post" action="/service?action=update&id=${service.idService}">
            <div class="form-group">
                <label for="formGroupExampleInput">Service Name</label>
                <input type="text" value="${service.serviceName}" name="serviceName" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Service Area</label>
                <input type="text" value="${service.serviceArea}" name="serviceArea" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Number Of Floor</label>
                <input type="text" class="form-control" name="numberOfFloor" value="${service.numberOfFloor}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput4">Service Max People</label>
                <input type="text" class="form-control" name="serviceMaxPeople" value="${service.serviceMaxPeople}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Service Cost</label>
                <input type="text" class="form-control" name="serviceCost" value="${service.serviceCost}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label>Type Rent</label>
                <select class="form-control" name="rentTypeId">
                    <c:forEach var="typeRentList" items="${typeRentList}">
                        <option value="${typeRentList.idTypeRent}" ${typeRentList.idTypeRent==service.rentTypeId?"selected":""}>${typeRentList.rentName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Type Service</label>
                <select class="form-control" name="serviceTypeId">
                    <c:forEach var="typeServiceList" items="${typeServiceList}">
                        <option value="${typeServiceList.idTypeService}" ${typeServiceList.idTypeService==service.rentTypeId?"selected":""}>${typeServiceList.typeServiceName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput8">Standard Room</label>
                <input type="text" class="form-control" name="standardRoom" value="${service.standardRoom}"
                       id="formGroupExampleInput8"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput9">Description Other Converience</label>
                <input type="text" class="form-control" name="descriptionOtherConverience"
                       value="${service.descriptionOtherConverience}"
                       id="formGroupExampleInput9"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput10">Pool Area</label>
                <input type="text" class="form-control" name="poolArea" value="${service.poolArea}"
                       id="formGroupExampleInput10"
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
