
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Simple Calculator</h3>
  <form action="/calculator" method="get">
    <p>First operand: <input type="number" name="First operand"></p>
    <p>Operator: <select name="Operator">
      <option value="+" name="+">addition</option>
      <option value="-">subtraction</option>
      <option value="*">multiplication</option>
      <option value="/">division</option>
    </select></p>
    <p>Second operand: <input type="number" name="Second operand"></p>
    <button type="submit">Calculate</button>
  </form>
  </body>
</html>
