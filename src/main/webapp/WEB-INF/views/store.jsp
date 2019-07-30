<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<t:page-template>
    <jsp:attribute name="titleText">Профиль пользователя</jsp:attribute>
    <jsp:attribute name="metaDescription">Профиль пользователя</jsp:attribute>


    <jsp:body>
        <ul class="nav nav-pills" id="myTab">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="pill" href="#about">О магазине</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="pill" href="#products">Товары</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="pill" href="#orders">Заказы</a>
            </li>
        </ul>

        <div class="tab-content">
            <div class="tab-pane container-fluid active" id="about">
                <form:form modelAttribute="user">
                    <address>
                        <h3>Добро пожаловать в наш магазин ${store.name}</h3>
                        <h3>Свяжитесь с нами :</h3><br>
                        <strong>${user.firstName}</strong><br>
                            ${user.lastName}<br>
                            ${user.email}<br>
                            ${user.phone}<br>

                    </address>
                </form:form>
                <form:form modelAttribute="store">
                    ${pageContext.session.setAttribute("storeId",store.id)}
                </form:form>
            </div>

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
                            <td>${product.category}</td>
                            <td>${product.price}</td>
                            <td>${product.pictureUrl}</td>
                            <td>
                                <a href="${updateLink}">Изменить</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Вы хотите удалить товар ?'))) return false">Удалить</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>


                <a href="${pageContext.request.contextPath}/product/addProductForm"
                   class="btn btn-primary"
                   role="button">Добавить товар</a>
            </div>
            <div class="tab-pane container-fluid fade" id="orders">
		    <div class="row justify-content-center">
                    <div class="col-md-9">
                        <c:forEach var="booking" items="${bookings}">
                            <br>
                            <div class="row">
                                <div class="card w-100">
                                    <div class="card-header">
                                        <div class="row">
                                            <div class="col-md-9">
                                                Заказ <a href="#"> ${booking.merchandise.name} </a>
                                            </div>
                                            <div class="col-md-3">
                                                <button onclick="window.location.href='/bookings/${booking.id}'">Перейти к
                                                    заказу ${product.store.name}</button>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-12 card-body">
                                        <h5> Покупатель: ${booking.buyer.firstName} ${booking.buyer.lastName}</h5>
                                        <h5> Адрес: ${booking.address.country} ${booking.address.city} ${booking.address.address}</h5>
                                        <h5> Количество: ${booking.count}</h5>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <h5> Стоимость: ${booking.count * booking.merchandise.price}</h5>
                                            </div>
                                            <div class="col-md-6">
                                                <h5 class="font-weight-bold">Заказ ${booking.bookingStatus.status}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
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
<%--</body>--%>
<%--</html>--%>
