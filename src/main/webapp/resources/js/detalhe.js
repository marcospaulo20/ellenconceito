$("#zoom_01").elevateZoom({
	zoomWindowFadeIn: 500,
	zoomWindowFadeOut: 500,
	lensFadeIn: 500,
	lensFadeOut: 500
});

function verificarURL() {
	if(window.location.href.indexOf('') == -1)
		return true;
	else
		return false;
}