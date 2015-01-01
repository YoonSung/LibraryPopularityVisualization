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
	
	document.querySelector("input.test").addEventListener("click", function(e) {
		e.preventDefault();

		eLoading.style.display = "inline-block";
		
		setTimeout(function() {
			containerJS.showContainer("/testJson", function(){
				eLoading.style.display = "none";
				eResult.className = "on";
			});
		}, 2000);
	}.bind(this));
}

function showLibraryPopularity(keyword) {

	eLoading.style.display = "inline-block";
	
	containerJS.showContainer("/getJson/"+keyword, function(){
		eLoading.style.display = "none";
		eResult.className = "on";
	});
}

function sleep(ms) {
	ms += new Date().getTime();
	while (new Date() < ms) {
	}
}

document.addEventListener("DOMContentLoaded", init.bind(this));