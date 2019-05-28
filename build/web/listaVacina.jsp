<%-- 
    Document   : loginSucesso
    Created on : 28/04/2019, 11:49:06
    Author     : Usuario
--%>
<%@page import="br.com.iniciando.dominio.Vacina"%>
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
        <title>Lista de vacinas registrados </title>
    </head>
    <body>

        <jsp:include page="cabecalho.jsp"></jsp:include>
            <h1 class="text-center">Lista de vacinas </h1>
        <%
            List<Vacina> listaVacina = (List<Vacina>) request.getAttribute("listaVacina");
            String aviso = "testando aqui mesmo";
            String vazio = "";
            if (listaVacina.isEmpty()) {
                aviso = "(você ainda não cadastrou nenhuma vacina!)";
                request.setAttribute("aviso", aviso);
            }
            else{
                request.setAttribute("aviso", vazio );
            }
            
        %>   
    </body>   
    <h1 class="text-center"><%=request.getAttribute("aviso")%></h1>
    <table class="table">
        <tr>
            <td>ID: </td>
            <td>Nome: </td>
            <td>Numero de doses: </td>
            <td>Periodicidade: </td>
            <td> </td>
            <th> </th>
            <th> </th>
        </tr>
        <%
            for (Vacina v : listaVacina) {
        %>
        <tr>
            <th><%=v.getId()%> </th>
            <th><%=v.getNome()%></th>
            <th><%=v.getNumeroDoses()%> </th>
            <th><%=v.getPeriodicidade()%></th>
            <th> </th>
            <th><a href="VacinaController?acao=excluir&id=<%=v.getId()%>">Excluir</a></th>
            <th><a href="VacinaController?acao=alterar&id=<%=v.getId()%>">Alterar</a></th>
        </tr>
        <%
            }
        %>
    </table>   
</html>
