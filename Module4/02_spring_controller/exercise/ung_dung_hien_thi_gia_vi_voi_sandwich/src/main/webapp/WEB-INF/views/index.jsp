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
    <title>Condiment</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <hr>
    <button type="submit"> Save</button>
  </form>

  <c:if test="${condiment!=null}">
    <h3>Your condiment is : <c:forEach items="${condiment}" var="condiment">
      ${condiment},
    </c:forEach>  </h3>
  </c:if>
  </body>
</html>
