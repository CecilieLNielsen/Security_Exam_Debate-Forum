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
    <title>Startpage</title>
</head>
<body>
// Nav - My profile - login/logout

<br/>
<br/>
<h1>All threads</h1>
<br/>
<form name="GetAllThreads" action="<%= request.getContextPath() %>/GetAllThreads" method="POST">
    <input type="submit" value="Get all threads"/>
</form>
<br/>

<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Titel</th>
            <th scope="col">Category?</th>
            <th scope="col">Created by</th>
            <th scope="col">Date creation</th>
            <th scope="col">Updated?</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="thread" items="${allThreads}">
            <tr>
                <th scope="row">${thread.id}</th>
                <td>${thread.title}</td>
                <td>${thread.category}</td>
                <td>${thread.author}</td>
                <td>${thread.dateOfCreation}</td>
                <td>${thread.dateOfUpdate}</td>
                <td>
                    <form name="GetThreadById" action="<%= request.getContextPath() %>/GetThreadById" method="POST">
                        <input type="hidden" name="id" value="${thread.id}">
                        <input type="submit" value="See thread"/>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    // Sorting and search?
</div>
</body>
</html>

