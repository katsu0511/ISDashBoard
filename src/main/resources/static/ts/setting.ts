const inform:HTMLButtonElement = <HTMLButtonElement>document.getElementById('inform')
const informSettingWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('inform_setting_wrapper')
inform.addEventListener('click', () => {
	informSettingWrapper.style.visibility = 'visible'
	informSettingWrapper.style.opacity = '1'
})

const closeInformSetting:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_inform_setting')
closeInformSetting.addEventListener('click', () => {
	informSettingWrapper.style.visibility = 'hidden'
	informSettingWrapper.style.opacity = '0'
})

const schedule:HTMLButtonElement = <HTMLButtonElement>document.getElementById('schedule')
const scheduleSettingWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('schedule_setting_wrapper')
schedule.addEventListener('click', () => {
	scheduleSettingWrapper.style.visibility = 'visible'
	scheduleSettingWrapper.style.opacity = '1'
})

const closeScheduleSetting:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_schedule_setting')
closeScheduleSetting.addEventListener('click', () => {
	scheduleSettingWrapper.style.visibility = 'hidden'
	scheduleSettingWrapper.style.opacity = '0'
})

const task:HTMLButtonElement = <HTMLButtonElement>document.getElementById('task')
const taskSettingWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('task_setting_wrapper')
task.addEventListener('click', () => {
	taskSettingWrapper.style.visibility = 'visible'
	taskSettingWrapper.style.opacity = '1'
})

const closeTaskSetting:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_task_setting')
closeTaskSetting.addEventListener('click', () => {
	taskSettingWrapper.style.visibility = 'hidden'
	taskSettingWrapper.style.opacity = '0'
})
