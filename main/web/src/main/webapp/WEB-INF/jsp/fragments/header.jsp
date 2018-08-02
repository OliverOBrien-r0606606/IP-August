<link type="text/css" rel="stylesheet" href="/css/main.css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="/css/navbar.css" type="text/css">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="nav-bar">
    <c:choose>
        <c:when test="${param.page eq 'Home'}">
            <a href="${pageContext.request.contextPath}/" class="nav-bar-element" id="current">Home</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/" class="nav-bar-element">HOME</a>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${param.page eq'Test'}">
            <a href="${pageContext.request.contextPath}/ADMIN/test" class="nav-bar-element" id="current">Test</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/ADMIN/test" class="nav-bar-element">TEST</a>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${param.page eq'Recipes'}">
            <a href="${pageContext.request.contextPath}/recipe/list" class="nav-bar-element" id="current">Recipes</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/recipe/list" class="nav-bar-element">Recipes</a>
        </c:otherwise>
    </c:choose>
    <sec:authorize access="isAnonymous()">
        <c:choose>
            <c:when test="${param.page eq'Login'}">
                <a href="${pageContext.request.contextPath}/login" class="nav-bar-element login" id="current">Login</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login" class="nav-bar-element login">Log in</a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${param.page eq'Register'}">
                <a href="${pageContext.request.contextPath}/user/register" class="nav-bar-element login" id="current">register</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/user/register" class="nav-bar-element login">Register</a>
            </c:otherwise>
        </c:choose>

    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="${pageContext.request.contextPath}/logout" class="nav-bar-element login" id="current">Log out</a>
    </sec:authorize>

</div>