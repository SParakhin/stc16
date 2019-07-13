<%@tag description="Menu page block" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar fixed-top navbar-expand-xl navbar-light bg-light shadow p-3 mb-5" style="opacity: 0.95;">
    <div class="container-fluid font-weight-bold">

        <a class="navbar-brand beauty-title font-weight-normal" style="font-size: 1.5rem;"
           href="${pageContext.request.contextPath}/">Innobazaar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            меню <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto text-lowercase">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">пункт 1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">пункт 2</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/addUserForm">регистрация</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listUsers">пользователи</a>
                </li>
                <li class="nav-item">
						<span class="navbar-brand mb-0 h6">
							<input class="btn btn-success my-2 my-sm-0" type="button" value="Войти"
                                   onclick="window.location.href='login'; return false;"/>
						</span>
                </li>
                <li class="nav-item">
                    <form:form class="form-inline"
                               action="${pageContext.request.contextPath}/logout"
                               method="POST">
							<span class="navbar-brand mb-0 h6">
								<input class="btn btn-warning my-2 my-sm-0" type="submit" value="Выйти">
							</span>
                    </form:form>
                </li>
            </ul>
        </div>
    </div>
</nav>