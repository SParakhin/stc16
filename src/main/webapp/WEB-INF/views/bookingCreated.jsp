<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>
        <div class="container justify-content-center">
            <div class="row">
                <div class="col-md-12 text-center">
                    <div class="alert alert-success text-center" role="alert">
                        <h2> Заказ успешно оформлен</h2>
                        <button onclick="window.location.href='/bookings'">Перейти к моим заказам</button>
                    </div>

                </div>
            </div>
        </div>
    </jsp:body>
</t:page-template>