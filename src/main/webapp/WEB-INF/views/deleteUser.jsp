<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../jsp/header.jsp" %>

<p>L'utilisateur <spring:out value="${ id }" /> a été supprimé !</p>

<a class="btn btn-success" href="/Escalade/users">Retour à la page des utilisateurs</a>

<%@ include file="../jsp/footer.jsp" %>