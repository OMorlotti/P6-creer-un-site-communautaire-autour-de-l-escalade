<%@ include file="../jsp/header.jsp" %>

<div class="card mt-1">
    <div class="card-body">
        <form method="POST" action="/Escalade/login">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="login">Login :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="login" id="login" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="password">Mot de passe :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="password" name="password" id="password" />
                </div>
            </div>

            <button class="btn btn-primary" type="submit">Se connecter</button>
            <a href="/Escalade/remind-password">
                Mot de passe oublié
            </a>
        </form>
    </div>
</div>

<%@ include file="../jsp/footer.jsp" %>