<#import "parts/common.ftl" as c>
    <#include "parts/security.ftl">

<@c.page>
    <div class="dishes">
        <div class="menu1">
            <img src="/img/${dish.filename}" alt="" class="menu-img">
            <div class="menu-name1">
                <h3>${dish.name} <#if isAdmin><a href="/menu/delete/${dish.id}">X</a><a href="/menu/edit/${dish.id}"> edit</a></#if></h3>
            </div>
            <p style="margin-left: 5px;">${dish.dishTypeStr}</p>
            <p style="margin-left: 5px;">${dish.text}</p>
            <p class="menu-weight1"><br> вага: <br> ${dish.weight} г</p>
            <p class="menu-price1"><br>ціна:<br>${dish.price} грн </p>
        </div>

        <br>
        <br>
        <br>
    </div>
</@c.page>