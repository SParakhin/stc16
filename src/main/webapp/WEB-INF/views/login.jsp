<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Вход</jsp:attribute>
    <jsp:attribute name="metaDescription">Страица авторизации пользователя</jsp:attribute>
    <jsp:body>

        <h1>Вход в систему</h1>
        <!-- WIP -->
        <form method="post" action="${pageContext.request.contextPath}/auth_user">s
            <input type="text" name="name" placeholder="name"><br/>
            <input type="password" name="password" placeholder="pasword"><br/>
            <input type="submit" value="войти"/>
        </form>

    </jsp:body>
</t:page-template>