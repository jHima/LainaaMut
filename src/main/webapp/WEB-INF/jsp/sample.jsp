<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello Maailma! </h2>
<p>nimi: ${nimi}</p>
<p>eli: ${alias}</p>
<c:forEach var="tavara" items="${tavarat}">

    <p>tavaran nimi <c:out value="${tavara.nimi}"/></p>
    <p>kuvaus: <c:out value="${tavara.kuvaus}"/> </p>
</c:forEach>
</body>
</html>