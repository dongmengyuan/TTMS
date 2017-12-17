/**
 * Created by ubuntu on 21/09/17.
 */
'use strict';

'use strict';
let array = {};
function find() {
    let table = document.getElementById('ss');
    let length = table.rows[0].cells.length;
    let l=table.rows.length;
    for(let i = 0;i<l;i++){
        if(i == 0){
            let row = table.rows[i];
            row.setAttribute('class','active');
        }
        else {
            let row = table.rows[i];
            row.setAttribute('class','default');
        }
    }
    if (event.srcElement.tagName == 'TD') {
        let curRow = event.srcElement.parentElement;
        let num = curRow.rowIndex;
        if(curRow.rowIndex == 0){
            curRow.setAttribute('class','warning');
            return 0;
        }
        else{
            curRow.setAttribute('class','info');

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

function checkNum(number){
    let check=/^[0-9]{6,20}$/;
    let num=document.getElementById('number').value;
    if(check.test(num)){
        document.getElementById('1').innerText='';
        return true;
    }
    else{
        document.getElementById('1').innerText='请输入6～20位数字！';
        document.getElementById('number').value='';
        return false;
    }
}

function checkName(name){
    let check=/[\u4e00-\u9fa5]{2,9}/;
    let nam=document.getElementById('name').value;
    if(check.test(nam)){
        document.getElementById('2').innerText='';
        return true;
    }
    else{
        document.getElementById('2').innerText='请输入2～9个汉字！';
        document.getElementById('name').value='';
        return false;
    }
}

function checkSex(s){
    let check=/^[男|女]$/;
    let sex=document.getElementById('s').value;
    if(check.test(sex)){
        document.getElementById('3').innerText='';
        return true;
    }
    else{
        document.getElementById('3').innerText='请输入男或女！';
        document.getElementById('s').value='';
        return false;
    }
}

function checkAge(age){
    let check=/^[2-5][0-9]$/;
    let aage=document.getElementById('age').value;
    if(check.test(aage)){
        document.getElementById('4').innerText='';
        return true;
    }
    else{
        document.getElementById('4').innerText='年龄20～59岁！';
        document.getElementById('age').value='';
        return false;
    }
}

function checkTel(tel){
    let check=/^1[3|4|5|7|8][0-9]{9}$/;
    let tele=document.getElementById('tel').value;
    if(check.test(tele)){
        document.getElementById('5').innerText='';
        return true;
    }
    else{
        document.getElementById('5').innerText='电话号码不符合格式！';
        document.getElementById('tel').value='';
        return false;
    }
}

function checkEmil(emil){
    let check=/^[a-zA-Z0-9_-]+@[a-z0-9]+(\.[a-z]{2,8}){1,2}$/;
    let email=document.getElementById('emil').value;
    if(check.test(email)){
        document.getElementById('6').innerText='';
        return true;
    }
    else{
        document.getElementById('6').innerText='邮箱不符合格式！';
        document.getElementById('emil').value='';
        return false;
    }
}

function checkJob(job){
    let check=/^[\u4e00-\u9fa5]{2,5}$/;
    let jjob=document.getElementById('job').value;
    if(check.test(jjob)){
        document.getElementById('7').innerText='';
        return true;
    }
    else{
        document.getElementById('7').innerText='职位为2～5个汉字！';
        document.getElementById('job').value='';
        return false;
    }
}

function checkAll(){
    let add=document.getElementById('add');
    if(checkNum()&&checkName()&&checkSex()&&checkAge()&&checkEmil()&&checkTel()&&checkJob()){
        add.setAttribute('data-dismiss','modal');
        return true;
    }
    else
    {
        return false;
    }
}

function model() {

    document.getElementById('num').value = array.info[0];
    document.getElementById('nam').value = array.info[1];
    document.getElementById('sex').value = array.info[2];
    document.getElementById('ag').value = array.info[3];
    document.getElementById('work').value = array.info[4];
    document.getElementById('tele').value = array.info[5];
    document.getElementById('email').value = array.info[6];


}


function save(obj) {
    let info = [];
    info[0]=document.getElementById('num').value;
    info[1]=document.getElementById('nam').value;
    info[2]=document.getElementById('sex').value;
    info[3]=document.getElementById('ag').value;
    info[4]=document.getElementById('work').value;
    info[5]=document.getElementById('tele').value;
    info[6]=document.getElementById('email').value;
    for (let i = 0; i < array.n; i++) {
        array.table.rows[array.num].cells[i].innerHTML = info[i];
    }

}

function del(obj) {
    (array.table).deleteRow(array.num);
}

function add() {
    if(checkAll()) {

        let employeAdd = document.getElementById('ss');
        let addInfo = [];
        addInfo[0] = document.getElementById('number').value;
        addInfo[1] = document.getElementById('name').value;
        addInfo[2] = document.getElementById('s').value;
        addInfo[3] = document.getElementById('age').value;
        addInfo[4] = document.getElementById('job').value;
        addInfo[5] = document.getElementById('tel').value;
        addInfo[6] = document.getElementById('emil').value;
        let newRow = employeAdd.insertRow();
        let employeeNumber = newRow.insertCell();
        let employeeName = newRow.insertCell();
        let employeeSex = newRow.insertCell();
        let employeeAge = newRow.insertCell();
        let employeeJob = newRow.insertCell();
        let employeeTel = newRow.insertCell();
        let employeeEmil = newRow.insertCell();

        employeeNumber.innerText = addInfo[0];
        employeeName.innerText = addInfo[1];
        employeeSex.innerText = addInfo[2];
        employeeAge.innerText = addInfo[3];
        employeeJob.innerText = addInfo[4];
        employeeTel.innerText = addInfo[5];
        employeeEmil.innerText = addInfo[6];

        document.getElementById('number').value = '';
        document.getElementById('name').value = '';
        document.getElementById('s').value = '';
        document.getElementById('age').value = '';
        document.getElementById('job').value = '';
        document.getElementById('tel').value = '';
        document.getElementById('emil').value = '';
    }
}

