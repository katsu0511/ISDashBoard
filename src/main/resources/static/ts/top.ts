for (let i = 1; i <= 3; i++) {
	const up:HTMLDivElement = <HTMLDivElement>document.getElementById('up' + i)
	const down:HTMLDivElement = <HTMLDivElement>document.getElementById('down' + i)
	const tbody:HTMLDivElement = <HTMLDivElement>document.getElementById('tbody' + i)
	up.addEventListener('click', function() {
		tbody.scrollBy(0,-10)
	})
	down.addEventListener('click', function() {
		tbody.scrollBy(0,10)
	})
}

const addInform:HTMLButtonElement = <HTMLButtonElement>document.getElementById('add_inform')
const addInformWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('add_inform_wrapper')
addInform.addEventListener('click', () => {
	addInformWrapper.style.visibility = 'visible'
	addInformWrapper.style.opacity = '1'
})

const closeAddInform:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_add_inform')
const informContentError:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('inform_content_error')
closeAddInform.addEventListener('click', () => {
	addInformWrapper.style.visibility = 'hidden'
	addInformWrapper.style.opacity = '0'
	informContentError.style.display = 'none'
})

const saveAddInform:HTMLInputElement = <HTMLInputElement>document.getElementById('save_add_inform')
const informContent:HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById('inform_content')
saveAddInform.addEventListener('click', function (event) {
    if (informContent.value == '') {
        informContentError.style.display = 'block'
    } else {
        informContentError.style.display = 'none'
    }
    
    if (informContent.value == '') {
        informContent.focus()
    } else {
        var message = '追加しますか？'
        if (!confirm(message)) {
            event.preventDefault()
        }
    }
})

const addSchedule:HTMLButtonElement = <HTMLButtonElement>document.getElementById('add_schedule')
const addScheduleWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('add_schedule_wrapper')
addSchedule.addEventListener('click', () => {
	addScheduleWrapper.style.visibility = 'visible'
	addScheduleWrapper.style.opacity = '1'
})

const closeAddSchedule:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_add_schedule')
const scheduleDatetimeError:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('schedule_datetime_error')
const scheduleContentError:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('schedule_content_error')
closeAddSchedule.addEventListener('click', () => {
	addScheduleWrapper.style.visibility = 'hidden'
	addScheduleWrapper.style.opacity = '0'
	scheduleDatetimeError.style.display = 'none'
	scheduleContentError.style.display = 'none'
})

const saveAddSchedule:HTMLInputElement = <HTMLInputElement>document.getElementById('save_add_schedule')
const startDate:HTMLInputElement = <HTMLInputElement>document.getElementById('start_date')
const endDate:HTMLInputElement = <HTMLInputElement>document.getElementById('end_date')
const scheduleContent:HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById('schedule_content')
saveAddSchedule.addEventListener('click', function (event) {
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
