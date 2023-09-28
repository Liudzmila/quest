<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Игра завершена</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card">
                <div class="card-body">
                    <h1 class="text-center display-4">Игра завершена</h1>
                    <p class="text-center">Спасибо за участие в игре, ${authenticatedUserName}!</p>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/restart" class="btn btn-primary">Начать заново</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>