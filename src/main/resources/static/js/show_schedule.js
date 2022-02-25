var editSchedule = document.getElementById('edit_schedule');
var editScheduleWrapper = document.getElementById('edit_schedule_wrapper');
editSchedule.addEventListener('click', function () {
    editScheduleWrapper.style.visibility = 'visible';
    editScheduleWrapper.style.opacity = '1';
});
var closeEditSchedule = document.getElementById('close_edit_schedule');
closeEditSchedule.addEventListener('click', function () {
    editScheduleWrapper.style.visibility = 'hidden';
    editScheduleWrapper.style.opacity = '0';
});
var saveEditSchedule = document.getElementById('save_edit_schedule');
var startDate = document.getElementById('start_date');
var endDate = document.getElementById('end_date');
var scheduleContent = document.getElementById('schedule_content');
var scheduleDatetimeError = document.getElementById('schedule_datetime_error');
var scheduleContentError = document.getElementById('schedule_content_error');
saveEditSchedule.addEventListener('click', function (event) {
    if (startDate.value == '' || endDate.value == '') {
        scheduleDatetimeError.style.display = 'block';
    }
    else {
        scheduleDatetimeError.style.display = 'none';
    }
    if (scheduleContent.value == '') {
        scheduleContentError.style.display = 'block';
    }
    else {
        scheduleContentError.style.display = 'none';
    }
    if (startDate.value == '') {
        startDate.focus();
    }
    else if (endDate.value == '') {
        endDate.focus();
    }
    else if (scheduleContent.value == '') {
        scheduleContent.focus();
    }
    else {
        var message = '追加しますか？';
        if (!confirm(message)) {
            event.preventDefault();
        }
    }
});
var deleteSchedule = document.getElementById('delete_schedule');
deleteSchedule.addEventListener('click', function (event) {
    var message = '削除しますか？';
    if (!confirm(message)) {
        event.preventDefault();
    }
});
var closeShowWrapper = document.getElementById('close_show_wrapper');
closeShowWrapper.addEventListener('click', function () {
    window.close();
});
