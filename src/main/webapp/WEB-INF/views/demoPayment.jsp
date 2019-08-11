<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>
        <form:form method="POST" action="/innopay/payments/createPayment"><%--@elvariable id="amount" type="BigDecimal"--%>
        <%--@elvariable id="booking" type="ru.innopolis.stc16.innobazaar.entity.Booking"--%>
        <%--@elvariable id="store" type="ru.innopolis.stc16.innobazaar.dto.Store"--%>
            <div class="form-group">
                <input hidden id="storeName" name="storeName" value="${store.name}"/>
                <input hidden id="secretKey" name="secretKey" value="${store.secretKey}"/>
                <input hidden id="customPaymentId" name="customPaymentId" value="${booking.id}"/>
                <input hidden id="amount" name="amount" value="${amount}"/>
                <input hidden id="returnPage" name="returnPage" value="http://localhost:8080/demoPayment"/>
            </div>
            <button type="submit" class="btn btn-primary">Оплатить</button>
        </form:form>
    </jsp:body>
</t:page-template>