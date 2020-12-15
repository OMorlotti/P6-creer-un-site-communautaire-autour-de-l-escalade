<%@ include file="../jsp/headerFrame.jsp" %>

<form method="POST" action="/Escalade/voie/update/<spring:out value="${ voie.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="height">Hauteur [mètres] :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="height" id="height" value="<spring:out value="${ voie.height }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="secteurfk">Secteur :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="secteurfk" id="secteur">
                <spring:forEach var="secteur" items="${ secteurs }">
                    <option value="<spring:out value="${ secteur.id }" />"<spring:if test="${ secteur.id == voie.secteurFK.id }"> selected</spring:if>>
                        <spring:out value="${ secteur.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Envoyer</button>

</form>

<hr />

<iframe src="/Escalade/longueurs" style="width: 100%; height: 600px; border: none;"></iframe>

<%@ include file="../jsp/footerFrame.jsp" %>