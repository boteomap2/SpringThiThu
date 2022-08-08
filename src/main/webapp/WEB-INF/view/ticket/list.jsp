<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Thống kê</title>
    <%@ include file="/common/css-lib.jsp"%>
</head>
<body class="d-flex flex-column">
    <%@ include file="/common/js-lib.jsp"%>
    <%@ include file="/common/header.jsp"%>

    <div class="container flex-grow-1">
        <div class="jumbotron">
            <div class="row">
                <div class="col">
                    <h2 class="text-center">Danh sách vé đăng ký</h2>
                </div>
                <div class="w-100"></div>

                <div class="col" style="position: relative">
                    <table
                            id="table"
                            class="table table-bordered table-hover table-striped"
                            data-toggle="table"
                            data-locale="en-US"
                            data-show-columns="true"
                            data-show-columns-toggle-all="true"
<%--                            data-search="true"--%>
<%--                            data-visible-search="true"--%>
                            data-filter-control="true"
                            data-show-search-clear-button="true"
                            data-search-on-enter-key="true"
                            data-pagination="true"
                            data-page-list="[10, 25, 50, 100, all]"
                            data-show-jump-to="true"
                    >
                        <thead>
                        <tr>
                            <th data-field="maDK" data-sortable="true" data-switchable="false">Mã DK</th>
                            <th data-field="hoTen" data-sortable="true" data-filter-control="input">Họ tên</th>
                            <th data-field="gioiTinh" data-sortable="true" >Giới tính</th>
                            <th data-field="ngaySinh" data-sortable="true">Ngày sinh</th>
                            <th data-field="diaChi" data-sortable="true">Địa chỉ</th>
                            <th data-field="soDienThoai" data-sortable="true">Số điện thoại</th>
                            <th data-field="maLT" data-sortable="true" data-filter-control="select">Mã LT</th>
                            <th data-field="ngayKH" data-sortable="true">Ngày khởi hành</th>
                            <th data-field="soLuongVe" data-sortable="true" >Số lượng vé</th>
                            <th data-field="tongTien" data-sortable="true">Tổng tiền</th>
                            <th data-field="operate"
                                data-switchable="false"
                                data-align="center"
                                data-formatter="operateFormatter"
                                data-events="operateEvents"
                            >
                                Chức năng
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${tickets}" var="ticket">
                            <tr>
                                <td>${ticket.maDK}</td>
                                <td>${ticket.hoTen}</td>
                                <td>${ticket.gioiTinh}</td>
                                <td>${ticket.ngaySinh}</td>
                                <td>${ticket.diaChi}</td>
                                <td>${ticket.soDienThoai}</td>
                                <td>${ticket.loTrinh.maLT}</td>
                                <td>${ticket.ngayKH}</td>
                                <td>${ticket.soLuongVe}</td>
                                <td>${ticket.tongTien}</td>
                                <td></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="/common/footer.jsp"%>
</body>
<script src="<c:url value="/assets/js/ticket/list.js" />"></script>
</html>