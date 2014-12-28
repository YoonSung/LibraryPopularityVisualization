var eResult = document.getElementById("result");
var eLoading = document.getElementById("loadArea");

function init() {
	eLoading.style.display = "none";
	
	var eInput = document.getElementById("inputfield");
	var eSubmit = document.querySelector("input[value][type='submit']");
	eSubmit.addEventListener("click", function(e) {
		e.preventDefault();
		showLibraryPopularity(eInput.value);
	}.bind(this));
}

function showLibraryPopularity(keyword) {

	eLoading.style.display = "inline-block";
	
	setTimeout(function() {
		eLoading.style.display = "none";
		eResult.className = "on";
	}, 2000);
	/*
	 * var xhr = new XMLHttpRequest(); xhr.open("post", "/library", false);
	 * 
	 * xhr.onload = function() { console.log("test : ", xhr.responseText);
	 * eResult.innerText = xhr.responseText; if
	 * (!eResult.classList.contains("on")) { eResult.classList.add("on"); } };
	 * xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded;
	 * charset=UTF-8"); //xhr.load xhr.send("originURL="+keyword);
	 */

	// eResult.innerText = keyword;
}

function sleep(ms) {
	ms += new Date().getTime();
	while (new Date() < ms) {
	}
}

document.addEventListener("DOMContentLoaded", init.bind(this));

/*
 * //test code setTimeout(function() { var result =
 * document.querySelector("#result"); result.classList.add("on"); }, 1000);
 */