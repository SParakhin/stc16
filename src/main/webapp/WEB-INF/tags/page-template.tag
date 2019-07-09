<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@attribute name="titleText" fragment="true" %>
<%@attribute name="metaDescription" fragment="true" %>

<!DOCTYPE html>
<html lang="ru">

<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="<jsp:invoke fragment="metaDescription"/>">

    <title>
        <jsp:invoke fragment="titleText"/>
    </title>
</head>

<body>
<jsp:doBody/>
</body>

</html>