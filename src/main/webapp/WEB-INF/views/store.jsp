<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Магазин</jsp:attribute>
    <jsp:attribute name="metaDescription">Работа с магазином</jsp:attribute>

    <jsp:body><%--@elvariable id="store" type="ru.innopolis.stc16.innobazaar.entity.Store"--%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="alert alert-success text-center" role="alert">
                    <h2> ${store.name}</h2>
                </div>
            </div>
        </div>
        <br>
        <ul class="nav nav-pills" id="myTab">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="pill" href="#about">О магазине</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="pill" href="#products">Товары</a>
            </li>
            <security:authentication var="principal" property="principal"/>
            <c:if test="${pageContext.request.userPrincipal.name eq store.user.username}">
                <li class="nav-item">
                    <a class="nav-link" data-toggle="pill" href="#orders">Заказы</a>
                </li>
            </c:if>
        </ul>

        <div class="tab-content">
        <div class="tab-pane container-fluid active" id="about">
            <form:form modelAttribute="user">
                <address>
                    <h3>Добро пожаловать в наш магазин</h3>
                    <h3>Свяжитесь с нами :</h3><br>
                    <strong>${store.user.firstName} ${store.user.lastName}</strong><br>
                        ${store.user.email}<br>
                        ${store.user.phone}<br>

                </address>
            </form:form>
            <form:form modelAttribute="store">
                ${pageContext.session.setAttribute("storeId",store.id)}
            </form:form>
        </div>

        <!-- Вкладка "Товары" для покупателя (витрина магазина)-->
        <c:if test="${pageContext.request.userPrincipal.name ne store.user.username}">
            <div class="tab-pane container-fluid fade" id="products">
                <div class="row justify-content-center">
                    <%--@elvariable id="products" type="java.util.List"--%>
                    <c:forEach var="merch" items="${products}">
                        <div class="col-xl-4 col-lg-4 col-md-6 col-sm-10 col-xs-10 my-2">
                            <div id="test" class="card">
                                <c:url var="openMerch" value="/merchandise">
                                    <c:param name="id" value="${merch.id}"/>
                                </c:url>
                                <a href="${openMerch}">
                                    <img class="card-img-top" src="${merch.pictureUrl}"
                                         alt="изображение товара ${merch.name}">
                                </a>
                                <div class="card-body">
                                    <h5 class="card-title">
                                        <a href="${openMerch}">${merch.name}</a>
                                    </h5>
                                    <p class="card-text">${merch.description}</p>
                                    <p class="card-text font-weight-bold">
                                        цена: ${merch.price}
                                        <c:url var="addToOrder" value="/addBasket">
                                            <c:param name="id" value="${merch.id}"/>
                                        </c:url>
                                        <span class="text-lowercase">
                                                <a class="btn btn-success btn-sm mx-2"
                                                   href="${addToOrder}">в корзину</a>
                                            </span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name eq store.user.username}">
            <div class="tab-pane container-fluid fade" id="products">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Название</th>
                        <th>Описание</th>
                        <th>Категория</th>
                        <th>Цена</th>
                        <th>Изображение</th>
                        <th>Действие</th>
                    </tr>

                <!-- loop over and print our users -->
                <%--@elvariable id="products" type="java.util.List"--%>
                <c:forEach var="product" items="${products}">
                    <!-- construct an "update" link with username id -->
                    <c:url var="updateLink" value="/product/updateProductForm">
                        <c:param name="id" value="${product.id}"/>
                    </c:url>

                        <!-- construct an "delete" link with username id -->
                        <c:url var="deleteLink" value="/product/deleteProduct">
                            <c:param name="id" value="${product.id}"/>
                        </c:url>

                        <tr>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>${product.category.name}</td>
                            <td>${product.price}</td>
                            <td>
                                <div class="media">
                                    <img src="${product.pictureUrl}" alt="изображение" class="img-thumbnail"
                                         style="width:60px;">
                                </div>
                            </td>
                            <td>
                                <a href="${updateLink}">Изменить</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Вы хотите удалить товар ?'))) return false">Удалить</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="${pageContext.request.contextPath}/product/addProductForm?id=${store.id}"
                   class="btn btn-success"
                   role="button">Добавить товар</a>
            </div>
        </c:if>

        <div class="tab-pane container-fluid fade" id="orders">
            <div class="row justify-content-center">
                <div class="col-md-9">
                    <%--@elvariable id="bookings" type="java.util.List"--%>
                    <c:forEach var="booking" items="${bookings}">
                        <br>
                        <div class="row">
                            <div class="card w-100">
                                <div class="col-md-12 card-body">
                                    <h5> Покупатель: ${booking.buyer.firstName} ${booking.buyer.lastName}</h5>
                                    <h5>
                                        Адрес: ${booking.address.country} ${booking.address.city} ${booking.address.address}</h5>
                                    <div class="row">
                                        <div class="card w-100">
                                            <c:forEach var="merchandise" items="${booking.merchandise}">
                                                <div class="card-body">

                                                    <div class="row">
                                                        <div class="col-md-2">
                                                            <img class="img-fluid"
                                                                 src="${merchandise.merchandise.pictureUrl}"
                                                                 alt="Нет картинки"
                                                                 style="width: 60px;">
                                                        </div>
                                                        <div class="col-md-4">
                                                            <a href="${pageContext.request.contextPath}/merchandise?id=${merchandise.merchandise.id}"> ${merchandise.merchandise.name} </a>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <strong>${merchandise.merchandise.price} руб.</strong>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <strong>${merchandise.count} шт.</strong>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <h4>Статус заказа: <strong>${booking.status}</strong></h4>
                                        <div class="col-md-9">
                                            Заказ <a href="${pageContext.request.contextPath}/merchandise?id=${booking.merchandise.id}"> ${booking.merchandise.name} </a>
                                        </div>
                                        <div class="col-md-3">
                                            <button onclick="window.location.href='/bookings/${booking.id}'">Перейти к заказу</button>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-12 card-body">
                                    <h5> Покупатель: ${booking.buyer.firstName} ${booking.buyer.lastName}</h5>
                                    <h5>
                                        Адрес: ${booking.address.country} ${booking.address.city} ${booking.address.address}</h5>
                                    <h5> Количество: ${booking.count}</h5>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h5> Стоимость: ${booking.count * booking.merchandise.price}</h5>
                                        </div>
                                        <div class="col-md-6">
                                            <h5 class="font-weight-bold">Заказ ${booking.bookingStatus.status}
                                                <c:if test = "${booking.paid}"><a href="/bookings/${booking.id}/details?returnPage=/store?id=${store.id}%23orders">оплачен</a></c:if>
                                                <c:if test = "${!booking.paid}"><a href="/bookings/${booking.id}/paidStatus?returnPage=/store?id=${store.id}%23orders">не оплачен</a></c:if>
                                            </h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        </div>

        <script>
            $(document).ready(function () {
                if (location.hash) {
                    $("a[href='" + location.hash + "']").tab("show");
                }
                $(document.body).on("click", "a[data-toggle='tab']", function (event) {
                    location.hash = this.getAttribute("href");
                });
            });
            $(window).on("popstate", function () {
                var anchor = location.hash || $("a[data-toggle='tab']").first().attr("href");
                $("a[href='" + anchor + "']").tab("show");
            });
        </script>

    </jsp:body>

</t:page-template>