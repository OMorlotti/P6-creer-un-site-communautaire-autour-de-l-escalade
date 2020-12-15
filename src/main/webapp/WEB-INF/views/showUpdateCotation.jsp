<%@ include file="../jsp/headerFrame.jsp" %>

<form method="POST" action="/Escalade/cotation/update/<spring:out value="${ secteur.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" value="<spring:out value="${ cotation.name }" />" />
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Envoyer</button>

</form>

<%@ include file="../jsp/footerFrame.jsp" %>