<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="/css/index.css">
<html>
<head>
    <title>Foodz.</title>
</head>
<body style="display: none">
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/index.js"></script>
<img id="banner" src="${pageContext.request.contextPath}/images/Foodz_Logo.png">

<h1 id="welcome">Welcome to Foodz.!&trade;</h1>

<div id="OptionContainer">
    <div class="languageSelect">
        <img class="languageImg" src="${pageContext.request.contextPath}/images/english.png"/>
        <h1>English</h1>
        <h4 class="subNote">Proceed in English</h4>
        <h4 style="visibility: hidden" class="welcomeNote">Welcome to Foodz.!&trade;</h4>
        <h4 style="visibility: hidden" class="lang">EN</h4>
    </div>

    <div class="languageSelect">
        <img class="languageImg" src="${pageContext.request.contextPath}/images/nederlands.png"/>
        <h1>Nederlands</h1>
        <h4 class="subNote">In het Nederlands verder gaan</h4>
        <h4 style="visibility: hidden" class="welcomeNote">Welkom bij Foodz.!&trade;</h4>
        <h4 style="visibility: hidden" class="lang">NL</h4>
    </div>

    <div class="languageSelect">
        <img class="languageImg" src="${pageContext.request.contextPath}/images/french.png"/>
        <h1>Français</h1>
        <h4 class="subNote">Continuer en français</h4>
        <h4 style="visibility: hidden" class="welcomeNote">Bievenue chez Foodz.!&trade;</h4>
        <h4 style="visibility: hidden" class="lang">FR</h4>
    </div>
</div>
</body>
</html>
