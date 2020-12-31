<%@ include file="../jsp/headerFrame.jsp" %>

<spring:if test="${not (sessionScope.currentUser.id eq -1)}">
<button class="btn btn-sm btn-primary" type="button" data-toggle="collapse" data-target="#commentform">Ajouter un commentaire</button>
</spring:if>

<div class="card mt-1 collapse" id="commentform">
    <div class="card-body">
        <form method="POST" action="/Escalade/comment">

            <input type="hidden" name="spotfk" value="<spring:out value="${ spotId }" />" />

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="comment">Commentaire :</label>
                <div class="col-sm-10">
                    <textarea class="form-control form-control-sm" rows="3" name="comment" id="comment"></textarea>
                </div>
            </div>

            <div class="text-right">
                <button class="btn btn-sm btn-primary" type="submit">Envoyer</button>
            </div>

        </form>
    </div>
</div>

<table class="table table-sm table-striped mt-2">
    <thead>
      <tr>
          <td>Login</td>
          <td>Commentaire</td>
          <td>Date</td>
          <spring:if test="${not (sessionScope.currentUser.id eq -1)}">
          <td></td>
          <td></td>
          </spring:if>
      </tr>
    </thead>
    <tbody>
        <spring:forEach var="comment" items="${ comments }">
        <tr>
            <td><spring:out value="${ comment.userFK.login }" /></td>
            <td><spring:out value="${ comment.comment }" /></td>
            <td><spring:out value="${ comment.created }" /></td>
            <spring:if test="${not (sessionScope.currentUser.id eq -1)}">
            <td><a href="/Escalade/comment/<spring:out value="${ comment.id }" />">Voir/Editer</a></td>
            <td><a href="/Escalade/comment/delete/<spring:out value="${ comment.id }" />">Supprimer</a></td>
            </spring:if>
        </tr>
        </spring:forEach>
    </tbody>
</table>

<%@ include file="../jsp/footerFrame.jsp" %>