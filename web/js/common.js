function _change() {
	$("#imgVerifyCode").attr("src", "/managementSystemOfShipLibrary/verifyCodeAction.action?a=" + new Date().getTime());
	alert($("#imgVerifyCode").attr("src"));
}