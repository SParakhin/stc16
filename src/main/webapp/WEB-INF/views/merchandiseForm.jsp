<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Карточка товара</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис создания личных магазинов</jsp:attribute>
    <jsp:body>

        <div class="container-fluid">
            <h2 class="text-center">Карточка товара</h2>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel-body">
                        <form:form action="saveProduct" cssClass="form-horizontal"
                                   method="POST" modelAttribute="merchandise">
                        <form:hidden path="id"></form:hidden>
                        <div class="form-group">
                            <div class="col-md-auto">
                                <label for="name">Название</label>
                                <form:input path="name" cssClass="form-control"/>
                                <form:errors path="name" cssClass="alert"/>
                                <label for="description">Описание</label>
                                <form:input path="description" cssClass="form-control"/>
                                <form:errors path="description" cssClass="alert"/>
                                    <%--<label for="category">Категория товара</label>--%>
                                    <%--<form:input path="category" cssClass="form-control"/>--%>
                                    <%--<form:errors path="category" cssClass="alert"/>--%>
                                    <%--<div class="form-group">--%>

                                <%--<label for="categoryName">Выберите категорию:</label>--%>
                                <%--<select class="form-control" id="categoryName">--%>
                                    <%--<option>--------------</option>--%>
                                    <%--<c:forEach var="category" items="${categories}">--%>
                                        <%--<option>${category.name}</option>--%>

                                        <%--&lt;%&ndash;${pageContext.session.setAttribute("categoryName",category.name)}&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<c:if test="${category.name eq pageContext.getAttribute(category)}">&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;${pageContext.session.setAttribute("categoryName",category.name)}&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
                                    <%--</c:forEach>--%>

                                <%--</select>--%>


                                    <%--</div>--%>
                                    <label for="categoryName">Выберите категорию:</label>
                                <form:select path="categoryName" cssClass="form-control">
                                    <form:option value="-" label="--Please Select--"/>
                                    <c:forEach var="category" items="${categories}">
                                        <option>${category.name}</option>
                                    </c:forEach>
                                    <%--<form:options items="${category.name}" />--%>
                                </form:select>

                                    <%--<form:select path="categoryName">--%>
                                    <%--<form:option value="-" label="--Please Select--"/>--%>
                                    <%--&lt;%&ndash;<form:options items="${categories}"/>&ndash;%&gt;--%>
                                    <%--<c:forEach var="category" items="${categories}">--%>
                                    <%--<form:options items="${category.name}"/>--%>
                                    <%--</c:forEach>--%>
                                    <%--</form:select>--%>

                                <label for="price">Цена</label>
                                <form:input path="price" cssClass="form-control"/>
                                <form:errors path="price" cssClass="alert"/>
                                <label for="pictureUrl">Изображение</label>
                                <form:input path="pictureUrl" cssClass="form-control"/>
                                <form:errors path="pictureUrl" cssClass="alert"/>

                                <div class="form-group">
                                    <!-- Button -->
                                    <div class="col-md-offset-3 col-md-9">
                                        <c:if test="${pageContext.request.getAttribute('newProduct')!=null}">
                                            <form:button cssClass="btn btn-primary">Сохранить</form:button>
                                        </c:if>
                                    </div>
                                </div>


                                <c:if test="${pageContext.request.getAttribute('newProduct')==null}">
                                    <form class="form-inline">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <button type="submit" id="updateButton" class="btn btn-primary"
                                                formmethod="POST"
                                                formaction="${pageContext.request.contextPath}/product/updateProduct"
                                                name="edit">
                                            Сохранить изменения
                                        </button>
                                    </form>
                                </c:if>


                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page-template>