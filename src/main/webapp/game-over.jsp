<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Игра завершена</title>
</head>
<body>
<h1>Игра завершена</h1>

<p>Спасибо за участие в игре!</p>

<p><a href="<%= request.getContextPath() %>/restart">Начать заново</a></p>
</body>
</html>
