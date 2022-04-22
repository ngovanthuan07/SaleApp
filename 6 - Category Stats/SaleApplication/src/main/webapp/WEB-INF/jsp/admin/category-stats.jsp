<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 class="text-center text-danger">THONG KE SAN PHAM THEO DANH MUC</h1>

<div>
    <canvas id="myCateStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Ma danh muc</th>
        <th>Ten danh muc</th>
        <th>So luong san pham</th>
    </tr>
    <c:forEach items="${cateStats}" var="c">
        <tr>
            <td>${c[0]}</td>
            <td>${c[1]}</td>
            <td>${c[2]}</td>
        </tr>
    </c:forEach>
</table>
<script>
    let cateLabels=[], cateInfo=[];

    <c:forEach items="${cateStats}" var="c">
        cateLabels.push('${c[1]}')
        cateInfo.push(${c[2]})
    </c:forEach>

    window.onload = function() {
        cateChart("myCateStatsChart", cateLabels, cateInfo)
    }
</script>