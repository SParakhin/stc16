<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Корзина</jsp:attribute>
    <jsp:attribute name="metaDescription">Просмотр корзины</jsp:attribute>
    <jsp:body>

        <div class="container-fluid">

            <c class="row justify-content-center">
                <c:if test="${empty basket}">
                <div class="row">
                    <div class="col text-center">
                        <p class="h3">
                            К сожалению, в корзине ещё нет товаров.
                        </p>
                    </div>
                </div>
                </c:if>

                <c:if test="${not empty basket}">
                <h2>Корзина товаров</h2>
                <div class="col-md-12">
                    <c:forEach var="merchandise" items="${basket}">
                        <br>
                        <div class="row">
                            <div class="card w-100">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <img src="${merchandise.pictureUrl}" alt="Нет картинки"
                                                 style="width: 60px;">
                                        </div>
                                        <div class="col-md-4">
                                            <a href="${pageContext.request.contextPath}/merchandise?id=${merchandise.id}"> ${merchandise.name} </a>
                                        </div>
                                        <div class="col-md-4">
                                            <strong>${merchandise.price} руб.</strong>
                                        </div>
                                        <c:url var="deleteLink" value="/deleteFromBasket">
                                            <c:param name="id" value="${merchandise.id}"/>
                                        </c:url>
                                        <div class="col-md-2">
                                            <button class="btn btn-danger btn-sm"
                                                    onclick="window.location.href='${deleteLink}'">Удалить
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <h5> Всего к оплате: ${totalSum} руб.</h5>
                    </div>
                    <div class="row">
                        <div class="col-md-auto">
                            <button class="btn btn-success">Оплатить</button>
                        </div>
                        <br>
                        <div class="col-md-auto">
                            <button class="btn btn-success">Оформить заказ</button>
                        </div>
                    </div>
                </div>
                </c:if>
        </div>
        </div>

    </jsp:body>
</t:page-template>

