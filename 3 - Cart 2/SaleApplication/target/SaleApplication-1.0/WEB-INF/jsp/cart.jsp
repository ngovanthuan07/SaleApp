<%-- 
    Document   : cart
    Created on : Apr 20, 2022, 8:05:34 PM
    Author     : ngova
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Gio Hang</h1>
<c:if test="${carts == null}">
    <h4 class="text-danger">Khong co san pham nao trong gio</h4>
</c:if>
<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Ma san pham</th>
            <th>Ten san pham</th>
            <th>Don gia</th>
            <th>So luong</th>
            <th></th>
        </tr>
        <c:forEach items="${carts}" var="c">
            <tr id="product${c.productId}">
                <td>${c.productId}</td>
                <td>${c.productName}</td>
                <td>${c.price} VND</td>
                <td>
                    <div class="form-group">
                        <input  type="number" 
                                onblur="updateCart(this, ${c.productId})"
                                value="${c.quantity}" 
                                class="form-control"/>
                    </div>
                </td>
                <td>
                    <input type="button" 
                           value="Xoa" 
                           onclick="deleteCart(${c.productId})"
                           class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>

    </table>
    <input type="button" value="Thanh toan" class="btn btn-danger" />
</c:if>
    <br><br>



