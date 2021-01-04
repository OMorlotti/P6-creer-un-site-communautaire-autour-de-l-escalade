<%@ include file="../jsp/header.jsp" %>

<div class="card mt-1">
    <div class="card-body">
        <form method="POST" action="/Escalade/remind-password">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="login">E-mail :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="email" id="email" />
                </div>
            </div>

            <button class="btn btn-primary" type="submit">M'envoyer mon mot de passe</button>

        </form>
    </div>
</div>

<%@ include file="../jsp/footer.jsp" %>