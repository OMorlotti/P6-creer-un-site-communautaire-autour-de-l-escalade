<%@ include file="../jsp/header.jsp" %>

<form method="POST" action="/Escalade/search">

<h4>Recherche</h4>

<div class="card mt-1 collapse" id="searchform">
    <div class="card-body">
        <form method="POST" action="/Escalade/search">

            <input type="hidden" name="userfk" value="<spring:out value="${ user.id }" />" />

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="departement">Code postal :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="departement" id="departement" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="cotation">Cotation :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="cotation" id="cotation" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="sectorsnumber">sectorsnumber :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="sectorsnumber" id="sectorsnumber" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="city">Nombre de  viues :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="city" id="city" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="country">Pays :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="country" id="country" />
                </div>
            </div>

            <div class="text-right">
                <button class="btn btn-primary" type="submit">Envoyer</button>
            </div>

        </form>
    </div>
</div>

<table class="table table-sm table-striped mt-2">
    <thead>
      <tr>
          <td>N° de voie</td>
          <td>Nom de voie</td>
          <td>Code postal</td>
          <td>Ville</td>
          <spring:if test="${not (sessionScope.currentUser.id eq -1)}">
          <td></td>
          <td></td>
          </spring:if>
      </tr>
    </thead>
    <tbody>
        <spring:forEach var="address" items="${ addresses }">
        <tr>
            <td><spring:out value="${ address.street }" /></td>
            <td><spring:out value="${ address.streetName }" /></td>
            <td><spring:out value="${ address.postalCode }" /></td>
            <td><spring:out value="${ address.city }" /></td>
            <spring:if test="${not (sessionScope.currentUser.id eq -1)}">
            <td><a href="/Escalade/address/<spring:out value="${ address.id }" />">Voir/Editer</a></td>
            <td><a href="/Escalade/address/delete/<spring:out value="${ address.id }" />">Supprimer</a></td>
            </spring:if>
        </tr>
        </spring:forEach>
    </tbody>
</table>


</form>

<%@ include file="../jsp/footer.jsp" %>