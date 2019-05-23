<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
    <#import "parts/pager.ftl" as p>
    <#include "parts/security.ftl">

<@c.page>
    <br>
    <div>
        <@p.pager url reports></@p.pager>
    </div>
    <#list reports.content as report>
    <div class="post">
        <h2 class="title"><a href="/report/${report.id}">${report.name}</a></h2>
        <div style="clear: both;">&nbsp;</div>
        <div class="entry">
            <div class="container-image">

                <div id="gallery">
<#assign
map = report.filenames?remove_ending('|')
srts = map?split("|")>
<#if srts?size gt 3>


<#list 0..2 as i>
    <#if report.isEmpty(srts[i])>
                    <figure class="photo">
                        <a href="/img/${srts[i]}" data-lightbox="roadtrip"><img
                                    src="/img/${srts[i]}"/></a>
                    </figure>
        </#if>

</#list>
<#else>
    <#list map?split("|") as i>
        <#if report.isEmpty(i)>
        <figure class="photo">
            <a href="/img/${i}" data-lightbox="roadtrip"><img
                        src="/img/${i}"/></a>
        </figure>
</#if>
    </#list>
    </#if>
                </div>
            </div>
            <p class="links"><a href="/report/${report.id}" class="more">Детальніше</a></p>
        </div>
    </div>
        <#else >
        пусто
    </#list>
    <div style="clear: both;">&nbsp;</div>
</@c.page>