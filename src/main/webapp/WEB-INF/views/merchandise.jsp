<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Карточка товара</jsp:attribute>
    <jsp:attribute name="metaDescription">Просмотр товара</jsp:attribute>
    <jsp:body>
        <html>
        <head>
            <title>Карточка товара</title>
        </head>
        <body>
        <div class="row">
            <div class="row">
                <div class="col-9">
                    <div class="product-item">
                        <img src=${merchandiseObject.pictureUrl}>
                        <div class="product-list">
                            <h3>${merchandiseObject.name}</h3>
                            <span class="price">${merchandiseObject.price} руб.</span>
                            <br>
                            <form action="${pageContext.request.contextPath}/merchandise/add" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <input type="hidden" name="merchandiseId" value="${merchandiseObject.id}">
                                <input type="submit" class="button" value="Добавить в корзину"/>
                            </form>

                        </div>
                    </div>
                </div>
                <div class="col-3">
                </div>
            </div>
            <div class="row">
                <div class="col-4">
                    <h3>Описание:</h3>
                    <span class="product">${merchandiseObject.productDetail}</span>
                </div>
            </div>
        </div>
        <div>
        </div>
        </div>
        </body>
        </html>
    </jsp:body>
</t:page-template>