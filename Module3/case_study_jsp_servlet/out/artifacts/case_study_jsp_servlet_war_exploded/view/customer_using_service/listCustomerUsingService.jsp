<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/dataTables.bootstrap.min.css">

</head>
<body>
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                       height="60" width="60"/></div>
</div>
<h1 class="d-flex justify-content-center">Customer Using Service List</h1>
<c:if test="${message!=null}">
    <p>${message} </p>
</c:if>
<p>
    <a href="/">Back to home</a>
</p>
<div class="col-4 d-flex">
    <form class="form-inline my-2 my-lg-0 d-flex" action="/customer?action=search" method="post">
        <input class="form-control mr-sm-2" type="search" name="nameSearch" placeholder="Search" aria-label="Search">
        <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>
<table id="tableCustomer" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Phone</th>
        <th>Show</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customerList">
        <tr>
            <td>${customerList.idCustomer}</td>
            <td>${customerList.name}</td>
            <td>${customerList.dayOfBirth}</td>
            <td>${customerList.phoneNumber}</td>
            <td>
                <button type="button" class="btn btn-primary"><a style="color: white"
                                                                 href="/customerUsing?action=showAttachService&id=${customerList.idCustomer}">Show Attach Service</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<script src="../../css/jquery-3.6.0.min.js"></script>
<script src="../../css/jquery.dataTables.min.js"></script>
<script src="../../css/dataTables.bootstrap4.min.js"></script>
<script src="../../css/popper.min.js"></script>
<script src="../../css/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });
</script>


</body>
</html>