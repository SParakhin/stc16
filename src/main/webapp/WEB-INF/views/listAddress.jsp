<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Адреса доставки</jsp:attribute>
    <jsp:attribute name="metaDescription">Список адресов доставки</jsp:attribute>
    <jsp:body>


        <div class="container-fluid">
            <jsp:include page="profileHeader.jsp"></jsp:include>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel-body">
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
                                </c:url>


                                <!-- construct an "delete" link with username id -->
                                <c:url var="deleteLink" value="/address/deleteAddress">
                                    <c:param name="id" value="${address.id}"/>
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

                        <form class="form-inline">
                            <button type="submit" class="btn btn-primary" formmethod="get"
                                    formaction="${pageContext.request.contextPath}/address/addAddressForm" name="edit">Добавить адрес
                            </button>
                        </form>
                    </div>
                </div>
            </div>

        </div>

    </jsp:body>
</t:page-template>