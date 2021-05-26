<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 5/26/2021
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="display-discount" method="post">
    <p>Product Description</p>
    <input type="text" name="Product Description" placeholder="Mô tả của sản phẩm">
    <p>List Price</p>
    <input type="text" name="List Price" placeholder="Giá niêm yết của sản phẩm">
    <p>Discount Percent</p>
    <input type="text" name="Discount Percent" placeholder="Tỷ lệ chiết khấu(%)">
    <button type="submit">Calculate Discount</button>
  </form>
  </body>
</html>
