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
		containerJS.showContainer("/testJson", function(){
			eLoading.style.display = "none";
			eResult.className = "on";
		});
	}, 2000);
}

function sleep(ms) {
	ms += new Date().getTime();
	while (new Date() < ms) {
	}
}

document.addEventListener("DOMContentLoaded", init.bind(this));