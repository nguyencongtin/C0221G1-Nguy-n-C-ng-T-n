<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 6/15/2021
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculator" method="post">
    <input type="number" name="num1" placeholder="Input number" value="${num1}">
    <input type="number" name="num2" placeholder="Input number" value="${num2}">
    <button type="submit" value="+" name="calculator">Addition(+)</button>
    <button type="submit" value="-" name="calculator">Subtraction(-)</button>
    <button type="submit" value="*" name="calculator">Multiplication(*)</button>
    <button type="submit" value="/" name="calculator">Division(/)</button>
  </form>
  <c:if test="${result!=null}">
    Result: ${result}
  </c:if>
  </body>
</html>
