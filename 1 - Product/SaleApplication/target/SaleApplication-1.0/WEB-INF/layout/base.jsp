<%-- 
    Document   : base
    Created on : Apr 2, 2022, 9:07:17 PM
    Author     : ngova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <titles:insertAttribute name="title" />
        </title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    </head>
    <body>
        <div class="container">
            <!-- HEADER -->
            <titles:insertAttribute name="header" />


            <!-- CONTENT -->
            <titles:insertAttribute name="content" />

            <!-- FOOTER -->
            <titles:insertAttribute name="footer" />
        </div>
    </body>
    <script src="<c:url value="/js/main.js"/>"></script>
</html>
