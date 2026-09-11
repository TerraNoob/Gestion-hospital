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
		 Hospital hospital = new Hospital("Hospital SIA", "Valparaíso");
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
	                    menuConsola(hospital, scanner);
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
       public static void menuConsola(Hospital hospital, Scanner scanner){
    	   
    	   int opcion;
	    	    do {
	    	    	System.out.println("========== MENÚ ==========");
	    	    	System.out.println("1. Gestionar Áreas");
	    	    	System.out.println("2. Gestionar Camas");
					System.out.println("3. Gestionar Pacientes");
	    	    	System.out.println("4. Funciones especiales");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
	    	    	
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Ingresando a menú áreas");
	                    menuAreas(hospital, scanner);
	                    break;

	                case 2:
	                    System.out.println("Ingresando a menú camas");
	                    menuCamas(hospital, scanner);
	                    break;
	                    
	                case 3:
	                    System.out.println("Ingresando a menú pacientes");
	                    menuPacientes(hospital, scanner);
	                    break;
	                    
	                case 4:
	                    System.out.println("Ingresando a funciones especiales");
	                    menuFuncionesEspeciales(hospital, scanner);
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
       public static void menuAreas(Hospital hospital, Scanner scanner){
    	   
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
       public static void menuCamas(Hospital hospital, Scanner scanner){
    	   
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
	                    agregarCama(hospital, scanner);
	                    break;

	                case 2:
	                    System.out.println("Eliminar Cama");
	                    eliminarCama(hospital, scanner);
	                    break;

	                case 3:
	                    System.out.println("Listar Cama");
	                    listarCamas(hospital, scanner);
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Cama");
	                    buscarCama(hospital, scanner);
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
       public static void menuPacientes(Hospital hospital, Scanner scanner){
    	   
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
	                    agregarPaciente(hospital, scanner);
	                    break;

	                case 2:
	                    System.out.println("Eliminar Paciente");
	                    eliminarPaciente(hospital, scanner);
	                    break;

	                case 3:
	                    System.out.println("Listar Paciente");
	                    listarPacientes(hospital);
	                    break;
	                    
	                case 4:
	                    System.out.println("Buscar Paciente");
	                    buscarPaciente(hospital, scanner);
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
       public static void menuFuncionesEspeciales(Hospital hospital, Scanner scanner){
    	   
    	   int opcion;
	    	    do {
	    	    	System.out.println("========== MENÚ ==========");
	    	    	System.out.println("1. Listar Camas Disponibles");
	    	    	System.out.println("2. Listar Pacientes Sin Asignar");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
	    	    	
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Listando Camas Disponibles");
	                    listarCamasDisponibles(hospital);
	                    break;
	                case 2:
	                    System.out.println("Listando Camas Disponibles");
	                    listarPacientesSinAsignar(hospital, scanner);
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
       
       public static void buscarArea(Hospital hospital, Scanner scanner){
    	   Area temp;
    	   System.out.println("===== BUSCAR ÁREA =====");

    	   System.out.print("Código del área: ");
    	   int codigo = scanner.nextInt();
    	   scanner.nextLine(); 
    	   
    	   temp = hospital.buscarArea(codigo);
    	   
    	   if (temp != null) {
    		   System.out.println("Código:" + temp.getCodigo());
    		   System.out.println("Nombre:" + temp.getNombre());
    		   System.out.println("Capacidad máxima:" + temp.getCapacidadMaxima());
    		   System.out.println("Cantidad de camas actuales:" + temp.getCamas().size());
    		   System.out.println("Desea ver la lista de camas?");
    		   System.out.println("1. Si");
    		   System.out.println("2. No");
    		   
    		   int opcion = scanner.nextInt();

    		   if (opcion == 1) {
    			   
    			   for (int i = 0; i < temp.getCamas().size();i++) {
    				   System.out.println("ID:" + temp.getCamas().get(i).getIdCama());
    				   System.out.println("Disponibilidad:" + temp.getCamas().get(i).getDisponibilidad());
    				   System.out.println("Categoría:" + temp.getCamas().get(i).getCategoriaCama());
    				   if (temp.getCamas().get(i).getPacienteActual() != null) {
    					   System.out.println("Paciente:" + temp.getCamas().get(i).getPacienteActual());
    				   } else {
    					   System.out.println("Cama vacía");
    				   }
    			   }
    		   } 
    		   scanner.nextLine();

    		   System.out.println("Modificar datos de área?");
    		   System.out.println("1. Nombre");
    		   System.out.println("2. Capacidad máxima");
    		   System.out.println("0. Salir");

    		   int opcionModificar = scanner.nextInt();
    		   scanner.nextLine();

    		   if (opcionModificar == 1) {

    		       System.out.print("Ingrese el nuevo nombre: ");
    		       String nuevoNombre = scanner.nextLine();

    		       temp.setNombre(nuevoNombre);

    		       System.out.println("Nombre modificado correctamente.");

    		   } else if (opcionModificar == 2) {

    		       System.out.print("Ingrese la nueva capacidad máxima: ");
    		       int nuevaCapacidad = scanner.nextInt();

    		       temp.setCapacidadMaxima(nuevaCapacidad);

    		       System.out.println("Capacidad modificada correctamente.");
    		   }
        	   
    	   } else {
    		   System.out.println("No existe área de código" + codigo);
    	   }
       }
       
       
       //FUNCIONES CAMAS
       public static void agregarCama(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== AGREGAR CAMA =====");

    	    System.out.print("Código del área para añadir la cama: ");
    	    int codigo = scanner.nextInt();
    	    scanner.nextLine();

    	    Area temp = hospital.buscarArea(codigo);

    	    if (temp != null) {

    	        System.out.print("ID de la cama: ");
    	        int idCama = scanner.nextInt();
    	        scanner.nextLine();

    	        System.out.print("Categoría de la cama: ");
    	        String categoria = scanner.nextLine();

    	        Cama nuevaCama = new Cama(idCama, categoria);

    	        if (temp.agregarCama(nuevaCama)) {
    	            System.out.println("Cama agregada correctamente.");
    	        } else {
    	            System.out.println("No se pudo agregar la cama.");
    	        }

    	    } else {
    	        System.out.println("No existe un área con código " + codigo);
    	    }
    	}
       
       public static void eliminarCama(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== ELIMINAR CAMA =====");
    	    System.out.print("ID de la cama: ");

    	    int idCama = scanner.nextInt();

    	    ArrayList<Area> areas = hospital.listarAreas();

    	    for (int i = 0; i < areas.size(); i++) {

    	        Area area = areas.get(i);

    	        Cama cama = area.buscarCama(idCama);

    	        if (cama != null) {

    	            if (area.eliminarCama(idCama)) {
    	                System.out.println("Cama eliminada correctamente.");
    	            } else {
    	                System.out.println("No se puede eliminar una cama ocupada.");
    	            }

    	            return;
    	        }
    	    }

    	    System.out.println("No existe una cama con ese ID.");

    	    System.out.println("No existe una cama con ese ID.");
       }
       
       public static void listarCamas(Hospital hospital, Scanner scanner){
    	   
   		    System.out.println("===== LISTAR CAMAS =====");

   		    System.out.print("Código del área: ");
   		    int codigo = scanner.nextInt();

   		    Area area = hospital.buscarArea(codigo);
   		    
   		    if (area != null) {

   		    	if (area.getCamas().isEmpty()) {
   		    		System.out.println("Esta área no tiene camas registradas.");
   		    		return;
    		    }

   		    	for (int i = 0; i < area.getCamas().size(); i++) {

   		    		Cama cama = area.getCamas().get(i);

   		    		System.out.println("ID: " + cama.getIdCama());
   		    		System.out.println("Categoría: " + cama.getCategoriaCama());
   		    		System.out.println("Disponibilidad: " + cama.getDisponibilidad());
   		    		System.out.println("----------------------");
    		    }

    		} else {
    			System.out.println("No existe un área con código " + codigo);
    		}
       }
   
       
       public static void buscarCama(Hospital hospital, Scanner scanner){
    	   


   		    System.out.println("===== BUSCAR CAMA =====");

   		    System.out.print("ID de la cama: ");
   		    int idCama = scanner.nextInt();
   		    scanner.nextLine();

    		ArrayList<Area> areas = hospital.listarAreas();

    		for (int i = 0; i < areas.size(); i++) {

    			Area area = areas.get(i);

    			Cama temp = area.buscarCama(idCama);

    			if (temp != null) {

    				System.out.println("ID: " + temp.getIdCama());
    				System.out.println("Categoría: " + temp.getCategoriaCama());
    				System.out.println("Disponibilidad: " + temp.getDisponibilidad());

    				System.out.println("¿Modificar datos de la cama?");
    				System.out.println("1. Categoría");

    				System.out.println("0. Salir");

    				int opcion = scanner.nextInt();
    				scanner.nextLine();

    				if (opcion == 1) {

    					System.out.print("Nueva categoría: ");
    					String nuevaCategoria = scanner.nextLine();

    					temp.setCategoriaCama(nuevaCategoria);

    		        } 

    		       	return;
    		    }
    	    }
    		System.out.println("No existe una cama con ID " + idCama);
    		
       }
       
       
       //FUNCIONES PACIENTES
       public static void agregarPaciente(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== AGREGAR PACIENTE =====");

    	    System.out.print("Nombre: ");
    	    String nombre = scanner.nextLine();

    	    System.out.print("RUT: ");
    	    String rut = scanner.nextLine();

    	    System.out.print("Edad: ");
    	    int edad = scanner.nextInt();
    	    scanner.nextLine();

    	    System.out.println("===== SIGNOS VITALES =====");

    	    System.out.print("Frecuencia cardíaca: ");
    	    int frecuenciaCardiaca = scanner.nextInt();

    	    System.out.print("Presión arterial: ");
    	    double presionArterial = scanner.nextDouble();

    	    System.out.print("Saturación: ");
    	    int saturacion = scanner.nextInt();

    	    System.out.print("Temperatura: ");
    	    double temperatura = scanner.nextDouble();
    	    scanner.nextLine();

    	    SignosVitales signos = new SignosVitales(
    	        frecuenciaCardiaca,
    	        presionArterial,
    	        saturacion,
    	        temperatura
    	    );

    	    Paciente nuevoPaciente = new Paciente(
    	        nombre,
    	        rut,
    	        edad,
    	        signos,
    	        null
    	    );

    	    if (hospital.agregarPacienteSinAsignar(nuevoPaciente)) {
    	        System.out.println("Paciente agregado correctamente");
    	        System.out.println("Gravedad calculada: " + nuevoPaciente.getGravedad());
    	    } else {
    	        System.out.println("No se pudo agregar el paciente");
    	    }
    	}
       
       public static void eliminarPaciente(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== ELIMINAR PACIENTE =====");
    	    System.out.print("RUT del paciente: ");

    	    String rutBuscar = scanner.nextLine();

    	    // Pacientes sin asignar
    	    for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {

    	        Paciente paciente = hospital.getPacientesSinAsignar().get(i);

    	        if (rutBuscar.equals(paciente.getRut())) {
    	            hospital.getPacientesSinAsignar().remove(i);

    	            System.out.println("Paciente eliminado correctamente.");
    	            return;
    	        }
    	    }

    	    // Pacientes en camas
    	    ArrayList<Area> areas = hospital.listarAreas();

    	    for (int i = 0; i < areas.size(); i++) {

    	        Area area = areas.get(i);

    	        for (int j = 0; j < area.getCamas().size(); j++) {

    	            Cama cama = area.getCamas().get(j);

    	            if (cama.getPacienteActual() != null &&
    	                rutBuscar.equals(cama.getPacienteActual().getRut())) {

    	                cama.desocuparCama();

    	                System.out.println("Paciente eliminado correctamente");
    	                return;
    	            }
    	        }
    	    }

    	    System.out.println("No existe un paciente con rut " + rutBuscar);
    	}
       
       
       public static void listarPacientes(Hospital hospital) {

    	    System.out.println("===== LISTA DE PACIENTES =====");

    	    boolean hayPacientes = false;

    	    // Pacientes sin asignar
    	    for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {

    	        Paciente paciente = hospital.getPacientesSinAsignar().get(i);

    	        System.out.println("Nombre: " + paciente.getNombre());
    	        System.out.println("Rut: " + paciente.getRut());
    	        System.out.println("Edad: " + paciente.getEdad());
    	        System.out.println("Gravedad: " + paciente.getGravedad());
    	        System.out.println("Estado: Sin cama");
    	        System.out.println("-------------------------");

    	        hayPacientes = true;
    	    }

    	    // Pacientes asignados
    	    ArrayList<Area> areas = hospital.listarAreas();

    	    for (int i = 0; i < areas.size(); i++) {

    	        Area area = areas.get(i);

    	        for (int j = 0; j < area.getCamas().size(); j++) {

    	            Cama cama = area.getCamas().get(j);

    	            if (cama.getPacienteActual() != null) {

    	                Paciente paciente = cama.getPacienteActual();

    	                System.out.println("Nombre: " + paciente.getNombre());
    	                System.out.println("RUT: " + paciente.getRut());
    	                System.out.println("Edad: " + paciente.getEdad());
    	                System.out.println("Gravedad: " + paciente.getGravedad());
    	                System.out.println("Estado: En cama " + cama.getIdCama());
    	                System.out.println("Área: " + area.getNombre());
    	                System.out.println("-------------------------");

    	                hayPacientes = true;
    	            }
    	        }
    	    }

    	    if (!hayPacientes) {
    	        System.out.println("No hay pacientes registrados.");
    	    }
    	}
       
       public static void buscarPaciente(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== BUSCAR PACIENTE =====");
    	    System.out.print("RUT del paciente: ");
    	    String rutBuscar = scanner.nextLine();

    	    // Pacientes sin asignar
    	    for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {

    	        Paciente paciente = hospital.getPacientesSinAsignar().get(i);

    	        if (rutBuscar.equals(paciente.getRut())) {

    	        	System.out.println("===== DATOS DEL PACIENTE =====");
    	            System.out.println("Nombre: " + paciente.getNombre());
    	            System.out.println("RUT: " + paciente.getRut());
    	            System.out.println("Edad: " + paciente.getEdad());
    	            System.out.println("Gravedad: " + paciente.getGravedad());

    	            System.out.println("Estado: Sin cama asignada");
    	            return;
    	        }
    	    }

    	    // Pacientes asignados
    	    ArrayList<Area> areas = hospital.listarAreas();

    	    for (int i = 0; i < areas.size(); i++) {

    	        Area area = areas.get(i);

    	        for (int j = 0; j < area.getCamas().size(); j++) {

    	            Cama cama = area.getCamas().get(j);

    	            if (cama.getPacienteActual() != null &&
    	                rutBuscar.equals(cama.getPacienteActual().getRut())) {

    	                Paciente paciente = cama.getPacienteActual();

    	                System.out.println("===== DATOS DEL PACIENTE =====");
    	                System.out.println("Nombre: " + paciente.getNombre());
    	                System.out.println("RUT: " + paciente.getRut());
    	                System.out.println("Edad: " + paciente.getEdad());
    	                System.out.println("Gravedad: " + paciente.getGravedad());

    	                System.out.println("Estado: En cama");
    	                System.out.println("Cama: " + cama.getIdCama());
    	                System.out.println("Área: " + area.getNombre());

    	                return;
    	            }
    	        }
    	    }

    	    System.out.println("No existe un paciente con RUT " + rutBuscar);
    	}
       
       //FUNCIONES ESPECIALES
       public static void listarCamasDisponibles(Hospital hospital) {

    	    System.out.println("===== CAMAS DISPONIBLES =====");

    	    ArrayList<Area> areas = hospital.listarAreas();
    	    boolean hayDisponibles = false;

    	    for (int i = 0; i < areas.size(); i++) {

    	        Area area = areas.get(i);

    	        for (int j = 0; j < area.getCamas().size(); j++) {

    	            Cama cama = area.getCamas().get(j);

    	            if (cama.getDisponibilidad() == 1) {

    	                System.out.println("ID: " + cama.getIdCama());
    	                System.out.println("Categoría: " + cama.getCategoriaCama());
    	                System.out.println("Área: " + area.getNombre());
    	                System.out.println("----------------------");

    	                hayDisponibles = true;
    	            }
    	        }
    	    }

    	    if (!hayDisponibles) {
    	        System.out.println("No hay camas disponibles.");
    	    }
    	}
       
       public static void asignarCama(Hospital hospital, Scanner scanner) {

    	   //Eliges paciente
    	   System.out.println("===== ASIGNAR CAMA =====");
    	   System.out.print("RUT del paciente: ");
    	   String rut = scanner.nextLine();

    	   Paciente paciente = null;

    	    
    	   for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {

    	       Paciente temp = hospital.getPacientesSinAsignar().get(i);

    	       if (rut.equals(temp.getRut())) {
    	           paciente = temp;
    	           break;
    	       }
    	   }

    	   if (paciente == null) {
    	       System.out.println("No existe un paciente sin asignar con ese RUT.");
    	       return;
    	   }

    	   //Eliges cama
    	   listarCamasDisponibles(hospital);

    	   System.out.print("ID de la cama: ");
    	   int idCama = scanner.nextInt();
    	   scanner.nextLine();

    	   ArrayList<Area> areas = hospital.listarAreas();

    	   for (int i = 0; i < areas.size(); i++) {

    	       Area area = areas.get(i);
    	       Cama cama = area.buscarCama(idCama);

    	       if (cama != null) {

    	           if (cama.getDisponibilidad() != 1) {
    	               System.out.println("La cama no está disponible.");
    	               return;
    	           }

    	           cama.ocuparCama(paciente);
    	           paciente.setCamaActual(cama);

    	           hospital.getPacientesSinAsignar().remove(paciente);

    	           System.out.println("Paciente asignado correctamente.");
    	           return;
    	       }
    	   }

    	   System.out.println("No existe una cama con ese ID.");
      }
       
      public static void listarPacientesSinAsignar(Hospital hospital, Scanner scanner) {
    	  for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {

    		 Paciente paciente = hospital.getPacientesSinAsignar().get(i);

    		 System.out.println("Nombre: " + paciente.getNombre());
    		 System.out.println("RUT: " + paciente.getRut());
    		 System.out.println("Edad: " + paciente.getEdad());
    		 System.out.println("Tipo: " + paciente.obtenerTipoAtencion());

    		     System.out.println("----------------------");
    		} 
       }
}
