<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
Accueil
<p>
<%
String message=(String) request.getAttribute("myComment");
out.println(message);

%>
${myComment} 
</p>

</body>
</html>