<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Начать игру</title>
</head>
<body>
<h1>Добро пожаловать в квест-игру!</h1>
<form action="${pageContext.request.contextPath}/start" method="get">
    <label for="userName">Введите ваше имя: </label>
    <input type="text" id="userName" name="userName" required>
    <input type="submit" value="Начать игру">
</form>
</body>
</html>