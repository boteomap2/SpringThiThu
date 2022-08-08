<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Cập nhật vé</title>
    <%@ include file="/common/css-lib.jsp"%>
</head>
<body class="d-flex flex-column">
<%@ include file="/common/js-lib.jsp"%>
<%@ include file="/common/header.jsp"%>

<div class="container flex-grow-1">
    <form:form action="${contextPath}/ticket/register" method="post" modelAttribute="ticket">
        <div class="jumbotron col-7 mx-auto mt-5">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="text-center">Cập nhật vé</h2>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="maDK">Mã DK</label>
                        <form:input
                                type="text"
                                path="maDK"
                                class="form-control"
                                readonly="true"
                        />
                        <form:errors path="maDK" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="hoTen">Họ tên</label>
                        <form:input
                                type="text"
                                path="hoTen"
                                class="form-control"
                        />
                        <form:errors path="hoTen" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="gioiTinh">Giới tính</label>
                        <form:select path="gioiTinh" class="form-control">
                            <form:option value="Nam" label="Nam"/>
                            <form:option value="Nu" label="Nữ"/>
                        </form:select>
                        <form:errors path="gioiTinh" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="ngaySinh">Ngày sinh</label>
                        <form:input
                                path="ngaySinh"
                                type="date"
                                class="form-control"
                        />
                        <form:errors path="ngaySinh" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="diaChi">Địa chỉ</label>
                        <form:input
                                path="diaChi"
                                type="text"
                                class="form-control"
                        />
                        <form:errors path="diaChi" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="soDienThoai">Số điện thoại</label>
                        <form:input
                                path="soDienThoai"
                                type="text"
                                class="form-control"
                        />
                        <form:errors path="soDienThoai" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="loTrinh.maLT">Mã lộ trình</label>
                        <form:select path="loTrinh.maLT" class="form-control">
                            <form:option value="" label="-- Chọn lộ trình --"/>
                            <form:options items="${loTrinhs}" itemLabel="moTa" itemValue="maLT"/>
                        </form:select>
                        <form:errors path="loTrinh.maLT" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="ngayKH">Ngày khởi hành</label>
                        <form:input
                                path="ngayKH"
                                type="date"
                                class="form-control"
                        />
                        <form:errors path="ngayKH" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="soLuongVe">Số lượng vé</label>
                        <form:input
                                path="soLuongVe"
                                type="number"
                                class="form-control"
                        />
                        <form:errors path="soLuongVe" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10">
                    <div class="form-group">
                        <label for="tongTien">Tổng tiền</label>
                        <form:input
                                path="tongTien"
                                type="number"
                                class="form-control"
                                readonly="true"
                        />
                        <form:errors path="tongTien" cssClass="error" />
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-10 d-flex justify-content-end">
                    <div class="form-group">
                        <form:button class="btn btn-primary btn-md">Submit</form:button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="/common/footer.jsp"%>
</body>
<%-- script tinh tien--%>
<script>
    let $maLT = $("#loTrinh\\.maLT");
    let $soLuongVe = $("#soLuongVe");
    let $tongTien = $("#tongTien");

    $maLT.on("change", function() {
        $("#loTrinh\\.maLT\\.errors").remove();
        if ($soLuongVe.val() <= 0) {
            $tongTien.val(0);
        } else {
            tinhTien();
        }
    });

    $soLuongVe.on("blur", function() {
        if ($soLuongVe.val() <= 0) {
            $tongTien.val(0);
        } else {
            tinhTien();
        }
    });

    function tinhTien() {
        let data = {
            maLT: $maLT.val(),
            soLuongVe: $soLuongVe.val(),
        };
        $.ajax({
            url : "/quanly/ticket/calculate",
            data: data,
            type: "POST",
        }).done(function(tongTien) {
            $tongTien.val(tongTien);
        });
    }
</script>

<%-- script validate--%>
<script>
    let ngaySinh = $("#ngaySinh").val().replaceAll("-","");
    $("#ticket").validate({
        rules: {
            ngayKH: {
                required: true,
                lgCurrentDate: true,
            },
            soLuongVe: {
                required: true,
                range: [$soLuongVe.val(), 10],

            },
        },
        messages: {
            ngayKH: {
                required: "Phải nhập ngày khởi hành",

            },
            soLuongVe: {
                required: "Phải nhập số lượng vé",
                range: "Error_" + ngaySinh + ": So luong ve thay doi khong hop le",
            },
        },
        errorPlacement: function (error, element) {
            // for check box and radio
            if (element.attr("name") == "checkme") {
                error.appendTo("#error-mess");
            } else {
                error.insertAfter(element);
            }
        },
        onfocusout: function (element) {
            // "eager" validation
            this.element(element);
        },
        success: "valid",
    });
</script>

<script src="<c:url value="/assets/js/validate-method.js" />"></script>
</html>