<%@ include file="../jsp/header.jsp" %>

Hello <spring:out value="${ sessionScope.currentUser.login }" />

<%@ include file="../jsp/footer.jsp" %>