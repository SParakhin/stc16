<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Добавление адреса доставки</jsp:attribute>
    <jsp:attribute name="metaDescription">Добавление адреса доставки</jsp:attribute>
    <jsp:body>

        <div class="container">
            <div class="col-md-offset-2 col-md-7">
                <h2 class="text-center">Добавление адреса доставки</h2>
                <div class="panel panel-info">
                    <div class="panel-body">


                            <%--@elvariable id="address" type="address"--%>
                        <form:form action="saveAddressToUser" cssClass="form-horizontal"
                                   method="POST" modelAttribute="address">


                        <div class="form-group">
                            <label for="postCode" class="col-md-3 control-label">Почтовый индекс</label>
                            <div class="col-md-9">
                                <form:input path="postCode" cssClass="form-control"/>
                                <form:errors path="postCode" cssClass="alert"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Country" class="col-md-3 control-label">Страна</label>
                            <div class="col-md-9">
                                <form:input path="country" cssClass="form-control"/>
                                <form:errors path="country" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="City" class="col-md-3 control-label">Город</label>
                            <div class="col-md-9">
                                <form:input path="city" cssClass="form-control"/>
                                <form:errors path="city" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Address" class="col-md-3 control-label">Адрес</label>
                            <div class="col-md-9">
                                <form:input path="address" cssClass="form-control"/>
                                <form:errors path="address" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Address" class="col-md-3 control-label">Описание</label>
                            <div class="col-md-9">
                                <form:input path="description" cssClass="form-control"/>
                                <form:errors path="description" cssClass="alert"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                                <form:button cssClass="btn btn-primary">Сохранить данные</form:button>
                            </div>
                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>

    </jsp:body>
</t:page-template>