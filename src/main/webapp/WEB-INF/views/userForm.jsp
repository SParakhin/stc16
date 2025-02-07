<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Регистрация</jsp:attribute>
    <jsp:attribute name="metaDescription">Регистрация нового пользователя</jsp:attribute>
    <jsp:body>

        <div class="container-fluid">
            <c:if test="${pageContext.request.getAttribute('newUser')==null}">
                <jsp:include page="profileHeader.jsp"/>
            </c:if>
            <div class="row">
                <div class="col-md-auto">
                    <c:if test="${pageContext.request.getAttribute('newUser')!=null}">
                        <h2 class="text-center">Регистрация пользователя</h2>
                    </c:if>
                    <div class="panel-body">
                        <form:form action="saveUser" cssClass="form-horizontal"
                                   method="POST" modelAttribute="user">
                        <div class="form-group">
                            <div class="col-md-auto">
                                <label for="firstName">Имя</label>
                                <form:input path="firstName" id="firstName" cssClass="form-control"/>
                                <form:errors path="firstName" cssClass="alert"/>
                                <label for="lastName">Фамилия</label>
                                <form:input path="lastName" id="lastName" cssClass="form-control"/>
                                <form:errors path="lastName" cssClass="alert"/>
                                <label for="email">Email</label>
                                <form:input path="email" id="email" cssClass="form-control"/>
                                <form:errors path="email" cssClass="alert"/>
                                <label for="phone">Телефон</label>
                                <form:input path="phone" id="phone" cssClass="form-control"/>
                                <form:errors path="phone" cssClass="alert"/>
                                <c:if test="${pageContext.request.getAttribute('newUser')!=null}">
                                    <label for="username">Логин</label>
                                    <form:input path="username" id="username" cssClass="form-control"/>
                                    <form:errors path="username" cssClass="alert"/>
                                    <label for="password" type="password">Пароль</label>
                                    <form:password path="password" id ="password" cssClass="form-control" showPassword="true"/>
                                    <form:errors path="password" cssClass="alert"/>
                                    <br>
                                    <div class="form-group">
                                        <div class="col-md-offset-3 col-md-9">
                                            <form:button class="btn btn-success">Зарегистрироваться</form:button>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${pageContext.request.getAttribute('newUser')==null}">
                                    <form:hidden path="username"/>
                                    <form:hidden path="password"/>
                                    <br>
                                    <button type="submit" class="btn btn-success" formmethod="POST"
                                            formaction="${pageContext.request.contextPath}/user/updateUser"
                                            name="edit">
                                        Сохранить изменения
                                    </button>
                                    <button type="submit" class="btn btn-success" formmethod="GET"
                                            formaction="${pageContext.request.contextPath}/user/deleteUser"
                                            name="delete">
                                        Удалить профиль
                                    </button>
                                </c:if>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page-template>