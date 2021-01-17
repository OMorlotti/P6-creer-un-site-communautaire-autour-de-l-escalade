<%@ include file="../jsp/headerFrame.jsp" %>

<h4>Détails du commentaire « <spring:out value="${ comment.id }" /> »</h4>

<form method="POST" action="/Escalade/comment/update/<spring:out value="${ comment.id }" />">

    <input type="hidden" name="spotfk" value="<spring:out value="${ spot.id }" />" />

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="comment">Commentaire :</label>
        <div class="col-sm-10">
            <textarea class="form-control form-control-sm" rows="3" name="comment" id="comment" required="required"><spring:out value="${ comment.comment }" /></textarea>
        </div>
    </div>

    <spring:if test="${!(sessionScope.currentUser.id eq -1)}">
        <div class="text-right">
            <button class="btn btn-primary" type="submit">Envoyer</button>
        </div>
    </spring:if>

</form>

<%@ include file="../jsp/footerFrame.jsp" %>