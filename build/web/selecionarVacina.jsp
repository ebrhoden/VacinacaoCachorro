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

    <script>
        function formatar(mascara, documento) {
            var i = documento.value.length;
            var saida = mascara.substring(0, 1);
            var texto = mascara.substring(i);

            if (texto.substring(0, 1) != saida) {
                documento.value += texto.substring(0, 1);
            }
        }
    </script>

    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
        <%
            Cachorro cachorro = (Cachorro) request.getAttribute("cachorro");
            String nomeDoCachorro = cachorro.getNome();
        %>
        <h1 class="text-center">Agendamento de vacinas para: <%=nomeDoCachorro%> </h1>
    </body>

    <%
        List<Vacina> listaVacina = (List<Vacina>) request.getAttribute("listaVacina");
    %>         
            <form action="HistoricoController" method="POST">             
                <input type="hidden" name="acao" value="salvar">

                <table class="table">
                    <tr>
                        <td> </td>
                        <td>ID: </td>
                        <td>Nome: </td>
                        <td>Numero de doses: </td>
                        <td>Periodicidade: </td>
                        <td>ID do usuário: </td>               
                    </tr>
                    <%
                        for (Vacina v : listaVacina) {
                    %>
                    <tr>                
                        <th><input name="selecionado" type="checkbox" value="<%=v.getId()%>"></th>
                        <th><%=v.getId()%> </th>
                        <th><%=v.getNome()%></th>
                        <th><%=v.getNumeroDoses()%> </th>
                        <th><%=v.getPeriodicidade()%></th>
                        <th><%=v.getIdUsuario()%></th>               
                    </tr>                   
                    <%
                        }
                    %>
                </table>          
                <br>
                <div class="form-group text-left ">
                    Data da primeira dose das vacinas selecionadas
                    <input type="text" name="dataInicial" id="dataInicial" class="form-group" required="" OnKeyPress="formatar('##/##/####', this)">

                </div>   
                <div class="form-group text-left">             
                    <input type="submit" id="submit" class="btn btn-primary" value="Cadastrar">

                </div>       
            </form>
</html>
