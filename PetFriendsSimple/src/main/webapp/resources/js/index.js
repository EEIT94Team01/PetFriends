function changeForm(checked){
	if (checked==1) {
		$("#localtionChange").text("走失地點：");
		$("#DateChange").text("走失地點：");
	}
	if (checked==2||checked==3) {
		$("#localtionChange").text("拾獲地點：");
		$("#DateChange").text("拾獲日期：");
	}
	if (checked==4) {
		$("#localtionChange").text("寵物現在地點：");
		$("#DateChange").text("養育時間(從)：");
	}
}
function clearForm() {
	$("input[name='PetForm'][value='1']").attr('selected', true);
	$("#PetType option[value='']").attr('selected', true);
    $("#FindCity option[value='']").attr('selected', true);
    $("#PetGender option[value='']").attr('selected', true);
	$("span").text("");
	$("input:text").val("");
	
	$("textarea").val("");
}