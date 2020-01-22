<#import "common/bootstrap.ftl" as b>

<@b.page>
    <div id="" class="container">
        <h4>Add Todo</h4>
        <form action="/addTodo" class="mb-4" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="value" name="value"/>
            </div>

            <button type="submit" class="btn btn-primary">Add</button>
        </form>

        <#if todos?? && (todos?size > 0)>
            <table class="table">
                <tr class="thead-dark">
                    <th>Todo</th>
                    <th>Created</th>
                    <th>Updated</th>
                    <th>Done</th>
                    <th>Remove</th>
                </tr>
                <#list todos as todo>
                    <tr>
                        <td>${todo.value}</td>
                        <td>${todo.createdAt}</td>
                        <td>${todo.updatedAt}</td>
                        <td><label class="checkbox"><input type="checkbox"/></label></td>
                        <td>
                            <form action="/removeTodo" method="post">
                                <input type="hidden" value="${todo.id}" name="id"/>
                                <Button class="btn btn-danger" type="submit">Remove</Button>
                            </form>
                        </td>
                    </tr>
                </#list>
            </table>
        </#if>
    </div>
</@b.page>