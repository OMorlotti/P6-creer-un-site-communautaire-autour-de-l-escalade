<%@ include file="../jsp/header.jsp" %>

<h4>Détails du topo « <spring:out value="${ topo.name }" /> »</h4>

<form method="POST" action="/Escalade/topo/update/<spring:out value="${ topo.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" value="<spring:out value="${ topo.name }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="description">Description :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="description" id="description" value="<spring:out value="${ topo.description }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="city">Ville :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="city" id="city" value="<spring:out value="${ topo.city }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="postalcode">Code postal :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="postalcode" id="postalcode" value="<spring:out value="${ topo.postalCode }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="releasedate">Date de parution :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="date" name="releasedate" id="releasedate" value="<spring:out value="${ topo.releaseDate }" />" required="required" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group row">
                <label class="col-sm-4 col-form-label" for="isavailable">Disponibilité :</label>
                <div class="col-sm-8">
                    <select class="custom-select custom-select-sm" name="isavailable" id="isavailable">
                        <option value="false" <spring:if test="${ topo.isAvailable == 'false' }"> selected</spring:if>>N'est pas disponible</option>
                        <option value="true" <spring:if test="${ topo.isAvailable == 'true' }"> selected</spring:if>>Est disponible</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <spring:choose>
                <spring:when test="${sessionScope.currentUser.id eq topo.userFK.id or sessionScope.currentUser.role eq 'ADMIN'}">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label" for="bookuserfk">Emprunteur :</label>
                        <div class="col-sm-8">
                            <select class="custom-select custom-select-sm" name="bookuserfk" id="bookuserfk">
                                <spring:forEach var="user" items="${ users }">
                                    <option value="<spring:out value="${ user.id }" />"<spring:if test="${ user.id == bookUserFK }"> selected</spring:if>>
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
                    -
                </spring:otherwise>
            </spring:choose>
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

    <spring:if test="${topo.userFK.id eq sessionScope.currentUser.id or sessionScope.currentUser.role eq 'ADMIN'}">
        <div class="text-right">
            <button class="btn btn-primary" type="submit">Envoyer</button>
        </div>
    </spring:if>

</form>

<hr />

<h5>L'ont déjà réservé (ordre chronologique)</h5>

<p>
<spring:forEach var="booking" items="${ bookings }">
    <span class="badge badge-pill badge-success"><spring:out value="${ booking }" /></span>
</spring:forEach>
</p>


<%@ include file="../jsp/footer.jsp" %>