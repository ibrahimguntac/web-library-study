<%--
  Created by IntelliJ IDEA.
  User: ibrahimg
  Date: 08.11.2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/index.jsp"/>
<!DOCTYPE html>
<html>
<header>
    <title>Save Author</title>

    <style>
        .error{
            color: darkred;
        }
    </style>

</header>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading"><h3>Add Author</h3></div>
        <p>

        <div class="panel-body">
            <form:form action="saveAuthor" modelAttribute="author" method="POST">
                <form:hidden path="id"/>
                <div class="form-group row">
                    <label for="authorName" class="col-sm-2 col-form-label badge badge-info"><h5>Author Name: </h5>
                    </label>

                    <div class="col-md-10">
                        <form:input path="authorName" name="authorName" class="form-control" placeholder="Author Name"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label badge badge-info" style="display: inline-block"><h5>Author
                        Last Name: </h5></label>

                    <div class="col-md-10">
                        <form:input path="authorLastName" class="form-control" style="display: inline-block"
                                    placeholder="Author Last Name"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label badge badge-info" style="display: inline-block"><h5>Author
                        Birth Date: </h5></label>

                    <div class="col-md-10">
                        <form:input path="birthDate" class="form-control error" style="display: inline-block"
                                    placeholder="Author Birth Date"/>
                        <form:errors path="birthDate" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label badge badge-info" style="display: inline-block"><h5>Author
                        Death Date: </h5></label>

                    <div class="col-md-10">
                        <form:input path="deathDate" class="form-control error" style="display: inline-block"
                                    placeholder="Author Death Date"/>
                        <form:errors path="deathDate" cssClass="error"/>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Save Author</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

