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
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/allThreads.css">
    <title>All threads</title>
    <% UserBean userBean = (UserBean) session.getAttribute("userBean"); %>
    <%
        if (userBean == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="wrapper wrapper-content animated fadeInRight">

                <div class="ibox-content m-b-sm border-bottom">
                    <div class="p-xs">
                        <div class="pull-left m-r-md">
                            <i class="fa fa-globe text-navy mid-icon"></i>
                        </div>
                        <h2>Welcome <%= userBean.getUsername() %> to our forum</h2>
                        <span>Feel free to choose topic you're interested in.</span>

                        <div class="pull-right forum-desc">
                            <form name="GoTo" action="<%= request.getContextPath() %>/GoTo" method="POST"
                                  id="createThread">
                                <input type="hidden" name="page" value="createThread">
                                <a href="javascript:{}" onclick="document.getElementById('createThread').submit();"
                                   class="forum-item-title">
                                    <i class="fa fa-edit"></i>
                                    Make new post
                                </a>
                            </form>
                        </div>

                    </div>
                </div>

                <div class="ibox-content forum-container">

                    <div class="forum-title">
                        <h3>Threads</h3>
                    </div>

                    <c:forEach var="thread" items="${allThreads}">
                        <div class="forum-item active">
                            <div class="row">
                                <div class="col-md-7">
                                    <div class="forum-icon">
                                        <i class="fa fa-bullhorn"></i>
                                    </div>
                                    <form name="GetThreadById" action="<%= request.getContextPath() %>/GetThreadById"
                                          method="POST" id="getThreadById:${thread.id}">
                                        <input type="hidden" name="id" value="${thread.id}">
                                        <a href="javascript:{}"
                                           onclick="document.getElementById('getThreadById:${thread.id}').submit();"
                                           class="forum-item-title">${thread.title}</a>
                                    </form>
                                    <div class="forum-sub-title">${thread.category}</div>
                                </div>
                                <div class="col-md-4 forum-info">
                                    <small>Author:</small>
                                    <div>
                                        <small>${thread.author}</small>
                                    </div>
                                </div>
                                <div class="col-md-1 forum-info">
                                        <span class="views-number">
                                                0
                                        </span>
                                    <div>
                                        <small>Comments</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

