<%-- 
    Document   : home
    Created on : 28/04/2019, 17:48:31
    Author     : Usuario
--%>

<%@page import="br.com.iniciando.dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
    </body>
    
    <%
        Usuario usuAutenticado = (Usuario)session.getAttribute("usuAutenticado");
        String bemVindo = usuAutenticado.getNome();
    %>
    <br>
    <div class="col-md-11 text-center">
        <h2>Seja muito bem vindo, <%=usuAutenticado.getNome()%></h2>
    </div>
<c:redirect url="CachorroController?acao=lista"/>    
</html>

