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
                                        <c:url var="deleteLink" value="/deleteFromBasket">
                                            <c:param name="id" value="${merchandise.id}"/>
                                        </c:url>
                                        <div class="col-md-2">
                                            <a href="${deleteLink}">Удалить</a>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <h5> Всего к оплате: ${totalSum}</h5>
                    </div>
                    <div class="col-md-auto">
                        <button class="btn btn-success">Оплатить</button>
                    </div>
                    <br>
                    <div class="col-md-auto">
                        <button class="btn btn-success">Оформить заказ</button>
                    </div>
                </div>

            </div>
        </div>

    </jsp:body>
</t:page-template>

