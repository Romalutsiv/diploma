<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
    <#include "parts/security.ftl">

<@c.page>
    <br>
        <div class="post">
            <h2 class="title"><a href="#">${report.name}</a></h2>
            <div style="clear: both;">&nbsp;</div>
            <div class="entry">
                <div class="container-image">

                    <div id="gallery">
                        <#assign
                        map = report.filenames?remove_ending('|')
                        >
                        <#list map?split("|") as i>
                            <#if report.isEmpty(i)>
                            <figure class="photo">
                                <a href="/img/${i}" data-lightbox="roadtrip"><img
                                            src="/img/${i}"/></a>
                            <#if isAdmin>
                                <form action="/report/deletephoto" method="get">
                                    <input type="hidden" name="filename" value="${i}">
                                    <input type="hidden" name="report" value="${report.id}">
                                    <button type="submit">X</button>

                                </form>
                                </#if>
                            </figure>
                                </#if>
                        </#list>

                    </div>
                </div>
                <p class="links"><a href="/report" class="more">Назад</a>
                    <#if isAdmin>
                    <a href="/report/delete/${report.id}" title="b0x" class="comments">del</a></p>
                    <a href="/report/edit/${report.id}" title="b0x" class="comments">edit</a></p>
                </#if>
            </div>
        </div>
    <div style="clear: both;">&nbsp;</div>
</@c.page>