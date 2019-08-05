<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Ввод данных платёжной карты</jsp:attribute>
    <jsp:body><%--@elvariable id="payment" type="ru.innopolis.stc16.innopay.dto.PaymentRequest"--%>
        <div class="creditCardForm">
            <div class="heading">
                <h1>Подтвердите покупку</h1>
            </div>
            <div class="payment">
                <form method="POST" action="${pageContext.request.contextPath}/payments/processPayment">
                    <input hidden id="store" name="store" value="${payment.storeName}"/>
                    <input hidden id="id" name="id" value="${payment.customPaymentId}"/>
                    <input hidden id="amount" name="amount" value="${payment.amount}"/>
                    <div class="form-group store">
                        <label>Магазин: ${payment.storeName}</label>
                    </div>
                    <div class="form-group amount">
                        <label>Сумма: ${payment.amount}</label>
                    </div>
                    <div class="form-group hr">
                        <hr>
                    </div>
                    <div class="form-group owner">
                        <label for="owner">Владелец карты</label>
                        <input type="text" class="form-control" id="owner">
                    </div>
                    <div class="form-group CVV">
                        <label for="cvv">CVV</label>
                        <input type="text" class="form-control" id="cvv">
                    </div>
                    <div class="form-group" id="card-number-field">
                        <label for="cardNumber">Номер карты</label>
                        <input type="text" class="form-control" id="cardNumber" name="cardNumber">
                    </div>
                    <div class="form-group" id="expiration-date">
                        <label>Срок действия</label>
                        <select>
                            <option value="01">Январь</option>
                            <option value="02">Февраль</option>
                            <option value="03">Март</option>
                            <option value="04">Апрель</option>
                            <option value="05">Май</option>
                            <option value="06">Июнь</option>
                            <option value="07">Июль</option>
                            <option value="08">Август</option>
                            <option value="09">Сентябрь</option>
                            <option value="10">Октябрь</option>
                            <option value="11">Ноябрь</option>
                            <option value="12">Декабрь</option>
                        </select>
                        <select>
                            <option value="19"> 2019</option>
                            <option value="20"> 2020</option>
                            <option value="21"> 2021</option>
                            <option value="22"> 2022</option>
                            <option value="23"> 2023</option>
                            <option value="24"> 2024</option>
                        </select>
                    </div>
                    <div class="form-group" id="credit_cards">
                        <img src="${pageContext.request.contextPath}/resources/img/visa.jpg" id="visa">
                        <img src="${pageContext.request.contextPath}/resources/img/mastercard.jpg" id="mastercard">
                        <img src="${pageContext.request.contextPath}/resources/img/amex.jpg" id="amex">
                    </div>
                    <div class="form-group" id="pay-now">
                        <button type="submit" class="btn btn-default" id="confirm-purchase">Подтвердить</button>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</t:page-template>