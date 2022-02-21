<!-- video 255 -->


<html>

<body>

<h1 style="text-align:center">Insertar Productos</h1>

<form name="form1"  action= "ControladorProductos_B" method="get">
<input type="hidden"  name="instruccion" value="insertarBBDD">
              
       <table width="50%" border="0">
         <tr>
           <td>Código Articulo</td>
           <td ><label for="CArt"></label>
           <input type="text" name="CArt" id="CArt"></td>
         </tr>
         <tr>
           <td>Seccion</td>
           <td><label for="seccion"></label>
           <input type="text" name="seccion" id="seccion"></td>
         </tr>
         <tr>
           <td>Nombre Artículo</td>
           <td><label for="NArt"></label>
           <input type="text" name="NArt" id="NArt"></td>
         </tr>
          <tr>
           <td>Precio</td>
           <td><label for="precio"></label>
           <input type="text" name="precio" id="precio"></td>
         </tr>
         <tr>
           <td>Fecha</td>
           <td><label for="fecha"></label>
           <input type="text" name="fecha" id="fecha"></td>
         </tr>
         <tr>
           <td>Importado</td>
           <td><label for="importado"></label>
           <input type="text" name="importado" id="importado"></td>
         </tr>
         <tr>
           <td>Pais de Origen</td>
           <td><label for="Porig"></label>
           <input type="text" name="Porig" id="Porig"></td>
         </tr>

         <tr>
            <td><input type="submit" name="envio" id="envio" value="Enviar"></td>
            <td><input type="reset"  name="borrar" id="borrar" value="Reestablecer"></td>
         </tr> 
      </table> 
     </form>


</body>
</html> 