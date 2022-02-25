var addPerformance = document.getElementById('add_performance');
var addPerformanceWrapper = document.getElementById('add_performance_wrapper');
addPerformance.addEventListener('click', function () {
    addPerformanceWrapper.style.visibility = 'visible';
    addPerformanceWrapper.style.opacity = '1';
});
var closeAddPerformance = document.getElementById('close_add_performance');
closeAddPerformance.addEventListener('click', function () {
    addPerformanceWrapper.style.visibility = 'hidden';
    addPerformanceWrapper.style.opacity = '0';
});
var saveAddPerformance = document.getElementById('save_add_performance');
var date1 = document.getElementById('date1');
var date1Error = document.getElementById('date1_error');
var cost1 = document.getElementById('cost1');
var cost1Error = document.getElementById('cost1_error');
var performanceContent1 = document.getElementById('performance_content1');
var performanceContent1Error = document.getElementById('performance_content1_error');
saveAddPerformance.addEventListener('click', function (event) {
    if (date1.value == '') {
        date1Error.style.display = 'block';
    }
    else {
        date1Error.style.display = 'none';
    }
    if (cost1.value == '') {
        cost1Error.style.display = 'block';
    }
    else {
        cost1Error.style.display = 'none';
    }
    if (performanceContent1.value == '') {
        performanceContent1Error.style.display = 'block';
    }
    else {
        performanceContent1Error.style.display = 'none';
    }
    if (date1.value == '') {
        date1.focus();
    }
    else if (cost1.value == '') {
        cost1.focus();
    }
    else if (performanceContent1.value == '') {
        performanceContent1.focus();
    }
    else {
        var message = '追加しますか？';
        if (!confirm(message)) {
            event.preventDefault();
        }
    }
});
var editPerformanceWrapper = document.getElementById('edit_performance_wrapper');
var closeEditPerformance = document.getElementById('close_edit_performance');
closeEditPerformance.addEventListener('click', function () {
    var pfmcId = document.getElementById('pfmc_id');
    pfmcId.value = '';
    var date2 = document.getElementById('date2');
    date2.value = '';
    var cost2 = document.getElementById('cost2');
    cost2.value = '';
    var user2 = document.getElementById('user2');
    user2.value = '';
    var performanceContent2 = document.getElementById('performance_content2');
    performanceContent2.value = '';
    editPerformanceWrapper.style.visibility = 'hidden';
    editPerformanceWrapper.style.opacity = '0';
});
var saveEditPerformance = document.getElementById('save_edit_performance');
var date2 = document.getElementById('date2');
var date2Error = document.getElementById('date2_error');
var cost2 = document.getElementById('cost2');
var cost2Error = document.getElementById('cost2_error');
var performanceContent2 = document.getElementById('performance_content2');
var performanceContent2Error = document.getElementById('performance_content2_error');
saveEditPerformance.addEventListener('click', function (event) {
    if (date2.value == '') {
        date2Error.style.display = 'block';
    }
    else {
        date2Error.style.display = 'none';
    }
    if (cost2.value == '') {
        cost2Error.style.display = 'block';
    }
    else {
        cost2Error.style.display = 'none';
    }
    if (performanceContent2.value == '') {
        performanceContent2Error.style.display = 'block';
    }
    else {
        performanceContent2Error.style.display = 'none';
    }
    if (date2.value == '') {
        date2.focus();
    }
    else if (cost2.value == '') {
        cost2.focus();
    }
    else if (performanceContent2.value == '') {
        performanceContent2.focus();
    }
    else {
        var message = '保存しますか？';
        if (!confirm(message)) {
            event.preventDefault();
        }
    }
});
var closeShowWrapper = document.getElementById('close_show_wrapper');
closeShowWrapper.addEventListener('click', function () {
    window.close();
});
