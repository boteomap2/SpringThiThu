<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Trang Quản Lý</title>
    <%@ include file="/common/css-lib.jsp"%>
</head>
<body class="d-flex flex-column">
    <%@ include file="/common/js-lib.jsp"%>
    <%@ include file="/common/header.jsp"%>

    <div class="container flex-grow-1">
        <div class="row flex-column h-75">
            <div class="col d-flex flex-grow-1 justify-content-center align-items-center">
                <h1>Quản Lý bán vé</h1>
            </div>
        </div>
    </div>

    <%@ include file="/common/footer.jsp"%>
</body>
</html>