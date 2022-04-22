<%--
    Document   : login
    Created on : Apr 9, 2022, 5:32:36 PM
    Author     : ngova
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:if test="${param.error != null}">
    <div class="alear alear-danger">
        Da co loi xay ra! Vui long quay lai sau!
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alear alear-danger">
        Ban khong co quen truy cap
    </div>
</c:if>

<c:url value="/login" var="action"/>

<h1 class="text-danger">DANG NHAP</h1>
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
            <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control"/>
    </div>

    <div class="form-group">
        <input type="submit" value="DANG NHAP" class="btn btn-danger"/>
    </div>
</form>