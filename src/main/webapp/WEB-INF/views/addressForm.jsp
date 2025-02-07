<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Изменение адреса</jsp:attribute>
    <jsp:attribute name="metaDescription">Изменение адреса доставки</jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="col-md-offset-2 col-md-7">
                <c:if test="${pageContext.request.getAttribute('newAddress')==null}">
                    <h2 class="text-center">Изменение адреса доставки</h2>
                </c:if>
                <c:if test="${pageContext.request.getAttribute('newAddress')!=null}">
                    <h2 class="text-center">Добавление адреса доставки</h2>
                </c:if>
                <div class="panel panel-info">
                    <div class="panel-body">

                        <form:form action="saveAddressToUser?returnPage=${returnPage}" cssClass="form-horizontal"
                                   method="POST" modelAttribute="address">
                        <form:hidden path="id"/>

                        <div class="form-group">
                            <label for="postCode" class="col-md-3 control-label">Индекс</label>
                            <div class="col-md-9">
                                <form:input path="postCode" cssClass="form-control"/>
                                <form:errors path="postCode" cssClass="alert"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="country" class="col-md-3 control-label">Страна</label>
                            <div class="col-md-9">
                                <form:input path="country" cssClass="form-control"/>
                                <form:errors path="country" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="city" class="col-md-3 control-label">Город</label>
                            <div class="col-md-9">
                                <form:input path="city" cssClass="form-control"/>
                                <form:errors path="city" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="address" class="col-md-3 control-label">Адрес</label>
                            <div class="col-md-9">
                                <form:input path="address" cssClass="form-control"/>
                                <form:errors path="address" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="description" class="col-md-3 control-label">Описание</label>
                            <div class="col-md-9">
                                <form:input path="description" cssClass="form-control"/>
                                <form:errors path="description" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${pageContext.request.getAttribute('newAddress')!=null}">
                                    <form:button class="btn btn-success"
                                                 name="saveButton">Сохранить данные</form:button>
                                </c:if>
                            </div>
                        </div>
                    </div>

                    <c:if test="${pageContext.request.getAttribute('newAddress')==null}">
                        <form class="form-inline">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input hidden id="returnPage" name="returnPage" value="${returnPage}"/>
                            <button type="submit" id="updateButton" class="btn btn-success" formmethod="POST"
                                    formaction="${pageContext.request.contextPath}/address/updateAddress" name="edit">
                                Сохранить изменения
                            </button>
                        </form>
                    </c:if>

                    </form:form>

                </div>
            </div>
        </div>
    </jsp:body>
</t:page-template>