package com.dino.ar;

//import java.util.*;

public class Productos{
	
	   
	
	





		//Hacer los Constructores con campo clave y para insertar y eliminar y sin campo clave para visualizar
	    public Productos(String cArt, String seccion, String nArt,  String precio, String fecha, String importado,
				String porig) {
			super();
			this.cArt = cArt;
			this.seccion = seccion;
			this.nArt = nArt;
			this.precio = precio;
			this.fecha = fecha;
			this.importado = importado;
			this.porig = porig;
		}
      


        public Productos(String seccion, String nArt,  String precio, String fecha, String importado, String porig) {
			super();
			this.seccion = seccion;
			this.nArt = nArt;
			this.precio = precio;
			this.fecha = fecha;
			this.importado = importado;
			this.porig = porig;
		}

		//Hacer los getters y Setters para manipular los campos de todos los campos.


        public String getcArt() {
			return cArt;
		}




		public void setcArt(String cArt) {
			this.cArt = cArt;
		}




		public String getSeccion() {
			return seccion;
		}




		public void setSeccion(String seccion) {
			this.seccion = seccion;
		}




		public String getnArt() {
			return nArt;
		}




		public void setnArt(String nArt) {
			this.nArt = nArt;
		}




		public  String getPrecio() {
			return precio;
		}




		public void setPrecio(String precio) {
			this.precio = precio;
		}




		public String getFecha() {
			return fecha;
		}




		public void setFecha(String fecha) {
			this.fecha = fecha;
		}




		public String getImportado() {
			return importado;
		}




		public void setImportado(String importado) {
			this.importado = importado;
		}




		public String getPorig() {
			return porig;
		}




		public void setPorig(String porig) {
			this.porig = porig;
		}



        //Hacer el metodo toString
     
		 @Override
			public String toString() {
				return "Productos [cArt=" + cArt + ", seccion=" + seccion + ", nArt=" + nArt + ", precio=" + precio
						+ ", fecha=" + fecha + ", importado=" + importado + ", porig=" + porig + "]";
		}


		//creamos los campos de los campos de la tabla productos
         private String cArt; //codigo del articulo
         private String seccion;
         private String nArt;
         private String precio;
         private String fecha;
         private String importado;
         private String porig; 
      
}
