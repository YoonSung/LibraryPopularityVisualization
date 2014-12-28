var eResult = document.getElementById("result");

function init() {
	var eInput = document.getElementById("inputfield");
	var eSubmit = document.querySelector("input[value][type='submit']");
	eSubmit.addEventListener("click", function(e) {
		e.preventDefault();
		showLibraryPopularity(eInput.value);
	}.bind(this));
}

function showLibraryPopularity(keyword) {

	/*
	 * var xhr = new XMLHttpRequest(); xhr.open("post", "/library", false);
	 * 
	 * xhr.onload = function() { console.log("test : ", xhr.responseText);
	 * eResult.innerText = xhr.responseText; if
	 * (!eResult.classList.contains("on")) { eResult.classList.add("on"); } };
	 * xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded;
	 * charset=UTF-8"); //xhr.load xhr.send("originURL="+keyword);
	 */

	//eResult.innerText = keyword;
	if (!eResult.classList.contains("on")) {
		eResult.classList.add("on");
	}
}

document.addEventListener("DOMContentLoaded", init.bind(this));

/*
 * //test code setTimeout(function() { var result =
 * document.querySelector("#result"); result.classList.add("on"); }, 1000);
 */