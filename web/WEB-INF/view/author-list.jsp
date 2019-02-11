<%--
  Created by IntelliJ IDEA.
  User: ibrahimg
  Date: 08.11.2018
  Time: 09:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:include page="/index.jsp"/>
<html>
<head>
    <title>Author List</title>
</head>
<body>
<div class="container" style="margin-top: 5%;">
    <div class="row">
        <form:form class="col-md-12" method="GET" action="searchAuthor">
            <div class="form-group row">
                <div class="col-md-4">
                    <input type="text" class="form-control" id="searchNameAndLastName" name="searchNameAndLastName"
                           placeholder="For Example: Author Name">
                </div>
                <div class="float-right">
                    <button type="submit" class="btn btn-default btn-primary">Search Author</button>
                </div>
            </div>
        </form:form>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Author Table</h3>
                        </div>
                        <div class="col col-xs-6 text-right">
                            <button type="button" class="btn btn-sm btn-primary btn-create"
                                    onclick="window.location.href = 'showFormForAddAuthor'; return false">Add Author
                            </button>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table  table-bordered">
                        <thead>
                        <tr>
                            <th>Author Name</th>
                            <th>Author Last Name</th>
                            <th>Author Birth Date</th>
                            <th>Author Death Date</th>
                        </tr>
                        <c:forEach var="tempAuthor" items="${authors}">

                            <c:url var="updateAuthorLink" value="/author/showFormForAuthorUpdate">

                                <c:param name="authorId" value="${tempAuthor.id}"/>

                            </c:url>

                            <c:url var="deleteAuthorLink" value="/author/showFormForAuthorDelete">

                                <c:param name="authorId" value="${tempAuthor.id} "/>

                            </c:url>

                            <c:url var="showBooks" value="/author/showBooksAuthor">

                                <c:param name="authorId" value="${tempAuthor.id}"/>

                            </c:url>

                            <tr>
                                <td>${tempAuthor.authorName}</td>
                                <td>${tempAuthor.authorLastName}</td>
                                <td>${tempAuthor.birthDate}</td>
                                <td>${tempAuthor.deathDate}</td>
                                <td>
                                    <button type="button" class="btn btn-success">
                                        <span class="glyphicon glyphicon-search"></span>
                                        <a href="${updateAuthorLink}">Update</a>
                                    </button>

                                    <button type="button" class="btn btn-danger">
                                        <span class="glyphicon glyphicon-search"></span>
                                        <a href="${deleteAuthorLink}"
                                           onclick="if(!(confirm('Are you sure you want to delete this?'))) return false">Delete</a>
                                    </button>

                                    <button type="button" class="btn btn-warning">
                                        <span class="glyphicon glyphicon-search"></span>
                                        <a href="${showBooks}">Show book(s)</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </thead>
                    </table>
                </div>
                <div class="panel-footer">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
