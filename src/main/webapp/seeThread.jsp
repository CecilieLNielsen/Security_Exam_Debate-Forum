<%@ page import="Models.DTO.ThreadWithCommentsDTO" %>
<%@ page import="Models.Beans.UserBean" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css"
          integrity="sha256-46r060N2LrChLLb5zowXQ72/iKKNiw/lAmygmHExk/o=" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/seeThread.css">
    <% ThreadWithCommentsDTO threadWithComments = (ThreadWithCommentsDTO) request.getSession().getAttribute("threadWithComments"); %>
    <title><%= threadWithComments.getThread().getTitle() %>
    </title>
    <% UserBean userBean = (UserBean) session.getAttribute("userBean"); %>
    <%
        if (userBean == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    %>
</head>
<body>
<div class="container">
    <div class="card mb-2">
        <div class="card-body p-2 p-sm-3">
            <div class="media forum-item">
                <div class="media-body">
                    <h5><%= threadWithComments.getThread().getTitle() %>
                    </h5>
                    <p class="text-secondary"><%= threadWithComments.getThread().getDescription() %>
                    </p>
                    <small>
                        <%= threadWithComments.getThread().getAuthor() %>
                        created this thread at:
                        <%= threadWithComments.getThread().getDateOfCreation() %>
                    </small>
                    <br>
                    <small>
                        <%= threadWithComments.getThread().getAuthor() %>
                        updated this thread at:
                        <%= threadWithComments.getThread().getDateOfUpdate() %>
                    </small>
                </div>
                <% if ("ADMIN".equals(userBean.getRole()) || userBean.getUsername() == threadWithComments.getThread().getAuthor()) { %>
                <form name="DeleteThreadById" action="<%= request.getContextPath() %>/DeleteThread"
                      method="POST" id="deleteThread">
                    <input type="hidden" name="id" value="<%= threadWithComments.getThread().getId() %>">
                    <a href="javascript:{}" onclick="document.getElementById('deleteThread').submit();"
                       class="forum-item-title">
                        <i class="fa fa-trash"></i>
                        Delete thread
                    </a>
                </form>
                <% } %>
            </div>
        </div>
    </div>

    <c:forEach var="comment" items="<%= threadWithComments.getComments() %>">
        <div class="inner-main-body p-2 p-sm-3 forum-content">
            <div class="card mb-2">
                <div class="card-body p-2 p-sm-3">
                    <div class="media forum-item">
                        <div class="media-body">
                            <p class="text-secondary">
                                    ${comment.description}
                            </p>
                            <small>${comment.author} replied ${comment.dateOfCreation}</small>
                            <br>
                            <small>${comment.author} edited ${comment.dateOfUpdate}</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
