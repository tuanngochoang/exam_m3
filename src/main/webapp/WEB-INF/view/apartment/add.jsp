<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.6.0/css/fontawesome.min.css" integrity="sha384-NvKbDTEnL+A8F/AA5Tc5kmMLSJHUO868P+lDtTpJIeQdGYaUIuLr4lVGOEA1OcMy" crossorigin="anonymous">
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="" style="max-width: 400px; width: 100%;">
        <h1 class="card-title text-center mb-4 mt-5">Them mat bang</h1>

        <div class="mt-3">
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success">${successMessage}</div>
            </c:if>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>
        </div>

        <form action="/apartments/add" method="post">
            <div class="mb-3 mt-5">
                <label for="id" class="form-label">Ma mat bang</label>
                <input type="text" id="id" name="id" class="form-control" placeholder="Vi du: MB000" required>
            </div>
            <div class="mb-3">
                <label for="area" class="form-label">dien tich</label>
                <input type="text" id="area" name="area" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="status" class="form-label">Trang thai</label>
                <div class="col">
                    <select name="status" id="status" class="form-select" required>
                        <option value="">-- Chon trang thai --</option>
                        <option value="Trong">Trong</option>
                        <option value="Ha tang">Ha Tang</option>
                        <option value="Day du">Day du</option>
                    </select>
                </div>
            </div>
            <div class="mb-3">
                <label for="floor" class="form-label">Tang</label>
                <div class="col">
                    <select name="floor" id="floor" class="form-select" required>
                        <option value="">-- Chon so tang --</option>
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
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                    </select>
                </div>
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Loai van phong</label>
                <div class="col">
                    <select name="type" id="type" class="form-select" required>
                        <option value="">-- Chon loai van phong --</option>
                        <option value="Trong">Van phong chia se</option>
                        <option value="Ha tang">Van phong tron goi</option>
                    </select>
                </div>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Mo ta cho tiet</label>
                <input type="text" id="description" name="description" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Gia cho thue</label>
                <input type="text" id="price" name="price" class="form-control" required>
            </div>
            <div>
                <div>
                    <div class="mb-3">
                        <label for="startDay" class="form-label">Ngay bat dau</label>
                        <input type="text" id="startDay" name="startDay" class="form-control" placeholder="DD/MM/YYYY" required>
                    </div>
                    <div class="mb-3">
                        <label for="endDay" class="form-label">Ngay ket thuc</label>
                        <input type="text" id="endDay" name="endDay" class="form-control" placeholder="DD/MM/YYYY" required>
                    </div>
                </div>
            </div>

            <div class="d-flex justify-content-center mt-3">
                <div class="d-grid mt-3" >
                    <button type="submit" class="btn btn-primary">Luu</button>
                </div>
                <div class="d-grid">
                    <button type="button" class="btn btn-danger" onclick="window.history.back();">Huy</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
