<%-- 
    Document   : loginSucesso
    Created on : 28/04/2019, 11:49:06
    Author     : Usuario
--%>
<%@page import="java.util.List"%>
<%@page import="br.com.iniciando.dominio.Usuario"%>
<%@page import="br.com.iniciando.dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="resources/css/style.css" />" rel="stylesheet" type="text/css"/>
        <title>Página - Salvar </title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
    </body>
    
        <%
            List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("listaUsuario");
        %>    
        <table class="table">
            <tr>
                <td>ID: </td>
                <td>Nome: </td>
                <td>Login: </td>
                <td>Senha: </td>
                <th>Excluir</th>
                <th>Alterar</th>
            </tr>
            <%
            for(Usuario u: listaUsuario){
            %>
            <tr>
                <th><%=u.getId()%> </th>
                <th><%=u.getNome()%></th>
                <th><%=u.getLogin()%> </th>
                <th><%=u.getSenha()%></th>
                <th><a href="UsuarioController?acao=excluir&id=<%=u.getId()%>">Excluir</a></th>
                <th><a href="UsuarioController?acao=alterar&id=<%=u.getId()%>">Alterar</a></th>
            </tr>
            <%
            }
            %>
     </table>   
</html>
