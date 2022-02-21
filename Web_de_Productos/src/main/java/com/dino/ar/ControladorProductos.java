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
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

 //Definir objeto modeloProductos
    private ModeloProductos modeloProductos;

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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
		 //-----------Obtener la lista de productos desde el modelo
	      //primero crear una lista de productos

	          List<Productos> productos;

	           try{

	           productos=modeloProductos.getProductos();


	      //----------Agregar la lista de productos al REQUEST

	          request.setAttribute("LISTAPRODUCTOS", productos);


	      //----------Enviar el REQUEST al la pagina JSP
	      
	         RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaProductos_B.jsp");


	     //con el metodo forward envia la informacion

	        miDispatcher.forward(request,response);

	       
	         }catch(Exception e){


	             e.printStackTrace();
	        
	         }

		
	
	
	}

}
