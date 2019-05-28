<%-- 
    Document   : salvarCadastro
    Created on : 28/04/2019, 17:15:22
    Author     : Usuario
--%>

<%@page import="br.com.iniciando.dao.VacinaDAO"%>
<%@page import="br.com.iniciando.dominio.Vacina"%>
<%@page import="java.text.ParseException"%>
<%@page import="br.com.iniciando.dao.CachorroDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.iniciando.dominio.Cachorro"%>
<%@page import="br.com.iniciando.dao.UsuarioDAO"%>
<%@page import="br.com.iniciando.dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página salvar cachoro </title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
        <%
            String snome = request.getParameter("nome");
            String speriodicidade = request.getParameter("periodicidade");
            String snumeroDoses = request.getParameter("numeroDoses");
            int periodicidadeInt = Integer.parseInt(speriodicidade);
            int numeroDosesInt = Integer.parseInt(snumeroDoses);
            Usuario usuAutenticado = (Usuario)session.getAttribute("usuAutenticado");
            String idUsu = String.valueOf(usuAutenticado.getId());
            int idUsuario = Integer.parseInt(idUsu);
            
            Vacina v = new Vacina();
            v.setNome(snome);
            v.setNumeroDoses(numeroDosesInt);
            v.setPeriodicidade(periodicidadeInt);
            v.setIdUsuario(idUsuario);
            
            VacinaDAO vDAO = new VacinaDAO();
            vDAO.create(v);
            
        %>
    </body>
    <h1>Salvo com sucesso!</h1>
</html>
