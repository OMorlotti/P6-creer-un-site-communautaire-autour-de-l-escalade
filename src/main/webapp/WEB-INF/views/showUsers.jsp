<%@ include file="../jsp/header.jsp" %>

<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#userform">Ajouter un utilisateur</button>

<div class="card mt-1 collapse" id="userform">
    <div class="card-body">
        <form method="POST" action="/Escalade/user">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="lastname">Nom :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="lastname" id="lastname" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="firstname">Prénom :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="firstname" id="firstname" />
                </div>
            </div>
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
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="sex">Sexe :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="sex" id="sex">
                        <option value="F">Femme</option>
                        <option value="M">Homme</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="birthdate">Date de naissance :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="date" name="birthdate" id="birthdate" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="phone">Numéro de téléphone :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="text" name="phone" id="phone" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="email">Email :</label>
                <div class="col-sm-10">
                    <input class="form-control form-control-sm" type="email" name="email" id="email" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="role">Rôle :</label>
                <div class="col-sm-10">
                    <spring:choose>
                        <spring:when test="${currentUser.role eq 'ADMIN'}">
                            <select class="custom-select custom-select-sm" name="role">
                                <option value="GUEST" selected>Invité</option>
                                <option value="USER">Utilisateur non membre</option>
                                <option value="MEMBER">Utilisateur membre</option>
                                <option value="ADMIN">Administrateur</option>
                            </select>
                        </spring:when>
                        <spring:otherwise>
                            <input class="form-control form-control-sm" type="text" name="role" value="GUEST" id="role" readonly="readonly" />
                        </spring:otherwise>
                    </spring:choose>
                </div>
            </div>

            <button class="btn btn-primary" type="submit">Envoyer</button>

        </form>
    </div>
</div>

<!-- La liste d'utilisateurs n'est affichée que pour les ADMINS -->

<spring:if test="${currentUser.role eq 'ADMIN'}">
<table class="table table-sm table-striped mt-2">
    <thead>
      <tr>
          <td>Login</td>
          <td>Prénom</td>
          <td>Nom de famille</td>
          <td></td>
          <td></td>
      </tr>
    </thead>
    <tbody>
        <spring:forEach var="user" items="${ users }">
        <tr>
            <td><spring:out value="${ user.login }" /></td>
            <td><spring:out value="${ user.firstName }" /></td>
            <td><spring:out value="${ user.lastName }" /></td>
            <td><a href="/Escalade/user/<spring:out value="${ user.id }" />">Voir/Editer</a></td>
            <td><a href="/Escalade/user/delete/<spring:out value="${ user.id }" />">Supprimer</a></td>
        </tr>
        </spring:forEach>
    </tbody>
</table>
</spring:if>

<%@ include file="../jsp/footer.jsp" %>