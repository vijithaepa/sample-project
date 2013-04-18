//slider functionality
sliderInit = 1;
sliderNext = 2;

$(Document).ready(function() {
	$("#slider>img#1").fadeIn(300);
	startSlider();
});

function startSlider() {
	count = $("#slider img").size();

	loop = setInterval(function() {
		if (sliderNext > count) {
			sliderInit = 1;
			sliderNext = 1;
		}
		$("#slider img").fadeOut(300);
		$("#slider img#" + sliderNext).fadeIn(300);

		sliderInit = sliderNext;
		sliderNext = sliderNext + 1;

	}, 3000);
}

function previous() {
	newSlide = sliderInit - 1;
	showSlide(newSlide);
}

function next() {
	newSlide = sliderInit + 1;
	showSlide(newSlide);
}

function pouseSlider() {
	window.clearInterval(loop);
}

function showSlide(id) {

	pouseSlider();
	
	if (id > count) {
		id = 1;
	} else if (id < 1) {
		id = count;
	}
	$("#slider img").fadeOut(300);
	$("#slider img#" + id).fadeIn(300);

	sliderInit = id;
	sliderNext = id + 1;

	startSlider();
}

$("#slider img").hover(function() {
	pouseSlider();
}, function() {
	startSlider();
});