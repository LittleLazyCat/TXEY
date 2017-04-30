/**
 * Created by ljwlgl on 17-4-3.
 */

window.onload = function() {
	init();
	// changeBackground();
}

function init() {
	// localStorage.clear();
	var btnAdd = document.getElementById("btn_add");
	btnAdd.onclick = createNote;
	// for(var i=0;i<localStorage.length;i++){
	// var key = localStorage.key(i);
	// if(key.substring(0,4) == "note"){
	// //console.log(localStorage.getItem(key));
	// var value = localStorage.getItem(key);
	// addNoteToDom(value);
	// }
	// }
}

/*
 * function changeBackground() {
 * 
 * var bg = document.getElementById("img_background"); bg.src = "img/bg_" +
 * parseInt(Math.random() * 10 % 5) + ".jpg"; setTimeout(changeBackground,
 * 60000); }
 */

function createNote() {
	var text = document.getElementById("wtms").value;
	// var key = "note"+localStorage.length;
	// localStorage.setItem(key,text);
	if (text == "") {
		alert("内容不能为空");
		return;
	}
	// addNoteToDom(text);
}
/*
 * function addNoteToDom(value) { var stickies =
 * document.getElementById("note"); var sticky = document.createElement("li");
 * sticky.setAttribute("class","li_note") noteTransform(sticky);
 * setNoteColor(sticky); var span = document.createElement("span");
 * span.setAttribute("class","span_note"); span.innerHTML = value;
 * sticky.appendChild(span); stickies.appendChild(sticky); }
 * 
 * function noteTransform(note) { var myRotate =
 * "rotate("+parseInt((Math.random()*100)%20-10)+"deg)"; note.style.transform =
 * myRotate; //console.log(Math.random()); }
 * 
 * function setNoteColor(note) { var strColor = [ "rgba(219,112,147,0.9)",
 * "rgba(169,169,169,0.9)", "rgba(255,165,0,0.9)", "rgba(95,158,160,0.9)",
 * "rgba(255,192,203,0.9)"]; var length = strColor.length; var myColor =
 * strColor[parseInt(Math.random()*10%length)]; note.style.backgroundColor =
 * myColor; console.log(myColor); }
 */