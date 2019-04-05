<%-- ici on voit comment en JSTL le code html est échapé, par défaut les balises HTML ne sont pas interprétées --%>
    <c:out value ="<p>Je suis un 'paragraphe'.</p>" />
    

    <%-- pour annuler l'échapement des balises : --%>
    <c:out value="<p>Je suis un 'paragraphe'.</p>" escapeXml="false" />

    <%-- Déclaration d'une variable --%>
    <c:set var="maVariable" value="valeur contenue dans la variable" />
    <c:set var="autreVariable">22</c:set>
    <%-- Affichage de la variable --%>
    <c:out value="${maVariable}" />
    <c:out value="${autreVariable}" />-->

    <%-- les conditions --%>
    <p>
        <c:if test="${4>5}"> Un test vrai</c:if>
    </p>
    
    <%-- les conditions multiples --%>
    <p>
        <c:choose>
            <c:when test="${false}">quand le test est vrai</c:when>
            <c:otherwise>qd le test est faux</c:otherwise>
        </c:choose>
    </p>

    <%-- les boucles --%>
    <table>
        <tr>
        <th>valeur</th>
        <th>valeur*2</th>
        <tr>
        <c:forEach var="i" begin="0" end="10" step="1">
        <tr>
        <td><c:out value="${i}"/></td>
        <td><c:out value="${i*2}"/></td>
        </tr>
        </c:forEach>
    </table>
    
    
    <ul>
    <c:forEach items="${listeUser}" var="user">
        <li><c:out value="${user.nom}"></c:out></li>
    </c:forEach>
    </ul>