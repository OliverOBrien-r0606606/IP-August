<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/head.jsp">

    <jsp:param name="pageName" value="Recipes"/>
</jsp:include>
<body>
<jsp:include page="fragments/header.jsp">
    <jsp:param name="page" value="Recipes"/>
</jsp:include>

<div id="scriptContainer">
    <script src="${pageContext.request.contextPath}/javascript/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/recipes.js"></script>
</div>

<h2><spring:message code="recipe.listTitle"/></h2>

<spring:message code="recipe.allergies.vegetarian" var="vegetarian"/>
<spring:message code="recipe.allergies.vegan" var="vegan"/>
<spring:message code="recipe.allergies.lactose" var="lactose"/>
<spring:message code="recipe.allergies.gluten" var="gluten"/>
<spring:message code="recipe.allergies.nuts" var="nuts"/>


<div id="table-Container">
    <table id="item-table">
        <thead id="item-table-head">
        <th><spring:message code="recipe.name"/></th>
        <th><spring:message code="recipe.description"/></th>
        <th><spring:message code="recipe.difficulty"/></th>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th><spring:message code="recipe.editRemove"/></th>
        </sec:authorize>
        </thead>
        <tbody id="accordion">
        <c:forEach items="${recipes}" var="recipe">
            <tr class="item" id="${recipe.id}">
                <td>
                    <h4>${recipe.name}</h4>
                    <c:if test="${recipe.vegetarian}">
                        <img src="${pageContext.request.contextPath}/images/vegetarian.gif" class="item-boolean-icon"
                             title="${vegetarian}">
                    </c:if>
                    <c:if test="${recipe.vegan}">
                        <img src="${pageContext.request.contextPath}/images/vegan.gif" class="item-boolean-icon"
                             title="${vegan}">
                    </c:if>
                    <c:if test="${recipe.gluten}">
                        <img src="${pageContext.request.contextPath}/images/gluten.gif" class="item-boolean-icon"
                             title="${gluten}">
                    </c:if>
                    <c:if test="${recipe.lactose}">
                        <img src="${pageContext.request.contextPath}/images/lactose.gif" class="item-boolean-icon"
                             title="${lactose}">
                    </c:if>
                    <c:if test="${recipe.nuts}">
                        <img src="${pageContext.request.contextPath}/images/nut.gif" class="item-boolean-icon"
                             title="${nuts}">
                    </c:if>
                </td>
                <td class="item-expandable">
                    <h6>${recipe.description}</h6>
                </td>
                <td class="item-expandable">
                    <h6>
                        <spring:message code="recipe.difficulty"/>
                        : <c:choose>
                        <c:when test="${fn:length(recipe.ingredients) le 5}"><spring:message
                                code="recipe.difficulty.novice"/></c:when>
                        <c:when test="${fn:length(recipe.ingredients) gt 5}"><spring:message
                                code="recipe.difficulty.advanced"/></c:when>
                        <c:when test="${fn:length(recipe.ingredients) gt 10}"><spring:message
                                code="recipe.difficulty.expert"/></c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                    </h6>
                </td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="${pageContext.request.contextPath}/recipe/edit/${recipe.id}">
                            <img src="${pageContext.request.contextPath}/images/edit.gif" class="alterOption-icon">
                        </a>
                        <a href="${pageContext.request.contextPath}/recipe/delete/${recipe.id}">
                            <img src="${pageContext.request.contextPath}/images/delete.gif" class="alterOption-icon">
                        </a>
                    </td>
                </sec:authorize>
            </tr>
            <tr class="content">
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
    <div>
        <h3><spring:message code="recipe.idea"/></h3>
        <p><spring:message code="recipe.share"/></p>
        <a href="${pageContext.request.contextPath}/recipe/create" class="button big"><spring:message
                code="recipe.button.create"/></a>
    </div>
</sec:authorize>
</body>
</html>
