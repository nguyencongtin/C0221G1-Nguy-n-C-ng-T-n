<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<form action="/convert" method="post">
    <fieldset>
        <legend> Convert Money</legend>
    <p>Input your money</p>
    <input type="number" name="number">
    <select name="typeViet">
        <option value="23000">VND</option>
        <option value="1">USD</option>
    </select>
    <select name="typeMy">
        <option value="1">USD</option>
        <option value="23000">VND</option>
    </select>
    <input type="submit" name="convert">
    </fieldset>
</form>
<c:if test="${money!=null}">
    <h1>Convert : ${money}</h1>
</c:if>
</body>
</html>
