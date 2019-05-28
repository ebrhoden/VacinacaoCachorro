<%-- 
    Document   : cabecalho
    Created on : 28/04/2019, 17:45:03
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cabeçalho</title>
    </head>
    <div class="text-right col-lg-auto"> 
        <a href="home.jsp">Inicio</a> <br>       
        <a href="UsuarioController?acao=lista">Lista de usuário</a> <br>
        <a href="CachorroController?acao=cadastro">Cadastro de cachorro</a> <br>
        <a href="CachorroController?acao=lista">Lista de cachorro</a> <br>
        <a href="VacinaController?acao=cadastro">Cadastro de vacina</a> <br>
        <a href="VacinaController?acao=lista">Lista de vacina</a> <br>
        <a href="autenticador">Sair</a>
            
        
    </div>
</html>
