<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Escalade - <spring:out value="${ title }" /></title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />

        <style>
            footer,
            .container {
                max-width: 1024px;
                margin-left: auto;
                margin-right: auto;
            }

            thead td {
                font-weight: bold;
            }
        </style>

        <script>
          function resizeIframe(obj)
          {
            setInterval(function() {
                obj.style.height = (20 + $(obj.contentWindow.document).find('.container').height()) + 'px';
            }, 500);
          }
        </script>

    </head>
    <body style="background: url('/Escalade/mountains2.png') no-repeat center center fixed; background-size: cover;">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom px-1 py-0">
            <a class="navbar-brand" href="/Escalade">
                <img src="/Escalade/mountains.png" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy"> Escalade
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="mainNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/topos">Topos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/spots">Spots</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/cotations">Cotations</a
                    </li>
                    <li class="nav-item">
                        <span class="nav-link">|</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/search">🔍 Recherche</a
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <spring:if test="${sessionScope.currentUser.role eq 'ADMIN'}">
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/users">Users</a>
                    </li>
                    </spring:if>
                    <spring:choose>
                        <spring:when test="${sessionScope.currentUser.id eq -1}">
                            <li class="nav-item">
                                <a class="nav-link" href="/Escalade/login">S'authentifier</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Escalade/users">S'enregistrer</a>
                            </li>
                        </spring:when>
                        <spring:otherwise>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                                    😷 <spring:out value="${ sessionScope.currentUser.firstName }" /> <spring:out value="${ currentUser.lastName }" />
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="/Escalade/user/<spring:out value="${ sessionScope.currentUser.id }" />">Espace personnel</a>
                                    <a class="dropdown-item" href="/Escalade/logout">Déconnecter</a>
                                </div>
                            </li>
                        </spring:otherwise>
                    </spring:choose>
                </ul>
            </div>
        </nav>

        <div class="container rounded-bottom shadow-lg bg-white p-2">

            <spring:if test="${ not empty message }">
            <div class="alert alert-<spring:out value="${ message_type }" />" role="alert">
                <spring:out value="${ message }" />
                <button class="close" type="button" data-dismiss="alert">
                    &times;
                </button>
            </div>
            </spring:if>