<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Escalade - <spring:out value="${ title }" /></title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />

        <style>
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
            <a class="navbar-brand" href="#">
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
                </ul>
            </div>
        </nav>

        <div class="container p-2">