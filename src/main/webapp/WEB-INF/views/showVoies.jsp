<%@ include file="../jsp/headerFrame.jsp" %>

<h4>Liste des voies</h4>

<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#voieform">Ajouter une voie</button>

<div class="card mt-1 collapse" id="voieform">
    <div class="card-body">
        <form method="POST" action="/Escalade/voie">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="height">Hauteur [mètres]:</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="height" id="height" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="secteurfk">Secteur :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="secteurfk" id="secteur">
                        <spring:forEach var="secteur" items="${ secteurs }">
                            <option value="<spring:out value="${ secteur.id }" />">
                                <spring:out value="${ secteur.id }" />
                                -
                                <spring:out value="${ secteur.name }" />
                            </option>
                        </spring:forEach>
                    </select>
                </div>
            </div>

            <button class="btn btn-primary" type="submit">Envoyer</button>

        </form>
    </div>
</div>

<table class="table table-sm table-striped mt-2">
    <spring:forEach var="voie" items="${ voies }">
    <tr>
        <td><spring:out value="${ voie.id }" /></td>
        <td><spring:out value="${ voie.height }" /></td>
        <td><spring:out value="${ voie.secteurFK.name }" /></td>
        <td><a href="/Escalade/voie/<spring:out value="${ voie.id }" />" target="_blank">Voir/Editer</a></td>
        <td><a href="/Escalade/voie/delete/<spring:out value="${ voie.id }" />">Supprimer</a></td>
    </tr>
    </spring:forEach>
</table>

<%@ include file="../jsp/footerFrame.jsp" %>