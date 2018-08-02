<link rel="stylesheet" href="/css/navbar.css" type="text/css">
<link type="text/css" rel="stylesheet" href="/css/main.css"/>
<link type="text/css" rel="stylesheet" href="/css/table.css"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/head.jsp">
    <jsp:param name="pageName" value="Recipes"/>
</jsp:include>
<body>
<jsp:include page="fragments/header.jsp">
    <jsp:param name="page" value="Recipes"/>
</jsp:include>

<h2>Recipes</h2>


<div id="table-Container">
    <table id="item-table">
        <thead id="item-table-head">
            <th>Name</th>
            <th>Description</th>
            <th>Difficulty</th>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th>Edit / Delete</th>
        </sec:authorize>
        </thead>
        <tbody>
            <c:forEach items="${recipes}" var="recipe">
                <tr class="item">
                    <td>
                        <h4>${recipe.name}</h4>
                        <c:if test="${recipe.vegetarian}">
                            <img src="/images/vegetarian.gif" class="item-boolean-icon" title="Vegetarian">
                        </c:if>
                        <c:if test="${recipe.vegan}">
                            <img src="/images/vegan.gif" class="item-boolean-icon" title="Vegan">
                        </c:if>
                        <c:if test="${recipe.gluten}">
                            <img src="/images/gluten.gif" class="item-boolean-icon" title="Contains Gluten">
                        </c:if>
                        <c:if test="${recipe.lactose}">
                            <img src="/images/lactose.gif" class="item-boolean-icon" title="Contains lactose">
                        </c:if>
                        <c:if test="${recipe.nuts}">
                            <img src="/images/nut.gif" class="item-boolean-icon" title="Contains nuts">
                        </c:if>
                    </td>
                    <td class="item-expandable">
                        <h6>${recipe.description}</h6>
                        <div class="expandable-div">
                            ${recipe.directions}
                        </div>
                    </td>
                    <td class="item-expandable">
                        <h6>
                            Difficulty:  <c:choose>
                                            <c:when test="${fn:length(recipe.ingredients) le 5}">Novice</c:when>
                                            <c:when test="${fn:length(recipe.ingredients) gt 5}">Advanced</c:when>
                                            <c:when test="${fn:length(recipe.ingredients) gt 10}">Expert</c:when>
                                            <c:otherwise></c:otherwise>
                                        </c:choose>
                        </h6>
                        <div class="expandable-div">
                            <h6>Ingredients</h6>
                            <table class="sub-item-table">
                                <c:forEach var="ingredient" items="${recipe.ingredients}">
                                    <tr class="sub-item">
                                        <td>${ingredient.amount} ${ingredient.unit}</td>
                                        <td>${ingredient.name}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </td>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <td>
                            <a href="${pageContext.request.contextPath}/recipe/edit/${recipe.id}">
                                <img src="/images/edit.gif" class="alterOption-icon">
                            </a>
                            <a href="${pageContext.request.contextPath}/recipe/delete/${recipe.id}">
                                <img src="/images/delete.gif" class="alterOption-icon">
                            </a>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
    <div>
        <h3>Have and idea for a new scrumptious meal!?</h3>
        <p>Please be our guest and add to our list and spread the love!</p>
        <a href="${pageContext.request.contextPath}/recipe/create" class="button big">Create</a>
    </div>
</sec:authorize>
</body>
</html>
