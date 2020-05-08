<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Practice</title>
</head>
<body>
<form name="loginBoard" id="loginBoard" method="post" action="/login">
    <table border="1">
    <thead>

    </thead>
    <tbody>
    <tr>
        <td>번호</td>
        <td><input type="text" id="id" name="id" /></td>
    </tr>
    <tr>
        <td>이름</td>
        <td><input type="text" id="name" name="name" /></td>
    </tr>
    </tbody>
    </table>
    <input type="submit" name="로그인" value="로그인" id="login" />
</form>
</body>

</html>