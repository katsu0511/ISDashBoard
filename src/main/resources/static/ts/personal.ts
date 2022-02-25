const openEye:HTMLSpanElement = <HTMLSpanElement>document.getElementById('open')
const closeEye:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close')
const password:HTMLInputElement = <HTMLInputElement>document.getElementById('password')
openEye.addEventListener('click', () => {
	openEye.style.display = 'none'
	closeEye.style.display = 'block'
	password.type = 'text'
})

closeEye.addEventListener('click', () => {
	closeEye.style.display = 'none'
	openEye.style.display = 'block'
	password.type = 'password'
})

const changePassword:HTMLButtonElement = <HTMLButtonElement>document.getElementById('change_password')
const passwordFormWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('password_form_wrapper')
changePassword.addEventListener('click', () => {
	passwordFormWrapper.style.visibility = 'visible'
	passwordFormWrapper.style.opacity = '1'
})

const closePassword:HTMLSpanElement = <HTMLSpanElement>document.getElementById('close_password')
closePassword.addEventListener('click', () => {
	passwordFormWrapper.style.visibility = 'hidden'
	passwordFormWrapper.style.opacity = '0'
})

const savePassword:HTMLInputElement = <HTMLInputElement>document.getElementById('save_password')
const password1:HTMLInputElement = <HTMLInputElement>document.getElementById('password1')
const password2:HTMLInputElement = <HTMLInputElement>document.getElementById('password2')
const password1Error1:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('password1_error1')
const password1Error2:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('password1_error2')
const password2Error1:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('password2_error1')
const password2Error2:HTMLParagraphElement = <HTMLParagraphElement>document.getElementById('password2_error2')
savePassword.addEventListener('click', function (event) {
    if (password1.value == '') {
        password1Error1.style.display = 'block'
    } else {
        password1Error1.style.display = 'none'
    }
    
    if (password2.value == '') {
        password2Error1.style.display = 'block'
    } else {
        password2Error1.style.display = 'none'
    }
    
    if (password1.value == '') {
		password1Error2.style.display = 'none'
	} else if (!password1.value.match(/(?=.*[a-z])(?=.*\d)[a-zA-Z0-9.?/-_]{8,32}/g)) {
		password1Error2.style.display = 'block'
	} else {
		password1Error2.style.display = 'none'
	}
	
	if (password2.value == '') {
		password2Error2.style.display = 'none'
	} else if (password2.value != password1.value) {
		password2Error2.style.display = 'block'
	} else {
		password2Error2.style.display = 'none'
	}
    
    if (password1.value == '') {
        password1.focus()
    } else if (!password1.value.match(/(?=.*[a-z])(?=.*\d)[a-zA-Z0-9.?/-_]{8,32}/g)) {
		password1.focus()
	} else if (password2.value == '') {
		password2.focus()
	} else if (password2.value != password1.value) {
		password2.focus()
		event.preventDefault()
	} else {
        var message = '保存しますか？'
        if (!confirm(message)) {
            event.preventDefault()
        }
    }
})
