<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <form action="/posts" method="post">
        <input type="text" name="name" placeholder="Enter name" />
        <#if textError??>
            ${textError}
        </#if>
        <textarea name="text" placeholder="Enter discr"></textarea>
        <#if textError??>
            ${textError}
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>


</@c.page>