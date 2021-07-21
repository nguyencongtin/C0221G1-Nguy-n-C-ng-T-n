<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/dataTables.bootstrap.min.css">

</head>
<body>
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                       height="60" width="60"/></div>
</div>
<h1 class="d-flex justify-content-center">Employee List</h1>
<c:if test="${message!=null}">
    <p>${message} </p>
</c:if>
<p>
    <a href="/">Back to home</a>
</p>
<div class="col-4 d-flex">
    <form class="form-inline my-2 my-lg-0 d-flex" action="/employee?action=search" method="post">
        <input class="form-control mr-sm-2" type="search" name="nameSearch" placeholder="Search" aria-label="Search">
        <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>
<table id="tableEmployee" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>User Name Employee</th>
        <th>Birthday</th>
        <th>Email</th>
        <th>Show</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employee}" var="employee">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.userName}</td>
            <td>${employee.employeeBirthday}</td>
            <td>${employee.employeeEmail}</td>
            <td>
                <button type="button" class="btn btn-primary"><a style="color: white"
                                                                 href="/employee?action=view&id=${employee.employeeId}">Show</a>
                </button>
            </td>
            <td>

                <button type="button" class="btn btn-success"><a style="color: white"
                                                                 href="/employee?action=edit&id=${employee.employeeId}">Edit</a>
                </button>
            </td>
            <td>
                <button onclick="myfunction(${employee.employeeId})" type="button" id="delete" value="delete" class="btn btn-danger" data-toggle="modal"
                        data-target="#myModal">Delete
                </button>
                <div id="myModal" class="modal fade">
                    <div class="modal-dialog modal-confirm">
                        <form action="/employee?action=delete" method="post">
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
                                    <input type="hidden" id="button-delete" name="employeeId">
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
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });
    function myfunction(id) {
        document.getElementById("button-delete").value=id;
    }
</script>


</body>
</html>