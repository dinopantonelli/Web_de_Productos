package com.dino.ar;

import java.sql.*;
//import java.sql.Date;
import java.util.*;
import javax.sql.*;

public class ModeloProductos{

   
         
       //almacenamos el POOL de conexion en el parametro del constructor
    
         public ModeloProductos(DataSource origenDatos){
            
              this.origenDatos=origenDatos;

       }

         ////////////////////////////////////////////////////////////   
   //con este metodo nos devuelve los productos
   public List<Productos> getProductos() throws  Exception{              //metemos el metodo dentro de un try catch para evitar que se cuelgue por eso el throw
        
                 List<Productos> productos=new ArrayList<>();
     
                 Connection miconexion=null;
      
                 Statement miStatement= null;

                 ResultSet miResultset=null;
  
         //-----------establecer la conexion
        try {
                 miconexion=origenDatos.getConnection();
                 
         //-----------crear sentencia SQL y Statement

                 String instruccionSql="SELECT * FROM PRODUCTOS";
     
                 miStatement=miconexion.createStatement();

                 
        //--------ejecutar la sentencia SQL

                miResultset=miStatement.executeQuery(instruccionSql);
 
         //----------recorrer el resultset
              // System.out.println("aca estoy");
               while(miResultset.next()){

               String c_art=miResultset.getString("CÓDIGOARTÍCULO");
               String seccion=miResultset.getString("SECCIÓN");
               String n_art=miResultset.getString("NOMBREARTÍCULO");
               String precio=miResultset.getString("PRECIO");
               String fecha=miResultset.getString("FECHA");
               String importado=miResultset.getString("IMPORTADO");
               String p_orig=miResultset.getString("PAÍSDEORIGEN");
                              
               
               
              Productos temProd=new Productos(c_art,seccion,n_art,precio,fecha,importado,p_orig);

              //agrega al Arraylist cada producto
              
              productos.add(temProd); 

             } 
               
              }finally {
  				
  				miStatement.close();
  				miconexion.close();
  			}
           
           return  productos;         

        }

     
   ////////////////////////////////////////////////////////////   		
         public  void agregarNuevoProducto(Productos nuevoproducto) throws Exception  {
			// TODO Auto-generated method stub
        	 
        	//Obtener la conexion con la base de datos
        	 Connection miConexion=null;
             
             PreparedStatement miStatement= null;  //Conconsulta preparada

             try {
           
             miConexion=origenDatos.getConnection();
            
        	 
        	 //Intsruccion SQL que inserte el producto
        	 
        	//String sql="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN  , NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN )"+
        	//"VALUES(?,?;?,?,?,?,?)";
            
        	String sql="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN) VALUES(?,?,?,?,?,?,?)";
        	 
        	miStatement=miConexion.prepareStatement(sql);
             
             
        	 //Establecer los parametros para el producto
     
        	 //System.out.println(nuevoproducto.getPorig());
        	 
        	 miStatement.setString(1,nuevoproducto.getcArt());
        	 miStatement.setString(2,nuevoproducto.getSeccion());
        	 miStatement.setString(3,nuevoproducto.getnArt());
        	 miStatement.setString(4,nuevoproducto.getPrecio());
        	 miStatement.setString(5,nuevoproducto.getFecha());
        	 miStatement.setString(6,nuevoproducto.getImportado());
        	 miStatement.setString(7,nuevoproducto.getPorig());
        	 //Ejecutar la instruccion SQL
        	 
        	 miStatement.execute();
        	 
              }catch(Exception e) {
            	 
             }finally {
  				
  				miStatement.close();
  				miConexion.close();
  			}
		}  
         
 ////////////////////////////////////////////////////////////        
         public Productos getProducto_modif(String codigoArticulo) throws Exception {
 			// TODO Auto-generated method stub
        	 
             Connection miConexion=null;
        	 
        	 PreparedStatement miStatement= null;  //Conconsulta preparada
        	 
        	 Productos prod_modif =null;
        	 
        	 ResultSet miresultset = null; 
        	 
        	 String cod_art_modif = codigoArticulo;
        	 
        	 //establecer la conexion
        	 
        	 try {
        		 
				miConexion=origenDatos.getConnection();
				
				 //establecer SQL que encuentre el producto
	        	 
				String consultaCodart="SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
						
	        	//Crear consulta preparada 
	        	 
				miStatement=miConexion.prepareStatement(consultaCodart);
				
	        	//Establecer los parametros
	        	 
	        	miStatement.setString(1, cod_art_modif);
	        	 
	        	//Ejecutar Consulta y lo almaceno en un resultset
	        	        	
	        	miresultset= miStatement.executeQuery();
	        		
	        	 
	        	//obtener el producto como respuesta recorriendo el Resulset
				
	        	 if(miresultset.next()){	        		 
	        		 
	        		 String CArt=miresultset.getString("CÓDIGOARTÍCULO");
	                 String seccion=miresultset.getString("SECCIÓN");
	                 String n_art=miresultset.getString("NOMBREARTÍCULO");
	                 String precio=miresultset.getString("PRECIO");
	                 String fecha=miresultset.getString("FECHA");
	                 String importado=miresultset.getString("IMPORTADO");
	                 String p_orig=miresultset.getString("PAÍSDEORIGEN");
	        		
	                 prod_modif=new Productos(CArt,seccion,n_art,precio,fecha,importado,p_orig);
	        		 
	                 
	        	 }else {
	        		 
	        		throw new Exception("No hemos encontrado el producto con ese código: "+ cod_art_modif);
	        	 
	        	 }
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
 				
 				miStatement.close();
 				miConexion.close();
 			}
        	 
           //devolver el producto a modificar solicitado
        	      	 
 			return  prod_modif;
 		}
         
 /////////////////////////////////////////////////////////////////////////////////        
         
         public void actualizarProducto_BBDD(Productos producto_actualizado) throws Exception{
 			// TODO Auto-generated method stub
 		
        	//Obtener la conexion con la base de datos
        	 Connection miConexion=null;
             
             PreparedStatement miStatement= null;  //Conconsulta preparada

                      
             try {
            	 
				miConexion=origenDatos.getConnection();
			
				//establecer SQL que modifique  el producto
	        	 
				String consultamodifProd="UPDATE PRODUCTOS SET SECCIÓN=?, NOMBREARTÍCULO=?, PRECIO=?, FECHA=?, IMPORTADO=?, PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=?";
				
				miStatement=miConexion.prepareStatement(consultamodifProd);
				
				// establecer los parametros
				
				miStatement.setString(1, producto_actualizado.getSeccion());
				miStatement.setString(2, producto_actualizado.getnArt());
				miStatement.setString(3, producto_actualizado.getPrecio());
				miStatement.setString(4, producto_actualizado.getFecha());
				miStatement.setString(5, producto_actualizado.getImportado());
				miStatement.setString(6, producto_actualizado.getPorig());
				miStatement.setString(7, producto_actualizado.getcArt());
				
				miStatement.execute();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
 				
 				miStatement.close();
 				miConexion.close();
 			}
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
 		}
         
         
 ////////////////////////////////////////////        
         
         public void EliminaProducto_BBDD(String productoelimina)throws Exception {
        	 
        	//Obtener la conexion con la base de datos
        	 Connection miConexion=null;
             
             PreparedStatement miStatement= null;  //Conconsulta preparada
             
             try {
            	 
            	        	 
            	 miConexion=origenDatos.getConnection(); 
            	 
            	 //Intsruccion SQL que elimine el producto
                         	
             	String sql="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=? ";
             	 
             	miStatement=miConexion.prepareStatement(sql);
             	
             	miStatement.setString(1, productoelimina);
            	            	 
             	//Ejecutar la instruccion SQL
           	 
           	    miStatement.execute();
            	 
            	 
            	 
             } catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} finally {
 				
 				miStatement.close();
 				miConexion.close();
 			}
             
        	 
        	 
        	 
 			
 		}
         
         
           
         
       private  DataSource origenDatos;

		


}