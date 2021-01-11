<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Escalade - <spring:out value="${ title }" /></title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />

        <style>
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
                obj.style.height = (16 + $(obj.contentWindow.document).find('.container').height()) + 'px';
            }, 500);
          }
        </script>

    </head>
    <body style="background: url('/Escalade/mountains2.png') no-repeat center center fixed; background-size: cover;">

        <div class="container rounded-bottom shadow-lg bg-white p-2">

            <spring:if test="${ not empty message }">
            <div class="alert alert-<spring:out value="${ message_type }" />" role="alert">
                <spring:out value="${ message }" />
                <button class="close" type="button" data-dismiss="alert">
                    &times;
                </button>
            </div>
            </spring:if>