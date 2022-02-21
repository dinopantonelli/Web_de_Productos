<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- video 252 253 -->


<%@ page import="java.util.*, com.dino.ar.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c"  %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<style type="text/css">

.cabecera{
      border-bottom:solid #F00 1px;
}
</style>

<%

 //obtiene los productos del controlador (Servlet) lo hace afuera del body porque alla abajo es la interfaz del usuario

  List<Productos> losProductos=(List<Productos>) request.getAttribute("LISTAPRODUCTOS");  //casting



%>






<body>

<table>

    <tr>

    <th class="cabecera">Codigo Articulo</th>
    <th class="cabecera">Seccion</th>
    <th class="cabecera">Nombre Articulo</th>
    <th class="cabecera">Precio</th>
    <th class="cabecera">Fecha</th>
    <th class="cabecera">Importado</th>
    <th class="cabecera">Pais de Origen</th> 

    </tr> 

    <% for(Productos tempProd:losProductos){ %>

    <tr>

      <td><%= tempProd.getcArt() %></td>
      <td><%= tempProd.getSeccion() %></td>
      <td><%= tempProd.getnArt() %></td>
      <td><%= tempProd.getPrecio() %></td>
      <td><%= tempProd.getFecha() %></td>
      <td><%= tempProd.getImportado() %></td>
      <td><%= tempProd.getPorig() %></td> 



    </tr>

    <% } %>

   

   </table> 



</body>
</html>