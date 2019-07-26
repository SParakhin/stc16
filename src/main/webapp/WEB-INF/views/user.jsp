<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<%--<t:page-template>--%>
    <%--<jsp:attribute name="titleText">Профиль пользователя</jsp:attribute>--%>
    <%--<jsp:attribute name="metaDescription">Профиль пользователя</jsp:attribute>--%>

    <%--<jsp:body>--%>

        <%--<ul class="nav nav-tabs" id="MyTab">--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link active" data-toggle="tab" href="#profile">Мой профиль</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" data-toggle="tab" href="#address">Мои адреса</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" data-toggle="tab" href="#store">Мои магазины</a>--%>
            <%--</li>--%>
        <%--</ul>--%>

        <%--<!-- Tab panes -->--%>
        <%--<div class="tab-content">--%>
            <%--<div class="tab-pane container active" id="profile">--%>
                <%--<jsp:include page="${pageContext.request.contextPath}/user/updateUserForm"></jsp:include>--%>
                    <%--&lt;%&ndash;<c:if test="${pageContext.request.getAttribute('userId')==null}">&ndash;%&gt;--%>

                    <%--&lt;%&ndash;<script>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$('#MyTab a[href="#address"]').tab('show')&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</script>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<jsp:include page="${pageContext.request.contextPath}/address/listAddress"></jsp:include>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
                <%--<script>--%>
                    <%--$('#MyTab a[href="#profile"]').tab('shown')--%>
                <%--</script>--%>


            <%--</div>--%>
            <%--<div class="tab-pane container fade" id="address">--%>
                <%--<jsp:include page="${pageContext.request.contextPath}/address/listAddress"></jsp:include>--%>
                <%--<script>--%>
                    <%--$('#MyTab a[href="#address"]').tab('show')--%>
                <%--</script>--%>
            <%--</div>--%>
            <%--<div class="tab-pane container fade" id="store">...</div>--%>
        <%--</div>--%>


    <%--</jsp:body>--%>
<%--</t:page-template>--%>
