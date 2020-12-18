<%@ include file="../jsp/headerFrame.jsp" %>

<h4>Liste des secteurs</h4>

<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#secteurform">Ajouter un secteur</button>

<div class="card mt-1 collapse" id="secteurform">
    <div class="card-body">
        <form method="POST" action="/Escalade/secteur">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="name">Nom :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="name" id="name" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="spotfk">Spot :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="spotfk" id="spot">
                        <spring:forEach var="spot" items="${ spots }">
                            <option value="<spring:out value="${ spot.id }" />">
                                <spring:out value="${ spot.id }" />
                                -
                                <spring:out value="${ spot.name }" />
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
    <thead>
      <tr>
          <td>Id</td>
          <td>Nom du secteur</td>
          <td>Nom du spot</td>
          <td></td>
          <td></td>
      </tr>
    </thead>
    <spring:forEach var="secteur" items="${ secteurs }">
    <tr>
        <td><spring:out value="${ secteur.id }" /></td>
        <td><spring:out value="${ secteur.name }" /></td>
        <td><spring:out value="${ secteur.spotFK.name }" /></td>
        <td><a href="/Escalade/secteur/<spring:out value="${ secteur.id }" />" target="_blank">Voir/Editer</a></td>
        <td><a href="/Escalade/secteur/delete/<spring:out value="${ secteur.id }" />">Supprimer</a></td>
    </tr>
    </spring:forEach>
</table>

<%@ include file="../jsp/footerFrame.jsp" %>