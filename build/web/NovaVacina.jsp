<%-- 
    Document   : cadastroVacina
    Created on : 17/04/2019, 10:51:23
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
        
        <div class="container">
            <div class="col-md-6 cadastro">
        <h1>Cadastro de vacina</h1>
        <form action="salvarVacina.jsp" method="POST">
                <div class="form-group">
                    Nome
                    <input type="text" name="nome" id="nomeVacina" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Periodicidade
                    <input type="number" name="periodicidade" id="periodicidade" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Numero de doses
                    <input type="number" name="numeroDoses" id="numeroDoses" class="form-control" required="">
              
                </div>
                <div class="form-group">             
                    <input type="submit" id="submit" class="btn btn-primary" value="Cadastrar">
                    
                </div>
            </form>
            </div>
        </div>
    </body>
</html>
