<%@ include file="../jsp/headerFrame.jsp" %>

<form method="POST" action="/Escalade/voie/update/<spring:out value="${ voie.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="voiefk">Voie :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="voiefk" id="voie">
                <spring:forEach var="voie" items="${ voies }">
                    <option value="<spring:out value="${ voie.id }" />"<spring:if test="${ voie.id == length.voieFK.id }"> selected</spring:if>>
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
                    <option value="<spring:out value="${ cotation.id }" />"<spring:if test="${ cotation.id == length.cotationFK.id }"> selected</spring:if>>
                        <spring:out value="${ cotation.id }" />
                        -
                        <spring:out value="${ cotation.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="numberofspit">Nombre de spit :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="numberofspit" id="numberofspit" value="<spring:out value="${ length.numberOfSpit }" />" />
        </div>
    </div>

    <spring:if test="${spot.userFK.id eq sessionScope.currentUser.id or sessionScope.currentUser.role eq 'MEMBER' or sessionScope.currentUser.role eq 'ADMIN'}">
        <div class="text-right">
            <button class="btn btn-primary" type="submit">Envoyer</button>
        </div>
    </spring:if>

</form>

<%@ include file="../jsp/footerFrame.jsp" %>