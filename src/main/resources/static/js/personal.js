var openEye = document.getElementById('open');
var closeEye = document.getElementById('close');
var password = document.getElementById('password');
openEye.addEventListener('click', function () {
    openEye.style.display = 'none';
    closeEye.style.display = 'block';
    password.type = 'text';
});
closeEye.addEventListener('click', function () {
    closeEye.style.display = 'none';
    openEye.style.display = 'block';
    password.type = 'password';
});
var changePassword = document.getElementById('change_password');
var passwordFormWrapper = document.getElementById('password_form_wrapper');
changePassword.addEventListener('click', function () {
    passwordFormWrapper.style.visibility = 'visible';
    passwordFormWrapper.style.opacity = '1';
});
var closePassword = document.getElementById('close_password');
closePassword.addEventListener('click', function () {
    passwordFormWrapper.style.visibility = 'hidden';
    passwordFormWrapper.style.opacity = '0';
});
var savePassword = document.getElementById('save_password');
var password1 = document.getElementById('password1');
var password2 = document.getElementById('password2');
var password1Error1 = document.getElementById('password1_error1');
var password1Error2 = document.getElementById('password1_error2');
var password2Error1 = document.getElementById('password2_error1');
var password2Error2 = document.getElementById('password2_error2');
savePassword.addEventListener('click', function (event) {
    if (password1.value == '') {
        password1Error1.style.display = 'block';
    }
    else {
        password1Error1.style.display = 'none';
    }
    if (password2.value == '') {
        password2Error1.style.display = 'block';
    }
    else {
        password2Error1.style.display = 'none';
    }
    if (password1.value == '') {
        password1Error2.style.display = 'none';
    }
    else if (!password1.value.match(/(?=.*[a-z])(?=.*\d)[a-zA-Z0-9.?/-_]{8,32}/g)) {
        password1Error2.style.display = 'block';
    }
    else {
        password1Error2.style.display = 'none';
    }
    if (password2.value == '') {
        password2Error2.style.display = 'none';
    }
    else if (password2.value != password1.value) {
        password2Error2.style.display = 'block';
    }
    else {
        password2Error2.style.display = 'none';
    }
    if (password1.value == '') {
        password1.focus();
    }
    else if (!password1.value.match(/(?=.*[a-z])(?=.*\d)[a-zA-Z0-9.?/-_]{8,32}/g)) {
        password1.focus();
    }
    else if (password2.value == '') {
        password2.focus();
    }
    else if (password2.value != password1.value) {
        password2.focus();
        event.preventDefault();
    }
    else {
        var message = '保存しますか？';
        if (!confirm(message)) {
            event.preventDefault();
        }
    }
});
