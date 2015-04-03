<%-- 
    Document   : cargarPedido
    Created on : 2/04/2015, 12:31:54 AM
    Author     : User
--%>

<%@page import="modulo.ofertas.dto.OfertaDto"%>
<%@page import="modulo.ofertas.FOferta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            FOferta faOfer = new FOferta();
            OfertaDto ofDto = faOfer.obtenerOfertaPorId(Integer.parseInt(request.getParameter("idOferta")));
            String cantidad = Integer.toString(ofDto.getInDto().getCantidad());            
            
        %>

        <strong><%=" " + ofDto.getPreDto().getDescripcion()%>s de </strong> (<%=ofDto.getProAso().getProDto().getNombres()%>)<strong> disponibles </strong><strong id="cantidad"><%=cantidad%></strong> 
        <input type="hidden" name="idOfer" id="idOferta" value="<%=ofDto.getIdOferta()%>">
    </body>
</html>
