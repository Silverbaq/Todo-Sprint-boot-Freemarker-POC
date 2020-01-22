(function () {
    // TODO: Make js that will update task when checking/unchecking
    var tasks = $("[name='task-done']");

    $.each(tasks, function (key, value) {
        var id = $(value).attr('id').replace("task", "");

        $(value).on('change', function () {
            updateTask(id, this.checked)
            console.log(this.checked)
        });
    });


    function updateTask(id, checked) {
        // TODO: Make web request
        httpPut()
    };
})();