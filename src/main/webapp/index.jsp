<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<form name="form" action="<%=request.getContextPath()%>/Login" method="post">
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
            <td>Password</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Login"/>
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
                <input type="hidden" name="page" value="register">
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>