var _loop_1 = function (i) {
    var up = document.getElementById('up' + i);
    var down = document.getElementById('down' + i);
    var tbody = document.getElementById('tbody' + i);
    up.addEventListener('click', function () {
        tbody.scrollBy(0, -10);
    });
    down.addEventListener('click', function () {
        tbody.scrollBy(0, 10);
    });
};
for (var i = 1; i <= 3; i++) {
    _loop_1(i);
}
var addInform = document.getElementById('add_inform');
var addInformWrapper = document.getElementById('add_inform_wrapper');
addInform.addEventListener('click', function () {
    addInformWrapper.style.visibility = 'visible';
    addInformWrapper.style.opacity = '1';
});
var closeAddInform = document.getElementById('close_add_inform');
var informContentError = document.getElementById('inform_content_error');
closeAddInform.addEventListener('click', function () {
    addInformWrapper.style.visibility = 'hidden';
    addInformWrapper.style.opacity = '0';
    informContentError.style.display = 'none';
});
var saveAddInform = document.getElementById('save_add_inform');
var informContent = document.getElementById('inform_content');
saveAddInform.addEventListener('click', function (event) {
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
        var message = '追加しますか？';
        if (!confirm(message)) {
            event.preventDefault();
        }
    }
});
var addSchedule = document.getElementById('add_schedule');
var addScheduleWrapper = document.getElementById('add_schedule_wrapper');
addSchedule.addEventListener('click', function () {
    addScheduleWrapper.style.visibility = 'visible';
    addScheduleWrapper.style.opacity = '1';
});
var closeAddSchedule = document.getElementById('close_add_schedule');
var scheduleDatetimeError = document.getElementById('schedule_datetime_error');
var scheduleContentError = document.getElementById('schedule_content_error');
closeAddSchedule.addEventListener('click', function () {
    addScheduleWrapper.style.visibility = 'hidden';
    addScheduleWrapper.style.opacity = '0';
    scheduleDatetimeError.style.display = 'none';
    scheduleContentError.style.display = 'none';
});
var saveAddSchedule = document.getElementById('save_add_schedule');
var startDate = document.getElementById('start_date');
var endDate = document.getElementById('end_date');
var scheduleContent = document.getElementById('schedule_content');
saveAddSchedule.addEventListener('click', function (event) {
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
