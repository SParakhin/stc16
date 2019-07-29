<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<div class="row">
    <div class="col-md-4">
        <!--Sidebar content-->
        <a href="${pageContext.request.contextPath}/user/updateUserForm">Мой профиль</a>
    </div>
    <div class="col-md-4">
        <!--Sidebar content-->
        <a href="${pageContext.request.contextPath}/address/listAddress">Мои адреса</a>
    </div>
    <div class="col-md-4">
        <!--Sidebar content-->
        <a href="${pageContext.request.contextPath}/store/listStore">Мои магазины</a>
    </div>
</div>

</body>
</html>
