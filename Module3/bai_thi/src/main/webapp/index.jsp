<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Product</title>
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
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
          Product
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/product?action=add" methods="get">Create</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/product">Show List</a>
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