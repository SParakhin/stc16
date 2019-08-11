<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Адреса доставки</jsp:attribute>
    <jsp:attribute name="metaDescription">Список адресов доставки</jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
            <jsp:include page="profileHeader.jsp"/>
            <c:set var="index" value="0"/>
            <%--@elvariable id="bookingWithStoresSort" type="java.util.List"--%>
            <c:forEach var="bookingWithMerchandises" items="${bookingWithStoresSort}"><%--@elvariable id="dates" type="java.util.List"--%>
            <%--@elvariable id="totalSums" type="java.util.List"--%>
                <c:forEach var="merchandisesByStore" items="${bookingWithMerchandises.value}">
                    <br>
                    <div class="row">
                        <div class="card w-100">
                            <div class="card-header">
                                <a href="${pageContext.request.contextPath}/store/${merchandisesByStore.key.id}">${merchandisesByStore.key.name} </a>
                            </div>
                            <c:forEach var="merchandise" items="${merchandisesByStore.value}">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <img class="img-fluid" src="${merchandise.merchandise.pictureUrl}"
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
                </c:forEach>
                <div class="row">
                    <h5>Дата заказа: ${dates[index]}</h5>
                </div>
                <div class="row">
                    <h5>Статус заказа: ${bookingWithMerchandises.key.bookingStatus}</h5>
                </div>
                <div class="row">
                    <h5>Всего к оплате: ${totalSums[index]} руб.</h5>
                </div>
                <c:set var="index" value="${index + 1}"/>
            </c:forEach>
        </div>
    </jsp:body>
</t:page-template>