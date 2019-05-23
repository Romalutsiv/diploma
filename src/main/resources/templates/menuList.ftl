<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>

<@c.page>
    <div id="Navigation">
        <br>
        <ul class="Navigation">
            <li><a href="/menu">Всі</a></li>
            <#assign i=0>
            <#list types as type>
                <li><a href="/menu/${type}">${type.toString(i)}</a>
                    <input type="hidden" value="${type.toString()}" name="dishtype"></li>
                <#assign i++>
            </#list>
        </ul>
        <br>
    </div>
    <div class="dishes">
    <#list dishes.content as dish>
        <div class="men">
            <#if dish.filename??>
            <img src="/img/${dish.filename}" alt="" class="menu-img">
            </#if>
            <div class="menu-name"><a href="/menu/show/${dish.id}"><h3>${dish.name}</h3></a></div>
            <p style="margin-left: 5px;">${dish.dishTypeStr}</p>
            <p class="menu-weight"><br>  вага: <br> ${dish.weight} г.</p>
            <p class="menu-price"><br>ціна:<br>${dish.price} грн </p>
        </div>
    <#else>
    Пусто
</#list>
        <br>
        <br>
        <br>
    </div>


    <br>
    <div>
        <@p.pager url dishes></@p.pager>
    </div>

</@c.page>