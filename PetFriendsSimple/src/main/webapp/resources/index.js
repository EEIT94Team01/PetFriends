function changeForm(checked){
	if (checked==1) {
		$("input[name=FindDate]").prop("disabled",false);
		$('tr').find('td').eq(18).text("走失地點：");
		$('tr').find('td').eq(21).text("走失日期：");
	}
	if (checked==2||checked==3) {
		$("input[name=FindDate]").prop("disabled",false);
		$('tr').find('td').eq(18).text("拾獲地點：");
		$('tr').find('td').eq(21).text("拾獲日期：");
	}
	if (checked==4) {
		$("input[name=FindDate]").prop("disabled",true);
		$('tr').find('td').eq(18).text("地點：");
		$('tr').find('td').eq(21).text("日期：");
	}
}