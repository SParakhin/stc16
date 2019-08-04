<%@tag description="Menu page block" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar fixed-top navbar-expand-xl navbar-light bg-light shadow p-3 mb-5" style="opacity: 0.95;">
    <div class="container-fluid">

        <a class="navbar-brand beauty-title font-weight-normal" style="font-size: 1.5rem;"
           href="${pageContext.request.contextPath}/">Innobazaar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <ul class="navbar-nav mr-auto text-lowercase">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        категории
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:forEach items="${cats}" var="cat">
                            <c:url var="openCatPage" value="/cat/openWithGoods">
                                <c:param name="catName" value="${cat.value}"/>
                                <c:param name="pageNumber" value="1"/>
                            </c:url>
                            <a class="dropdown-item" href="${openCatPage}">${cat.key}</a>
                        </c:forEach>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listUsers">пользователи</a>
                </li>
            </ul>

            <span class="navbar-text">
                <security:authorize access="isAnonymous()">
                    <span class=" mb-0 h6">
                        <input class="btn btn-success my-2 my-sm-0" type="button" value="Войти"
                               onclick="window.location.href='login'; return false;"/>
                    </span>
                </security:authorize>
                <security:authorize access="isAuthenticated()">

                <ul class="navbar-nav ml-auto">
                    <li class="navbar-item mt-1 mr-3">вы вошли как:

                        <!-- Example split danger button -->
<li class="btn-group">
  <button type="button" class="btn btn-success"> <security:authentication property="principal.username"/></button>
  <button type="button" class="btn btn-success dropdown-toggle dropdown-toggle-split" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/updateUserForm">Мои профиль</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/store/listStore">Мои магазины</a>
    <a class="dropdown-item" href="#">Мои заказы</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/address/listAddress">Мои адреса доставки</a>
  </div>
</li>
             <li class="navbar-item">
            <form:form cssClass="form-inline" action="${pageContext.request.contextPath}/logout"
                       method="POST">
                <input class="btn btn-warning" type="submit" value="Выйти">
            </form:form>
        </li>
        </ul>
                </security:authorize>
        </span>

        </div>

    </div>
</nav>