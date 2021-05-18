<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://www.google.com/recaptcha/api.js"></script>
    <script>
        function onSubmit(token) {
            document.getElementById("registerForm").submit();
        }
    </script>
    <title>Register</title>
</head>
<body>
<form name="Register" action="<%=request.getContextPath()%>/Register" method="post" id="registerForm">
    <table align="center">
        <tr>
            <td></td>
            <td>
                <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password1"/></td>
        </tr>
        <tr>
            <td>Retype password</td>
            <td><input type="text" name="password2"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button class="g-recaptcha"
                        data-sitekey="reCAPTCHA_site_key"
                        data-callback='onSubmit'
                        data-action='submit'>Register</button>
                <input type="reset" value="Reset"/>
            </td>
        </tr>
    </table>
</form>
<form name="GoTo" action="<%= request.getContextPath() %>/GoTo" method="POST">
    <table align="center">
        <tr>
            <td></td>
            <td>
                <input type="hidden" name="page" value="index">
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
