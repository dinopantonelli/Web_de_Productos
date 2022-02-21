<!-- video 255 -->


<html>

<body>

<h1 style="text-align:center">Actualizar Productos</h1>

<form name="form1"  action= "ControladorProductos_B" method="get">
<input type="hidden"  name="instruccion" value="actualizarBBDD">

<!--  Campo oculto con el codigo articulo a modificar para enviarle al MODELO y que el usuario no lo modifique-->
<input type="hidden"  name="CArt" value="${PROD_MODIFICADO.cArt}"> <!-- campo de clase de Productos cArt --> 

          
       <table width="50%" border="0">
        
         <tr>
           <td>Seccion</td>
           <td><label for="seccion"></label>
           <input type="text" name="seccion" id="seccion" value="${PROD_MODIFICADO.seccion}"></td>
         </tr>
         <tr>
           <td>Nombre Artículo</td>
           <td><label for="NArt"></label>
           <input type="text" name="NArt" id="NArt" value="${PROD_MODIFICADO.nArt}"></td>
         </tr>
          <tr>
           <td>Precio</td>
           <td><label for="precio"></label>
           <input type="text" name="precio" id="precio" value="${PROD_MODIFICADO.precio}" ></td>
         </tr>
         <tr>
           <td>Fecha</td>
           <td><label for="fecha"></label>
           <input type="text" name="fecha" id="fecha" value="${PROD_MODIFICADO.fecha}"></td>
         </tr>
         <tr>
           <td>Importado</td>
           <td><label for="importado"></label>
           <input type="text" name="importado" id="importado" value="${PROD_MODIFICADO.importado}"></td>
         </tr>
         <tr>
           <td>Pais de Origen</td>
           <td><label for="Porig"></label>
           <input type="text" name="Porig" id="Porig" value="${PROD_MODIFICADO.porig}"></td>
         </tr>

         <tr>
            <td><input type="submit" name="envio" id="envio" value="Enviar"></td>
            <td><input type="reset"  name="borrar" id="borrar" value="Restablecer"></td>
         </tr> 
      </table> 
     </form>


</body>
</html> 