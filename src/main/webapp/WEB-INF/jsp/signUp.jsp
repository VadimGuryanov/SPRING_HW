<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<a href="<c:url value="/" />">Homepage</a><br><br>
<c:if test="${not empty message}">
    <h1>${message}</h1>
</c:if>
<form:form method="POST" modelAttribute="userDto">

    <form:errors path=""/>

    <form:label path="email">Email</form:label>
    <form:input path="email"/>
    <form:errors path="email" /><br>

    <form:label path="password">Password</form:label>
    <form:input path="password" type="password"/>
    <form:errors path="password" /><br>

    <form:label path="passwordRepeat">Password repeat</form:label>
    <form:input path="passwordRepeat" type="password"/>
    <form:errors path="passwordRepeat" /><br>

    <form:label path="gender">Sex</form:label>
    <form:radiobutton path="gender" value="M"/>Male
    <form:radiobutton path="gender" value="F"/>Female
    <form:errors path="gender" /><br>

    <form:label path="country">Country</form:label>
    <form:select path="country">
        <form:option value="-">-</form:option>
        <form:option value="Russia">Russia</form:option>
        <form:option value="USA">USA</form:option>
    </form:select>
    <form:errors path="country" /><br>

    <form:label path="birthday">Birthday</form:label>
    <form:input path="birthday"  type="time"/>
    <form:errors path="birthday" /><br>

    <form:label path="agreement">
        Do you agree to the processing of your data?</form:label>
    <form:checkbox path="agreement"/>
    <form:errors path="agreement" /><br>

    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
