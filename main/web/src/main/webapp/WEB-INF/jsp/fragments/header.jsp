<link type="text/css" rel="stylesheet" href="/css/main.css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/navbar.css" type="text/css">

<div id="nav-bar">
    <c:choose>
        <c:when test="${param.page eq 'Home'}">
            <a href="${pageContext.request.contextPath}/home" class="nav-bar-element" id="current">Home</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/home" class="nav-bar-element">HOME</a>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${param.page eq'Test'}">
            <a href="${pageContext.request.contextPath}/test" class="nav-bar-element" id="current">Test</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/test" class="nav-bar-element">TEST</a>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${param.page eq'Login'}">
            <a href="${pageContext.request.contextPath}/user/toLogin" class="nav-bar-element" id="current">Login</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/user/toLogin" class="nav-bar-element">Login</a>
        </c:otherwise>
    </c:choose>
</div>