<%@ include file="../jsp/headerFrame.jsp" %>

<form method="POST" action="/Escalade/secteur/update/<spring:out value="${ secteur.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" value="<spring:out value="${ secteur.name }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="spotfk">Spot :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="spotfk" id="spot">
                <spring:forEach var="spot" items="${ spots }">
                    <option value="<spring:out value="${ spot.id }" />"<spring:if test="${ spot.id == secteur.spotFK.id }"> selected</spring:if>>
                        <spring:out value="${ spot.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Envoyer</button>

</form>

<hr />

<iframe src="/Escalade/voies" style="width: 100%; height: 600px; border: none;"></iframe>

<%@ include file="../jsp/footerFrame.jsp" %>