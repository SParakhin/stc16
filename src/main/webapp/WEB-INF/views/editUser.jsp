<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:page-template>
    <jsp:attribute name="titleText">Изменение данных профиля</jsp:attribute>
    <jsp:attribute name="metaDescription">Изменение данных профиля пользователя</jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="col-md-offset-2 col-md-7">
                <h2 class="text-center">Редактирование профиля пользователя</h2>
                <div class="panel panel-info">
                    <div class="panel-body">
                        <form:form action="updateUser" cssClass="form-horizontal"
                                   method="POST" modelAttribute="user">
                        <form:hidden path="id"/>

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
                            <label for="password" class="col-md-3 control-label">Пароль</label>
                            <div class="col-md-9">
                                <form:input path="password" cssClass="form-control"/>
                                <form:errors path="password" cssClass="alert"/>
                            </div>
                        </div>

                            <form class="form-inline">
                                <button type="submit" class="btn btn-primary" formmethod="get"
                                        formaction="/address/listAddress" name="edit">Адреса доставки
                                </button>
                            </form>

                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                                <form:button cssClass="btn btn-primary">Сохранить данные</form:button>
                            </div>
                        </div>
                    </div>
                    </form:form>

                    <form:form action="deleteUser" cssClass="form-horizontal"
                               method="GET" modelAttribute="user">
                        <form:hidden path="id"/>
                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                                <form:button cssClass="btn btn-primary">Удалить профиль</form:button>
                            </div>
                        </div>
                    </form:form>




                </div>
            </div>
        </div>







    </jsp:body>
</t:page-template>