<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><titles:insertAttribute name="title" /></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <script src="https://kit.fontawesome.com/176ee4c68c.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<h1 class="text-center text-info">TRANG THONG KE - BAO CAO</h1>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-xs-12">
            <!-- LEFT -->
            <titles:insertAttribute name="left" />
        </div>
        <div class="col-md-8 col-xs-12">
            <!-- CONTENT -->
            <titles:insertAttribute name="content" />
        </div>
    </div>
    <!-- FOOTER -->
    <titles:insertAttribute name="footer" />
</div>
</body>
    <script src="<c:url value="/js/stats.js" />"></script>
</html>
