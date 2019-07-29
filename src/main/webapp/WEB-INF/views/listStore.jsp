<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Список магазинов</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазино</jsp:attribute>
    <jsp:body>


        <div class="container-fluid">
            <jsp:include page="profileHeader.jsp"></jsp:include>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel-body">
                        <table class="table table-striped table-bordered">
                            <tr>
                                <th>Название</th>
                                <th>Описание</th>
                                <th>Действие</th>
                            </tr>

                            <!-- loop over and print our users -->
                            <c:forEach var="store" items="${stores}">

                                <!-- construct an "update" link with username id -->
                                <c:url var="updateLink" value="/store/updateStoreForm">
                                    <c:param name="id" value="${store.id}"/>
                                </c:url>


                                <!-- construct an "delete" link with username id -->
                                <c:url var="deleteLink" value="/store/deleteStore">
                                    <c:param name="id" value="${store.id}"/>
                                </c:url>

                                <c:url var="Link" value="/store">
                                    <c:param name="id" value="${store.id}"/>
                                    <%--${pageContext.session.setAttribute("storeId",store.id)}--%>
                                </c:url>
                                ${pageContext.session.setAttribute("storeId",store.id)}
                                <tr>
                                    <td>${store.name}</td>
                                    <td>${store.description}</td>
                                    <td>
                                        <a href="${updateLink}">Изменить</a>
                                        | <a href="${deleteLink}"
                                             onclick="if (!(confirm('Вы хотите удалить магазин ?'))) return false">Удалить</a>
                                        | <a href="${Link}">Перейти в магазин</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>

                        <form class="form-inline">
                            <button type="submit" class="btn btn-primary" formmethod="get"
                                    formaction="${pageContext.request.contextPath}/store/addStoreForm" name="edit">Добавить магазин
                            </button>
                        </form>
                    </div>
                </div>
            </div>

        </div>

    </jsp:body>
</t:page-template>