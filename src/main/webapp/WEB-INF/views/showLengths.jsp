<%@ include file="../jsp/headerFrame.jsp" %>

<h4>Liste des longueurs</h4>

<spring:if test="${not (sessionScope.currentUser.id eq -1)}">
<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#lengthform">Ajouter une longueur</button>
</spring:if>

<div class="card mt-1 collapse" id="lengthform">
    <div class="card-body">
        <form method="POST" action="/Escalade/length" >

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="voiefk">Voie :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="voiefk" id="voie">
                        <spring:forEach var="voie" items="${ voies }">
                            <option value="<spring:out value="${ voie.id }" />"<spring:if test="${ voie.id == parentVoieId }"> selected</spring:if>>
                                <spring:out value="${ voie.id }" />
                                -
                                <spring:out value="${ voie.height }" />
                            </option>
                        </spring:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="cotationfk">Cotation :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="cotationfk" id="cotation">
                        <spring:forEach var="cotation" items="${ cotations }">
                            <option value="<spring:out value="${ cotation.id }" />">
                                <spring:out value="${ cotation.id }" />
                                -
                                <spring:out value="${ cotation.name }" />
                            </option>
                        </spring:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="numberofspit">Nombre de spits :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="numberofspit" id="numberofspit" required="required" />
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
          <td>Id</td>
          <td>Hauteur de la voie</td>
          <td>Cotation</td>
          <td>Nombre de spits</td>
          <td></td>
          <td></td>
       </tr>
    </thead>
    <tbody>
        <spring:forEach var="length" items="${ lengths }">
        <tr>
            <td><spring:out value="${ length.id }" /></td>
            <td><spring:out value="${ length.voieFK.height }" /></td>
            <td><spring:out value="${ length.cotationFK.name }" /></td>
            <td><spring:out value="${ length.numberOfSpits }" /></td>
            <spring:choose>
                <spring:when test="${sessionScope.currentUser.role eq 'MEMBER' or sessionScope.currentUser.role eq 'ADMIN'}">
                    <td><a href="/Escalade/length/<spring:out value="${ length.id }" />" target="_blank">Voir/Editer</a></td>
                    <td><a href="/Escalade/length/delete/<spring:out value="${ length.id }" />">Supprimer</a></td>
                </spring:when>
                <spring:otherwise>
                    <td><a href="/Escalade/length/<spring:out value="${ length.id }" />" target="_blank">Voir</a></td>
                    <td>-</td>
                </spring:otherwise>
            </spring:choose>
        </tr>
        </spring:forEach>
    </tbody>
</table>

<%@ include file="../jsp/footerFrame.jsp" %>