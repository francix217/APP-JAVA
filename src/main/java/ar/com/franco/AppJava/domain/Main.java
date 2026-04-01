package ar.com.franco.AppJava.domain;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.com.franco.AppJava.emuns.Genero;
import ar.com.franco.AppJava.emuns.Login;

@SpringBootApplication


public class Main {

	public static void main(String[] args) {
		System.out.println("--Bienvenido a GymTech--");
		
		SpringApplication.run(Main.class, args);
		Scanner scanner = new Scanner(System.in);
			
		Genero generoGuardado = null;
		
		boolean login = false;
		ArrayList<Producto> listaProductos = new ArrayList<>();
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		
		while (!login){
			
			mostrarMenu();
			int opcion  = scanner.nextInt();
			
			if (opcion == 1){
				
				cargaProductos(scanner, listaProductos, null);
				
			}else if (opcion == 2){
				Cliente usr = registro(scanner, generoGuardado);
				listaUsuarios.add(usr);
				
			} else if (opcion == 3){
				
				inicioSesion(scanner, listaUsuarios);
				
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
    	System.out.print("Ingrese el Usuario: ");			
		String nombre = scanner.next();
		
		System.out.print("Ingresar Contraseña: ");		
		String contra = scanner.next();
		
		System.out.println(" --Genero--");		
		for (Genero g : Genero.values()) {
			System.out.println((g.ordinal() + 1) + "- " + g);
		}
		
		System.out.print("Selecione su Genero: ");
		int opcionGenero = scanner.nextInt();
		
		   Genero generoSeleccionado = Genero.values()[opcionGenero - 1];

		    
			Cliente cliente = new Cliente(nombre, contra , generoSeleccionado);
 
		return cliente;
    }
    
    private static Usuario inicioSesion(Scanner scanner, ArrayList<Usuario> listaUsuarios) {
		System.out.print("Ingrese el Usuario: ");
		String user = scanner.next();

		System.out.print("Ingresar Contraseña: ");
		String contra = scanner.next();
		
		for (Usuario usr : listaUsuarios) {
			if (usr.getUsuario().equals(user) && usr.getContrasena().equals(contra)) {
				System.out.println("Registro Completo");
				return usr;
			}
		}
		
		System.out.println("Registro Incorrecto");
    	return null;
    }
}  
