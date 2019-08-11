<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>
        <div class="container justify-content-center">
            <br>
            <a href="${pageContext.request.contextPath}/store?id=${booking.store.id}#orders"
               class="btn btn-primary"
               role="button">Вернуться к заказам</a>
            <br>
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4 class="font-weight-bold">Покупатель: ${booking.buyer.firstName} ${booking.buyer.lastName}</h4>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 class="font-weight-bold">Адрес доставки:</h4>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h5>Страна: ${booking.address.country}</h5>
                                        </div>
                                        <div class="col-md-6">
                                            <h5>Город: ${booking.address.country}</h5>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h5>Индекс: ${booking.address.postCode}</h5>
                                        </div>
                                        <div class="col-md-6">
                                            <h5>Улица,дом: ${booking.address.address}</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-md-12">
                                    <h4 class="font-weight-bold">Описание заказа: </h4>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h5>Количество: ${booking.count}</h5>
                                        </div>
                                        <div class="col-md-6">
                                            <h5>Стоимость: ${booking.count * booking.merchandise.price}</h5>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h4 class="font-weight-bold">Статус заказа: ${booking.bookingStatus}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page-template>