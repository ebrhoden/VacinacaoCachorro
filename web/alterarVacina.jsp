<%-- 
    Document   : cadastroVacina
    Created on : 17/04/2019, 10:51:23
    Author     : Usuario
--%>

<%@page import="br.com.iniciando.dominio.Vacina"%>
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
            Vacina vacina = (Vacina)request.getAttribute("vacina");
        %>
        
        <div class="container">
            <div class="col-md-6 cadastro">
        <h1>Alterar de vacina</h1>
        <form action="VacinaController" method="POST">
            <input type="hidden" name="acao" value="salvar">    
            <div class="form-group">                   
                    <input type="hidden" name="id" id="id" value="<%=vacina.getId()%>">     
            
                <div class="form-group">
                    Nome
                    <input type="text" name="nome" id="nome" value="<%=vacina.getNome()%>" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Periodicidade
                    <input type="number" name="periodicidade" id="periodicidade" value="<%=vacina.getPeriodicidade()%>" class="form-control" required="">
                    
                </div>
                <div class="form-group">
                    Numero de doses
                    <input type="number" name="numeroDoses" id="numeroDoses" value="<%=vacina.getNumeroDoses()%>" class="form-control" required="">
              
                </div>
                <div class="form-group">             
                    <input type="submit" id="submit" class="btn btn-primary" value="Cadastrar">
                    
                </div>
            </form>
            </div>
                    </div>
        </div>
    </body>
</html>
