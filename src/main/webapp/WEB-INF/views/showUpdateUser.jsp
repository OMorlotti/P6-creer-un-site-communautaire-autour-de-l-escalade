<%@ include file="../jsp/header.jsp" %>

<form method="POST" action="/Escalade/user/update/<spring:out value="${ user.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="lastname">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="lastname" value="<spring:out value="${ user.lastName }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="firstname">Prénom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="firstname" value="<spring:out value="${ user.firstName }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="login">Login :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="login" value="<spring:out value="${ user.login }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="password">Mot de passe :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="password" name="password" value="<spring:out value="${ user.password }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="sex">Sexe :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="sex">
                <option value="F"<spring:if test="${ user.sex == 'F' }"> selected</spring:if>>Femme</option>
                <option value="M"<spring:if test="${ user.sex == 'M' }"> selected</spring:if>>Homme</option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="birthdate">Date de naissance :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="date" name="birthdate" value="<spring:out value="${ user.birthdate }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="phone">Numéro de téléphone :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="phone" value="<spring:out value="${ user.phone }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="email">Email :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="email" name="email" value="<spring:out value="${ user.email }" />" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="role">Rôle :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="role" value="GUEST" value="<spring:out value="${ user.role }" />" readonly="readonly" />
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Envoyer</button>

</form>

<hr />

<iframe src="/Escalade/addresses?user=<spring:out value="${ user.id }" />" style="width: 100%; height: 600px; border: none;"></iframe>

<%@ include file="../jsp/footer.jsp" %>