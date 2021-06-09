<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="<c:url value='/jsps/css/user/regist.css'/>" type="text/css">
    <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/jsps/js/user/regist.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
    <script type="text/javascript">
        function _change()
        {
            $("#imgVerifyCode").attr("src", "/managementSystemOfShipLibrary/verifyCodeAction.action?a=" + new Date().getTime());
        }

        //2.切换注册按钮的图片
        $("#submitBtn").hover(function ()
        {
            alert("ok");
            $(this).attr("src", "/managementSystemOfShipLibrary/images/regist2.jpg");

        }, function ()
        {
            alert("no ok;")
            $(this).attr("src", "/managementSystemOfShipLibrary/images/regist1.jpg");
        });
        alert($("#submitBtn"));
    </script>
</head>
<body>
<div id="divMain">

    <div id="divTitle">
        <span id="spanTitle">新用户注册</span>
    </div>

    <div id="divBody">
        <form action="<c:url value='/UserServlet'/> " method="post" id="formRegist">
            <input type="hidden" name="method" value="regist">
            <table id="tableForm">
                <tr>
                    <td class="tdText">用户名：</td>
                    <td class="tdInput"><input class="inputClass" type="text" name="loginname" id="loginname"
                                               value="${user.loginname}"></td>
                    <td class="tdError"><label class="errorClass" id="loginnameError">${errors.loginname}</label></td>
                </tr>
                <tr>
                    <td class="tdText">登录密码：</td>
                    <td><input class="inputClass" type="password" name="loginpass" id="loginpass"
                               value="${user.loginpass}"></td>
                    <td><label class="errorClass" id="loginpassError">${errors.loginpass}</label></td>
                </tr>
                <tr>
                    <td class="tdText">确认密码：</td>
                    <td><input class="inputClass" type="password" name="reloginpass" id="reloginpass"
                               value="${user.reloginpass}"></td>
                    <td><label class="errorClass" id="reloginpassError">${errors.reloginpass}</label></td>
                </tr>
                <tr>
                    <td class="tdText">Email：</td>
                    <td><input class="inputClass" type="text" name="email" id="email" value="${user.email}"></td>
                    <td><label class="errorClass" id="emailError">${errors.email}</label></td>
                </tr>
                <tr>
                    <td class="tdText">验证码：</td>
                    <td><input class="inputClass" type="text" name="verifyCode" id="verifyCode"
                               value="${user.verifyCode}"></td>
                    <td><label class="errorClass" id="verifyCodeError">${errors.verifyCode}</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <div id="divVerifyCode"><img id="imgVerifyCode"
                                                     src="<c:url value='/verifyCodeAction.action'/> ">
                        </div>
                    </td>
                    <td><label><a href="javascript:_change();">换一张</a></label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input id="submitBtn" type="image" src="<c:url value='/images/regist1.jpg'/> " ></td>
                    <td><label></label></td>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>
