<%@ include file="../jsp/header.jsp" %>

<form method="POST" action="/Escalade/spot/update/<spring:out value="${ spot.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" value="<spring:out value="${ spot.name }" />" />
        </div>
    </div>
    <spring:choose>
        <spring:when test="${sessionScope.currentUser.role eq 'ADMIN'}">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="userfk">Utilisateur :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="userfk" id="userfk">
                        <spring:forEach var="user" items="${ users }">
                            <option value="<spring:out value="${ user.id }" />"<spring:if test="${ user.id == sessionScope.currentUser.id }"> selected</spring:if>>
                                <spring:out value="${ user.login }" />
                                -
                                <spring:out value="${ user.firstName }" />
                                <spring:out value="${ user.lastName }" />
                            </option>
                        </spring:forEach>
                    </select>
                </div>
            </div>
        </spring:when>
        <spring:otherwise>
            <input type="hidden" name="userfk" value="<spring:out value="${ sessionScope.currentUser.id }" />" id="userfk" />
        </spring:otherwise>
    </spring:choose>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="topo">Topo :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="topofk" id="topo">
                <spring:forEach var="topo" items="${ topos }">
                    <option value="<spring:out value="${ topo.id }" />"<spring:if test="${ topo.id == spot.topoFK.id }"> selected</spring:if>>
                        <spring:out value="${ topo.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="departement">Département :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="departement" id="departement" value="<spring:out value="${ spot.departement }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="latitude">Latitude :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="latitude" id="latitude" value="<spring:out value="${ spot.latitude }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="longitude">Longitude :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="longitude" id="longitude" value="<spring:out value="${ spot.longitude }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="isofficial">Est officiel :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="isofficial" id="isofficial">
                <option value="false" <spring:if test="${ spot.isOfficial == 'false' }"> selected</spring:if>>Spot non officiel</option>
                <option value="true" <spring:if test="${ spot.isOfficial == 'true' }"> selected</spring:if>>Spot officiel</option>
            </select>
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Envoyer</button>

</form>

<hr />

<iframe src="/Escalade/comments?spot=<spring:out value="${ spot.id }" />" style="width: 100%; height: 600px; border: none;"></iframe>

<hr />

<iframe src="/Escalade/sectors?spot=<spring:out value="${ spot.id }" />" style="width: 100%; height: 600px; border: none;"></iframe>

<%@ include file="../jsp/footer.jsp" %>