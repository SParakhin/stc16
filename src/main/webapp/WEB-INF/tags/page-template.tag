<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@attribute name="titleText" fragment="true" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">

    <title>
        <jsp:invoke fragment="titleText"/>
    </title>

</head>

<body>

<jsp:doBody/>

</body>

</html>