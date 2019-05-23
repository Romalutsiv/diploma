<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>

<@c.page>
    <div id="content">
        <div>
            <@p.pager url messages></@p.pager>
        </div>
        <div class="post">
            <div class="entry">
                <#list messages.content as message>
                    <#if message.active>
                    <a href="/messages/${message.id}"><p style="color: crimson"><strong>Повідолення від ${message.firstname} ${message.secondname} за ${message.date}</strong></p></a>
                        <#else >
                            <a href="/messages/${message.id}"><p>Повідолення від ${message.firstname} ${message.secondname} за ${message.date}</p></a>
                    </#if>
    </#list>
            </div>
        </div>
    </div>
</@c.page>