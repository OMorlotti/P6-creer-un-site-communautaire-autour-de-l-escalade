<%@ include file="../jsp/header.jsp" %>

<h4>Détails du spot « <spring:out value="${ spot.name }" /> »</h4>

<form method="POST" action="/Escalade/spot/update/<spring:out value="${ spot.id }" />">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nom :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="name" id="name" value="<spring:out value="${ spot.name }" />" />
        </div>
    </div>
    <spring:choose>
        <spring:when test="${sessionScope.currentUser.role eq 'ADMIN'}">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="userfk">Utilisateur :</label>
                <div class="col-sm-10">
                    <select class="custom-select custom-select-sm" name="userfk" id="userfk">
                        <spring:forEach var="user" items="${ users }">
                            <option value="<spring:out value="${ user.id }" />"<spring:if test="${ user.id == sessionScope.currentUser.id }"> selected</spring:if>>
                                <spring:out value="${ user.login }" />
                                -
                                <spring:out value="${ user.firstName }" />
                                <spring:out value="${ user.lastName }" />
                            </option>
                        </spring:forEach>
                    </select>
                </div>
            </div>
        </spring:when>
        <spring:otherwise>
            <input type="hidden" name="userfk" value="<spring:out value="${ sessionScope.currentUser.id }" />" id="userfk" />
        </spring:otherwise>
    </spring:choose>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="topo">Topo :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="topofk" id="topo">
                <spring:forEach var="topo" items="${ topos }">
                    <option value="<spring:out value="${ topo.id }" />"<spring:if test="${ topo.id == spot.topoFK.id }"> selected</spring:if>>
                        <spring:out value="${ topo.name }" />
                    </option>
                </spring:forEach>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="departement">Département :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="departement" id="departement">
                <option value="00"<spring:if test="${ spot.departement == '00' }"> selected</spring:if>>(00) Hors France</option>
                <option value="01"<spring:if test="${ spot.departement == '01' }"> selected</spring:if>>(01) Ain </option>
                <option value="02"<spring:if test="${ spot.departement == '02' }"> selected</spring:if>>(02) Aisne </option>
                <option value="03"<spring:if test="${ spot.departement == '03' }"> selected</spring:if>>(03) Allier </option>
                <option value="04"<spring:if test="${ spot.departement == '04' }"> selected</spring:if>>(04) Alpes de Haute Provence </option>
                <option value="05"<spring:if test="${ spot.departement == '05' }"> selected</spring:if>>(05) Hautes Alpes </option>
                <option value="06"<spring:if test="${ spot.departement == '06' }"> selected</spring:if>>(06) Alpes Maritimes </option>
                <option value="07"<spring:if test="${ spot.departement == '07' }"> selected</spring:if>>(07) Ardèche </option>
                <option value="08"<spring:if test="${ spot.departement == '08' }"> selected</spring:if>>(08) Ardennes </option>
                <option value="09"<spring:if test="${ spot.departement == '09' }"> selected</spring:if>>(09) Ariège </option>
                <option value="10"<spring:if test="${ spot.departement == '10' }"> selected</spring:if>>(10) Aube </option>
                <option value="11"<spring:if test="${ spot.departement == '11' }"> selected</spring:if>>(11) Aude </option>
                <option value="12"<spring:if test="${ spot.departement == '12' }"> selected</spring:if>>(12) Aveyron </option>
                <option value="13"<spring:if test="${ spot.departement == '13' }"> selected</spring:if>>(13) Bouches du Rhône </option>
                <option value="14"<spring:if test="${ spot.departement == '14' }"> selected</spring:if>>(14) Calvados </option>
                <option value="15"<spring:if test="${ spot.departement == '15' }"> selected</spring:if>>(15) Cantal </option>
                <option value="16"<spring:if test="${ spot.departement == '16' }"> selected</spring:if>>(16) Charente </option>
                <option value="17"<spring:if test="${ spot.departement == '17' }"> selected</spring:if>>(17) Charente Maritime </option>
                <option value="18"<spring:if test="${ spot.departement == '18' }"> selected</spring:if>>(18) Cher </option>
                <option value="19"<spring:if test="${ spot.departement == '19' }"> selected</spring:if>>(19) Corrèze </option>
                <option value="2A"<spring:if test="${ spot.departement == '2A' }"> selected</spring:if>>(2A) Corse du Sud </option>
                <option value="2B"<spring:if test="${ spot.departement == '2B' }"> selected</spring:if>>(2B) Haute-Corse </option>
                <option value="21"<spring:if test="${ spot.departement == '21' }"> selected</spring:if>>(21) Côte d'Or </option>
                <option value="22"<spring:if test="${ spot.departement == '22' }"> selected</spring:if>>(22) Côtes d'Armor </option>
                <option value="23"<spring:if test="${ spot.departement == '23' }"> selected</spring:if>>(23) Creuse </option>
                <option value="24"<spring:if test="${ spot.departement == '24' }"> selected</spring:if>>(24) Dordogne </option>
                <option value="25"<spring:if test="${ spot.departement == '25' }"> selected</spring:if>>(25) Doubs </option
                <option value="26"<spring:if test="${ spot.departement == '26' }"> selected</spring:if>>(26) Drôme </option>
                <option value="27"<spring:if test="${ spot.departement == '27' }"> selected</spring:if>>(27) Eure </option>
                <option value="28"<spring:if test="${ spot.departement == '28' }"> selected</spring:if>>(28) Eure et Loir </option>
                <option value="29"<spring:if test="${ spot.departement == '29' }"> selected</spring:if>>(29) Finistère </option>
                <option value="30"<spring:if test="${ spot.departement == '30' }"> selected</spring:if>>(30) Gard </option>
                <option value="31"<spring:if test="${ spot.departement == '31' }"> selected</spring:if>>(31) Haute Garonne </option>
                <option value="32"<spring:if test="${ spot.departement == '32' }"> selected</spring:if>>(32) Gers </option>
                <option value="33"<spring:if test="${ spot.departement == '33' }"> selected</spring:if>>(33) Gironde </option>
                <option value="34"<spring:if test="${ spot.departement == '34' }"> selected</spring:if>>(34) Hérault </option>
                <option value="35"<spring:if test="${ spot.departement == '35' }"> selected</spring:if>>(35) Ille et Vilaine </option>
                <option value="36"<spring:if test="${ spot.departement == '36' }"> selected</spring:if>>(36) Indre </option>
                <option value="37"<spring:if test="${ spot.departement == '37' }"> selected</spring:if>>(37) Indre et Loire </option>
                <option value="38"<spring:if test="${ spot.departement == '38' }"> selected</spring:if>>(38) Isère </option>
                <option value="39"<spring:if test="${ spot.departement == '39' }"> selected</spring:if>>(39) Jura </option>
                <option value="40"<spring:if test="${ spot.departement == '40' }"> selected</spring:if>>(40) Landes </option>
                <option value="41"<spring:if test="${ spot.departement == '41' }"> selected</spring:if>>(41) Loir et Cher </option>
                <option value="42"<spring:if test="${ spot.departement == '42' }"> selected</spring:if>>(42) Loire </option>
                <option value="43"<spring:if test="${ spot.departement == '43' }"> selected</spring:if>>(43) Haute Loire </option>
                <option value="44"<spring:if test="${ spot.departement == '44' }"> selected</spring:if>>(44) Loire Atlantique </option>
                <option value="45"<spring:if test="${ spot.departement == '45' }"> selected</spring:if>>(45) Loiret </option>
                <option value="46"<spring:if test="${ spot.departement == '46' }"> selected</spring:if>>(46) Lot </option>
                <option value="47"<spring:if test="${ spot.departement == '47' }"> selected</spring:if>>(47) Lot et Garonne </option>
                <option value="48"<spring:if test="${ spot.departement == '48' }"> selected</spring:if>>(48) Lozère </option>
                <option value="49"<spring:if test="${ spot.departement == '49' }"> selected</spring:if>>(49) Maine et Loire </option>
                <option value="50"<spring:if test="${ spot.departement == '50' }"> selected</spring:if>>(50) Manche </option>
                <option value="51"<spring:if test="${ spot.departement == '51' }"> selected</spring:if>>(51) Marne </option>
                <option value="52"<spring:if test="${ spot.departement == '52' }"> selected</spring:if>>(52) Haute Marne </option>
                <option value="53"<spring:if test="${ spot.departement == '53' }"> selected</spring:if>>(53) Mayenne </option>
                <option value="54"<spring:if test="${ spot.departement == '54' }"> selected</spring:if>>(54) Meurthe et Moselle </option>
                <option value="55"<spring:if test="${ spot.departement == '55' }"> selected</spring:if>>(55) Meuse </option>
                <option value="56"<spring:if test="${ spot.departement == '56' }"> selected</spring:if>>(56) Morbihan </option>
                <option value="57"<spring:if test="${ spot.departement == '57' }"> selected</spring:if>>(57) Moselle </option>
                <option value="58"<spring:if test="${ spot.departement == '58' }"> selected</spring:if>>(58) Nièvre </option>
                <option value="59"<spring:if test="${ spot.departement == '59' }"> selected</spring:if>>(59) Nord </option>
                <option value="60"<spring:if test="${ spot.departement == '60' }"> selected</spring:if>>(60) Oise </option>
                <option value="61"<spring:if test="${ spot.departement == '61' }"> selected</spring:if>>(61) Orne </option>
                <option value="62"<spring:if test="${ spot.departement == '62' }"> selected</spring:if>>(62) Pas de Calais </option>
                <option value="63"<spring:if test="${ spot.departement == '63' }"> selected</spring:if>>(63) Puy de Dôme </option>
                <option value="64"<spring:if test="${ spot.departement == '64' }"> selected</spring:if>>(64) Pyrénées Atlantiques </option>
                <option value="65"<spring:if test="${ spot.departement == '65' }"> selected</spring:if>>(65) Hautes Pyrénées </option>
                <option value="66"<spring:if test="${ spot.departement == '66' }"> selected</spring:if>>(66) Pyrénées Orientales </option>
                <option value="67"<spring:if test="${ spot.departement == '67' }"> selected</spring:if>>(67) Bas Rhin </option>
                <option value="68"<spring:if test="${ spot.departement == '68' }"> selected</spring:if>>(68) Haut Rhin </option>
                <option value="69"<spring:if test="${ spot.departement == '69' }"> selected</spring:if>>(69) Rhône </option>
                <option value="70"<spring:if test="${ spot.departement == '70' }"> selected</spring:if>>(70) Haute Saône </option>
                <option value="71"<spring:if test="${ spot.departement == '71' }"> selected</spring:if>>(71) Saône et Loire </option>
                <option value="72"<spring:if test="${ spot.departement == '72' }"> selected</spring:if>>(72) Sarthe </option>
                <option value="73"<spring:if test="${ spot.departement == '73' }"> selected</spring:if>>(73) Savoie </option>
                <option value="74"<spring:if test="${ spot.departement == '74' }"> selected</spring:if>>(74) Haute Savoie </option>
                <option value="75"<spring:if test="${ spot.departement == '75' }"> selected</spring:if>>(75) Paris </option>
                <option value="76"<spring:if test="${ spot.departement == '76' }"> selected</spring:if>>(76) Seine Maritime </option>
                <option value="77"<spring:if test="${ spot.departement == '77' }"> selected</spring:if>>(77) Seine et Marne </option>
                <option value="78"<spring:if test="${ spot.departement == '78' }"> selected</spring:if>>(78) Yvelines </option>
                <option value="79"<spring:if test="${ spot.departement == '79' }"> selected</spring:if>>(79) Deux Sèvres </option>
                <option value="80"<spring:if test="${ spot.departement == '80' }"> selected</spring:if>>(80) Somme </option>
                <option value="81"<spring:if test="${ spot.departement == '81' }"> selected</spring:if>>(81) Tarn </option>
                <option value="82"<spring:if test="${ spot.departement == '82' }"> selected</spring:if>>(82) Tarn et Garonne </option>
                <option value="83"<spring:if test="${ spot.departement == '83' }"> selected</spring:if>>(83) Var </option>
                <option value="84"<spring:if test="${ spot.departement == '84' }"> selected</spring:if>>(84) Vaucluse </option>
                <option value="85"<spring:if test="${ spot.departement == '85' }"> selected</spring:if>>(85) Vendée </option>
                <option value="86"<spring:if test="${ spot.departement == '86' }"> selected</spring:if>>(86) Vienne </option>
                <option value="87"<spring:if test="${ spot.departement == '87' }"> selected</spring:if>>(87) Haute Vienne </option>
                <option value="88"<spring:if test="${ spot.departement == '88' }"> selected</spring:if>>(88) Vosges </option>
                <option value="89"<spring:if test="${ spot.departement == '89' }"> selected</spring:if>>(89) Yonne </option>
                <option value="90"<spring:if test="${ spot.departement == '90' }"> selected</spring:if>>(90) Territoire de Belfort </option>
                <option value="91"<spring:if test="${ spot.departement == '91' }"> selected</spring:if>>(91) Essonne </option>
                <option value="92"<spring:if test="${ spot.departement == '92' }"> selected</spring:if>>(92) Hauts de Seine </option>
                <option value="93"<spring:if test="${ spot.departement == '93' }"> selected</spring:if>>(93) Seine Saint Denis </option>
                <option value="94"<spring:if test="${ spot.departement == '94' }"> selected</spring:if>>(94) Val de Marne </option>
                <option value="95"<spring:if test="${ spot.departement == '95' }"> selected</spring:if>>(95) Val d'Oise </option>
                <option value="971"<spring:if test="${ spot.departement == '971' }"> selected</spring:if>>(971) Guadeloupe </option>
                <option value="972"<spring:if test="${ spot.departement == '972' }"> selected</spring:if>>(972) Martinique </option>
                <option value="973"<spring:if test="${ spot.departement == '973' }"> selected</spring:if>>(973) Guyane </option>
                <option value="974"<spring:if test="${ spot.departement == '974' }"> selected</spring:if>>(974) Réunion </option>
                <option value="975"<spring:if test="${ spot.departement == '975' }"> selected</spring:if>>(975) Saint Pierre et Miquelon </option>
                <option value="976"<spring:if test="${ spot.departement == '976' }"> selected</spring:if>>(976) Mayotte </option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="latitude">Latitude :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="latitude" minlength="6" id="latitude" value="<spring:out value="${ spot.latitude }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="longitude">Longitude :</label>
        <div class="col-sm-10">
            <input class="form-control form-control-sm" type="text" name="longitude" minlength="6" id="longitude" value="<spring:out value="${ spot.longitude }" />" required="required" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="isofficial">Est officiel :</label>
        <div class="col-sm-10">
            <select class="custom-select custom-select-sm" name="isofficial" id="isofficial">
                <option value="false" <spring:if test="${ spot.isOfficial == 'false' }"> selected</spring:if>>Spot non officiel</option>
                <option value="true" <spring:if test="${ spot.isOfficial == 'true' }"> selected</spring:if>>Spot officiel</option>
            </select>
        </div>
    </div>

    <spring:if test="${spot.userFK.id eq sessionScope.currentUser.id or sessionScope.currentUser.role eq 'MEMBER' or sessionScope.currentUser.role eq 'ADMIN'}">
        <div class="text-right">
            <button class="btn btn-primary" type="submit">Envoyer</button>
        </div>
    </spring:if>

</form>

<hr />

<iframe src="/Escalade/comments?spot=<spring:out value="${ spot.id }" />" style="width: 100%; height: 600px; border: none;" onload="resizeIframe(this)"></iframe>

<hr />

<iframe src="/Escalade/sectors?spot=<spring:out value="${ spot.id }" />" style="width: 100%; height: 600px; border: none;" onload="resizeIframe(this)"></iframe>

<%@ include file="../jsp/footer.jsp" %>