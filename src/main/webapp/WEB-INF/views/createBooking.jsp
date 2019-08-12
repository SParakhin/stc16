<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>
        <div class="container justify-content-center">
            <div class="row">
                <div class="col-md-12 text-center">
                    <div class="alert alert-success text-center" role="alert">
                        <h2>Ваш заказ</h2>
                    </div>

                </div>
            </div>
            <form:form method="POST" action="${pageContext.request.contextPath}/booking/save">
                <c:forEach var="merchandisesByStore" items="${merchandisesByStores}">

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
                                            <img class="img-fluid" src="${merchandise.key.pictureUrl}"
                                                 alt="Нет картинки"
                                                 style="width: 60px;">
                                        </div>
                                        <div class="col-md-4">
                                            <a href="${pageContext.request.contextPath}/merchandise?id=${merchandise.key.id}"> ${merchandise.key.name} </a>
                                        </div>
                                        <div class="col-md-4">
                                            <strong>${merchandise.key.price} руб.</strong>
                                        </div>
                                        <div class="col-md-2">
                                            <strong>${merchandise.value} шт.</strong>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
                <div class="row">
                    <h5> Всего к оплате: ${totalSum} руб.</h5>
                </div>
                <div class="card">
                    <div class="row">
                        <div class="col-md-12">
                            <strong>Ваши данные: </strong>
                            <div class="row">
                                <div class="col-md-12">
                                    <label>Имя</label>
                                    <div> ${user.firstName} </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class=" col-md-12">
                                    <label>Фамилия</label>
                                    <div>${user.lastName}</div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label>Телефон</label>
                                    <div>${user.phone}</div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <label>Email</label>
                                    <div>${user.email}</div>
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-md-12">
                                    <a href="${pageContext.request.contextPath}/user/updateUserForm">Изменить личные данные</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <c:if test="${fn:length(user.addressList) == 0}">
                        <strong>Список ваших адресов пуст. Необходимо добавить хотя бы один адрес</strong>
                        <a href="${pageContext.request.contextPath}/address/listAddress">Добавить адрес</a>
                    </c:if>
                    <c:if test="${fn:length(user.addressList) != 0}">
                        <div class="form-group">
                            <strong>Выберите адрес доставки:</strong>
                            <label>
                                <select class="form-control" name="addressId">
                                    <c:forEach var="address_" items="${user.addressList}">
                                        <option value="${address_.id}">${address_.country}, ${address_.city}, ${address_.postCode}, ${address_.address}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                    </c:if>
                </div>
                <div class="row">
                    <div class="col-md-auto">
                        <button class="btn btn-lg btn-success" type="submit" <c:if
                                test="${fn:length(user.addressList) == 0}"> disabled="disabled" </c:if> >Подтвердить
                            заказ
                        </button>
                    </div>
                </div>
            </form:form>
        </div>
    </jsp:body>
</t:page-template>