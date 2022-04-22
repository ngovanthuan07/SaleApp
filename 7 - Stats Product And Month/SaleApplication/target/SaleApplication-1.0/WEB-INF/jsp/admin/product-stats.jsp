<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1 class="text-center text-info">THONG KE DOANH THU THEO SAN PHAM</h1>

<form action="">
    <div class="form-group">
        <label>Tu khoa</label>
        <input type="text" name="kw" class="form-control" />
    </div>
    <div class="form-group">
        <label>Tu thoi diem</label>
        <input type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <label>Den thoi diem</label>
        <input type="date" name="toDate" class="form-control" />
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success" />
</form>

<div>
    <canvas id="myProductStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Ma san pham</th>
        <th>Ten san pham</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${productStats}" var="p">
        <tr>
            <td>${p[0]}</td>
            <td>${p[1]}</td>
            <td>${p[2]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let productLabels=[], productInfo=[]
    <c:forEach items="${productStats}" var="p">
    productLabels.push('${p[1]}')
    productInfo.push(${p[2]})
    </c:forEach>

    window.onload = function() {
        productChart("myProductStatsChart", productLabels, productInfo)
    }
</script>