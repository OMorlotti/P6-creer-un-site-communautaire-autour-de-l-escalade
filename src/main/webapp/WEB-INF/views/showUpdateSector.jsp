<%@ include file="../jsp/header.jsp" %>

<h4>Détails du secteur « <spring:out value="${ sector.name }" /> »</h4>

<form method="POST" action="/Escalade/sector/update/<spring:out value="${ sector.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" value="<spring:out value="${ sector.name }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="spotfk">Spot :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="spotfk" id="spot">
                <spring:forEach var="spot" items="${ spots }">
                    <option value="<spring:out value="${ spot.id }" />"<spring:if test="${ spot.id == sector.spotFK.id }"> selected</spring:if>>
                        <spring:out value="${ spot.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>

    <spring:if test="${spot.userFK.id eq sessionScope.currentUser.id or sessionScope.currentUser.role eq 'MEMBER' or sessionScope.currentUser.role eq 'ADMIN'}">
        <div class="text-right">
            <button class="btn btn-primary" type="submit">Envoyer</button>
        </div>
    </spring:if>

</form>

<hr />

<iframe src="/Escalade/voies?sector=<spring:out value="${ sector.id }" />" style="width: 100%; height: 600px; border: none;" onload="resizeIframe(this)"></iframe>

<%@ include file="../jsp/footer.jsp" %>