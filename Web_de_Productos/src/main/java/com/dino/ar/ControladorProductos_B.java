package com.dino.ar;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos_B")
public class ControladorProductos_B extends HttpServlet {
	private static final long serialVersionUID = 1L;



//Definir el SataSource POOL de conexion
   @Resource(name="jdbc/Productos")
   private DataSource miPool;

//Definir metodo "init" desde donde arranca la aplicacion
  @Override
 public void init() throws ServletException{
   super.init();
   try{

   modeloProductos=new  ModeloProductos(miPool);

   }catch(Exception e){

     throw new ServletException(e);
   }
	
}    	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //creamos  metodos que muestre la lista de productos o para insertar productos para limpiar un poco el codigo


        //Leer el parametro que le llega del formulario para saber que hago o de la actualizacion del producto

       String elComando=request.getParameter("instruccion"); //Si hay instruccion de insertar aca se alamacena el valor de la instruccion que es "insertarBBDD"


       //si no se envia parametro , listar productos

      
      if(elComando==null)elComando=""; 

        //Redirigir el flujo de ejecucion al metodo de listar o insertar dependiendo o que diga
       System.out.println(elComando);
       
        switch (elComando){
    
          case"listarProductos":
          
                  obtenerProductos(request,response);

                  break;

          case "insertarBBDD":

                 agregarProductos(request,response);

                 break;
                 
          case "cargar_pro_modif":  
        	  
        	  
			try {
				
				cargaProductosmodif(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	     
        	     break;
        	     
        	     
           // si presiona el boton Enviar en el formulario modifica_productos 
        //    el valor del atributo de instruccion es actualizaBBDD 	     
        	     
          case "actualizarBBDD":
        	  
        	  try {
        		  
				actualizaProductos(request,response);
			
        	  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
        	  break;
        	  
        	  
          case "eliminar_producto":

              try {
				EliminarProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

              break;
        	  
        	  
          
          default:

                obtenerProductos(request,response);

         }

}
	
		
	
	private void EliminarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		
		//leer el codigo articulo que viene del listado para saber que producto eliminar
		
		String codigoArticulo=request.getParameter("CArticulo");
					       
		//Enviar objeto al modelo Insertar objeto Productos en la BBDD a traves del objeto ModeloProducto creado con un metodo propio

        modeloProductos.EliminaProducto_BBDD(codigoArticulo);

		//Volver al listado de Productos actualizada

        obtenerProductos(request,response);

		
		
		
	}

	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//leer los datos que le vienen del formulario modificar_producto
		 
		String CodArticulo=request.getParameter("CArt");
		String Seccion=request.getParameter("seccion");
		String NombreArticulo=request.getParameter("NArt");
		String Precio=request.getParameter("precio");  //hay que cambiar el tipo de variable
		String Fecha=request.getParameter("fecha");  //hay que cambiar el tipo de variable
		String Importado=request.getParameter("importado");
		String PaisOrigen=request.getParameter("Porig");
		
		//crear un producto con esos datos
		
		Productos producto_actualizado= new  Productos(CodArticulo,Seccion,NombreArticulo,Precio,Fecha,Importado,PaisOrigen);

		//llamar al modelo y enviarle la informacion para que modifique la BBDD
		
		 modeloProductos.actualizarProducto_BBDD(producto_actualizado);
		 
		//Presentar la lista actualizada
		
		 obtenerProductos(request,response);
	}

	private void cargaProductosmodif(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	 
		//leer el codigo articulo que viene del listado para saber que producto modificar
		
		String codigoArticulo=request.getParameter("CArticulo");//nombre del parametro en el name
				
		//LLamo Metodo getProducto_modif sobre los campos de datos del producto que tengo que modificar y nos devuelva esos datos
	
		Productos elProducto_modif=  modeloProductos.getProducto_modif(codigoArticulo);
		
		//El producto me llega con todos los campos entnoces ; colocar atributo correspondiente al codigo articulo para saber cual es en la vuelta
		
	   request.setAttribute("PROD_MODIFICADO", elProducto_modif);
		
		//Enviar producto al formulario de actualizar
		
	   RequestDispatcher miDispatcher=request.getRequestDispatcher("/modifica_producto.jsp");

	   miDispatcher.forward(request,response);
	
	}
	
	
	
	
	
	
	

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response){

		//leer la informacion que viene desde el formulario, los campos deben ser
		//iguales a los campos que vienen del formulario del cuadro de texto

		String CodArticulo=request.getParameter("CArt");
		String Seccion=request.getParameter("seccion");
		String NombreArticulo=request.getParameter("NArt");
		String Precio=request.getParameter("precio");  //hay que cambiar el tipo de variable
		String Fecha=request.getParameter("fecha");  //hay que cambiar el tipo de variable
		String Importado=request.getParameter("importado");
		String PaisOrigen=request.getParameter("Porig");
      
		
		
		//Crear un objeto de tipo Producto

         Productos nuevoproducto= new  Productos(CodArticulo,Seccion,NombreArticulo,Precio,Fecha,Importado,PaisOrigen);

        
		//Enviar objeto al modelo Insertar objeto Productos en la BBDD a traves del objeto ModeloProducto creado con un metodo propio

         try {
			modeloProductos.agregarNuevoProducto(nuevoproducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Volver al listado de Productos actualizada

         obtenerProductos(request,response);

		}




		private void obtenerProductos(HttpServletRequest request, HttpServletResponse response){

		      //-----------Obtener la lista de productos desde el modelo
		      //primero crear una lista de productos
		          List<Productos> productos;

		           try{

		           productos=modeloProductos.getProductos();


		      //----------Agregar la lista ARRAYLIST de productos al REQUEST

		          request.setAttribute("LISTAPRODUCTOS", productos);


		      //----------Enviar el REQUEST al la pagina JSP
		      
		         RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaProductos_B.jsp");


		     //con el metodo forward envia la informacion

		        miDispatcher.forward(request,response);

		       
		       }catch(Exception e){


		            e.printStackTrace();
		        
		       }
		   


		}
	
	
		//Definir objeto modeloProductos
		
	    private ModeloProductos modeloProductos;

}



