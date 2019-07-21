<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>
        <div class="container">
            <br>
            <form:form action="${pageContext.request.contextPath}/search" method="POST">

                <div class="row">
                    <div class="col">
                        <input id="searchQuery" name="query" value="${merchandisesPage.criteria.query}"
                               class="form-control form-control-lg form-control-borderless"
                               placeholder="Название товара">
                    </div>
                    <div class="col-auto">
                        <button class="btn btn-lg btn-success" type="submit">Search</button>
                    </div>
                </div>
                <br>
                <div class="row">
                    <c:if test="${merchandisesPage.criteria.query != ''}">
                        По запросу "${merchandisesPage.criteria.query}" найдено ${merchandisesPage.totalElementsNumber} товаров
                    </c:if>
                </div>
                <div class="row">
                    <div class="col-md-9">
                        <c:forEach var="product" items="${merchandisesPage.content}">
                            <div class="row product">
                                <div class="card w-100">
                                    <div class="card-header">
                                        <a href="#"> ${product.name} </a>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <img src="${product.pictureUrl}" alt="Нет картинки">
                                        </div>
                                        <div class="col-md-8 card-body">
                                            <h5> Описание: ${product.description}</h5>
                                            <h6> Цена: ${product.price}</h6>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <a href="#">Перейти к товару</a>
                                                </div>
                                                <div class="col-md-6">
                                                    <a href="#">Перейти к магазину ${product.store.name}</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-md-3">
                        <div class="btn-group">
                            <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle">
                                Категории
                                <span
                                        class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <c:set var="index" value="0"/>
                                <c:forEach var="category" items="${categories}">
                                    <li>
                                        <label>
                                            <input type="checkbox" name="categoryIds"
                                                   value="${category.id}"
                                            <c:if test="${category.id == merchandisesPage.criteria.categoryIds[index]}">
                                                   checked="checked"
                                                <c:set var="index" value="${index + 1}"/>
                                            </c:if> > ${category.name}<br>
                                        </label>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <footer class="row">
                        <nav>
                            <ul class="pagination">
                                <c:if test="${merchandisesPage.criteria.pageNumber > 0}">
                                    <li class="page-item">
                                        <button class="page-link" type="submit"
                                                onclick="document.getElementById('pageNumber').value=${merchandisesPage.criteria.pageNumber - 1}">
                                            <span aria-hidden="true">&laquo;</span>
                                            <span class="sr-only">Предыдущая</span>
                                        </button>
                                    </li>
                                </c:if>
                                <li class="page-item active"><a class="page-link">
                                    Страница ${merchandisesPage.criteria.pageNumber + 1}</a>
                                    <input hidden id="pageNumber" name="pageNumber" value="0"/>
                                </li>
                                <c:if test="${merchandisesPage.criteria.pageNumber + 1 < merchandisesPage.totalElementsNumber / merchandisesPage.criteria.pageSize}">
                                    <li class="page-item">
                                        <button class="page-link" type="submit"
                                                onclick="document.getElementById('pageNumber').value=${merchandisesPage.criteria.pageNumber + 1}">
                                            <span aria-hidden="true">&raquo;</span>
                                            <span class="sr-only">Следующая</span>
                                        </button>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </footer>
                </div>
            </form:form>
        </div>
    </jsp:body>
</t:page-template>