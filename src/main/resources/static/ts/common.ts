const drawers:HTMLDivElement = <HTMLDivElement>document.getElementById('drawers')
const drawerWrapper:HTMLDivElement = <HTMLDivElement>document.getElementById('drawer-wrapper')
const closeBtn:HTMLImageElement = <HTMLImageElement>document.getElementById('close-btn')
drawers.addEventListener('click', () => {
	drawerWrapper.style.visibility = 'visible'
	drawerWrapper.style.opacity = '1'
})
closeBtn.addEventListener('click', function() {
	drawerWrapper.style.visibility = 'hidden'
	drawerWrapper.style.opacity = '0'
})

const reload:HTMLInputElement = <HTMLInputElement>document.getElementById('reload')
reload.addEventListener('click', function() {
	location.reload()
})
