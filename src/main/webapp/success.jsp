<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body> 
<c:if test="${not empty message}">
	<h1>${message})</h1>
</c:if>

</body>

</html>
