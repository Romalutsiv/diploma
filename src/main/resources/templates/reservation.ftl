<#import "parts/common.ftl" as c>

<@c.page>
    <div class="contact">
        <br>
        <h1 style="text-align:center">Бронювання</h1>
        <form action="/reservation/add" method="post">
            <fieldset>
                <div class="row">
                    <section class="col col-2">
                        <label class="input">
                            <i class="fa fa-append fa-user"></i>
                            <input type="text" placeholder="Ім'я" required name="firstname">
                        </label>
                    </section>
                    <section class="col col-2">
                        <label class="input">
                            <i class="fa fa-append fa-envelope-o"></i>
                            <input type="text" placeholder="Прізвище" required name="secondname">
                        </label>
                    </section>
                </div>
                <section>
                    <label class="input">
                        <i class="fa fa-append fa-tag"></i>
                        <input type="text" placeholder="Телефон" name="phone">
                    </label>
                </section>
                <section>
                    <label class="input">
                        <i class="fa fa-append fa-tag"></i>
                        <input type="email" placeholder="Пошта" name="email">
                    </label>
                </section>
                <section>
                    <label class="input">
                        <i class="fa fa-append fa-tag"></i>
                        <input type="datetime-local" name="date">
                    </label>
                </section>
                <section>
                    <label class="textarea">
                        <i class="fa fa-append fa-comment"></i>
                        <textarea rows="4" placeholder="Додаткові побажання" required name="message"></textarea>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    </label>
                </section>
                <button type="submit" class="button">Відправити</button>
            </fieldset>
        </form>
    </div>
    <br>
</@c.page>