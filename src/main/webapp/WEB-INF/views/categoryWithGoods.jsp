<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Вход</jsp:attribute>
    <jsp:attribute name="metaDescription">Страница авторизации пользователя</jsp:attribute>
    <jsp:body>

        <div class="my-3">
            <c:choose>
                <c:when test="${empty goods}">
                    <div class="row">
                        <div class="col text-center">
                            <p class="h3">
                                К сожалению, в категории "${catName}" ещё нет товаров.<br>
                                Попробуйте посмотреть позже :)
                            </p>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <div class="col">
                            <p class="h3">
                                Товары в категории "${catName}":
                            </p>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <c:forEach var="merch" items="${goods}">
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
                    <div class="row">
                        <div class="col">
                            <nav aria-label="goods pagination">
                                <ul class="pagination pagination-lg justify-content-center">
                                    <c:forEach var="pageNumber" items="${pageNumbers}">
                                        <c:choose>
                                            <c:when test="${currentPageNumber == pageNumber}">
                                                <li class="page-item disabled">
                                                    <a class="page-link" href="#" tabindex="-1">${pageNumber}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <c:url var="openCatPage" value="/cat/openWithGoods">
                                                    <c:param name="catName" value="${catName}"/>
                                                    <c:param name="pageNumber" value="${pageNumber}"/>
                                                </c:url>
                                                <li class="page-item">
                                                    <a class="page-link" href="${openCatPage}">${pageNumber}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

    </jsp:body>
</t:page-template>