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
<h1 class="d-flex justify-content-center">Customer List</h1>
<c:if test="${message!=null}">
    <p>${message} </p>
</c:if>
<p>
    <a href="/">Back to home</a>
</p>
<div class="col-4 d-flex">
    <form class="form-inline my-2 my-lg-0 d-flex">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>
<table id="tableCustomer" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Id Type Customer</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Email</th>
        <th>Show</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customer}" var="customer">
        <tr>
            <td>${customer.idCustomer}</td>
            <td>${customer.idTypeCustomer}</td>
            <td>${customer.name}</td>
            <td>${customer.dateOfBirth}</td>
            <td>${customer.email}</td>
            <td>
                <button type="button" class="btn btn-primary"><a style="color: white"
                                                                 href="/customer?action=view&id=${customer.idCustomer}">Show</a>
                </button>
            </td>
            <td>
                <button type="button" class="btn btn-success"><a style="color: white"
                                                                 href="/customer?action=edit&id=${customer.idCustomer}">Edit</a>
                </button>
            </td>
            <td>
                <button onclick="myfunction(${customer.idCustomer})" type="button" id="delete" value="delete" class="btn btn-danger" data-toggle="modal"
                        data-target="#myModal">Delete
                </button>
                <div id="myModal" class="modal fade">
                    <div class="modal-dialog modal-confirm">
                        <form action="/customer?action=delete" method="post">
                            <div class="modal-content">
                                <div class="modal-header flex-column">
                                    <div class="icon-box">
                                        <i class="material-icons"></i>
                                    </div>
                                    <h4 class="modal-title w-100">Are you sure?</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p>Do you really want to delete these records? This process cannot be undone.</p>
                                </div>
                                <div class="modal-footer justify-content-center">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                    <button type="submit" class="btn btn-danger">
                                          Delete
                                    </button>
                                    <input type="hidden" id="button-delete" name="idCustomer">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
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
    function myfunction(id) {
        document.getElementById("button-delete").value=id;
        alert(id);
    }
</script>


</body>
</html>