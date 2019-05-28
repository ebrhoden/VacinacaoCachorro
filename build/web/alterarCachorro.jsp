<%-- 
    Document   : formNovoUsuario
    Created on : 17/04/2019, 13:52:34
    Author     : Usuario
--%>

<%@page import="br.com.iniciando.dominio.Cachorro"%>
<%@page import="br.com.iniciando.dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <title>Cadastro</title>
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
        %>

        <div class="container">
            <div class="col-md-6 cadastro">
                <h1>Alterar cachorro</h1>
                <form action="CachorroController" method="POST">
                    <input type="hidden" name="acao" value="salvar">
                    <div class="form-group">                   
                        <input type="hidden" name="id" id="id" value="<%=cachorro.getId()%>">     

                        <div class="form-group">
                            Nome
                            <input type="text" name="nome" id="nome" class="form-control" value="<%=cachorro.getNome()%>">

                        </div>
                        <div class="form-group">
                            Peso
                            <input type="text" name="peso" id="peso" class="form-control" value="<%=cachorro.getPeso()%>">

                        </div>
                        <div class="form-group">
                            Data de nascimento
                            <input type="text" name="dataNascimento" id="dataNascimento" class="form-control" required="" value="<%=cachorro.getDataNascimento()%>" OnKeyPress="formatar('##/##/####', this)">

                        </div>               
                        <div class="form-group">             
                            <input type="submit" id="submit" class="btn btn-primary" value="Alterar">

                        </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
