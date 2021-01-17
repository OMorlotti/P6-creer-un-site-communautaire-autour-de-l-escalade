<%@ include file="../jsp/header.jsp" %>

<h5 class="text-center">Bienvenue sur le site des Amis de l'escalade</h5>

<h5 class="text-center">Bonne visite !</h5>

<spring:if test="${ sessionScope.currentUser.id eq -1 }">
<div class="text-center my-4">
    <a class="btn btn-success mr-1" href="/Escalade/login" style="width: 200px;">M'authentifier</a>
    <a class="btn btn-success ml-1" href="/Escalade/users" style="width: 200px;">Créer mon compte</a>
</div>
</spring:if>

<%@ include file="../jsp/footer.jsp" %>