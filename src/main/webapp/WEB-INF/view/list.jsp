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
    <table border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>닉네임</th>
                <th>포지션</th>
                 <th>삭제</th>
                 <th>수정</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.name}</td>
                    <td>${member.nickname}</td>
                    <td>${member.position}</td>
                    <td>
                    <form name="deleteBoard" id="deleteBoard" method="post" action="/delete">
                    <input type="hidden" name="id" value=${member.id}></input>
                    <input type="hidden" name="name" value=${member.name}></input>
                    <input type="submit" value="삭제"></form>
                    </td>
                    <td>
                    <form name="UpdateBoard" id="UpdateBoard" method="get" action="/updateMember">
                    <input type="hidden" name="id" value=${member.id}></input>
                    <input type="submit" value="수정"></form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>

</html