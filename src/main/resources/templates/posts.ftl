<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#import "parts/pager.ftl" as p>

<@c.page>

<div id="content">
    <div>
        <@p.pager url posts></@p.pager>
    </div>
    <#list posts.content as post>
    <div class="post">
        <h2 class="title"><a href="/posts/${post.id}">${post.name}</a></h2>
        <p class="meta"><span class="date">April 25, 2013</span><span class="posted">Posted by <a href="#">${post.authorName}</a></span></p>
        <div style="clear: both;">&nbsp;</div>
        <div class="entry">
            <#if post.text?length gt 105>
            <p>${post.text?substring(0,105)}...</p>
                <#else >
                    <p>${post.text}</p>
            </#if>
            <p class="links"><a href="/posts/${post.id}" class="more">Детальніше</a></p>
        </div>
    </div>
    <#else>
        <br>
        <div class="jumbotron container">
            <h1 class="display-4">Неічого не знайдено</h1>

        </div>

    </#list>
    <div style="clear: both;">&nbsp;</div>
</div>



    <#--<div style="clear: both;">&nbsp;</div>-->
    <div id="sidebar">
        <ul>
            <li>
                <a href="/menu"><h2>Меню</h2></a>
                <ul>
                    <#assign i=0>
                    <#list types as type>
                        <li><a href="/menu/${type}">${type.toString(i)}</a>
                            <input type="hidden" value="${type.toString()}" name="dishtype"></li>
                        <#assign i++>
                    </#list>
                </ul>
            </li>

        </ul>
    </div>


</@c.page>
