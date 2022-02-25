const addPerformance:HTMLButtonElement = <HTMLButtonElement>document.getElementById('add_performance')
const addPerformanceWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('add_performance_wrapper')
addPerformance.addEventListener('click', () => {
	addPerformanceWrapper.style.visibility = 'visible'
	addPerformanceWrapper.style.opacity = '1'
})

const closeAddPerformance:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_add_performance')
closeAddPerformance.addEventListener('click', () => {
	addPerformanceWrapper.style.visibility = 'hidden'
	addPerformanceWrapper.style.opacity = '0'
})

const saveAddPerformance:HTMLInputElement = <HTMLInputElement>document.getElementById('save_add_performance')
const date1:HTMLInputElement = <HTMLInputElement>document.getElementById('date1')
const date1Error:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('date1_error')
const cost1:HTMLInputElement = <HTMLInputElement>document.getElementById('cost1')
const cost1Error:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('cost1_error')
const performanceContent1:HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById('performance_content1')
const performanceContent1Error:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('performance_content1_error')
saveAddPerformance.addEventListener('click', function (event) {
	if (date1.value == '') {
        date1Error.style.display = 'block'
    } else {
		date1Error.style.display = 'none'
	}
	
	if (cost1.value == '') {
        cost1Error.style.display = 'block'
    } else {
		cost1Error.style.display = 'none'
	}
	
	if (performanceContent1.value == '') {
        performanceContent1Error.style.display = 'block'
    } else {
		performanceContent1Error.style.display = 'none'
	}
	
	if (date1.value == '') {
        date1.focus()
    } else if (cost1.value == '') {
		cost1.focus()
	} else if (performanceContent1.value == '') {
		performanceContent1.focus()
	} else {
        var message = '追加しますか？'
        if (!confirm(message)) {
            event.preventDefault()
        }
    }
})

const editPerformanceWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('edit_performance_wrapper')
const closeEditPerformance:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_edit_performance')
closeEditPerformance.addEventListener('click', () => {
	const pfmcId:HTMLInputElement = <HTMLInputElement>document.getElementById('pfmc_id')
	pfmcId.value = ''
	const date2:HTMLInputElement = <HTMLInputElement>document.getElementById('date2')
	date2.value = ''
	const cost2:HTMLInputElement = <HTMLInputElement>document.getElementById('cost2')
	cost2.value = ''
	const user2:HTMLInputElement = <HTMLInputElement>document.getElementById('user2')
	user2.value = ''
	const performanceContent2:HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById('performance_content2')
	performanceContent2.value = ''
	editPerformanceWrapper.style.visibility = 'hidden'
	editPerformanceWrapper.style.opacity = '0'
})

const saveEditPerformance:HTMLInputElement = <HTMLInputElement>document.getElementById('save_edit_performance')
const date2:HTMLInputElement = <HTMLInputElement>document.getElementById('date2')
const date2Error:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('date2_error')
const cost2:HTMLInputElement = <HTMLInputElement>document.getElementById('cost2')
const cost2Error:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('cost2_error')
const performanceContent2:HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById('performance_content2')
const performanceContent2Error:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('performance_content2_error')
saveEditPerformance.addEventListener('click', function (event) {
	if (date2.value == '') {
        date2Error.style.display = 'block'
    } else {
		date2Error.style.display = 'none'
	}
	
	if (cost2.value == '') {
        cost2Error.style.display = 'block'
    } else {
		cost2Error.style.display = 'none'
	}
	
	if (performanceContent2.value == '') {
        performanceContent2Error.style.display = 'block'
    } else {
		performanceContent2Error.style.display = 'none'
	}
	
	if (date2.value == '') {
        date2.focus()
    } else if (cost2.value == '') {
		cost2.focus()
	} else if (performanceContent2.value == '') {
		performanceContent2.focus()
	} else {
        var message = '保存しますか？'
        if (!confirm(message)) {
            event.preventDefault()
        }
    }
})

const closeShowWrapper:HTMLButtonElement = <HTMLButtonElement>document.getElementById('close_show_wrapper')
closeShowWrapper.addEventListener('click', () => {
	window.close()
})
