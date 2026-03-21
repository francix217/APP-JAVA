package ar.com.franco.AppJava.domain;

import java.util.ArrayList;
import java.util.Scanner;

import ar.com.franco.AppJava.emuns.Genero;
import ar.com.franco.AppJava.emuns.Login;

public class Main {

	public static void main(String[] args) {
		System.out.println("--Bienvenido a GymTech--");
		
		Scanner scanner = new Scanner(System.in);
			
		Genero generoGuardado = null;
		
		boolean login = false;
		ArrayList<Producto> listaProductos = new ArrayList<>();
		
		while (!login){
			
			mostrarMenu();
			int opcion  = scanner.nextInt();
			
			if (opcion == 1){
				
				cargaProductos(scanner, listaProductos, null);
				
			}else if (opcion == 2){
				registro(scanner, generoGuardado);
				
			} else if (opcion == 3){
				
				System.out.print("Ingrese el Usuario: ");
				String user = scanner.next();

				System.out.print("Ingresar Contraseña: ");
				String contra = scanner.next();
				
				if (user.equals(cliente.getUsuario()) && contra.equals(cliente.getContraseña())) {
					System.out.println("Login correcto");
					login = true;	
				} else {
					System.out.println("Usuario o contraseña incorrectos");
				}	

			}else if (opcion == 4){
				System.out.println("--Catalogo de Productos--");
				
				for (Producto p : listaProductos) {
					p.mostrarProducto();
				}
				
			} else if (opcion == 5){
				login = true;
				System.out.println("--Saliste del Programa--");
				
			} 	
		}		
        scanner.close();
        
	}

	
    private static void mostrarMenu() {
		for (Login l : Login.values()) {
			System.out.println((l.ordinal() + 1) + "- " + l);
		}
		System.out.print("Elegir una opcion: ");
    } 
     
    private static void cargaProductos(Scanner scanner, ArrayList<Producto> listaProductos, Producto producto) {
		System.out.println("----Carga de Maquinas de Gym----");
				
		Producto produc = new Producto("", 0);

		System.out.print("Ingresa el Nombre de la Maquina: ");		
		produc.setNombre(scanner.next());

		System.out.print("Ingresa el Precio de la Maquina: ");		
		produc.setPrecio(scanner.nextInt());

		listaProductos.add(produc);
    }
    
    private static Cliente registro(Scanner scanner, Genero genero) {
		Cliente cliente = new Cliente("", "", "");
    	
    	System.out.print("Ingrese el Usuario: ");		
		cliente.setUsuario(scanner.next());
		
		System.out.print("Ingresar Contraseña: ");		
	    cliente.setContraseña(scanner.next());
		
		System.out.println(" --Genero--");		
		for (Genero g : Genero.values()) {
			System.out.println((g.ordinal() + 1) + "- " + g);
		}
		
		System.out.print("Selecione su Genero: ");
		int opcionGenero = scanner.nextInt();
		   Genero generoSeleccionado = Genero.values()[opcionGenero - 1];

		    cliente.setGenero(generoSeleccionado.name());
		    
		return cliente;
    }
}  
