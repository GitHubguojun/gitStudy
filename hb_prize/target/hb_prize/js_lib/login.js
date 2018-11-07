/**
 * 根据用户名和密码验证登录
 */

function check() {
	var userName = $("#username").val();
	var pwd = $("#password").val();
	if (userName == "") {
		$(".lab1").empty();
		$(".lab1").append("用户名不能为空").css('color', 'red');
		return false;
	}
	if (pwd == "") {
		$(".lab1").empty();
		$(".lab1").append("密码不能为空").css('color', 'red');
		return false;
	}
	var form = document.getElementById("form1");
	form.action = "/timeSheet/Empl/queryUserAndPwd";
	form.submit();
}