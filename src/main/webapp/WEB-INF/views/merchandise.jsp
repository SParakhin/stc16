<%--
  Created by IntelliJ IDEA.
  User: Рамиль
  Date: 18.07.2019
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
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
                            <img src=${merchandiseObject.imageURL}>
                            <div class="product-list">
                                <h3>${merchandiseObject.name}</h3>
                                <span class="price">${merchandiseObject.price} руб.</span>
                                <br>
                                <a href="" class="button">Добавить в корзину</a>
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