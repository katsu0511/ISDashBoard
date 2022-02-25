const editSchedule:HTMLButtonElement = <HTMLButtonElement>document.getElementById('edit_schedule')
const editScheduleWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('edit_schedule_wrapper')
editSchedule.addEventListener('click', () => {
	editScheduleWrapper.style.visibility = 'visible'
	editScheduleWrapper.style.opacity = '1'
})

const closeEditSchedule:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_edit_schedule')
closeEditSchedule.addEventListener('click', () => {
	editScheduleWrapper.style.visibility = 'hidden'
	editScheduleWrapper.style.opacity = '0'
})

const saveEditSchedule:HTMLInputElement = <HTMLInputElement>document.getElementById('save_edit_schedule')
const startDate:HTMLInputElement = <HTMLInputElement>document.getElementById('start_date')
const endDate:HTMLInputElement = <HTMLInputElement>document.getElementById('end_date')
const scheduleContent:HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById('schedule_content')
const scheduleDatetimeError:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('schedule_datetime_error')
const scheduleContentError:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('schedule_content_error')
saveEditSchedule.addEventListener('click', function (event) {
	if (startDate.value == '' || endDate.value == '') {
        scheduleDatetimeError.style.display = 'block'
    } else {
		scheduleDatetimeError.style.display = 'none'
	}
	
	if (scheduleContent.value == '') {
        scheduleContentError.style.display = 'block'
    } else {
		scheduleContentError.style.display = 'none'
	}
	
	if (startDate.value == '') {
        startDate.focus()
    } else if (endDate.value == '') {
		endDate.focus()
	} else if (scheduleContent.value == '') {
		scheduleContent.focus()
	} else {
        var message = '追加しますか？'
        if (!confirm(message)) {
            event.preventDefault()
        }
    }
})

const deleteSchedule:HTMLInputElement = <HTMLInputElement>document.getElementById('delete_schedule')
deleteSchedule.addEventListener('click', function (event) {
	var message = '削除しますか？'
	if (!confirm(message)) {
		event.preventDefault()
	}
})

const closeShowWrapper:HTMLButtonElement = <HTMLButtonElement>document.getElementById('close_show_wrapper')
closeShowWrapper.addEventListener('click', () => {
	window.close()
})
