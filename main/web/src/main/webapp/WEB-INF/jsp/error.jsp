<%--
  Created by IntelliJ IDEA.
  User: Oli
  Date: 22/08/2018
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">

<html>
<head>
    <jsp:include page="fragments/head.jsp">
        <jsp:param name="pageName" value="Oops!"/>
    </jsp:include>
</head>
<body>


<jsp:include page="fragments/header.jsp">
    <jsp:param name="page" value="Oops!"/>
</jsp:include>
<div id="center">
    <img src="${pageContext.request.contextPath}/images/oops.png" class="item-boolean-icon">
    <h1>Oops!...</h1>
    <h2>Something went wrong..</h2>
    <table>

        <tr>
            <td>Date</td>
            <td>${timestamp}</td>
        </tr>
        <tr>
            <td>Error</td>
            <td>${error}</td>
        </tr>
        <tr>
            <td>Status</td>
            <td>${status}</td>
        </tr>
        <tr>
            <td>Message</td>
            <td>${message}</td>
        </tr>
        <tr>
            <td>Exception</td>
            <td>${exception}</td>
        </tr>
        <tr>
            <td>Trace</td>
            <td>
                <pre>${trace}</pre>
            </td>
        </tr>

    </table>
    <h2>We will find out what went wrong.</h2>
</div>



</body>
</html>
