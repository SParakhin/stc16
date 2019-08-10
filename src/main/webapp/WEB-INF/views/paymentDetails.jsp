<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Детали платежа</jsp:attribute>
    <jsp:attribute name="metaDescription">Просмотр деталей платежа</jsp:attribute>
    <jsp:body><%--@elvariable id="date" type="String"--%>
        <%--@elvariable id="payment" type=" ru.innopolis.stc16.innobazaar.dto.Payment"--%>
        <%--@elvariable id="returnPage" type="String"--%>
        <div class="col-md-12 card-body">
            <c:if test="${payment != null}">
                <h5>Дата: ${date}</h5>
                <h5>Номер карты: ${payment.cardNumber}</h5>
                <h5>Сумма: ${payment.amount}</h5>
            </c:if>
            <c:if test="${payment == null}">
                <h5>Не найдена информация о платеже</h5>
            </c:if>
            <h5>
                <a href="${returnPage}">Вернуться</a>
            </h5>
        </div>
    </jsp:body>
</t:page-template>