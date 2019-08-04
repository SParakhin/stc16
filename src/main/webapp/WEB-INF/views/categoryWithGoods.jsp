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
                                <div id="test" class="card" >
                                    <img class="card-img-top" src="${merch.pictureUrl}"
                                         alt="изображение товара ${merch.name}">
                                    <div class="card-body">
                                        <h5 class="card-title">${merch.name}</h5>
                                        <p class="card-text">${merch.description}</p>
                                        <p class="card-text">цена: ${merch.price}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="row">
                        <div class="col">
                            <nav aria-label="goods pagination">
                                <ul class="pagination pagination-lg justify-content-center">
                                    <li class="page-item disabled">
                                        <a class="page-link" href="#" tabindex="-1">1</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

    </jsp:body>
</t:page-template>