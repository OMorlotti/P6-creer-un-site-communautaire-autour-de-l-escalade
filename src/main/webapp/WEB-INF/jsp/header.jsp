<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Escalade - <spring:out value="${ title }" /></title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />

        <style>
            html, body {

                height: 100%;
            }

            body {

                background-image: url('/Escalade/mountains.png');
                background-repeat: no-repeat;
                background-position: bottom;
                background-size: 5%;
            }

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

    </head>
    <body>

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
                        <a class="nav-link" href="/Escalade/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/users">Users</a>
                    </li>
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
                        <a class="nav-link" href="/Escalade/reservations">Réservations</a
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <spring:choose>
                        <spring:when test="${currentUser.id eq 0}">
                            <li class="nav-item">
                                <a class="nav-link" href="/Escalade/login">S'authentifier</a>
                            </li>
                        </spring:when>
                        <spring:otherwise>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                                    😷 <spring:out value="${ currentUser.firstName }" /> <spring:out value="${ currentUser.lastName }" />
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="/Escalade/user/<spring:out value="${ currentUser.id }" />">Espace personnel</a>
                                    <a class="dropdown-item" href="/Escalade/logout">Déconnecter</a>
                                </div>
                            </li>
                        </spring:otherwise>
                    </spring:choose>
                </ul>
            </div>
        </nav>

        <div class="container p-2">

            <spring:if test="${ not empty message }">
            <div class="alert alert-<spring:out value="${ message_type }" />" role="alert">
                <spring:out value="${ message }" />
            </div>
            </spring:if>