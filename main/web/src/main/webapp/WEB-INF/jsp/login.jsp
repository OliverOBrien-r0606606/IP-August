<%--
  Created by IntelliJ IDEA.
  User: Oli
  Date: 29/07/2018
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<jsp:include page="fragments/head.jsp">
    <jsp:param name="pageName" value="Login"/>
</jsp:include>
<body>
<jsp:include page="fragments/header.jsp">
    <jsp:param name="page" value="Login"/>
</jsp:include>
<H1>LOGIN</H1>
<spring:message code="login.Email-placeholder" var="email-placeholder"/>
<spring:message code="login.Pass-placeholder" var="pass-placeholder"/>
<spring:message code="login.login" var="login"/>

<form:form modelAttribute="User" method="POST"  action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
            <td><spring:message code="login.userName"/> </td>
            <td><form:input path="username" placeholder="${email-placeholder}" /></td>
            <td><form:errors path="username"/></td>
        </tr>
        <tr>
            <td><spring:message code="login.password"/> </td>
            <td><form:password path="password" /></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <input type="submit" value="${login}">
        </tr>
    </table>
</form:form>

</body>
</html>
