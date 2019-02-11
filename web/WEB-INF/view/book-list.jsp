<%--
  Created by IntelliJ IDEA.
  User: ibrahimg
  Date: 02.11.2018
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:include page="/index.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<div class="container" style="margin-top: 5%;">
    <div class="row">
        <form:form class="col-md-12" method="GET" action="searchBook">
            <div class="form-group row">
                <div class="col-md-4">
                    <input type="text" class="form-control" id="searchName" name="searchName"
                           placeholder="For Example: Book Name">
                </div>
                <div class="float-right">
                    <button type="submit" class="btn btn-default btn-primary">Search Book</button>
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
                            <h3 class="panel-title">Books Table</h3>
                        </div>
                        <div class="col col-xs-6 text-right">
                            <button type="button" class="btn btn-sm btn-primary btn-create"
                                    onclick="window.location.href = 'showFormForAddBooks'; return false">Add Book
                            </button>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table  table-bordered">
                        <thead>
                        <tr>
                            <th>Book Name</th>
                            <th>Book Type</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="tempBook" items="${books}">

                            <c:url var="updateBookLink" value="/book/showFormForUpdate">

                                <c:param name="bookId" value="${tempBook.id}"/>

                            </c:url>

                            <c:url var="deleteBookLink" value="/book/showFormForDelete">

                                <c:param name="bookId" value="${tempBook.id} "/>

                            </c:url>

                            <c:url var="showAuthor" value="/book/showAuthorForBook">

                                <c:param name="bookId" value="${tempBook.id}"/>

                            </c:url>

                            <tr>
                                <td>${tempBook.bookName}</td>
                                <td>${tempBook.bookType}</td>
                                <td>
                                    <button type="button" class="btn btn-success">
                                        <span class="glyphicon glyphicon-search"></span>
                                        <a href="${updateBookLink}">Update</a>
                                    </button>

                                    <button type="button" class="btn btn-danger">
                                        <span class="glyphicon glyphicon-search"></span>
                                        <a href="${deleteBookLink}"
                                           onclick="if(!(confirm('Are you sure you want to delete this?'))) return false">Delete</a>
                                    </button>

                                    <button type="button" class="btn btn-warning">
                                        <span class="glyphicon glyphicon-search"></span>
                                        <a href="${showAuthor}">Show author(s)</a>
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
