<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<div class="row">
    <div class="col-md-4">
        <!--Sidebar content-->
        <div class="btn btn-success">
        <a href="${pageContext.request.contextPath}/user/updateUserForm" class="text-white">Мой профиль</a>
    </div>
    </div>
    <div class="col-md-4">
        <!--Sidebar content-->
        <div class="btn btn-success">
        <a href="${pageContext.request.contextPath}/address/listAddress" class="text-white">Мои адреса</a>
        </div>
    </div>
    <div class="col-md-4">
        <!--Sidebar content-->
        <div class="btn btn-success">
        <a href="${pageContext.request.contextPath}/store/listStore" class="text-white">Мои магазины</a>
        </div>
    </div>
</div>

</body>
</html>
