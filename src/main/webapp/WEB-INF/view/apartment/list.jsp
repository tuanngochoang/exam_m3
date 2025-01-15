<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách căn hộ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Danh sách căn hộ</h2>
    <c:if test="${not empty message}">
        <div class="alert alert-success mt-3" role="alert">
                ${message}
        </div>
    </c:if>
    <table class="table table-bordered table-striped mt-3">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Diện tích (m²)</th>
            <th>Tình trạng</th>
            <th>Tầng</th>
            <th>Loại</th>
            <th>Mô tả</th>
            <th>Giá (VND)</th>
            <th>Ngày bắt đầu</th>
            <th>Ngày kết thúc</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="apartment" items="${apartments}">
            <tr>
                <td>${apartment.id}</td>
                <td>${apartment.area}</td>
                <td>${apartment.status}</td>
                <td>${apartment.floor}</td>
                <td>${apartment.type}</td>
                <td>${apartment.description}</td>
                <td>${apartment.price}</td>
                <td>${apartment.startDay}</td>
                <td>${apartment.endDay}</td>
                <td>
                    <a class="btn btn-danger" href="javascript:void(0);"
                       onclick="confirmDelete('<c:url value='/apartments/remove?id=${apartment.id}' />')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript">
    function confirmDelete(url) {
        if (confirm("Bạn có chắc chắn muốn xóa căn hộ này?")) {
            window.location.href = url;
        }
    }
</script>
</html>
