<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../css/jquery-3.6.0.min.js"></script>
    <script src="../../css/popper.min.js"></script>
    <script src="../../css/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                       height="60" width="60"/></div>
</div>
<h1 class="d-flex justify-content-center">Delete customer</h1>
<p>
    <a href="/">Back to home</a>
</p>
<div>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Customer information</legend>
            <table>
                <tr>
                    <td>Id:</td>
                    <td><input type="text" name="id" id="Id" hidden></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" value="${customer.getName()}"></td>
                </tr>
                <tr>
                    <td>Birthday:</td>
                    <td><input type="text" name="birthday" id="birthday" value="${customer.getBirthday()}"></td>
                </tr>
                <tr>
                    <td>Gender :</td>
                    <td><input type="text" name="gender" id="gender" value="${customer.getGender()}"></td>
                </tr>
                <tr>
                    <td>IdCard :</td>
                    <td><input type="text" name="idCard" id="idCard" value="${customer.getIdCard()}"></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><input type="text" name="phone" id="phone" value="${customer.getPhone()}"></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><input type="text" name="email" id="email" value="${customer.getEmail()}"></td>
                </tr>
                <tr>
                    <td>Type Customer :</td>
                    <td><input type="text" name="typeId" id="typeId" value="${customer.getTypeId()}"></td>
                </tr>
                <tr>
                    <td>Address :</td>
                    <td><input type="text" name="address" id="address" value="${customer.getAddress()}"></td>
                </tr>
                <div class="text-center">
                    <tr>
                        <td>
                            <button type="button" id="delete" value="delete" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                Delete
                            </button>
                        </td>
                    </tr>
                </div>
            </table>
        </fieldset>
    </form>
</div>
<div id="myModal" class="modal fade">
    <div class="modal-dialog modal-confirm">
        <div class="modal-content">
            <div class="modal-header flex-column">
                <div class="icon-box">
                    <i class="material-icons"></i>
                </div>
                <h4 class="modal-title w-100">Are you sure?</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <p>Do you really want to delete these records? This process cannot be undone.</p>
            </div>
            <div class="modal-footer justify-content-center">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
