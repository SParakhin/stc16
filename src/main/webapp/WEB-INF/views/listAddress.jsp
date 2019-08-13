<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Адреса доставки</jsp:attribute>
    <jsp:attribute name="metaDescription">Список адресов доставки</jsp:attribute>
    <jsp:body><%--@elvariable id="returnPage" type="String"--%>
        <div class="container-fluid">
            <jsp:include page="profileHeader.jsp"/>
            <div class="row">
                <div class="col-md-auto">
                    <div class="panel-body">
                            <%--@elvariable id="addresses" type="List"--%>
                        <c:if test="${!addresses.isEmpty()}">
                            <table class="table table-striped table-bordered">
                                <tr>
                                    <th>Описание</th>
                                    <th>Идекс</th>
                                    <th>Страна</th>
                                    <th>Город</th>
                                    <th>Адрес</th>
                                    <th>Действие</th>
                                </tr>

                                <!-- loop over and print our users -->
                                <c:forEach var="address" items="${addresses}">

                                    <!-- construct an "update" link with username id -->
                                    <c:url var="updateLink" value="/address/updateAddressForm">
                                        <c:param name="id" value="${address.id}"/>
                                        <c:if test="${returnPage != null}">
                                            <c:param name="returnPage" value="${returnPage}"/>
                                        </c:if>
                                    </c:url>


                                    <!-- construct an "delete" link with username id -->
                                    <c:url var="deleteLink" value="/address/deleteAddress">
                                        <c:param name="id" value="${address.id}"/>
                                        <c:if test="${returnPage != null}">
                                            <c:param name="returnPage" value="${returnPage}"/>
                                        </c:if>
                                    </c:url>

                                    <tr>
                                        <td>${address.description}</td>
                                        <td>${address.postCode}</td>
                                        <td>${address.country}</td>
                                        <td>${address.city}</td>
                                        <td>${address.address}</td>

                                        <td>
                                            <a href="${updateLink}">Изменить</a>
                                            | <a href="${deleteLink}"
                                                 onclick="if (!(confirm('Вы хотите удалить адрес доставки?'))) return false">Удалить</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                        <c:if test="${addresses.isEmpty()}">
                            У Вас нет адресов доставки
                        </c:if>
                        <form class="form-inline">
                            <input hidden id="returnPage" name="returnPage" value="${returnPage}"/>
                            <div class="col-md-auto">
                                <button type="submit" class="btn btn-success" formmethod="get"
                                        formaction="${pageContext.request.contextPath}/address/addAddressForm">Добавить
                                    адрес
                                </button>
                                <c:if test="${returnPage != null}">
                                    <button type="submit" class="btn btn-success" formmethod="get"
                                            formaction="${pageContext.request.contextPath}${returnPage}">Вернуться
                                    </button>
                                </c:if>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page-template>