<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/navbar.css" type="text/css">
<link type="text/css" rel="stylesheet" href="/css/main.css"/>
<link type="text/css" rel="stylesheet" href="/css/formRecipe.css"/>
<html>
<spring:message code="page.title.${pageName}" var="title"/>
<jsp:include page="fragments/head.jsp">
    <jsp:param name="pageName" value="${title}"/>
</jsp:include>
<body>

<jsp:include page="fragments/header.jsp">
    <jsp:param name="page" value="${pageName} Recipe"/>
</jsp:include>

<h2>${pageName} <spring:message code="recipe.recipeTitle"/> </h2>

<spring:message code="recipe.ingredients" var="ingredients"/>
<spring:message code="recipe.allergies" var="alergies"/>
<form:form method="POST" action="" modelAttribute="recipe" id="submit">
    <table id="item-form">
        <tr ><form:input path="id" style="visibility: hidden"/></tr>
        <tr class="item-form-row">
            <td><label for="name"><spring:message code="recipe.name"/></label></td>
            <td><form:input path="Name" name="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr class="item-form-row">
            <td><label for="description"><spring:message code="recipe.description"/></label></td>
            <td><form:textarea path="description" name="description" rows="3" cols="50"/></td>
            <td><form:errors path="description"/></td>
        </tr>
        <tr class="item-form-row">
            <td><label for="directions"><spring:message code="recipe.directions"/></label></td>
            <td><form:textarea path="directions" name="directions" rows="10" cols="100"/></td>
            <td><form:errors path="directions"/></td>
        </tr>
        <tr class="item-form-devider 3"><h3 class="move" name="3">${alergies}:</h3></tr>
        <tr class="item-form-row">
            <td>
                <span class="checkbox" id="vegetarian"><spring:message code="recipe.allergies.vegetarian"/></span>
                <span class="checkbox" id="vegan"><spring:message code="recipe.allergies.vegan"/></span>
                <span class="checkbox" id="gluten"><spring:message code="recipe.allergies.gluten"/></span>
                <span class="checkbox" id="lactose"><spring:message code="recipe.allergies.lactose"/></span>
                <span class="checkbox" id="nuts"><spring:message code="recipe.allergies.nuts"/></span>
            </td>
        </tr>
        <tr class="item-form-devider 2"><h3 class="move" name="2">${ingredients}:</h3></tr>
        <tr class="item-form-row 1">
            <table class="move" name="1">
                <thead>
                <th><spring:message code="recipe.ingredients.amount"/></th>
                <th><spring:message code="recipe.ingredients.unit"/></th>
                <th><spring:message code="recipe.ingredients.name"/></th>
                </thead>
                <tbody>
                <c:forEach var="ingredient" items="${recipe.ingredients}" varStatus="status">
                    <tr class="list-item">
                        <td class="toNumber amount"><form:input path="ingredients[${status.index}].amount" name="amount"/></td>
                        <td class="todropdown unit"><form:input path="ingredients[${status.index}].unit" name="unit"/></td>
                        <td class="name"><form:input path="ingredients[${status.index}].name" name="unit"/></td>
                        <td>
                            <a href="#" class="item-remove-button">
                                <img src="/images/remove.gif" alt="add" title="remove ${ingredient.name}"
                                     class="alterOption-icon">
                            </a></td>
                    </tr>
                </c:forEach>
                <tr id="list-item-new">
                    <a href="#" onclick="addIngredientLine()">
                        <img src="/images/add.gif" alt="add" title="Add ingredient" class="alterOption-icon">
                    </a>
                </tr>
                </tbody>
            </table>
        </tr>
        <tr>
            <button type="button" onclick="newRecipe()"><spring:message code="button.send"/></button>
        </tr>

    </table>
</form:form>
<div id="ScriptContainer">
    <script type="text/javascript" src="/javascript/jquery.js"></script>
    <script type="text/javascript" src="/javascript/newRecipe.js"></script>
</div>
</body>
</html>
