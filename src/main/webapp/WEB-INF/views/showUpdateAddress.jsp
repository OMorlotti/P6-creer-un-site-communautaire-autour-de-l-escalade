<%@ include file="../jsp/headerFrame.jsp" %>

<h4>Détails de l'adresse « #<spring:out value="${ address.id }" /> »</h4>

<form method="POST" action="/Escalade/address/update/<spring:out value="${ address.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="street">Numéro de voie :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="street" value="<spring:out value="${ address.street }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="streetname">Nom de voie :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="streetname" value="<spring:out value="${ address.streetName }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="postalcode">Code postal :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="postalcode" value="<spring:out value="${ address.postalCode }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="city">Ville :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="city" value="<spring:out value="${ address.city }" />" required="required" />
        </div>
    </div>
     <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="country">Pays :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="country" value="<spring:out value="${ address.country }" />" required="required" />
        </div>
    </div>

    <div class="text-right">
        <button class="btn btn-primary" type="submit">Envoyer</button>
    </div>

</form>

<%@ include file="../jsp/footerFrame.jsp" %>