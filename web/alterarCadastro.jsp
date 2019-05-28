<%-- 
    Document   : formNovoUsuario
    Created on : 17/04/2019, 13:52:34
    Author     : Usuario
--%>

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
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
        <%
            Usuario usu = (Usuario)request.getAttribute("usuario");
        %>
        
        <div class="container">
            <div class="col-md-6 cadastro">
        <h1>Alterar usuário</h1>
        <form action="UsuarioController" method="POST">
            <input type="hidden" name="acao" value="salvar">
                <div class="form-group">                   
                    <input type="hidden" name="id" id="id" value="<%=usu.getId()%>">     
                </div>
                <div class="form-group">
                    Nome
                    <input type="text" name="nome" id="nome" value="<%=usu.getNome()%>">
                    
                </div>
                <div class="form-group">
                    Login
                   <input type="text" name="login" id="login" value="<%=usu.getLogin()%>">
                    
                </div>
                <div class="form-group">
                    Senha
                    <input type="text" name="senha" id="senha" value="<%=usu.getSenha()%>">
                    
                </div>
                <div class="form-group">             
                    <input type="submit" id="submit" class="btn btn-primary" value="Alterar">
                    
                </div>
            </form>
            </div>
        </div>
    </body>
</html>
