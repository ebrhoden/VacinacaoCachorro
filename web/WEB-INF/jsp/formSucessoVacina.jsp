<%-- 
    Document   : formSucessoCachorrro
    Created on : 20/04/2019, 10:42:08
    Author     : Usuario
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <title>Vacinas cadastradas</title>
    </head>
    <body>
        <div class="container">
            
            <table class="table">
                <thread>
                    <tr>
                        <th>Nome</th>
                        <th>Periodicidade</th>
                        <th>Numero de doses</th>
                    
                    </tr>
                </thread>
                
                <tbody>
                    <c:forEach items="${listaVacina}" var="atributo">
                        <tr>
                            <td>${atributo.nome}</td>
                            <td>${atributo.periodicidade}</td>
                            <td>${atributo.numeroDoses}</td>
                            <td>
                                <a href="<c:url value='vacinas/remover/${atributo.id}' />">Remover</a>></th>   
                            </td>
                            
                        </tr>
                        
                    </c:forEach>
                    
                </tbody>
            </table>
            
            
            
        </div>
    </body>
</html>