<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>


    <link href="<%= request.getContextPath() %>/main.css" rel="stylesheet">
    <title>JSP - Hello World</title>
</head>
<body>
<div class="container">
<div class="title">
    <h2>Car query</h2>
</div>
<div class="d-flex">
    <form action="service-request" method="post">
        <label>

            <select name="type">
                <option value="">Select car type</option>
                <c:forEach items="${types}" var="type">
                    <option value="${type}" >${type}</option>
                </c:forEach>

            </select>
        </label>
        <label>

            <select name="model">
                <option value="">Select car model</option>
                <c:forEach items="${models}" var="model">
                    <option value="${model}" >${model}</option>
                </c:forEach>

            </select>

        </label>
        <label>

            <select name="manufacturer">
                <option value="">Select manufacturer</option>
                <c:forEach items="${manufacturers}" var="manufacturers">
                    <option value="${manufacturers}" >${manufacturers}</option>
                </c:forEach>
            </select>
        </label>
        <label for="quantity"><span>Minimum horsepower</span>
        <input type="number" id="quantity" name="horsepower" min="50" max="900">
        </label>
        <label>
        <input type="checkbox" name="electric" value=true><span>Electric</span>
            <button type="submit">Place query</button>
        </label>
    </form>

</div>
</div>
</body>
</html>



