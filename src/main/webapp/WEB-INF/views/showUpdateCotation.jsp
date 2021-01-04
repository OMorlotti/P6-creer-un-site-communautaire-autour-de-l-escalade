<%@ include file="../jsp/header.jsp" %>

<form method="POST" action="/Escalade/cotation/update/<spring:out value="${ cotation.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" value="<spring:out value="${ cotation.name }" />" />
        </div>
    </div>

    <spring:if test="${spot.userFK.id eq sessionScope.currentUser.id or sessionScope.currentUser.role eq 'MEMBER' or sessionScope.currentUser.role eq 'ADMIN'}">
        <div class="text-right">
            <button class="btn btn-primary" type="submit">Envoyer</button>
        </div>
    </spring:if>

</form>

<%@ include file="../jsp/footer.jsp" %>