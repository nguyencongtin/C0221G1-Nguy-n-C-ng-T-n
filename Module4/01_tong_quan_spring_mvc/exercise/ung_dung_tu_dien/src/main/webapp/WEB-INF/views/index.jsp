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
    <title>$Title$</title>
  </head>
  <body>
  <fieldset>
    <form action="/translate" method="post">
      <legend>Translation</legend>
      <p>Input word :</p>
      <input type="text" name="word">
      <input type="submit" name="translate">
    </form>
  </fieldset>
  <h1><c:if test="${word!=null}">
    The word is : ${word}
  </c:if></h1>
  </body>
</html>
