<!-- video 69 -->



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>


<html>


<style type="text/css">

.cabecera{
     font-size:1.2em;
     font-weight:bold;
     color:#FFFFFF;
     background-color:#08088A;
}

.filas{
     
      text-align:center;
      background-color:#5882FA;
}

<!-- Para que este a la izquierda la tabla-->

table{

      float:left;

}


<!--El resto y el Boton a la derecha-->

#contenedorBoton{

     margin-left:1000px;

}





</style>

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
    <th class="cabecera">Accion Modificar</th>
    <th class="cabecera">Accion Eliminar</th>
    
    </tr> 


     <c:forEach var="tempProd"  items="${LISTAPRODUCTOS}">
     
     <!--Links ACTUALIZAR (CONSTRUCCION) para cada producto con su campo clave -->
     
     <c:url  var="linktemp"  value="ControladorProductos_B">
     
     <c:param  name="instruccion"  value="cargar_pro_modif">   </c:param>  <!--Para enviar un parametro name="instruccion" es el que espera el controlador al igual que en insterta productos-->
    
     <c:param  name="CArticulo"  value="${tempProd.cArt}">   </c:param> <!--Necesitamos que cada vinculo cargue el codigo articulo, lo conseguimos con la tags-->
            
     </c:url>
     
     
     <!--Links ELIMINAR (CONSTRUCCION) para cada producto con su campo clave -->
     
     <c:url  var="linktempeliminar"  value="ControladorProductos_B">
     
     <c:param  name="instruccion"  value="eliminar_producto">   </c:param>  <!--Para enviar un parametro name="instruccion" es el que espera el controlador al igual que en insterta productos-->
    
     <c:param  name="CArticulo"  value="${tempProd.cArt}">   </c:param> <!--Necesitamos que cada vinculo cargue el codigo articulo, lo conseguimos con la tags para saber que eliminar-->
            
     </c:url>
     
     
     
     
      <!-- No nos hace falta ecurrir a los getters para acceder a los campos Usamos JSPTags accediendo con el mismo nombre que la guarde en la clase Productos -->
   
    <tr>

      <td class="filas">${tempProd.cArt}</td>
      <td class="filas">${tempProd.seccion}</td>
      <td class="filas">${tempProd.nArt}</td>
      <td class="filas">${tempProd.precio}</td>
      <td class="filas">${tempProd.fecha}</td>
      <td class="filas">${tempProd.importado}</td>
      <td class="filas">${tempProd.porig}</td>
      <td class="filas"><a href="${linktemp}">Actualizar</a></td>
      <td class="filas"><a href="${linktempeliminar}">Eliminar</a></td>

    </tr>

   </c:forEach>
   

   </table> 

<!-- Creamos un contenedor para la creacion de botones VIDEO 255-->

<div id="contenedorBoton">

  <input type="button" value="Insertar Producto" onclick="window.location.href='inserta_producto.jsp'"/>

   
</div> 




</body>
</html>
