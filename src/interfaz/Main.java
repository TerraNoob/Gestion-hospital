package interfaz;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import modelo.Hospital;
import modelo.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		 Scanner scanner = new Scanner(System.in);
		 int opcion;

		//MENÚ PRINCIPAL
		 do {
	            System.out.println("========================");
	            System.out.println("       SISTEMA SIA");
	            System.out.println("========================");
	            System.out.println("1. Ingresar por consola");
	            System.out.println("2. Ingresar por ventanas");
	            System.out.println("0. Salir");
	            System.out.print("Seleccione una opcion: ");

	            opcion = scanner.nextInt();

	            switch (opcion) {
	                case 1:
	                    System.out.println("Ingresando por consola");
	                    menuConsola();
	                    break;

	                case 2:
	                    System.out.println("Ingresando por ventanas");
	                    //menuVentanas();
	                    //Esto para cuando haya GUI
	                    break;

	                case 0:
	                    System.out.println("Saliendo del sistema");
	                    break;
	                    
	                default:
	                    System.out.println("Opcion no valida.");
	            }

	        } while (opcion != 0);

		 scanner.close();
	}  
	        
       //MENÚ CONSOLA
       public void menuConsola(Hospital hospital, Scanner scanner){
    	   
    	   int opcion;
	    	    do {
	    	    	System.out.println("========== MENÚ ==========");
	    	    	System.out.println("1. Gestionar Áreas");
	    	    	System.out.println("2. Gestionar Camas");
	    	    	System.out.println("3. Funciones especiales");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
	    	    	
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Ingresando a menú áreas");
	                    menuAreas();
	                    break;

	                case 2:
	                    System.out.println("Ingresando a menú camas");
	                    menuCamas();
	                    break;

	                case 3:
	                    System.out.println("Saliendo a funciones especiales");
	                    menuFuncionesEspeciales();
	                    break;
	                    
	                case 0:
	                	System.out.println("Saliendo");
	                	break;
	          
	                    
	                default:
	                    System.out.println("Opcion no valida.");
	    	    	}
	    	    	
	    	    } while (opcion != 0);
    	    
    	    
    	    
       }
       
       //MENÚ ÁREAS
       public void menuAreas(Hospital hospital, Scanner scanner){
    	   
    	   int opcion;
	    	    do {
	    	    	System.out.println("========== MENÚ ==========");
	    	    	System.out.println("1. Agregar Areas");
	    	    	System.out.println("2. Eliminar Areas");
	    	    	System.out.println("3. Listar Areas");
	    	    	System.out.println("4. Buscar Areas");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
	    	    	
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Agregar Area");
	                    agregarArea(hospital, scanner);
	                    break;

	                case 2:
	                    System.out.println("Eliminar Area");
	                    eliminarArea(hospital, scanner);
	                    break;

	                case 3:
	                    System.out.println("Listar Area");
	                    listarAreas(hospital);
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Area");
	                    buscarArea(hospital, scanner);
	                    break;
	                    
	                case 0:
	                	System.out.println("Saliendo");
	                	break;
	          
	                    
	                default:
	                    System.out.println("Opcion no valida.");
	    	    	}
	    	    	
	    	    } while (opcion != 0);
    	    
    	    
    	    
       }
       
       
     //MENÚ CAMAS
       public void menuCamas(Hospital hospital, Scanner scanner){
    	   
    	   int opcion;
	    	    do {
	    	    	System.out.println("========== MENÚ ==========");
	    	    	System.out.println("1. Agregar Cama");
	    	    	System.out.println("2. Eliminar Cama");
	    	    	System.out.println("3. Listar Camas");
	    	    	System.out.println("4. Buscar Camas");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
	    	    	
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Agregar Cama");
	                    agregarCama();
	                    break;

	                case 2:
	                    System.out.println("Eliminar Cama");
	                    eliminarCama();
	                    break;

	                case 3:
	                    System.out.println("Listar Cama");
	                    listarCamas();
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Cama");
	                    buscarCama();
	                    break;
	                    
	                case 0:
	                	System.out.println("Saliendo");
	                	break;
	          
	                    
	                default:
	                    System.out.println("Opcion no valida.");
	    	    	}
	    	    	
	    	    } while (opcion != 0);
    	    
    	    
    	    
       }
       
     //MENÚ PACIENTES
       public void menuPäcientes(Hospital hospital, Scanner scanner){
    	   
    	   int opcion;
	    	    do {
	    	    	System.out.println("========== MENÚ ==========");
	    	    	System.out.println("1. Agregar Paciente");
	    	    	System.out.println("2. Eliminar Paciente");
	    	    	System.out.println("3. Listar Paciente");
	    	    	System.out.println("4. Buscar Paciente");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
	    	    	
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Agregar Paciente");
	                    agregarPaciente();
	                    break;

	                case 2:
	                    System.out.println("Eliminar Paciente");
	                    eliminarPaciente();
	                    break;

	                case 3:
	                    System.out.println("Listar Paciente");
	                    listarPacientes();
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Paciente");
	                    buscarPaciente();
	                    break;
	                    
	                case 0:
	                	System.out.println("Saliendo");
	                	break;
	          
	                    
	                default:
	                    System.out.println("Opcion no valida.");
	    	    	}
	    	    	
	    	    } while (opcion != 0);
    	    
    	    
    	    
       }

       //FUNCIONES ESPECIALES
       public void menuArea(Hospital hospital, Scanner scanner){
    	   
    	   int opcion;
	    	    do {
	    	    	System.out.println("========== MENÚ ==========");
	    	    	System.out.println("1. Listar Camas Disponibles");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
	    	    	
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Listando Camas Disponibles");
	                    listarCamasDisponibles();
	                    break;

	                case 0:
	                	System.out.println("Saliendo");
	                	break;
	          
	                    
	                default:
	                    System.out.println("Opcion no valida.");
	    	    	}
	    	    	
	    	    } while (opcion != 0);
    	    
    	    
    	    
       }
       
       
       //METODOS NECESARIOS PARA FUNCIONAMIENTO MAIN
       //DENTRO DE LAS BUSQUEDAS SE PERMITIRÁN MODIFICAR 
       //ATRIBUTOS
       
       //FUNCIONES AREAS
       public static void agregarArea(Hospital hospital, Scanner scanner){
    	   System.out.println("===== AGREGAR ÁREA =====");

    	   System.out.print("Código del área: ");
    	   int codigo = scanner.nextInt();
    	   scanner.nextLine(); 

    	   System.out.print("Nombre del área: ");
    	   String nombre = scanner.nextLine();

    	   System.out.print("Capacidad máxima: ");
    	   int capacidad = scanner.nextInt();

    	   Area nuevaArea = new Area(codigo, nombre, capacidad);
    	   
    	   if (hospital.agregarArea(nuevaArea)) {
    	        System.out.println("Área agregada correctamente");
    	    } else {
    	        System.out.println("Error: ya existe un área con ese código");
    	    }

    	   System.out.println("Área agregada correctamente.");
    	
       }
       
       public static void eliminarArea(Hospital hospital, Scanner scanner){
    	   System.out.println("===== ELIMINAR ÁREA =====");
    	   
    	   System.out.print("Código del área: ");
    	   int codigo = scanner.nextInt();
    	   scanner.nextLine(); 
    	   
    	   if (hospital.eliminarArea(codigo)) {
    		   System.out.println("Área eliminada correctamente");
    	   } else {
    		   System.out.println("Error: no existe un área con ese código");
    	   }
       }
       
       public static void listarAreas(Hospital hospital) {

    	    ArrayList<Area> areas = hospital.listarAreas();

    	    if (areas.isEmpty()) {
    	        System.out.println("No hay áreas registradas.");
    	        return;
    	    }

    	    System.out.println("===== ÁREAS DEL HOSPITAL =====");

    	    for (int i = 0; i < areas.size(); i++) {
    	    	Area area = areas.get(i);
    	    	
    	        System.out.println("Código: " + area.getCodigo());
    	        System.out.println("Nombre: " + area.getNombre());
    	        System.out.println("Capacidad máxima: " + area.getCapacidadMaxima());
    	        System.out.println("------------------------------");
    	    }
    	}
       
       public void buscarArea(Hospital hospital, Scanner scanner){
    	   
       }
       
       
       //FUNCIONES CAMAS
       public void agregarCama(Hospital hospital, Scanner scanner){
    	   
       }
       
       public void eliminarCama(Hospital hospital, Scanner scanner){
    	   
       }
       
       public void listarCamas(Hospital hospital, Scanner scanner){
    	   
       }
       
       public void buscarCama(Hospital hospital, Scanner scanner){
    	   
       }
       
       //FUNCIONES PACIENTES
       public void agregarPaciente(Hospital hospital, Scanner scanner){
    	   
       }
       
       public void eliminarPaciente(Hospital hospital, Scanner scanner){
    	   
       }
       
       public void listarPacientes(Hospital hospital, Scanner scanner){
    	   
       }
       
       public void buscarPaciente(Hospital hospital, Scanner scanner){
    	   
       }
       
       //FUNCIONES ESPECIALES
       public void listarCamasDisponibles(Hospital hospital, Scanner scanner) {
    	   
       }
       
}
