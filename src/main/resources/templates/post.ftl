<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">

<@c.page>
    <div id="content">
        <div class="post">
            <h2 class="title"><a href="#">${post.name}</a></h2>
            <p class="meta"><span class="date">April 25, 2013</span><span class="posted">Posted by <a href="#">${post.authorName}</a></span></p>
            <div style="clear: both;">&nbsp;</div>
            <div class="entry">
                <p>${post.text}</p>
                <p class="links"><a href="/posts" class="more">Назад</a></p>
                <#if isAdmin>
                <p class="links"><a href="/posts/delete/${post.id}" class="more">del</a></p>
                <p class="links"><a href="/posts/edit/${post.id}" class="more">edit</a></p>
                </#if>
            </div>
        </div>
    </div>

</@c.page>