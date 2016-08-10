var context = {
	name : '',
	setContext : function(context){
		this.name = context;
	},
	init : function(context) {
		var bt_bom = document.querySelector('#bt_bom');
		var bt_dom = document.querySelector('#bt_dom');
		var bt_kaup = document.querySelector('#bt_kaup');
		var bt_creator = document.querySelector('#bt_creator');
		console.log('CONTEXT : '+context);
		this.setContext(context);
		console.log('CONTEXT : '+this.name);
		
		bt_bom.addEventListener('click',this.bom_go,false);
		bt_dom.addEventListener('click',this.dom_go,false);
		bt_kaup.addEventListener('click',this.kaup_go,false);
		bt_creator.addEventListener('click',this.creator_go,false);
	},
	bom_go : function() {
		location.href=this.name+'/douglas.do?page=bom';
	},
	dom_go : function() {
		location.href=this.name+'/douglas.do?page=dom';
	},
	creator_go : function() {
		location.href=this.name+'/douglas.do?page=creator';
	}
};
var create = {
	creator_init : function() {
		document
		.querySelector('#bt_spec_show')
		.addEventListener('click',member_spec,false);
		document
		.querySelector('#bt_make_account')
		.addEventListener('click',account_spec,false);
		document
		.querySelector('#bt_deposit')
		.addEventListener('click',account_deposit,false);
		document
		.querySelector('#bt_withdraw')
		.addEventListener('click',account_withdraw,false);
	}	
};
var member = {
		
};
function account_spec(){
	var account = {
		account_no : 0,
		money : 0
	}
	account.account_no = Math.floor(Math.random()*899999)+100000;
	document.querySelector('#result_account').innerHTML = account.account_no;
	
}
function account_deposit(){
	var money = document.querySelector('#money').value;
	document.querySelector('#rest_money').innerHTML=money;
}
function account_withdraw(){
	var money = document.querySelector('#money').value;
	document.querySelector('#rest_money').innerHTML='-'+money;
}
function member_spec(){
	var member = new Object();
	var ssn=document.querySelector('#ssn').value;
	member.name=document.querySelector('#name').value;
	member.age = 0;
	member.gender = '';
	var now = new Date().getFullYear();
	var ssnArr = ssn.split("-");
	var ageResult1 = ssnArr[0];
	var genderResult = ssnArr[1];
	var ageResult0 = 0;
	switch (genderResult%2) {
	case 1: case 5: 
		member.gender="남"; 
		ageResult0 = now - 1900-(ageResult1/10000);
		member.age = ageResult0.toString().split(".")[0];
		break;
	case 3: case 7:
		member.gender="남"; 
		ageResult0 = now - 2000-(ageResult1/10000);
		member.age = ageResult0.toString().split(".")[0];
		break;
	case 2: case 6:
		member.gender="여";
		ageResult0 = now - 1900-(ageResult1/10000);
		member.age = ageResult0.toString().split(".")[0];
		break;
	case 4: case 8:
		member.gender="여";
		ageResult0 = now - 2000-(ageResult1/10000);
		member.age = ageResult0.toString().split(".")[0];
		break;

}	
	document.getElementById('result_name').innerHTML = member.name;
	document.getElementById('result_age').innerHTML = member.age;
	document.getElementById('result_gender').innerHTML = member.gender;
}
/*kaup*/
function kaup_init(){
	alert('카우푸 이닛 호출');
	var bt_kaup_calc = document.getElementById('bt_kaup_calc');
	bt_kaup_calc.addEventListener('click',kaup_calc,false);
}
function kaup_go(){
	location.href=getContext()+'/douglas.do?page=kaup';
}

function kaup_calc(){
	alert('카우푸 칼크 클릭');
	var name=document.querySelector('#name').value;
	var height=document.getElementById('height').value;
	var weight=document.getElementById('weight').value;
	console.log('name'+name);
	console.log('height'+height);
	console.log('weight'+weight);
	var result = '';
	var kaup = weight / (height / 100) / (height / 100);
	if (kaup < 18.5) {
		result = "저체중";
	} else if (kaup < 22.9 && kaup > 18.5) {
		result = "정상";
	} else if (kaup < 24.9 && kaup > 23.0) {
		result = "위험체중";
	} else if (kaup < 29.9 && kaup > 25.0) {
		result = "비만1단계";
	} else if (kaup < 40 && kaup > 30.0) {
		result = "비만2단계";
	} else if (kaup >= 40) {
		result = "비만3단계";
	}
	document.getElementById('result').innerHTML=name+'의 카우푸결과'+result;
	/*return name + "의 BMI지수는 " + Double.parseDouble(String.format("%.2f", kaup)) + "이고, " + result + "이다";*/
}
/*account*/

