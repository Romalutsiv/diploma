<#import "parts/common.ftl" as c>

<@c.page>
    <div id="content">
        <div class="post">
            <h2 class="title">Телефон: ${message.phone}</h2>
            <p class="meta"><span class="date">${message.date}</span><span class="posted">Відправник: ${message.firstname} ${message.secondname}</span></p>
            <div style="clear: both;">&nbsp;</div>
            <div class="entry">
                <p>Email: ${message.email}</p>
                <p>Опис: ${message.message}</p>
                <p class="links"><a href="/messages" class="more">Назад</a></p>

            </div>
        </div>
    </div>
</@c.page>