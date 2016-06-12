<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <style><jsp:include page="WEB-INF/Style/Style.css"/></style>
</head>
<body>
<!-- HTML for SEARCH BAR -->
<div id="tfheader">
    <form id="tfnewsearch" method="get" action="${pageContext.request.contextPath}/test">
        <div style="display: table-cell;">
            <select name="fLanguage" class="langDrop" >
                <c:forEach items="${languages}" var="lang" >
                    <option value="${lang.id}">${lang.name}</option>
                </c:forEach>
            </select>
            <br/>
            <textarea name="fWord" cols="40" rows="5"><c:if test="${not empty tWord}">
                    ${fWord}
                </c:if></textarea>
        </div>

        <div style="display: table-cell;">
            <select name="tLanguage" class="langDrop">
                <c:forEach items="${languages}" var="lang" >
                    <option value="${lang.id}">${lang.name}</option>
                </c:forEach>
            </select>
            <br/>
                <textarea  cols="40" rows="5">
                    <c:if test="${not empty tWord}">
                        ${tWord}
                    </c:if>
                </textarea>
        </div>
        <input type="submit" value="search" class="tfbutton"/>
    </form>
    <div class="tfclear"></div>
</div>

<div class="content">
    <c:if test="${not empty description}">
        <h2> ${word}</h2>
        ${description}
    </c:if>
</div>



</body>
</html>