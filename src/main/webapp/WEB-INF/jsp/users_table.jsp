<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <table border="1">
        <tr>
            <th>Email</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Country</th>
        </tr>
        <tr>
            <c:forEach var="user" items="${users}">
                    <td>${user.getEmail()}</td>
                    <td>${user.getBirthday()}</td>
                    <td>${user.getGender()}</td>
                    <td>${user.getCountry()}</td>
            </c:forEach>
        </tr>
    </table>
</body>
</html>
