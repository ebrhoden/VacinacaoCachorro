<%-- 
    Document   : login
    Created on : 20/04/2019, 11:04:08
    Author     : Usuario
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        
        <div class="container">
${loginError}
            <div class="col-md-6 cadastro">
        <h1>Login</h1>
        <form action="login" method="POST">            
                <div class="form-group">
                    Login
                   <input type="text" name="login" id="login" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Senha
                    <input type="password" name="senha" id="senha" class="form-control" required="">
                    
                </div>
                <div class="form-group">             
                    <input type="submit" id="submit" class="btn btn-primary" value="Logar">
                    
                </div>
            </form>
            </div>
        </div>
    </body>
</html>
