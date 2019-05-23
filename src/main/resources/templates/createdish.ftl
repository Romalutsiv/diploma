<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <form action="/menu" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Enter name" />
        <#if textError??>
            ${textError}
        </#if>
        <input type="text" name="text" placeholder="Enter discr"/>
        <#if textError??>
            ${textError}
        </#if>
        <input type="file" accept="image/*" name="file">
        <input type="text" name="price" placeholder="Enter price "/>
        <#if textError??>
            ${textError}
        </#if>
        <input type="text" name="weight" placeholder="Enter weight"/>
        <#if textError??>
            ${textError}
        </#if>
        <p><select name="type">
                <option disabled>Выберіть тип страви</option>
                <option value="HOTDRINK">Гарячі напої</option>
                <option value="COLDDRINK">Холодні напої</option>
                <option value="ALCOGOL">Алкогольні напої</option>
                <option value="COCKTAIL">Коктелі</option>
                <option value="COLDSNAK">Холодні закуски</option>
                <option value="HOTSNAK">Гарячі закуски</option>
                <option value="GARNISH">Гарніри</option>
                <option value="SALAT">Салати</option>
                <option value="FIRSTDISH">Перші страви</option>
                <option value="DESERT">Десерти</option>
            </select></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>


</@c.page>