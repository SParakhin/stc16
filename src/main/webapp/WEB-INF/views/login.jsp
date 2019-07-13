<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Вход</jsp:attribute>
    <jsp:attribute name="metaDescription">Страица авторизации пользователя</jsp:attribute>
    <jsp:body>

        <div class="container-fluid text-center">
            <div class="row">
                <div class="col">
                    <h1 class="display-4">Вход в систему</h1>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col col-md-6 justify-content-center">
                    <form method="post" action="${pageContext.request.contextPath}/auth_user">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">login</span>
                            </div>
                            <input class="form-control" type="text" name="name"><br/>
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon2">password</span>
                            </div>
                            <input class="form-control" type="password" name="password"><br/>
                        </div>

                        <input class="btn btn-lg btn-success my-1" type="submit" value="войти"/>
                    </form>
                </div>
            </div>
        </div>

    </jsp:body>
</t:page-template>