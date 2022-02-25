var inform = document.getElementById('inform');
var informSettingWrapper = document.getElementById('inform_setting_wrapper');
inform.addEventListener('click', function () {
    informSettingWrapper.style.visibility = 'visible';
    informSettingWrapper.style.opacity = '1';
});
var closeInformSetting = document.getElementById('close_inform_setting');
closeInformSetting.addEventListener('click', function () {
    informSettingWrapper.style.visibility = 'hidden';
    informSettingWrapper.style.opacity = '0';
});
var schedule = document.getElementById('schedule');
var scheduleSettingWrapper = document.getElementById('schedule_setting_wrapper');
schedule.addEventListener('click', function () {
    scheduleSettingWrapper.style.visibility = 'visible';
    scheduleSettingWrapper.style.opacity = '1';
});
var closeScheduleSetting = document.getElementById('close_schedule_setting');
closeScheduleSetting.addEventListener('click', function () {
    scheduleSettingWrapper.style.visibility = 'hidden';
    scheduleSettingWrapper.style.opacity = '0';
});
var task = document.getElementById('task');
var taskSettingWrapper = document.getElementById('task_setting_wrapper');
task.addEventListener('click', function () {
    taskSettingWrapper.style.visibility = 'visible';
    taskSettingWrapper.style.opacity = '1';
});
var closeTaskSetting = document.getElementById('close_task_setting');
closeTaskSetting.addEventListener('click', function () {
    taskSettingWrapper.style.visibility = 'hidden';
    taskSettingWrapper.style.opacity = '0';
});
