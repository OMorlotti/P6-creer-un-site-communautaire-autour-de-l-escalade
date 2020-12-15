<%@ include file="../jsp/header.jsp" %>

<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#spotform">Ajouter un spot</button>

<form class="collapse" method="POST" action="/Escalade/spot" id="spotform">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="userfk">Utilisateur :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="userfk" id="user">
                <spring:forEach var="user" items="${ users }">
                    <option value="<spring:out value="${ user.id }" />">
                        <spring:out value="${ user.login }" />
                        -
                        <spring:out value="${ user.firstName }" />
                        <spring:out value="${ user.lastName }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="topofk">Topo :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="topofk" id="topofk">
                <spring:forEach var="topo" items="${ topos }">
                    <option value="<spring:out value="${ topo.id }" />">
                        <spring:out value="${ topo.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="departement">Département :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="departement" id="departement" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="latitude">Latitude :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="latitude" id="latitude" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="longitude">Longitude :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="longitude" id="longitude" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="isofficial">Est officiel :</label>
         <div class="col-sm-10">
             <select class="custom-select custom-select-sm" name="isofficial" id="isofficial">
                 <option value="0">Spot non officiel</option>
                 <option value="1">Spot officiel</option>
             </select>
         </div>
    </div>

    <button class="btn btn-primary" type="submit">Envoyer</button>

</form>

<table class="table table-sm table-striped mt-2">
    <spring:forEach var="spot" items="${ spots }">
    <tr>
        <td><spring:out value="${ spot.name }" /></td>
        <td><spring:out value="${ spot.userFK.login }" /></td>
        <td><spring:out value="${ spot.topoFK.name }" /></td>
        <td><spring:out value="${ spot.departement }" /></td>
        <td><spring:if test="${ spot.isOfficial == 'true' }">Officiel</spring:if><spring:if test="${ spot.isOfficial == 'false' }">Non officiel</spring:if></td>
        <td><a href="/Escalade/spot/<spring:out value="${ spot.id }" />">Voir/Editer</a></td>
        <td><a href="/Escalade/spot/delete/<spring:out value="${ spot.id }" />">Supprimer</a></td>
    </tr>
    </spring:forEach>
</table>

<%@ include file="../jsp/footer.jsp" %>