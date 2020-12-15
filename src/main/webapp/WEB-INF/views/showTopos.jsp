<%@ include file="../jsp/header.jsp" %>

<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#topoform">Ajouter un topo</button>

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

            <button class="btn btn-primary" type="submit">Envoyer</button>

        </form>
    </div>
</div>

<table class="table table-sm table-striped mt-2">
    <spring:forEach var="topo" items="${ topos }">
    <tr>
        <td><spring:out value="${ topo.name }" /></td>
        <td><spring:out value="${ topo.description }" /></td>
        <td><spring:out value="${ topo.city }" /></td>
        <td><spring:out value="${ topo.postalCode }" /></td>
        <td><spring:if test="${ topo.isAvailable == 'true' }">disponible</spring:if><spring:if test="${ topo.isAvailable == 'false' }">indisponible</spring:if></td>
        <td><a href="/Escalade/topo/<spring:out value="${ topo.id }" />">Voir/Editer</a></td>
        <td><a href="/Escalade/topo/delete/<spring:out value="${ topo.id }" />">Supprimer</a></td>
    </tr>
    </spring:forEach>
</table>

<%@ include file="../jsp/footer.jsp" %>