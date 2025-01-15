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

    <form action="/apartments/list" method="get">
        <div class="mb-3">
            <label for="type" class="form-label">Loại văn phòng</label>
            <select name="type" id="type" class="form-select">
                <option value="">-- Chọn loại văn phòng --</option>
                <option value="Trong">Văn phòng chia sẻ</option>
                <option value="Ha tang">Văn phòng trọn gói</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Giá cho thuê (VND)</label>
            <input type="number" id="price" name="price" class="form-control" min="0" placeholder="Nhập giá cho thuê">
        </div>

        <div class="mb-3">
            <label for="floor" class="form-label">Tầng</label>
            <select name="floor" id="floor" class="form-select">
                <option value="">-- Chọn tầng --</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
        </div>

        <div class="d-grid mt-3">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </div>
    </form>

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
            <th>Thao tác</th>
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

<script type="text/javascript">
    function confirmDelete(url) {
        if (confirm("Bạn có chắc chắn muốn xóa căn hộ này?")) {
            window.location.href = url;
        }
    }
</script>

</body>
</html>
