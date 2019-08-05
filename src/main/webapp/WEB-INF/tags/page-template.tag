<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="titleText" fragment="true" %>
<%@attribute name="metaDescription" fragment="true" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">    <!-- Custom styles -->
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">
    <meta name="description" content="<jsp:invoke fragment="metaDescription"/>">

    <title>
        <jsp:invoke fragment="titleText"/>
    </title>
</head>

<body>
<t:header-template/>

<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col col-sm-10 col-md-9 col-lg-7">
            <jsp:doBody/>
        </div>
    </div>
</div>
<t:footer-template/>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</body>

</html>