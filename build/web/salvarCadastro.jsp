<%-- 
    Document   : salvarCadastro
    Created on : 28/04/2019, 17:15:22
    Author     : Usuario
--%>

<%@page import="br.com.iniciando.dao.UsuarioDAO"%>
<%@page import="br.com.iniciando.dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página salvar usuário</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
        <%
            String snome = request.getParameter("nome");
            String slogin = request.getParameter("login");
            String ssenha = request.getParameter("senha");
        
            Usuario u = new Usuario();
            u.setNome(snome);
            u.setLogin(slogin);
            u.setSenha(ssenha);
            
            UsuarioDAO uDAO = new UsuarioDAO();
            uDAO.create(u);
        %>
    </body>
    <c:redirect url="login.jsp"></c:redirect>
    <h1>Salvo com sucesso!</h1>
</html>
