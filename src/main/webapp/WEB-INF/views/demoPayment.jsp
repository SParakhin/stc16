<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>
        <form:form method="POST" action="/innopay/payments/createPayment">
            <div class="form-group">
                <input hidden id="storeName" name="storeName" value="test"/>
                <input hidden id="secretKey" name="secretKey" value="4728ac9e-4618-44ea-8a55-c915c1b33b43"/>
                <input hidden id="customPaymentId" name="customPaymentId" value="1"/>
                <input hidden id="amount" name="amount" value="5.00"/>
                <input hidden id="returnPage" name="returnPage" value="http://localhost:8080/demoPayment"/>
            </div>
            <button type="submit" class="btn btn-primary">Оплатить</button>
        </form:form>
    </jsp:body>
</t:page-template>