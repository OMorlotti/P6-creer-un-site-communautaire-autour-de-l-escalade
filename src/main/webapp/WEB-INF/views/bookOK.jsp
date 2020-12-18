<%@ include file="../jsp/header.jsp" %>

<p>La réservation <spring:out value="${ id }" /> a été acceptée !</p>

<a class="btn btn-success" href="/Escalade/topo/<spring:out value="${ topo.id }" />">Retour à la page du topo réservé</a>

<%@ include file="../jsp/footer.jsp" %>