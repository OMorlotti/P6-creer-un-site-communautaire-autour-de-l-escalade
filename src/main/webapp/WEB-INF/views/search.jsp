<%@ include file="../jsp/header.jsp" %>

<form method="POST" action="/Escalade/search">

<h4>Recherche</h4>

<div class="card mt-1" id="searchform">
    <div class="card-body">

        <p>Sélectionnez vos critères de recherche.</p>

        <form method="POST" action="/Escalade/search">

            <input type="hidden" name="userfk" value="<spring:out value="${ user.id }" />" />

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="departement">Département :</label>
                <div class="col-sm-10">

                    <div class="input-group input-group-sm">
                      <div class="input-group-prepend">
                        <div class="input-group-text">
                          <input type="checkbox" onclick="$('#departement').prop('disabled', !$(this).prop('checked'));" />
                        </div>
                      </div>
                        <select class="custom-select custom-select-sm" name="departement" id="departement" disabled>
                            <option value="00">(00) Hors France</option>
                            <option value="01">(01) Ain </option>
                            <option value="02">(02) Aisne </option>
                            <option value="03">(03) Allier </option>
                            <option value="04">(04) Alpes de Haute Provence </option>
                            <option value="05">(05) Hautes Alpes </option>
                            <option value="06">(06) Alpes Maritimes </option>
                            <option value="07">(07) Ardèche </option>
                            <option value="08">(08) Ardennes </option>
                            <option value="09">(09) Ariège </option>
                            <option value="10">(10) Aube </option>
                            <option value="11">(11) Aude </option>
                            <option value="12">(12) Aveyron </option>
                            <option value="13">(13) Bouches du Rhône </option>
                            <option value="14">(14) Calvados </option>
                            <option value="15">(15) Cantal </option>
                            <option value="16">(16) Charente </option>
                            <option value="17">(17) Charente Maritime </option>
                            <option value="18">(18) Cher </option>
                            <option value="19">(19) Corrèze </option>
                            <option value="2A">(2A) Corse du Sud </option>
                            <option value="2B">(2B) Haute-Corse </option>
                            <option value="21">(21) Côte d'Or </option>
                            <option value="22">(22) Côtes d'Armor </option>
                            <option value="23">(23) Creuse </option>
                            <option value="24">(24) Dordogne </option>
                            <option value="25">(25) Doubs </option
                            <option value="26">(26) Drôme </option>
                            <option value="27">(27) Eure </option>
                            <option value="28">(28) Eure et Loir </option>
                            <option value="29">(29) Finistère </option>
                            <option value="30">(30) Gard </option>
                            <option value="31">(31) Haute Garonne </option>
                            <option value="32">(32) Gers </option>
                            <option value="33">(33) Gironde </option>
                            <option value="34">(34) Hérault </option>
                            <option value="35">(35) Ille et Vilaine </option>
                            <option value="36">(36) Indre </option>
                            <option value="37">(37) Indre et Loire </option>
                            <option value="38">(38) Isère </option>
                            <option value="39">(39) Jura </option>
                            <option value="40">(40) Landes </option>
                            <option value="41">(41) Loir et Cher </option>
                            <option value="42">(42) Loire </option>
                            <option value="43">(43) Haute Loire </option>
                            <option value="44">(44) Loire Atlantique </option>
                            <option value="45">(45) Loiret </option>
                            <option value="46">(46) Lot </option>
                            <option value="47">(47) Lot et Garonne </option>
                            <option value="48">(48) Lozère </option>
                            <option value="49">(49) Maine et Loire </option>
                            <option value="50">(50) Manche </option>
                            <option value="51">(51) Marne </option>
                            <option value="52">(52) Haute Marne </option>
                            <option value="53">(53) Mayenne </option>
                            <option value="54">(54) Meurthe et Moselle </option>
                            <option value="55">(55) Meuse </option>
                            <option value="56">(56) Morbihan </option>
                            <option value="57">(57) Moselle </option>
                            <option value="58">(58) Nièvre </option>
                            <option value="59">(59) Nord </option>
                            <option value="60">(60) Oise </option>
                            <option value="61">(61) Orne </option>
                            <option value="62">(62) Pas de Calais </option>
                            <option value="63">(63) Puy de Dôme </option>
                            <option value="64">(64) Pyrénées Atlantiques </option>
                            <option value="65">(65) Hautes Pyrénées </option>
                            <option value="66">(66) Pyrénées Orientales </option>
                            <option value="67">(67) Bas Rhin </option>
                            <option value="68">(68) Haut Rhin </option>
                            <option value="69">(69) Rhône </option>
                            <option value="70">(70) Haute Saône </option>
                            <option value="71">(71) Saône et Loire </option>
                            <option value="72">(72) Sarthe </option>
                            <option value="73">(73) Savoie </option>
                            <option value="74">(74) Haute Savoie </option>
                            <option value="75">(75) Paris </option>
                            <option value="76">(76) Seine Maritime </option>
                            <option value="77">(77) Seine et Marne </option>
                            <option value="78">(78) Yvelines </option>
                            <option value="79">(79) Deux Sèvres </option>
                            <option value="80">(80) Somme </option>
                            <option value="81">(81) Tarn </option>
                            <option value="82">(82) Tarn et Garonne </option>
                            <option value="83">(83) Var </option>
                            <option value="84">(84) Vaucluse </option>
                            <option value="85">(85) Vendée </option>
                            <option value="86">(86) Vienne </option>
                            <option value="87">(87) Haute Vienne </option>
                            <option value="88">(88) Vosges </option>
                            <option value="89">(89) Yonne </option>
                            <option value="90">(90) Territoire de Belfort </option>
                            <option value="91">(91) Essonne </option>
                            <option value="92">(92) Hauts de Seine </option>
                            <option value="93">(93) Seine Saint Denis </option>
                            <option value="94">(94) Val de Marne </option>
                            <option value="95">(95) Val d'Oise </option>
                            <option value="971">(971) Guadeloupe </option>
                            <option value="972">(972) Martinique </option>
                            <option value="973">(973) Guyane </option>
                            <option value="974">(974) Réunion </option>
                            <option value="975">(975) Saint Pierre et Miquelon </option>
                            <option value="976">(976) Mayotte </option>
                        </select>
                    </div>

                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nbofsectors">Nb. de secteurs :</label>
                <div class="col-sm-10">

                    <div class="input-group input-group-sm">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input type="checkbox" onclick="$('#nbofsectors').prop('disabled', !$(this).prop('checked'));" />
                            </div>
                        </div>
                        <input class="form-control form-control-sm" type="number" min="1" name="nbofsectors" id="nbofsectors" disabled />
                    </div>

                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nbofvoies">Nombre de voies :</label>
                <div class="col-sm-10">

                    <div class="input-group input-group-sm">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input type="checkbox" onclick="$('#nbofvoies').prop('disabled', !$(this).prop('checked'));" />
                            </div>
                        </div>
                        <input class="form-control form-control-sm" type="number" min="1" name="nbofvoies" id="nbofvoies" disabled />
                    </div>

                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="cotation">Cotation :</label>
                <div class="col-sm-10">

                    <div class="input-group input-group-sm">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input type="checkbox" onclick="$('#cotation').prop('disabled', !$(this).prop('checked'));" />
                            </div>
                        </div>
                        <select class="custom-select custom-select-sm" name="cotationfk" id="cotation" disabled>
                            <spring:forEach var="cotation" items="${ cotations }">
                                <option value="<spring:out value="${ cotation.id }" />">
                                    <spring:out value="${ cotation.name }" />
                                </option>
                            </spring:forEach>
                        </select>
                    </div>

                </div>
            </div>

            <div class="text-right">
                <button class="btn btn-light" type="submit">🔍 Rechercher</button>
            </div>

        </form>
    </div>
</div>

<table class="table table-sm table-striped mt-2">
    <thead>
        <tr>
            <td>Spot</td>
            <td></td>
        </tr>
    </thead>
    <tbody>
        <spring:forEach var="spot" items="${ spots }">
        <tr>
            <td><spring:out value="${ spot.name }" /></td>
            <td><a href="/Escalade/spot/<spring:out value="${ spot.id }" />" target="_blank">voir</td>
        </tr>
        </spring:forEach>
    </tbody>
</table>

<%@ include file="../jsp/footer.jsp" %>