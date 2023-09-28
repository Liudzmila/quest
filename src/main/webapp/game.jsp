<%@ page import="in.javarush.sobaleva.quest.entity.Answer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>${gameName}</title>
</head>
<body>
<div class="container mt-5">
    <h1 class="display-4">${gameName}</h1>

    <form action="${pageContext.request.contextPath}/game" method="post">
        <img src="${questionImagePath}" alt="Изображение вопроса">
        <h3 class="mb-4 game-user text-success">${authenticatedUserName},</h3>
        <h4 class="mb-4 question-text text-success">${questionText}</h4>
        <ul class="list-group">
            <c:forEach var="answer" items="${answers}">
                <li class="list-group-item">
                    <input type="radio" name="answerId" value="${answer.id}" class="form-check-input me-2" required>
                    <label class="form-check-label text-success">${answer.text}</label>
                </li>
            </c:forEach>
        </ul>
        <button type="submit" name="submit" class="btn btn-primary mt-3">Ответить</button>
    </form>
</div>
</body>
</html>