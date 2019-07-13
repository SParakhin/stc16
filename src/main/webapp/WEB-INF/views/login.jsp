<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Вход</jsp:attribute>
    <jsp:attribute name="metaDescription">Страница авторизации пользователя</jsp:attribute>
    <jsp:body>

        <div class="container-fluid text-center">
            <div class="row">
                <div class="col">
                    <h1 class="display-4">Вход в систему</h1>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col col-md-6 justify-content-center">
                    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
                        <c:if test="${param.error != null}">
                            <span class="text-danger text-monospace">
                                <i>*** Извините! Вы ввели некорректное имя пользователя/пароль ***</i>
                            </span>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <span class="text-info text-monospace">
                                <i>*** Вы вышли из своей учётной записи! ***</i>
                            </span>
                        </c:if>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">логин</span>
                            </div>
                            <input class="form-control" type="text" name="username"><br/>
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon2">пароль</span>
                            </div>
                            <input class="form-control" type="password" name="password"><br/>
                        </div>

                        <input class="btn btn-lg btn-success my-1" type="submit" value="войти"/>
                    </form:form>
                </div>
            </div>
        </div>

    </jsp:body>
</t:page-template>