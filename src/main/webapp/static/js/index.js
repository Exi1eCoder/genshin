window.onload=function(){
	var holdList = document.getElementsByClassName("hold-character-item");
	console.log(holdList);
	for(var i = 0; i < holdList.length; i++){
		var hid = holdList[i].childNodes[1].innerText;
		removeStyle(hid);
	}
}

function removeStyle(id){
	document.getElementById(id).className="";
}
