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
                max-width: 960px;
                margin-left: auto;
                margin-right: auto;
            }
        </style>

    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <a class="navbar-brand" href="/Escalade">
                Escalade
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
                        <a class="nav-link" href="/Escalade/secteurs">Secteurs BEURK</a
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/voies">Voies BEURK BIS</a
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/longueurs">Longueurs BEURK TER</a
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Escalade/cotations">Cotations BEURK QUATER</a
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container p-2">

            <spring:if test="${ not empty message }">
            <div class="alert alert-<spring:out value="${ message_type }" />" role="alert">
                <spring:out value="${ message }" />
            </div>
            </spring:if>