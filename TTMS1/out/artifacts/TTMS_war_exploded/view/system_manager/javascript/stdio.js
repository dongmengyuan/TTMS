'use strict';
let array = {};
function find() {
    let table = document.getElementById('stdio');
    let length = table.rows[0].cells.length;
    let l = table.rows.length;
    for (let i = 0; i < l; i++) {
        if (i == 0) {
            let row = table.rows[i];
            row.setAttribute('class', 'active');
        }
        else {
            let row = table.rows[i];
            row.setAttribute('class', 'default');
        }
    }
    if (event.srcElement.tagName == 'TD') {
        let curRow = event.srcElement.parentElement;
        let num = curRow.rowIndex;
        if (curRow.rowIndex == 0) {
            curRow.setAttribute('class', 'warning');
            return 0;
        }
        else {
            curRow.setAttribute('class', 'info');

        }
        let arr = [];
        for (let i = 0; i < length; i++) {
            arr[i] = table.rows[num].cells[i].innerHTML;
        }

        array.num = num;
        array.table = table;
        array.n = length;
        array.info = arr;
        return array;
    }

}

function checkName(name) {
    let check = /^[\u4e00-\u9fa5]{5,9}$/;
    let nam = document.getElementById('name').value;
    if (check.test(nam)) {
        document.getElementById('1').innerText = '';
        return true;
    }
    else {
        document.getElementById('1').innerText = '请输入5～9个汉字！';
        document.getElementById('name').value = '';
        return false;
    }
}

function checkType(type) {
    let check = /^[\u4e00-\u9fa5]{1,2}$/;
    let nam = document.getElementById('type').value;
    if (check.test(nam)) {
        document.getElementById('2').innerText = '';
        return true;
    }
    else {
        document.getElementById('2').innerText = '请输入演出厅类型！';
        document.getElementById('type').value = '';
        return false;
    }
}

function checkRow(row) {
    let r = document.getElementById('row').value;
    if (r>0&&r<=20) {
        document.getElementById('3').innerText = '';
        return true;
    }
    else {
        document.getElementById('3').innerText = '行数不为0且不超过20！';
        document.getElementById('row').value = '';
        return false;
    }
}

function checkCol(col) {
    let c = document.getElementById('col').value;
    if (c>0&&c<=20) {
        document.getElementById('4').innerText = '';
        return true;
    }
    else {
        document.getElementById('4').innerText = '列数不为0且不超过20！';
        document.getElementById('col').value = '';
        return false;
    }
}

function checkStatus(status) {
    let check = /^[\u4e00-\u9fa5]{2,3}$/;
    let s = document.getElementById('status').value;
    if (check.test(s)) {
        document.getElementById('5').innerText = '';
        return true;
    }
    else {
        document.getElementById('5').innerText = '可用或不可用！';
        document.getElementById('status').value = '';
        return false;
    }
}

function checkAll() {
    let add = document.getElementById('add');
    if (checkName() && checkType() && checkRow() && checkCol() && checkStatus()) {
        add.setAttribute('data-dismiss', 'modal');
        return true;
    }
    else {
        return false;
    }
}


function model() {
    // let a = find();
    // console.log(array);

    document.getElementById('nam').value = array.info[0];
    document.getElementById('typ').value = array.info[1];
    document.getElementById('rows').value = array.info[2];
    document.getElementById('cols').value = array.info[3];
    document.getElementById('statu').value = array.info[4];


}


function save(obj) {
    let info = [];
    info[0] = document.getElementById('nam').value;
    info[1] = document.getElementById('typ').value;
    info[2] = document.getElementById('rows').value;
    info[3] = document.getElementById('cols').value;
    info[4] = document.getElementById('statu').value;
    for (let i = 0; i < array.n; i++) {
        array.table.rows[array.num].cells[i].innerHTML = info[i];
    }

}

function del(obj) {
    (array.table).deleteRow(array.num);
}

function add() {
    if (checkAll()) {
        let employeAdd = document.getElementById('stdio');
        let addInfo = [];
        addInfo[0] = document.getElementById('name').value;
        addInfo[1] = document.getElementById('type').value;
        addInfo[2] = document.getElementById('row').value;
        addInfo[3] = document.getElementById('col').value;
        addInfo[4] = document.getElementById('status').value;
        let newRow = employeAdd.insertRow();
        let employeeName = newRow.insertCell();
        let employeeType = newRow.insertCell();
        let employeeRow = newRow.insertCell();
        let employeeCol = newRow.insertCell();
        let employeeStatus = newRow.insertCell();

        employeeName.innerText = addInfo[0];
        employeeType.innerText = addInfo[1];
        employeeRow.innerText = addInfo[2];
        employeeCol.innerText = addInfo[3];
        employeeStatus.innerText = addInfo[4];

        document.getElementById('name').value = '';
        document.getElementById('type').value = '';
        document.getElementById('row').value = '';
        document.getElementById('col').value = '';
        document.getElementById('status').value = '';
    }
}

