<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Регистрация</jsp:attribute>
    <jsp:attribute name="metaDescription">Регистрация нового пользователя</jsp:attribute>
    <jsp:body>

        <div class="container">
            <div class="col-md-offset-2 col-md-7">
                <h2 class="text-center">Регистрация пользователя</h2>
                <div class="panel panel-info">
                    <div class="panel-body">
                        <form:form action="saveUser" cssClass="form-horizontal"
                                   method="POST" modelAttribute="user">

                        <div class="form-group">
                            <label for="firstName" class="col-md-3 control-label">Фамилия</label>
                            <div class="col-md-9">
                                <form:input path="firstName" cssClass="form-control"/>
                                <form:errors path="firstName" cssClass="alert"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-md-3 control-label" onerror="null">Имя</label>
                            <div class="col-md-9">
                                <form:input path="lastName" cssClass="form-control"/>
                                <form:errors path="lastName" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="col-md-3 control-label">Email</label>
                            <div class="col-md-9">
                                <form:input path="email" cssClass="form-control"/>
                                <form:errors path="email" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-md-3 control-label">Телефон</label>
                            <div class="col-md-9">
                                <form:input path="phone" cssClass="form-control"/>
                                <form:errors path="phone" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="login" class="col-md-3 control-label">Логин</label>
                            <div class="col-md-9">
                                <form:input path="login" cssClass="form-control"/>
                                <form:errors path="login" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" type="password" class="col-md-3 control-label">Пароль</label>
                            <div class="col-md-9">
                                <form:input path="password" cssClass="form-control"/>
                                <form:errors path="password" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                                <form:button cssClass="btn btn-primary">Зарегистрироваться</form:button>
                            </div>
                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>

    </jsp:body>
</t:page-template>