package ar.com.franco.AppJava.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTO")

public class Producto extends Persisteble{
		
		@Column(name = "precio")
		private int precio;
		@Column(name = "nombre")
		private String nombre;
				
		public Producto(String nombre, int precio) {
			this.nombre = nombre;
			this.precio = precio;
		}
		
		public void mostrarProducto(){
			System.out.println("Nombre: " + nombre);
			System.out.println("Precio: $" + precio);
			System.out.println("----------------------");
			
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}
}
