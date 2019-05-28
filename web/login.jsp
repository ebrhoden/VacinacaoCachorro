<%-- 
    Document   : login
    Created on : 30/04/2019, 16:20:39
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
              <title>Página - Login</title>
    </head>
    <body>
        <fieldset>
            <div class="container">
                <div class="text-center">
                <br>
                <h1>Login</h1>
                </div>
                <div class="col-md-6 cadastro">
                <form action="autenticador" method="POST">
                    <div class="form-group">
                        Usuário
                        <input type="text" name="login" id="login" class="form-control" required="">

                    </div>
                    <div class="form-group">
                        Senha
                        <input type="password" name="senha" id="senha" class="form-control" required="">

                    </div>
                    <div class="form-group">             
                        <input type="submit" id="submit" class="btn btn-primary" value="Logar">

                    </div>
                    <a href="UsuarioController?acao=cadastro">Ainda não se registrou?</a> <br>
                </form>
            </div>
            </div>
        </fieldset>

    </body>
</html>
