<%@ page import="Models.DTO.ThreadWithCommentsDTO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <% ThreadWithCommentsDTO threadWithComments = (ThreadWithCommentsDTO) request.getSession().getAttribute("threadWithComments"); %>
    <title>Thread</title>
</head>
<body>
<h1><%= threadWithComments.getThread().getTitle() %>
</h1>
<div class="card">
    <div class="card-body">
        <p><%= threadWithComments.getThread().getDescription() %>
        </p>

        <form name="DeleteThreadById" action="<%= request.getContextPath() %>/DeleteThread" method="POST">
            <input type="hidden" name="id" value="<%= threadWithComments.getThread().getId() %>">
            <input type="submit" value="Delete thread"/>
        </form>
    </div>
</div>
</body>
</html>
