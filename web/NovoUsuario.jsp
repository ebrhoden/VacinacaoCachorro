<%-- 
    Document   : formNovoUsuario
    Created on : 17/04/2019, 13:52:34
    Author     : Usuario
--%>

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
    <body>
        <br>
        <div class="text-right col-lg-auto">
            <a href="autenticador">Sair</a>
        </div>
        
        <div class="container">
            <div class="col-md-6 cadastro">
        <h1>Cadastro de usuário</h1>
        <form action="salvarCadastro.jsp" method="POST">
                <div class="form-group">
                    Nome
                    <input type="text" name="nome" id="nome" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Usuario
                   <input type="text" name="login" id="login" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Senha
                    <input type="password" name="senha" id="senha" class="form-control" required="">
                    
                </div>
                <div class="form-group">             
                    <input type="submit" id="submit" class="btn btn-primary" value="Cadastrar">
                    
                </div>
            </form>
            </div>
        </div>
    </body>
</html>
