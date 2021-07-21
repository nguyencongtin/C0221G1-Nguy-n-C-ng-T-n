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
    <a href="/customerUsing">Back to List Customer Using Service</a>
</p>
<table id="tableCustomer" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>Id Contract</th>
        <th>Id Attach Service</th>
        <th>Attach Service Name</th>
        <th>Attach Service Status</th>
        <th>Contract Start Date</th>
        <th>Contract End Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${attachService}" var="attachService">
        <tr>
            <td>${attachService.contractId}</td>
            <td>${attachService.attachServiceId}</td>
            <td>${attachService.attachServiceName}</td>
            <td>${attachService.attachServiceStatus}</td>
            <td>${attachService.contractStartDate}</td>
            <td>${attachService.contractEndDate}</td>
            <td>
                <button type="button" class="btn btn-success"><a style="color: white"
                                                                 href="/customerUsing?action=edit&id=${attachService.contractId}">Edit</a>
                </button>
            </td>
            <td>
                <button onclick="myfunction(${attachService.contractId})" type="button" id="delete" value="delete" class="btn btn-danger" data-toggle="modal"
                        data-target="#myModal">Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div id="myModal" class="modal fade">
    <div class="modal-dialog modal-confirm">
        <form action="/customerUsing?action=deleteAttachService" method="post">
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
                    <input type="hidden" id="contractId" name="contractId">
                </div>
            </div>
        </form>
    </div>
</div>

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
        document.getElementById("contractId").value=id;
    }
</script>


</body>
</html>