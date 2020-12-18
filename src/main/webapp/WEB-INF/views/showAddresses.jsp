<%@ include file="../jsp/headerFrame.jsp" %>

<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#addressform">Ajouter une adresse</button>

<div class="card mt-1 collapse" id="addressform">
    <div class="card-body">
        <form method="POST" action="/Escalade/address">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="user">Utilisateur :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="userfk" id="user">
                        <spring:forEach var="user" items="${ users }">
                            <option value="<spring:out value="${ user.id }" />">
                                <spring:out value="${ user.firstName }" />
                                <spring:out value="${ user.lastName }" />
                            </option>
                        </spring:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="street">Numéro de voie :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="street" id="street" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="streetname">Nom de voie :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="streetname" id="streetname" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="postalcode">Code postal :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="postalcode" id="postalcode" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="city">Ville :</label>
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

            <button class="btn btn-primary" type="submit">Envoyer</button>

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
          <td></td>
          <td></td>
      </tr>
    </thead>
    <tbody>
        <spring:forEach var="address" items="${ addresses }">
        <tr>
            <td><spring:out value="${ address.street }" /></td>
            <td><spring:out value="${ address.streetName }" /></td>
            <td><spring:out value="${ address.postalCode }" /></td>
            <td><spring:out value="${ address.city }" /></td>
            <td><a href="/Escalade/address/<spring:out value="${ address.id }" />">Voir/Editer</a></td>
            <td><a href="/Escalade/address/delete/<spring:out value="${ address.id }" />">Supprimer</a></td>
        </tr>
        </spring:forEach>
    </tbody>
</table>

<%@ include file="../jsp/footerFrame.jsp" %>