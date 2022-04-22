<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar bg-light">
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/category-stats" />">Thong ke san pham theo danh muc</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/product-stats" />">Thong doanh thu theo tung san pham</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/product-month-stats" />">Thong ke doanh thu theo thang</a>
        </li>
    </ul>
</nav>

