<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Furama Resort</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<div class="container-fluid align-items-center justify-content-between d-flex  ">
    <div class=""><img src="logo.png" height="70" width="140"/></div>
    <p id="name">Nguyễn Công Tín</p>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-success">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link " href="#"> <b>Home</b> <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Employee
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <a class="dropdown-item" href="/employee?action=add" methods="get">Create</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/employee">Show List</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Customer
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/customer?action=add" methods="get">Create</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/customer">Show List</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Service
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/service?action=add" methods="get">Create</a>
                    <a class="dropdown-item" href="#">Edit</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/service">Show List</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Contract
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/view/contract/create.jsp">Create</a>
                    <a class="dropdown-item" href="#">Edit</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown6" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Contract Detail
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/view/contract_detail/create.jsp">Create</a>
                    <a class="dropdown-item" href="#">Edit</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>

        </ul>

        <form class="form-inline my-2 my-lg-0 d-flex">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container-fluid mb-3" style="height: auto">
    <div class="row d-flex ">
        <div class="col-lg-3 bg-warning " style="border: 1px " >
            <ul>
                <li>Item one</li>
                <li>Item two</li>
                <li>Item three</li>
            </ul>
        </div>
        <div class="col-lg-9 bg-primary d-flex justify-content-center align-items-center">
            <p>Body</p>
        </div>
    </div>
</div>




<div class="container-fluid bg-light d-flex justify-content-center align-items-center" >
    <p>Footer</p>
</div>
<script src="css/jquery-3.6.0.min.js"></script>
<script src="css/bootstrap.min.js"></script>
</body>
</html>