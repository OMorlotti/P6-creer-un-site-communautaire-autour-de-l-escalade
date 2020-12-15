<%@ include file="../jsp/headerFrame.jsp" %>

<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#cotatioform">Ajouter une cotation</button>

<form class="collapse" method="POST" action="/Escalade/cotation" id="cotationform">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" />
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Envoyer</button>

</form>

<table class="table table-sm table-striped mt-2">
    <spring:forEach var="cotation" items="${ cotations }">
    <tr>
        <td><spring:out value="${ cotation.id }" /></td>
        <td><spring:out value="${ cotation.name }" /></td>
        <td><a href="/Escalade/cotation/<spring:out value="${ cotation.id }" />">Voir/Editer</a></td>
        <td><a href="/Escalade/cotation/delete/<spring:out value="${ cotation.id }" />">Supprimer</a></td>
    </tr>
    </spring:forEach>
</table>

<%@ include file="../jsp/footerFrame.jsp" %>