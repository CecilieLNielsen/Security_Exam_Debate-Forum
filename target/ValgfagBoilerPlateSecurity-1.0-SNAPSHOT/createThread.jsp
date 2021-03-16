<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 22/02/2021
  Time: 12.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Create thread</title>
</head>
<body>
<h1>Make a thread</h1>

<br>



<select class="form-select" aria-label="Category">
    <option selected>Choose category</option>
    <option value="1">Baking</option>
    <option value="2">Animals</option>
    <option value="3">Beauty</option>
</select>

<br>
<br>

<div class="mb-3">
    <label for="exampleFormControlInput1" class="form-label">Title</label>
    <input type="title" class="form-control" id="exampleFormControlInput1">
</div>

<br>

<div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label">Write your post</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
<button type="button" class="btn btn-primary">Create</button>
</body>
</html>
