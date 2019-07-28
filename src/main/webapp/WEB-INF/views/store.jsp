<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:page-template>
    <jsp:attribute name="titleText">Профиль пользователя</jsp:attribute>
    <jsp:attribute name="metaDescription">Профиль пользователя</jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">
                        <%--<div class="card">--%>
                        <%--<div class="card-body">--%>
                    <form:form modelAttribute="user">
                        <address>
                            <strong>${user.firstName}</strong><br>
                                ${user.lastName}<br>
                                ${user.email}<br>
                        </address>
                    </form:form>
                        <%--</div>--%>
                        <%--</div>--%>
                </div>
                    <%--</div>--%>
                    <%--<div class="row">--%>
                    <%--<div class="form-group">--%>
                <div class="col-md-10">
                    <a href="${pageContext.request.contextPath}/product/addProductForm" class="btn btn-primary"
                       role="button">Добавить товар</a>

                        <%--<form:hidden path="id"></form:hidden>--%>
                        <%--<button type="button" class="btn btn-info">Button</button>--%>
                        <%--<input type="button" class="btn btn-info" value="Input Button">--%>
                        <%--<input type="submit" class="btn btn-info" value="Submit Button">--%>
                </div>
            </div>
                <%--</div>--%>
                <%--</div>--%>

        </div>


    </jsp:body>
</t:page-template>
