var drawers = document.getElementById('drawers');
var drawerWrapper = document.getElementById('drawer-wrapper');
var closeBtn = document.getElementById('close-btn');
drawers.addEventListener('click', function () {
    drawerWrapper.style.visibility = 'visible';
    drawerWrapper.style.opacity = '1';
});
closeBtn.addEventListener('click', function () {
    drawerWrapper.style.visibility = 'hidden';
    drawerWrapper.style.opacity = '0';
});
var reload = document.getElementById('reload');
reload.addEventListener('click', function () {
    location.reload();
});
