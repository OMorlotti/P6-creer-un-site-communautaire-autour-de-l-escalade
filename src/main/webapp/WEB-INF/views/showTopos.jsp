<%@ include file="../jsp/header.jsp" %>

<h4>Liste des topos</h4>

<spring:if test="${not (sessionScope.currentUser.id eq -1)}">
<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#topoform">Ajouter un topo</button>
</spring:if>

<div class="card mt-1 collapse" id="topoform">
    <div class="card-body">
        <form method="POST" action="/Escalade/topo">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="name">Nom :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="name" id="name" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="description">Description :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="description" id="description" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="city">Ville :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="city" id="city" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="postalcode">Code postal :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="postalcode" id="postalcode" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="releasedate">Date de parution :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="date" name="releasedate" id="releasedate" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="isavailable">Disponibilité :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="isavailable" id="isavailable">
                        <option value="0">N'est pas disponible</option>
                        <option value="1">Est disponible</option>
                    </select>
                </div>
            </div>
            <spring:choose>
                <spring:when test="${sessionScope.currentUser.role eq 'ADMIN'}">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="userfk">Utilisateur :</label>
                        <div class="col-sm-10">
                            <select class="custom-select custom-select-sm" name="userfk" id="userfk">
                                <spring:forEach var="user" items="${ users }">
                                    <option value="<spring:out value="${ user.id }" />"<spring:if test="${ user.id == sessionScope.currentUser.id }"> selected</spring:if>>
                                        <spring:out value="${ user.login }" />
                                        -
                                        <spring:out value="${ user.firstName }" />
                                        <spring:out value="${ user.lastName }" />
                                    </option>
                                </spring:forEach>
                            </select>
                        </div>
                    </div>
                </spring:when>
                <spring:otherwise>
                    <input type="hidden" name="userfk" value="<spring:out value="${ sessionScope.currentUser.id }" />" id="userfk" />
                </spring:otherwise>
            </spring:choose>

            <div class="text-right">
                <button class="btn btn-primary" type="submit">Envoyer</button>
            </div>

        </form>
    </div>
</div>

<table class="table table-sm table-striped mt-2">
    <thead>
      <tr>
          <td>Nom</td>
          <td>Description</td>
          <td>Ville</td>
          <td>Code postal</td>
          <td>Disponibilité<sup>1</sup></td>
          <td></td>
          <td></td>
      </tr>
    </thead>
    <tbody>
        <spring:forEach var="topo" items="${ topos }">
        <tr>
            <td><spring:out value="${ topo.name }" /></td>
            <td><spring:out value="${ topo.description }" /></td>
            <td><spring:out value="${ topo.city }" /></td>
            <td><spring:out value="${ topo.postalCode }" /></td>
            <spring:choose>
                <spring:when test="${sessionScope.currentUser.id eq -1}">
                    <td><spring:if test="${ topo.isAvailable == 'true' }">disponible</spring:if><spring:if test="${ topo.isAvailable == 'false' }">non disponible</spring:if></td>
                </spring:when>
                <spring:otherwise>
                    <td><spring:if test="${ topo.isAvailable == 'true' }"><a class="btn btn-sm btn-success p-1" href="/Escalade/topo/book/<spring:out value="${ topo.id }" />?user=<spring:out value="${ parentUser }" />">Réserver</a></spring:if><spring:if test="${ topo.isAvailable == 'false' }"><button class="btn btn-sm btn-danger p-1" type="button" disabled>Réserver</span></spring:if></td>
                </spring:otherwise>
            </spring:choose>
            <spring:choose>
                <spring:when test="${topo.userFK.id eq sessionScope.currentUser.id or sessionScope.currentUser.role eq 'ADMIN'}">
                    <td><a href="/Escalade/topo/<spring:out value="${ topo.id }" />">Voir/Editer</a></td>
                    <td><a href="/Escalade/topo/delete/<spring:out value="${ topo.id }" />">Supprimer</a></td>
                </spring:when>
                <spring:otherwise>
                    <td><a href="/Escalade/topo/<spring:out value="${ topo.id }" />">Voir</a></td>
                    <td>-</td>
                </spring:otherwise>
            </spring:choose>
        </tr>
        </spring:forEach>
    </tbody>
</table>

<div><small>1. Réservation pour les utilisateurs authentifiés seulement</small></div>

<%@ include file="../jsp/footer.jsp" %>