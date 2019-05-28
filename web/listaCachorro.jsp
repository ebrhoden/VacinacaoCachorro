<%-- 
    Document   : loginSucesso
    Created on : 28/04/2019, 11:49:06
    Author     : Usuario
--%>
<%@page import="br.com.iniciando.dominio.Cachorro"%>
<%@page import="java.util.List"%>
<%@page import="br.com.iniciando.dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <title>Lista de cachorros registrados </title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" ></jsp:include>
        <h1 class="text-center">Lista de cachorros registrados </h1>
    </body>
    
        <%
            List<Cachorro> listaCachorro = (List<Cachorro>)request.getAttribute("listaCachorro");
        %>    
        <table class="table">
            <tr>
                <td>ID: </td>
                <td>Nome: </td>
                <td>Data de nascimento: </td>
                <td>Peso: </td>
                <td> </td>
                <td> </td>
                <td> </td>
            </tr>
            <%
            for(Cachorro c: listaCachorro){
            %>
            <tr>
                <th><%=c.getId()%> </th>
                <th><%=c.getNome()%></th>
                <th><%=c.getDataNascimento()%> </th>
                <th><%=c.getPeso()%></th>
                <th> </th>
                <th><a href="CachorroController?acao=excluir&id=<%=c.getId()%>">Excluir</a></th>
                <th><a href="CachorroController?acao=alterar&id=<%=c.getId()%>">Alterar</a></th>
                <th><a href="AgendamentoController?acao=cadastro&id=<%=c.getId()%>">Agendar vacinas</a></th>
            </tr>
            <%
            }
            %>
     </table>   
</html>
