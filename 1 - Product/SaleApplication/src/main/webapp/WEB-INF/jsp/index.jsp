<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">DANH MUC SAN PHAM</h1>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(productCounter/9)}" var="page">
        <li class="page-item"><a class="page-link" href="<c:url value="/"/>?page=${page}">${page}</a></li>
        </c:forEach>
</ul>

<div class="row">
    <c:forEach var="p" items="${products}">
        <div class="col-md-3 col-xs-12" style="padding: 10px">

            <div class="card">
                <a href="<c:url value="/products/${p.id}"/>">
                    <c:choose>
                        <c:when test="${p.image != null && p.image.startsWith('https') == true}">
                            <img class="card-img-top img-fluid" src="${p.image}" alt="${p.name}" />
                        </c:when>
                        <c:when test="${p.image != null || p.image.startsWith('https') != true}">
                            <img class="card-img-top img-fluid" src="<c:url value="/images/default.jpg"/>" alt="${p.name}" />
                        </c:when>
                    </c:choose>
                </a>
                <div class="card-body">
                    <h4 class="card-title">${p.name}</h4>
                    <p class="card-text">${p.price} VND</p>
                    <a href="#" class="btn btn-primary">Dat hang</a>
                </div>
            </div>

        </div>
    </c:forEach>
</div>
<hr>
<div class="alert alert-success">
    <h1>CAC SAN PHAM BAN CHAY</h1>
</div>
<div class="row">
    <c:forEach var="p" items="${hotProducts}">
        <div class="col-md-3 col-xs-12" style="padding: 10px">

            <div class="card">
                <a href="<c:url value="/products/${p[0]}"/>">
                    <c:choose>
                        <c:when test="${p[3] != null && p[3].startsWith('https') == true}">
                            <img class="card-img-top" src="${p[3]}" alt="${p[1]}">
                        </c:when>
                        <c:when test="${p[3] != null || p[3].startsWith('https') != true}">
                            <img class="card-img-top img-fluid" src="<c:url value="/images/default.jpg"/>" alt="${p[1]}" />
                        </c:when>
                    </c:choose>
                </a>
                <div class="card-body">
                    <h4 class="card-title">${p[1]}</h4>
                    <p class="card-text">${p[2]} VND</p>
                    <p class="text-danger"><strong>Tong san pham ban: ${p[4]}</strong></p>
                    <a href="#" class="btn btn-primary">Xem chi tiet</a>
                    <a href="#" class="btn btn-danger">Them vao gio</a>
                </div>
            </div>

        </div>
    </c:forEach>
</div>
<hr>
<div class="alert alert-success">
    <h1>CAC SAN PHAM DUOC THAO LUAN NHIEU NHAT</h1>
</div>
<div class="row">
    <c:forEach var="p" items="${disProducts}">
        <div class="col-md-3 col-xs-12" style="padding: 10px">

            <div class="card">
                <a href="<c:url value="/products/${p[0]}"/>">
                    <c:choose>
                        <c:when test="${p[3] != null && p[3].startsWith('https') == true}">
                            <img class="card-img-top" src="${p[3]}" alt="${p[1]}">
                        </c:when>
                        <c:when test="${p[3] != null || p[3].startsWith('https') != true}">
                            <img class="card-img-top img-fluid" src="<c:url value="/images/default.jpg"/>" alt="${p[1]}" />
                        </c:when>
                    </c:choose>
                </a>
                <div class="card-body">
                    <h4 class="card-title">${p[1]}</h4>
                    <p class="card-text">${p[2]} VND</p>
                    <p class="text-danger"><strong>So luong thao luan: ${p[4]}</strong></p>
                    <div class="row">
                        <a href="#" class="btn btn-primary col-md-6 ">Xem chi tiet</a>
                        <a href="#" class="btn btn-danger col-md-6 ">Them vao gio</a>
                    </div>

                </div>
            </div>

        </div>
    </c:forEach>
</div>
