<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/dataTables.bootstrap.min.css">

</head>
<body>
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                       height="60" width="60"/></div>
</div>
<h1 class="d-flex justify-content-center">Product List</h1>
<c:if test="${message!=null}">
    <p>${message} </p>
</c:if>
<p>
    <a href="/">Back to home</a>
</p>
<div class="col d-flex">
    <form class="form-inline my-2 my-lg-0 d-flex" action="/product?action=search" method="post">
        <input class="form-control mr-sm-2" type="search" name="nameSearch" placeholder="Search" aria-label="Search">
        <button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
    </form>

</div>
<table id="tableProduct" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Cost</th>
        <th>Amount</th>
        <th>Color</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${product}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.productCost}</td>
            <td>${product.productAmount}</td>
            <td>${product.productColor}</td>
            <td>${product.productDescription}</td>
            <c:forEach var="category" items="${categoryList}">
                <c:if test="${category.categoryId == product.productCategory}">
                    <td>${category.categoryName}</td>
                </c:if>
            </c:forEach>
            <td>
                <button type="button" class="btn btn-success"><a style="color: white"
                                                                 href="/product?action=edit&id=${product.productId}">Edit</a>
                </button>
            </td>
            <td>
                <button onclick="myfunction(${product.productId})" type="button" id="delete" value="delete"
                        class="btn btn-danger" data-toggle="modal"
                        data-target="#myModal">Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div id="myModal" class="modal fade">
    <div class="modal-dialog modal-confirm">
        <form action="/product?action=delete" method="post">
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
                    <input type="hidden" id="button-delete" name="productId">
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
        $('#tableProduct').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });

    function myfunction(id) {
        document.getElementById("button-delete").value = id;
    }
</script>


</body>
</html>