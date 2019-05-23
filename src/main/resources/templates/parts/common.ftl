<#macro page >
    <#import "login.ftl" as l>
    <#include "security.ftl">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Wonderland</title>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/static/main.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">
    <link rel="stylesheet" href="/static/reset.css">
    <link rel="stylesheet" href="/static/style.css">
    <link rel="stylesheet" href="/static/lightbox/css/lightbox.min.css">
</head>
<body>
<#if isAdmin>
<div id="admin-wrapper">
    <div id="admin" class="container">
        <div id="admin-name">
            <h1><a href="/">${name}</a></h1>
        </div>
        <div id="admin-menu">

            <ul>
                <li><a href="/createpost" accesskey="1" title="">Добавити Новину</a></li>
                <li><a href="/messages" accesskey="1" title="">Бронювання</a></li>
                <li><a href="/createdish" accesskey="2" title="">Добавити страву</a></li>
                <li><a href="/createreport" accesskey="3" title="">Добавити Фотозвіт</a></li>
                <li><@l.logout /></li>
            </ul>
        </div>
    </div>
</div>
</#if>
<div id="banner-wrapper"></div>
<div id="header-wrapper">
    <div id="header" class="container">
        <div id="logo">
            <h1><a href="/">Wonderland</a></h1>
        </div>
        <div id="menu">
            <ul>
                <li><a href="/posts" accesskey="1" title="">Новини</a></li>
                <li><a href="/menu" accesskey="2" title="">Меню</a></li>
                <li><a href="/report" accesskey="2" title="">Фотозвіти</a></li>
                <li><a href="/about" accesskey="4" title="">Про нас</a></li>
                <li><a href="/reservation" accesskey="4" title="">Бронювання</a></li>
            </ul>
        </div>
    </div>
</div>
<div id="page" class="container">
<#nested>
</div>

<div id="footer" class="container">
    <p>&copy; Луців Роман</p>
</div>
<script src="/static/lightbox/js/lightbox-plus-jquery.min.js"></script>
</body>
</html>
</#macro>
