<#import "parts/common.ftl" as c>

<@c.page>
<form action="report" method="post" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="Enter name">
    <#if textError??>
        ${textError}
    </#if>
    <input type="file" name="file" accept="image/*" multiple>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Добавить</button>
</form>


</@c.page>