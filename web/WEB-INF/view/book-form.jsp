<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/index.jsp"/>
<!DOCTYPE html>
<html>
<header>
    <title>Save Book</title>
</header>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading badge badge-info"><h3>Add Book</h3></div>
        <p>

        <div class="panel-body">
            <form:form action="saveBook" modelAttribute="book" method="POST">
                <form:hidden path="id"/>
                <div class="form-group row">
                    <label for="bookName" class="col-sm-2 col-form-label badge badge-info"><h5>Book Name: </h5></label>

                    <div class="col-md-10">
                        <form:input path="bookName" name="bookName" class="form-control" placeholder="Book Name"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label badge badge-info" style="display: inline-block"><h5>Book
                        Type: </h5></label>

                    <div class="col-md-10">
                        <form:input path="bookType" class="form-control" style="display: inline-block"
                                    placeholder="Book Type"/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2 col-form-label">
                        <label class="badge badge-info"><h5>Select Author(s): </h5></label>
                    </div>
                    <div class="col-md-10">
                        <form:select id="authors" name="authors" path="authors" multiple="true"
                                     class="form-control">
                            <c:forEach var="author" items="${authors}">
                                <form:option value="${author.id}">
                                    <c:out value="${author.authorName} ${author.authorLastName}"/></form:option>
                            </c:forEach>
                        </form:select>
                        <br>
                        <button type="submit" class="btn btn-primary">Save Book</button>
                    </div>

                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>


<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<jsp:include page="/index.jsp"/>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>

<%--<header>--%>
<%--<title>Save Book</title>--%>
<%--<link--%>
<%--type="text/css"--%>
<%--rel="stylesheet"--%>
<%--href="${pageContext.request.contextPath}/resources/css/style.css"--%>
<%--/>--%>
<%--<link--%>
<%--type="text/css"--%>
<%--rel="stylesheet"--%>
<%--href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"--%>
<%--/>--%>
<%--</header>--%>

<%--<body>--%>
<%--<div>--%>
<%--<h2>Add Book</h2>--%>
<%--</div>--%>
<%--<div id="container">--%>
<%--<form:form action="saveBook" modelAttribute="book" method="POST">--%>
<%--<form:hidden path="id"/>--%>
<%--<table>--%>
<%--<tbody>--%>
<%--<tr>--%>
<%--<td><label>Book Name</label></td>--%>
<%--<td><form:input path="bookName"></form:input></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td><label>Book Type</label></td>--%>
<%--<td><form:input path="bookType"></form:input></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td><label>Author List</label></td>--%>
<%--<div id="container2">--%>
<%--<td>--%>
<%--<form:select id="authors" name="authors" path="authors" multiple="true">--%>
<%--<c:forEach var="author" items="${authors}">--%>
<%--<form:option value="${author.id}"><c:out--%>
<%--value="${author.authorName} ${author.authorLastName}"/></form:option>--%>
<%--</c:forEach>--%>
<%--</form:select>--%>
<%--</td>--%>
<%--</div>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td><label></label></td>--%>
<%--<td><input type="submit" value="Save Book" class="save"></td>--%>
<%--</tr>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--</form:form>--%>
<%--<div>--%>
<%--<p>--%>
<%--<a href="${pageContext.request.contextPath}/book/list">Back to list</a>--%>
<%--</p>--%>

<%--<p>--%>
<%--<a href="${pageContext.request.contextPath}/">Back to main menu</a>--%>
<%--</p>--%>
<%--</div>--%>
<%--</div>--%>

<%--</body>--%>

<%--</html>--%>