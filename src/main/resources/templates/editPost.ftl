<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <form action="/posts/edit" method="post">
            <input type="text" name="name" placeholder="Enter name" />
            <#if textError??>
                ${textError}
            </#if>
            <textarea name="text" placeholder="Enter discr"></textarea>
            <#if textError??>
                ${textError}
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="hidden" name="post" value="${post.id}" />
            <button type="submit">Редагувати</button>
        </form>
    </div>

</@c.page>