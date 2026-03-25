package ar.com.franco.AppJava.domain;

	public class Producto {
		private int precio;
		private String nombre;
		
		public Producto(String nombre, int precio) {
			this.setNombre(nombre);
			this.setPrecio(precio);
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
