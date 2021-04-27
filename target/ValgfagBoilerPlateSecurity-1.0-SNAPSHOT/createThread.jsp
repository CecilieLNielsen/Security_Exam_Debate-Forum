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

    <title>Create post</title>
</head>
<body>
<h4>Please fill in the following to make a post</h4>

<br>





<br>
<br>

<form name="CreateThread" action="<%= request.getContextPath() %>/CreateThread" method="POST">

    <div class="mb-3">
        <label for="title" class="form-label">Title</label>
        <input type="text" class="form-control" id="title" name="title"/>
    </div>

    <div class="mb-3">
        <label for="category" class="form-label">Category</label>
        <input type="text" class="form-control" id="category" name="category"/>
    </div>

    <div class="mb-3">
        <label for="description" class="form-label">Write your post</label>
        <textarea type="text" class="form-control" id="description" name="description" rows="3"></textarea>
    </div>
    <input type="submit" value="Create"/>
</form>

<form name="Cancel" action="<%= request.getContextPath() %>/Cancel" method="POST">
    <input type="submit" value="Cancel"/>
</form>
</body>
</html>
