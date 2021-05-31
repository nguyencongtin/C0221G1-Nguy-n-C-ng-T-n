<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../css/bootstrap.min.js"></script>
    <script src="../../css/jquery-3.6.0.min.js"></script>

</head>
<body>
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                       height="60" width="60"/></div>
</div>
<h1 class="d-flex justify-content-center">Customer List</h1>
<p>
    <a href="/">Back to home</a>
</p>
<div class="col-4 d-flex">
    <form class="form-inline my-2 my-lg-0 d-flex">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>IdCard</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Type Customer</th>
        <th>Address</th>
        <th>Show</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customer}" var ="customer">
        <tr>
            <td><a href="customer?action=view&id=${customer.getId()}">${customer.getId()}</a></td>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>
            <td>${customer.gender}</td>
            <td>${customer.idCard}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>
            <td>${customer.typeId}</td>
            <td>${customer.address}</td>
            <td><a href="customer?action=view&id=${customer.getId()}">${customer.getId()}Show</a></td>
            <td><a href="customer?action=edit&id=${customer.id}">Edit</a></td>
            <td><a href="customer?action=delete&id=${customer.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</div>


</body>
</html>