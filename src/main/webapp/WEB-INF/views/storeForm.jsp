<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Изменение/добавление магазина</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="col-md-offset-2 col-md-7">
                <c:if test="${pageContext.request.getAttribute('newStore')==null}">
                    <h2 class="text-center">Изменение свойств магазина</h2>
                </c:if>
                <c:if test="${pageContext.request.getAttribute('newStore')!=null}">
                    <h2 class="text-center">Создание магазина</h2>
                </c:if>
                <div class="panel panel-info">
                    <div class="panel-body">

                        <form:form action="saveStoreToUser" cssClass="form-horizontal"
                                   method="POST" modelAttribute="store">
                        <form:hidden path="id"/>

                        <div class="form-group">
                            <label for="name" class="col-md-3 control-label">Название</label>
                            <div class="col-md-9">
                                <form:input path="name" cssClass="form-control"/>
                                <form:errors path="name" cssClass="alert"/>
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
                                <c:if test="${pageContext.request.getAttribute('newStore')!=null}">
                                    <form:button cssClass="btn btn-success"
                                                 name="saveButton">Сохранить данные</form:button>
                                </c:if>
                            </div>
                        </div>
                    </div>

                    <c:if test="${pageContext.request.getAttribute('newStore')==null}">
                        <form class="form-inline">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit" id="updateButton" class="btn btn-success" formmethod="POST"
                                    formaction="${pageContext.request.contextPath}/store/updateStore" name="edit">
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
