<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">

<@c.page>
    <form action="/report/edit" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Enter name">
        <#if textError??>
            ${textError}
        </#if>
        <input type="file" name="file" accept="image/*" multiple>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="hidden" name="report" value="${report.id}" />
        <button type="submit">Редагувати</button>
    </form>
</@c.page>