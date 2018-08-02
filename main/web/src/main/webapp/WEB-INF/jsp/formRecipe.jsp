<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/navbar.css" type="text/css">
<link type="text/css" rel="stylesheet" href="/css/main.css"/>
<html>
<jsp:include page="fragments/head.jsp">
    <jsp:param name="pageName" value="${pageName} Recipe"/>
</jsp:include>
<body>

<jsp:include page="fragments/header.jsp">
    <jsp:param name="page" value="${pageName} Recipe"/>
</jsp:include>

<h2>${pageName} Recipe</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/recipe/${pageName}Recipe" modelAttribute="recipe">
    <table id="item-form">
        <tr><form:input path="id" style="display: none"/></tr>
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
        <tr class="item-form-devider"><spring:message code="recipe.allergies"/>:</tr>
        <tr class="item-form-row">
            <td>
                <form:checkbox path="vegetarian" name="vegitarian" value="vegitarian"/><label for="vegitarian"><spring:message code="recipe.allergies.vegetarian"/></label>
                <form:checkbox path="vegan" name="vegan" value="vegan"/><label for="vegan"><spring:message code="recipe.allergies.vegan"/></label>
                <form:checkbox path="gluten" name="gluten" value="gluten"/><label for="gluten"><spring:message code="recipe.allergies.gluten"/></label>
                <form:checkbox path="lactose" name="lactose" value="lactose"/><label for="lactose"><spring:message code="recipe.allergies.lactose"/></label>
                <form:checkbox path="nuts" name="nut" value="nut"/><label for="nut"><spring:message code="recipe.allergies.nuts"/></label>
            </td>
        </tr>
        <tr class="item-form-devider"><spring:message code="recipe.ingredients"/>:</tr>
        <tr class="item-form-row">
            <table>
                <thead>
                    <th><spring:message code="recipe.ingredients.amount"/></th>
                    <th><spring:message code="recipe.ingredients.unit"/></th>
                    <th><spring:message code="recipe.ingredients.name"/></th>
                </thead>
                <c:forEach var="ingredient" items="${recipe.ingredients}" varStatus="status">
                    <tr>
                        <td><form:input path="ingredients[${status.index}].amount" name="amount"/></td>
                        <td><form:input path="ingredients[${status.index}].unit" name="unit"/></td>
                        <td><form:input path="ingredients[${status.index}].name" name="unit"/></td>
                    </tr>
                </c:forEach>
            </table>
        </tr>
        <tr>
            <form:button value="">${pageName}</form:button>
        </tr>

    </table>
</form:form>

</body>
</html>
