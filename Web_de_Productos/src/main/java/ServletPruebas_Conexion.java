
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class ServletPruebas_Conexion
 */
@WebServlet("/ServletPruebas_Conexion")
public class ServletPruebas_Conexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//Definir el DataSource con anotaciones

	@Resource(name="jdbc/Productos")
	 private DataSource miPool;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas_Conexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		 //Crear el obj printWrinter

        PrintWriter salida=response.getWriter();

        response.setContentType("text/plain");

        //Crear conexion con BBDD

        Connection miConexion=null;
 
        Statement miStatement=null;
 
        ResultSet miResultset=null;

    
        try{

         miConexion=miPool.getConnection();
 
         String miSql="SELECT * FROM PRODUCTOS";

         miStatement= miConexion.createStatement();

         miResultset=miStatement.executeQuery(miSql);


        //recorro el resultset


          while(miResultset.next()){

             String nombre_articulo=miResultset.getString(3);

             salida.println(nombre_articulo);

         }



       }catch(Exception e){
         
         e.printStackTrace();
 
       }
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
