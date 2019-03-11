<%-- 
    Document   : juego
    Created on : 4/03/2019, 04:49:25 PM
    Author     : Xcelsius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table style="width: 237px;" border="1">
<tbody>
<tr>
<td style="width: 79px;">&nbsp;</td>
<td style="width: 79px;">&nbsp;Cliente</td>
<td style="width: 79px;">&nbsp;Servidor</td>
</tr>
<tr>
<td style="width: 79px;">&nbsp;Juega</td>
<td style="width: 79px;">&nbsp;<%= request.getAttribute("opcionCliente") %></td>
<td style="width: 79px;">&nbsp;<%= request.getAttribute("opcionServidor") %></td>
</tr>
<tr>
<td style="width: 79px;">&nbsp;Ganador jugada</td>
<td style="width: 79px;"><%=request.getAttribute("opcionCliente")%></td>
<td style="width: 79px;"><%=request.getAttribute("opcionServidor")%></td>
</tr>
<tr>
<td style="width: 79px;">&nbsp;Jugadas ganadas</td>
<td style="width: 79px;"><%=request.getAttribute("jugadasGanadasCliente")%></td>
<td style="width: 79px;"><%=request.getAttribute("jugadasGanadasServidor")%></td>
</tr>
<tr>
<td style="width: 79px;">&nbsp;Jugadas empatadas</td>
<td style="width: 79px;"><%=request.getAttribute("jugadasEmpatadas")%></td>
<td style="width: 79px;">&nbsp;</td>
</tr>
<tr>
<td style="width: 79px;">&nbsp;Partidas ganadas</td>
<td style="width: 79px;"><%=request.getAttribute("partidasGanadasCliente")%></td>
<td style="width: 79px;"><%=request.getAttribute("partidasGanadasServidor")%></td>
</tr>
<tr>
<td style="width: 79px;">&nbsp;Partidas empatadas</td>
<td style="width: 79px;"><%=request.getAttribute("partidasEmpatadas")%></td>
<td style="width: 79px;">&nbsp;</td>
</tr>
</tbody>
</table>
<!-- DivTable.com -->
    </body>
</html>
