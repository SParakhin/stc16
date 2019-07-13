<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="titleText" fragment="true" %>
<%@attribute name="metaDescription" fragment="true" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">

    <meta name="description" content="<jsp:invoke fragment="metaDescription"/>">

    <title>
        <jsp:invoke fragment="titleText"/>
    </title>
</head>

<body>

<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col col-sm-10 col-md-9 col-lg-7">
            <t:header-template/>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col col-sm-10 col-md-9 col-lg-7">
            <jsp:doBody/>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col col-sm-10 col-md-9 col-lg-7">
            <t:footer-template/>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

</body>

</html>