<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">CHI TIET SAN PHAM</h1> 
<div class="row">
    <div class="col-md-6">
        <c:choose>
            <c:when test="${product.image != null && product.image.startsWith('https') == true}">
                <img class="card-img-top img-fluid" src="${product.image}" alt="${product.name}" />
            </c:when>
            <c:when test="${product.image == null || product.image.startsWith('https') != true}">
                <img class="card-img-top img-fluid" src="<c:url value="/images/default.jpg"/>" alt="${product.name}" />
            </c:when>
        </c:choose>
    </div>

    <div class="col-md-6">
        <h1>${product.name}</h1>
        <h3 class="text-danger">${product.price} VND</h3>
        <p>${product.description}</p>
        <div>
            <input type="button" value="Dat hang" class="btn btn-danger" onclick="addToCart(${product.id}, '${product.name}', ${product.price})"/>
        </div>
    </div>
</div>
<br><br>
<form>
    <div class="form-group">
        <textarea class="form-control" id="commentId" placeholder="Nhap danh gia cua ban..."></textarea>
        <br>
        <input type="button" onclick="addComment(${product.id})"
               value="Gui binh luan" class="btn btn-danger" />
    </div>
</form>

<div id="commentArea">
    
    <c:forEach var="comment" items="${product.commentCollection}"  >
        <div class="row">
            <div class="col-md-2" style="padding: 10px">
                <img class="rounded-circle" src="<c:url value="/images/default.jpg" />" style="width: 100px"/>
            </div>
            <div class="col-md-10 my-date">
                <p>${comment.content}</p>
                <i>${comment.createdDate}</i>
            </div> 

        </div> 
    </c:forEach>
</div>

<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>