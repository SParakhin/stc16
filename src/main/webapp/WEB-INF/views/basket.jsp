<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Корзина</jsp:attribute>
    <jsp:attribute name="metaDescription">Просмотр корзины</jsp:attribute>
    <jsp:body>
        <div class="cart_info">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <!-- Column Titles -->
                        <div class="cart_info_columns clearfix">
                            <div class="cart_info_col cart_info_col_product">Товар</div>
                            <div class="cart_info_col cart_info_col_price">Цена</div>
                        </div>
                    </div>
                </div>
                <div class="row cart_items_row">
                    <div class="col">

                        <!-- Cart Item -->
                        <c:forEach var="merchandise" items="${basket}">
                            <div class="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
                                <!-- Name -->
                                <div class="cart_item_product d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_item_image">
                                        <div><img src=${merchandise.pictureUrl} alt=""></div>
                                    </div>
                                    <div class="cart_item_name_container">
                                        <div class="cart_item_name"><a href="#">${merchandise.name}</a></div>
                                    </div>
                                </div>
                                <!-- Price -->
                                <div class="cart_item_price">${merchandise.price}</div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="col-lg-6 offset-lg-2">
                    <div class="cart_total">
                        <div class="section_title">Cart total</div>
                        <div class="section_subtitle">Final info</div>
                        <div class="cart_total_container">
                            <ul>
                                <c:forEach var="merchandise" items="${basket}">
                                    <li class="d-flex flex-row align-items-center justify-content-start">
                                        <div class="cart_total_title">Subtotal</div>
                                        <div class="cart_total_value ml-auto">${merchandise.price}</div>
                                    </li>
                                </c:forEach>
                                <li class="d-flex flex-row align-items-center justify-content-start">
                                    <div class="cart_total_title">Total</div>
                                    <%--<div class="cart_total_value ml-auto">${totalSum}</div>--%>
                                </li>
                            </ul>
                            <button class="newsletter_button">Оплатить</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </jsp:body>
</t:page-template>

