<%@ include file="../jsp/header.jsp" %>

<p>Félicitations, le nouvel utilisateur <spring:out value="${ login }" /> a été ajouté !</p>

<a class="btn btn-success" href="/Escalade/users">Retour à la page des Utilisateurs</a>

<%@ include file="../jsp/footer.jsp" %>