<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="fragments/head.jsp">
        <jsp:param name="pageName" value="Registrationr"/>
    </jsp:include>
<body>
<jsp:include page="fragments/header.jsp">
    <jsp:param name="page" value="Register"/>
</jsp:include>
<H1>REGISTRATION</H1>
<spring:message code="login.Email-placeholder" var="email-placeholder"/>
<spring:message code="login.Pass-placeholder" var="pass-placeholder"/>
<spring:message code="registration.submit" var="login"/>

<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/user/register">
    <table>
        <tr>
            <td><spring:message code="registration.username"/></td>
            <td><form:input path="username"/></td>
            <td><form:errors path="username"/></td>
        </tr>
        <tr>
            <td><spring:message code="registration.email"/></td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email"/></td>
        </tr>
        <tr>
            <td><spring:message code="registration.password"/></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <td><spring:message code="registration.confirmPassword"/></td>
            <td><form:password path="confirmPassword"/></td>
            <td><form:errors path="confirmPassword"/></td>
        </tr>
        <tr>
            <td><spring:message code="registration.name"/></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><spring:message code="registration.sirname"/></td>
            <td><form:input path="sirName"/></td>
            <td><form:errors path="sirName"/></td>
        </tr>

        <tr>
            <input type="submit" value="${login}">
        </tr>
    </table>
</form:form>

</body>
</html>
</title>
</head>
<body>

</body>
</html>
