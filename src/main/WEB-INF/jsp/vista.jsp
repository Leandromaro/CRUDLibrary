<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>CRUD Library</title>
</head>
<body>

<h2>CRUD Library</h2>

<form:form method="post" action="add" commandName="employee">

    <table>
    <tr>
        <td><form:label path="titulo"><spring:message code="label.titulo"/></form:label></td>
        <td><form:input path="titulo" /></td>
    </tr>
    <tr>
        <td><form:label path="edicion"><spring:message code="label.edicion"/></form:label></td>
        <td><form:input path="edicion" /></td>
    </tr>
    <tr>
        <td><form:label path="isbn"><spring:message code="label.isbn"/></form:label></td>
        <td><form:input path="isbn" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table>
</form:form>


<h3>Books</h3>
<c:if  test="${!empty books}">
<table class="data">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>&amp;amp;amp;amp;amp;amp;nbsp;</th>
</tr>
<c:forEach items="${books}" var="b">
    <tr>

        <td>${b.title}</td>
        <td>${b.edicion}</td>
        <td>${b.isbn}</td>

        <td><a href="delete/${emp.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>