<link type="text/css" rel="stylesheet" href="/css/main.css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/navbar.css" type="text/css">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="script" uri="http://www.springframework.org/tags" %>

<div id="nav-bar">
    <c:choose>
        <c:when test="${param.page eq 'Home'}">
            <a href="${pageContext.request.contextPath}/home" class="nav-bar-element" id="current"><spring:message code="navigationBar.home"/></a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/home" class="nav-bar-element"><spring:message code="navigationBar.home"/></a>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${param.page eq'Test'}">
            <a href="${pageContext.request.contextPath}/ADMIN/test" class="nav-bar-element" id="current"><spring:message code="navigationBar.test"/></a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/ADMIN/test" class="nav-bar-element"><spring:message code="navigationBar.test"/></a>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${param.page eq'Recipes'}">
            <a href="${pageContext.request.contextPath}/recipe/list" class="nav-bar-element" id="current"><spring:message code="navigationBar.recipes"/></a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/recipe/list" class="nav-bar-element"><spring:message code="navigationBar.recipes"/></a>
        </c:otherwise>
    </c:choose>
    <sec:authorize access="isAnonymous()">
        <c:choose>
            <c:when test="${param.page eq'Login'}">
                <a href="${pageContext.request.contextPath}/login" class="nav-bar-element login" id="current"><spring:message code="navigationBar.login"/></a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login" class="nav-bar-element login"><spring:message code="navigationBar.login"/></a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${param.page eq'Register'}">
                <a href="${pageContext.request.contextPath}/user/register" class="nav-bar-element login" id="current"><spring:message code="navigationBar.register"/></a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/user/register" class="nav-bar-element login"><spring:message code="navigationBar.register"/></a>
            </c:otherwise>
        </c:choose>

    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="${pageContext.request.contextPath}/logout" class="nav-bar-element login" id="current"><spring:message code="navigationBar.logout"/></a>
    </sec:authorize>

    <div class="nav-bar-element right">
        <div><script:message code="language.language"/></div>
        <a href="?lang=en">EN</a> /
        <a href="?lang=fr">FR</a> /
        <a href="?lang=nl">NL</a>
    </div>


</div>