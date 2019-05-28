<%-- 
    Document   : cadastro
    Created on : 16/04/2019, 15:47:06
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
        <title>Cadastro de cachorro</title>
    </head>
    
    <script>
        function formatar(mascara,documento){
            var i = documento.value.length;
            var saida = mascara.substring(0,1);
            var texto = mascara.substring(i);
            
            if(texto.substring(0,1) != saida){
                documento.value += texto.substring(0,1); 
            }
        }
    </script>
    
    <body>
        
        <div class="container">
            <div class="col-md-6 cadastro">
        <h1>Cadastro do cachorro</h1>
        <form action="salvarCachorro.jsp" method="POST">          
            <div class="form-group">
                    Nome
                    <input type="text" name="nome" id="nomeCachorro" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Data de nascimento
                    <input type="text" name="dataNascimento" id="dataNascimento" class="form-control" required="" OnKeyPress="formatar('##/##/####', this)">
                    
                </div>
                <div class="form-group">
                    Peso
                    <input type="number" name="peso" id="peso" step=".01" class="form-control" required="">
                                     
                </div>
                <div class="form-group">             
                    <input type="submit" id="submit" class="btn btn-primary" value="Cadastrar">
                    
                </div>
            </form>
            </div>
        </div>
    </body>
</html>
