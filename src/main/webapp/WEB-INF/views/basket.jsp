<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Корзина</jsp:attribute>
    <jsp:attribute name="metaDescription">Просмотр корзины</jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-md-9">
                    <c:forEach var="merchandise" items="${basket}">
                        <br>
                        <div class="row">
                            <div class="card w-100">
                                <div class="card-header">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <img src="${merchandise.pictureUrl}" alt="Нет картинки">
                                        </div>

                                        <div class="col-md-6">
                                            <a Название товара></a>
                                            <a href="${pageContext.request.contextPath}/merchandise?id=${merchandise.id}"> ${merchandise.name} </a>
                                        </div>

                                        <div class="col-md-2">
                                                ${merchandise.price} </a>
                                        </div>

                                        <div class="col-md-2">
                                            <a href="#">Удалить</a>
                                        </div>


                                            <%--<div class="col-md-3">--%>
                                            <%--<button onclick="window.location.href='/bookings/${booking.id}'">Перейти к--%>
                                            <%--товару ${merchandise.name}</button>--%>
                                            <%--</div>--%>
                                    </div>
                                </div>

                                    <%--<div class="col-md-12 card-body">--%>
                                    <%--<h5> Покупатель: ${booking.buyer.firstName} ${booking.buyer.lastName}</h5>--%>
                                    <%--<h5>--%>
                                    <%--Адрес: ${booking.address.country} ${booking.address.city} ${booking.address.address}</h5>--%>
                                    <%--<h5> Количество: ${merchandise.count}</h5>--%>
                                    <%--<div class="row">--%>
                                    <%--<div class="col-md-6">--%>
                                    <%--<h5> Стоимость: ${booking.count * booking.merchandise.price}</h5>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-md-6">--%>
                                    <%--<h5 class="font-weight-bold">Заказ ${booking.bookingStatus.status}</h5>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                                    <%--</div>--%>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <h5> Всего к оплате: ${totalSum}</h5>
                    </div>
                    <div class="col-md-auto">
                        <button class="btn btn-success">Оплатить</button>
                    </div>

                        <div class="col-md-auto">
                            <button class="btn btn-success">Оформить заказ</button>
                        </div>
                    </div>

            </div>
        </div>


        <%--<div class="cart_info">--%>
        <%--<div class="container-fluid">--%>
        <%--<div class="row">--%>
        <%--<div class="col-md-auto">--%>
        <%--<!-- Column Titles -->--%>
        <%--<div class="cart_info_columns clearfix">--%>
        <%--<div class="cart_info_col cart_info_col_product">Товар</div>--%>
        <%--<div class="cart_info_col cart_info_col_price">Цена</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="row">--%>
        <%--<div class="col-md-auto">--%>

        <%--<!-- Cart Item -->--%>
        <%--<c:forEach var="merchandise" items="${basket}">--%>
        <%--&lt;%&ndash;<div class="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">&ndash;%&gt;--%>
        <%--<!-- Name -->--%>
        <%--&lt;%&ndash;<div class="cart_item_product d-flex flex-row align-items-center justify-content-start">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="cart_item_image">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div><img src=${merchandise.pictureUrl}></div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--<div class="row">--%>
        <%--<div class="col-md-4">--%>
        <%--<img src="${merchandise.pictureUrl}" alt="Нет картинки">--%>
        <%--</div>--%>

        <%--<div class="cart_item_name_container">--%>
        <%--<div class="cart_item_name"><a--%>
        <%--href="${pageContext.request.contextPath}/merchandise?id=${merchandise.id}">${merchandise.name}</a>--%>
        <%--<input type="hidden" name="id" value="${merchandise.id}">--%>
        <%--</div>--%>

        <%--</div>--%>
        <%--</div>--%>
        <%--<!-- Price -->--%>
        <%--<div class="cart_item_price">${merchandise.price}</div>--%>
        <%--</div>--%>
        <%--</c:forEach>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<div class="col-lg-6 offset-lg-2">--%>
        <%--<div class="cart_total">--%>
        <%--&lt;%&ndash;<div class="section_title">Cart total</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="section_subtitle">Final info</div>&ndash;%&gt;--%>
        <%--<div class="cart_total_container">--%>
        <%--<ul>--%>
        <%--<c:forEach var="merchandise" items="${basket}">--%>
        <%--<li class="d-flex flex-row align-items-center justify-content-start">--%>
        <%--&lt;%&ndash;<div class="cart_total_title">Subtotal</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="cart_total_value ml-auto">${merchandise.price}</div>&ndash;%&gt;--%>
        <%--</li>--%>
        <%--</c:forEach>--%>
        <%--<li class="d-flex flex-row align-items-center justify-content-start">--%>
        <%--<div class="cart_total_title">Всего</div>--%>
        <%--<div class="cart_total_value ml-auto">${totalSum}</div>--%>
        <%--</li>--%>
        <%--</ul>--%>
        <%--<button class="btn btn-success">Оплатить</button>--%>

        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    </jsp:body>
</t:page-template>

