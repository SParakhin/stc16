<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Результат оплаты</jsp:attribute>
    <jsp:body><%--@elvariable id="paymentResult" type="ru.innopolis.stc16.innopay.dto.PaymentResult"--%>
        <form method="POST" action="${pageContext.request.contextPath}/payments/returnToStore">
            <div class="form-group">
                <label>${paymentResult.result}</label>
            </div>
            <input hidden id="returnPage" name="returnPage" value="${paymentResult.returnPage}"/>
            <button type="submit" class="btn btn-primary">Вернуться в магазин</button>
        </form>
    </jsp:body>
</t:page-template>
