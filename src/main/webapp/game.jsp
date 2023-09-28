<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quest Game</title>
</head>
<body>
<h1>Quest Game</h1>
<h2>${currentQuestionText}</h2>

<form action="play" method="post">
    <ul>
        <c:forEach var="entry" items="${currentQuestionAnswers}">
            <li>
                <input type="radio" name="selectedAnswerId" value="${entry.key}" id="answer${entry.key}">
                <label for="answer${entry.key}">${entry.value}</label>
            </li>
        </c:forEach>
    </ul>
    <button type="submit">Submit Answer</button>
</form>
</body>
</html>
