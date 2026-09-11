package interfaz;


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
	                    menuAreas();
	                    break;

	                case 2:
	                    System.out.println("Eliminar Area");
	                    menuCamas();
	                    break;

	                case 3:
	                    System.out.println("Listar Area");
	                    menuFuncionesEspeciales();
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Area");
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
	                    menuAreas();
	                    break;

	                case 2:
	                    System.out.println("Eliminar Cama");
	                    menuCamas();
	                    break;

	                case 3:
	                    System.out.println("Listar Cama");
	                    menuFuncionesEspeciales();
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Cama");
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
	                    menuAreas();
	                    break;

	                case 2:
	                    System.out.println("Eliminar Paciente");
	                    menuCamas();
	                    break;

	                case 3:
	                    System.out.println("Listar Paciente");
	                    menuFuncionesEspeciales();
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Paciente");
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
	                    menuAreas();
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
       
       
}
