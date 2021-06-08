function _change() {
	$("#imgVerifyCode").attr("src", "/managementSystemOfShipLibrary/VerifyCodeServlet?a=" + new Date().getTime());
}