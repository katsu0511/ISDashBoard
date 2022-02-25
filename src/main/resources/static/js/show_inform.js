var editInform = document.getElementById('edit_inform');
var editInformWrapper = document.getElementById('edit_inform_wrapper');
editInform.addEventListener('click', function () {
    editInformWrapper.style.visibility = 'visible';
    editInformWrapper.style.opacity = '1';
});
var closeEditInform = document.getElementById('close_edit_inform');
closeEditInform.addEventListener('click', function () {
    editInformWrapper.style.visibility = 'hidden';
    editInformWrapper.style.opacity = '0';
});
var saveEditInform = document.getElementById('save_edit_inform');
var informContent = document.getElementById('inform_content');
var informContentError = document.getElementById('inform_content_error');
saveEditInform.addEventListener('click', function (event) {
    if (informContent.value == '') {
        informContentError.style.display = 'block';
    }
    else {
        informContentError.style.display = 'none';
    }
    if (informContent.value == '') {
        informContent.focus();
    }
    else {
        var message = '保存しますか？';
        if (!confirm(message)) {
            event.preventDefault();
        }
    }
});
var deleteInform = document.getElementById('delete_inform');
deleteInform.addEventListener('click', function (event) {
    var message = '削除しますか？';
    if (!confirm(message)) {
        event.preventDefault();
    }
});
var closeShowWrapper = document.getElementById('close_show_wrapper');
closeShowWrapper.addEventListener('click', function () {
    window.close();
});
