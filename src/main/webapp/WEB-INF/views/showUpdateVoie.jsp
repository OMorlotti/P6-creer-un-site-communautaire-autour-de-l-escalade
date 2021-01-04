<%@ include file="../jsp/headerFrame.jsp" %>

<form method="POST" action="/Escalade/voie/update/<spring:out value="${ voie.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="height">Hauteur [mètres] :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="height" id="height" value="<spring:out value="${ voie.height }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="sectorfk">Secteur :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="sectorfk" id="sectorfk">
                <spring:forEach var="sector" items="${ sectors }">
                    <option value="<spring:out value="${ sector.id }" />"<spring:if test="${ sector.id == voie.sectorFK.id }"> selected</spring:if>>
                        <spring:out value="${ sector.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>

    <spring:if test="${sessionScope.currentUser.role eq 'MEMBER' or sessionScope.currentUser.role eq 'ADMIN'}">
        <div class="text-right">
            <button class="btn btn-primary" type="submit">Envoyer</button>
        </div>
    </spring:if>

</form>

<hr />

<iframe src="/Escalade/longueurs?voie=<spring:out value="${ voie.id }" />" style="width: 100%; height: 600px; border: none;" onload="resizeIframe(this)"></iframe>

<%@ include file="../jsp/footerFrame.jsp" %>