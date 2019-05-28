<%-- 
    Document   : salvarCadastro
    Created on : 28/04/2019, 17:15:22
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            String speso = request.getParameter("peso");
            String sdataNascimento = request.getParameter("dataNascimento");
            double pesoConvertido = Double.parseDouble(speso);
            Usuario usuAutenticado = (Usuario)session.getAttribute("usuAutenticado");
            String idUsu = String.valueOf(usuAutenticado.getId());
            int idUsuario = Integer.parseInt(idUsu);
            
            try{
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date(format.parse(sdataNascimento).getTime());
            
            
            
            
            Cachorro c = new Cachorro();
            c.setNome(snome);
            c.setPeso(pesoConvertido);
            c.setDataNascimento(new java.sql.Date(data.getTime()));
            c.setIdUsuario(idUsuario);
            
            CachorroDAO cDAO = new CachorroDAO();
            cDAO.create(c);
            }catch(ParseException e){
                out.print("Erro de data - "+e.getMessage());
            }
        %>
    </body>
    <c:redirect url="CachorroController?acao=lista"></c:redirect>
    <h1>Salvo com sucesso!</h1>
</html>
