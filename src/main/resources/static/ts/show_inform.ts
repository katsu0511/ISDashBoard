const editInform:HTMLButtonElement = <HTMLButtonElement>document.getElementById('edit_inform')
const editInformWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('edit_inform_wrapper')
editInform.addEventListener('click', () => {
	editInformWrapper.style.visibility = 'visible'
	editInformWrapper.style.opacity = '1'
})

const closeEditInform:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_edit_inform')
closeEditInform.addEventListener('click', () => {
	editInformWrapper.style.visibility = 'hidden'
	editInformWrapper.style.opacity = '0'
})

const saveEditInform:HTMLInputElement = <HTMLInputElement>document.getElementById('save_edit_inform')
const informContent:HTMLTextAreaElement = <HTMLTextAreaElement>document.getElementById('inform_content')
const informContentError:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('inform_content_error')
saveEditInform.addEventListener('click', function (event) {
    if (informContent.value == '') {
        informContentError.style.display = 'block'
    } else {
        informContentError.style.display = 'none'
    }
    
    if (informContent.value == '') {
        informContent.focus()
    } else {
        var message = '保存しますか？'
        if (!confirm(message)) {
            event.preventDefault()
        }
    }
})

const deleteInform:HTMLInputElement = <HTMLInputElement>document.getElementById('delete_inform')
deleteInform.addEventListener('click', function (event) {
	var message = '削除しますか？'
	if (!confirm(message)) {
		event.preventDefault()
	}
})

const closeShowWrapper:HTMLButtonElement = <HTMLButtonElement>document.getElementById('close_show_wrapper')
closeShowWrapper.addEventListener('click', () => {
	window.close()
})
