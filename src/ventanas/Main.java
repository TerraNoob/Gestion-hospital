package ventanas;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import modelo.Hospital;
import modelo.*;
import java.util.Scanner;
import excepciones.*;

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
			 	scanner.nextLine();

	            switch (opcion) {
	                case 1:
	                    System.out.println("Ingresando por consola");
	                    menuConsola(hospital, scanner);
	                    break;

	                case 2:
	                    System.out.println("Ingresando por ventanas");
	                    new VentanaMenuPrincipal(hospital);
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
					scanner.nextLine();
	    	    	
	    	    	
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
	    	    	System.out.println("5. Modificar Area");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
					scanner.nextLine();
	    	    	
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
	                case 5:
	                    System.out.println("Modificar Area");
	                    modificarArea(hospital, scanner);
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
	    	    	System.out.println("5. Modificar Camaa");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
					scanner.nextLine();
	    	    	
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
	                case 5:
	                    System.out.println("Modificar Cama");
	                    modificarCama(hospital, scanner);
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
	    	    	System.out.println("5. Modificar Paciente");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
					scanner.nextLine();
	    	    	
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
	                
	                case 5:
	                    System.out.println("Modificar Paciente");
	                    modificarPaciente(hospital, scanner);
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
	    	    	System.out.println("3. Asignar Cama A Paciente");
	    	    	System.out.println("0. Salir");
	    	    	System.out.print("Seleccione una opción: ");
	    	    	opcion = scanner.nextInt();
					scanner.nextLine();
	    	    	
	    	    	switch (opcion) {
	                case 1:
	                    System.out.println("Listando Camas Disponibles");
	                    listarCamasDisponibles(hospital);
	                    break;
	                case 2:
	                    System.out.println("Listando pacientes sin asignar");
	                    listarPacientesSinAsignar(hospital, scanner);
	                    break;
	                case 3:
	                    System.out.println("Asignando Cama");
	                    asignarCama(hospital, scanner);
	                    break;
	                case 0:
	                	System.out.println("Saliendo");
	                	break;
	          
	                    
	                default:
	                    System.out.println("Opcion no valida");
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
       }
       
       public static void eliminarArea(Hospital hospital, Scanner scanner){
    	   System.out.println("===== ELIMINAR ÁREA =====");
    	   
    	   System.out.print("Código del área: ");
    	   int codigo = scanner.nextInt();
    	   scanner.nextLine(); 
    	   
    	   try{
			   hospital.eliminarArea(codigo);
    		   System.out.println("Área eliminada correctamente");
    	   }catch(ExcepcionAreaNoExistente e){
    		   System.out.println(e.getMessage());
    	   }
       }
       
       public static void listarAreas(Hospital hospital) {

    	    ArrayList<Area> areas = hospital.listarAreas();

    	    if (areas.isEmpty()) {
    	        System.out.println("No hay áreas registradas");
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
       
       public static void buscarArea(Hospital hospital, Scanner scanner) {
    		System.out.println("===== BUSCAR AREA =====");
    		System.out.println("1. Buscar por Codigo");
    		System.out.println("2. Buscar por Nombre");
    		System.out.print("Seleccione una opcion: ");
    		int tipo = scanner.nextInt();
    		scanner.nextLine();

			try {
				if (tipo == 1) {
					System.out.print("Codigo del area: ");
					int codigo = scanner.nextInt();
					scanner.nextLine();

					Area temp = hospital.buscarArea(codigo);

					System.out.println("Codigo: " + temp.getCodigo());
					System.out.println("Nombre: " + temp.getNombre());
					System.out.println("Capacidad maxima: " + temp.getCapacidadMaxima());
					System.out.println("Cantidad de camas actuales: " + temp.getCamas().size());
					System.out.println("¿Desea ver la lista de camas?");
					System.out.println("1. Si");
					System.out.println("2. No");
					System.out.print("Opcion: ");
					int opcionVerCamas = scanner.nextInt();
					scanner.nextLine();

					if (opcionVerCamas == 1) {
						for (int i = 0; i < temp.getCamas().size(); i++) {
							Cama c = temp.getCamas().get(i);
							System.out.println("ID: " + c.getIdCama());
							System.out.println("Disponibilidad: " + c.getDisponibilidad());
							System.out.println("Categoría: " + c.getCategoriaCama());

							if (c.getPacienteActual() != null) {
								Paciente p = c.getPacienteActual();
								System.out.println("Paciente: " + p.getNombre() + " (RUT: " + p.getRut() + ")");
							} else {
								System.out.println("Paciente: Cama vacía");
							}
							System.out.println("----------------------");
						}
					}

				}else if (tipo == 2){
					System.out.print("Nombre del area: ");
					String nombre = scanner.nextLine();

					// Llama a buscarArea(String)
					ArrayList<Area> encontradas = hospital.buscarArea(nombre);

					for (int j = 0; j < encontradas.size(); j++) {
						Area temp = encontradas.get(j);

						System.out.println("===== AREA ENCONTRADA =====");
						System.out.println("Codigo: " + temp.getCodigo());
						System.out.println("Nombre: " + temp.getNombre());
						System.out.println("Capacidad maxima: " + temp.getCapacidadMaxima());
						System.out.println("Cantidad de camas actuales: " + temp.getCamas().size());
						System.out.println("¿Desea ver la lista de camas?");
						System.out.println("1. Si");
						System.out.println("2. No");
						System.out.print("Opcion: ");
						int opcionVerCamas = scanner.nextInt();
						scanner.nextLine();

						if (opcionVerCamas == 1) {
							for (int i = 0; i < temp.getCamas().size(); i++) {
								Cama c = temp.getCamas().get(i);
								System.out.println("ID: " + c.getIdCama());
								System.out.println("Disponibilidad: " + c.getDisponibilidad());
								System.out.println("Categoria: " + c.getCategoriaCama());

								if (c.getPacienteActual() != null) {
									Paciente p = c.getPacienteActual();
									System.out.println("Paciente: " + p.getNombre() + " (RUT: " + p.getRut() + ")");
								} else {
									System.out.println("Paciente: Cama vacia");
								}
								System.out.println("----------------------");
							}
						}
					}

				}else{
					System.out.println("Opcion no valida.");
				}

			}catch(ExcepcionAreaNoExistente e){
				System.out.println(e.getMessage());
			}
		}
       
       public static void modificarArea(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== MODIFICAR ÁREA =====");

    	    System.out.print("Código del área: ");
    	    int codigo = scanner.nextInt();
    	    scanner.nextLine();

    	    try {
    	        Area temp = hospital.buscarArea(codigo);

    	        System.out.println("Área encontrada:");
    	        System.out.println("Nombre actual: " + temp.getNombre());
    	        System.out.println("Capacidad actual: " + temp.getCapacidadMaxima());

    	        System.out.println("¿Qué desea modificar?");
    	        System.out.println("1. Nombre");
    	        System.out.println("2. Capacidad máxima");
    	        System.out.println("0. Salir");

    	        int opcion = scanner.nextInt();
    	        scanner.nextLine();

    	        if (opcion == 1) {

    	            System.out.print("Ingrese el nuevo nombre: ");
    	            String nuevoNombre = scanner.nextLine();

    	            temp.setNombre(nuevoNombre);

    	            System.out.println("Nombre modificado correctamente");

    	        } else if (opcion == 2) {

    	            System.out.print("Ingrese la nueva capacidad máxima: ");
    	            int nuevaCapacidad = scanner.nextInt();
    	            scanner.nextLine();

    	            temp.setCapacidadMaxima(nuevaCapacidad);

    	            System.out.println("Capacidad modificada correctamente");
    	        }

    	    } catch (ExcepcionAreaNoExistente e) {
    	        System.out.println(e.getMessage());
    	    }
    	}
       
       
       //FUNCIONES CAMAS
       public static void agregarCama(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== AGREGAR CAMA =====");

    	    System.out.print("Código del área para añadir la cama: ");
    	    int codigo = scanner.nextInt();
    	    scanner.nextLine();

    	    try{
				Area temp = hospital.buscarArea(codigo);

    	        System.out.print("ID de la cama: ");
    	        int idCama = scanner.nextInt();
    	        scanner.nextLine();

    	        System.out.print("Categoría de la cama: ");
    	        String categoria = scanner.nextLine();

    	        Cama nuevaCama = new Cama(idCama, categoria);

    	        if (temp.agregarCama(nuevaCama)) {
    	            System.out.println("Cama agregada correctamente");
    	        } else {
    	            System.out.println("No se pudo agregar la cama");
    	        }

    	    } catch(ExcepcionAreaNoExistente e){
    	        System.out.println(e.getMessage());
    	    }
    	}
       
       public static void eliminarCama(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== ELIMINAR CAMA =====");
    	    System.out.print("ID de la cama: ");

    	    int idCama = scanner.nextInt();
		    scanner.nextLine();

    	    ArrayList<Area> areas = hospital.listarAreas();

    	    for (int i = 0; i < areas.size(); i++) {

    	        Area area = areas.get(i);

    	        Cama cama = area.buscarCama(idCama);

    	        if (cama != null) {

    	            if (area.eliminarCama(idCama)) {
    	                System.out.println("Cama eliminada correctamente");
    	            } else {
    	                System.out.println("No se puede eliminar una cama ocupada");
    	            }

    	            return;
    	        }
    	    }
    	    System.out.println("No existe una cama con ese ID");
       }
       
       public static void listarCamas(Hospital hospital, Scanner scanner){
    	   
   		    System.out.println("===== LISTAR CAMAS =====");

   		    System.out.print("Código del área: ");
   		    int codigo = scanner.nextInt();
   		    
   		    try{
				Area area = hospital.buscarArea(codigo);

   		    	if (area.getCamas().isEmpty()) {
   		    		System.out.println("Esta área no tiene camas registradas");
   		    		return;
    		    }

   		    	for (int i = 0; i < area.getCamas().size(); i++) {

   		    		Cama cama = area.getCamas().get(i);

   		    		System.out.println("ID: " + cama.getIdCama());
   		    		System.out.println("Categoría: " + cama.getCategoriaCama());
   		    		System.out.println("Disponibilidad: " + cama.getDisponibilidad());
   		    		System.out.println("----------------------");
    		    }

    		}catch(ExcepcionAreaNoExistente e){
    			System.out.println(e.getMessage());
    		}
       }
   
	  public static void buscarCama(Hospital hospital, Scanner scanner) {
			System.out.println("===== BUSCAR CAMA =====");
			System.out.println("1. Buscar por ID de cama (int)");
			System.out.println("2. Buscar por RUT de paciente internado (String)");
			System.out.print("Seleccione una opcion: ");
			int tipo = scanner.nextInt();
			scanner.nextLine();

			ArrayList<Area> areas = hospital.listarAreas();
			Cama temp = null;
			Area areaEncontrada = null;

			if (tipo == 1) {
				System.out.print("ID de la cama: ");
				int idCama = scanner.nextInt();
				scanner.nextLine();

				// SIA-5: Uso de sobrecarga buscarCama(int)
				for (int i = 0; i < areas.size(); i++) {
					Area area = areas.get(i);
					temp = area.buscarCama(idCama);
					if (temp != null) {
						areaEncontrada = area;
						break;
					}
				}

			} else if (tipo == 2) {
				System.out.print("RUT del paciente internado: ");
				String rut = scanner.nextLine();

				// SIA-5: Uso de sobrecarga buscarCama(String)
				for (int i = 0; i < areas.size(); i++) {
					Area area = areas.get(i);
					temp = area.buscarCama(rut);
					if (temp != null) {
						areaEncontrada = area;
						break;
					}
				}

			} else {
				System.out.println("Opcion no valida.");
				return;
			}

			if (temp != null) {
				System.out.println("===== CAMA ENCONTRADA =====");
				System.out.println("ID: " + temp.getIdCama());
				System.out.println("Categoria: " + temp.getCategoriaCama());
				System.out.println("Area a la que pertenece: " + areaEncontrada.getNombre());

				if (temp.isOcupada()) {
					System.out.println("Estado: Ocupada");
				} else {
					System.out.println("Estado: Disponible");
				}

				if (temp.getPacienteActual() != null) {
					Paciente p = temp.getPacienteActual();
					System.out.println("Paciente: " + p.getNombre() + " (RUT: " + p.getRut() + ")");
					System.out.println("Gravedad: " + p.getGravedad());
				} else {
					System.out.println("Paciente: sin paciente");
				}
			} else {
				System.out.println("No se encontro ninguna cama");
			}
	    }
       
       
       public static void modificarCama(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== MODIFICAR CAMA =====");

    	    System.out.print("ID de la cama: ");
    	    int idCama = scanner.nextInt();
    	    scanner.nextLine();

    	    ArrayList<Area> areas = hospital.listarAreas();

    	    for (int i = 0; i < areas.size(); i++) {

    	        Area area = areas.get(i);

    	        Cama temp = area.buscarCama(idCama);

    	        if (temp != null) {

    	            System.out.println("Cama encontrada");
    	            System.out.println("Categoría actual: " + temp.getCategoriaCama());

    	            System.out.print("Nueva categoría: ");
    	            String nuevaCategoria = scanner.nextLine();

    	            temp.setCategoriaCama(nuevaCategoria);

    	            System.out.println("Categoría modificada correctamente");

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

		   Paciente nuevoPaciente;
		   if (edad < 18){
        		System.out.print("Nombre del apoderado: ");
        		String apoderado = scanner.nextLine();
        		System.out.print("RUT del apoderado: ");
        		String rutApoderado = scanner.nextLine();

       		 	nuevoPaciente = new Nino(nombre, rut, edad, null, apoderado, rutApoderado);
        		nuevoPaciente.setSignos(signos);
		  	}else{
			   System.out.print("Sistema de previsión (FONASA/ISAPRE): ");
        	   String prevision = scanner.nextLine();
        	   nuevoPaciente = new Adulto(nombre, rut, edad, signos, null, prevision);
			}
		   if (hospital.agregarPacienteSinAsignar(nuevoPaciente)){
    	        System.out.println("Paciente agregado correctamente");
    	        System.out.println("Gravedad calculada: " + nuevoPaciente.getGravedad());
    	    } else{
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
				System.out.println("Tipo de atención: " + paciente.obtenerTipoAtencion());
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
						System.out.println("Tipo de atención: " + paciente.obtenerTipoAtencion());
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

    	    try {
    	        Paciente paciente = hospital.buscarPaciente(rutBuscar);

    	        System.out.println("===== DATOS DEL PACIENTE =====");
    	        System.out.println("Nombre: " + paciente.getNombre());
    	        System.out.println("RUT: " + paciente.getRut());
    	        System.out.println("Edad: " + paciente.getEdad());
    	        System.out.println("Gravedad: " + paciente.getGravedad());

    	        if (paciente.getCamaActual() != null) {
    	            System.out.println("Estado: En cama " + paciente.getCamaActual().getIdCama());
    	        } else {
    	            System.out.println("Estado: Sin cama asignada");
    	        }

    	        if (paciente.getSignos() != null) {
    	            System.out.println("--- Signos Vitales ---");
    	            System.out.println("Frecuencia cardiaca: " + paciente.getSignos().getFrecuenciaCardiaca()  );
    	            System.out.println("Presion Arterial: " + paciente.getSignos().getPresionArterial() );
    	            System.out.println("Saturacion oxigeno: " + paciente.getSignos().getSaturacion() );
    	            System.out.println("Temperatura: " + paciente.getSignos().getTemperatura() + " °C");
    	        }

    	        System.out.println("------------------------------------");

    	    } catch (ExcepcionPacienteNoEncontrado e) {
    	        System.out.println(e.getMessage());
    	    }
    	}
       
       public static void modificarPaciente(Hospital hospital, Scanner scanner) {

    	    System.out.println("===== MODIFICAR PACIENTE =====");
    	    System.out.print("RUT del paciente: ");

    	    String rutBuscar = scanner.nextLine();

    	    try {
    	        Paciente paciente = hospital.buscarPaciente(rutBuscar);

    	        System.out.println("Paciente encontrado:");
    	        System.out.println("Nombre: " + paciente.getNombre());
    	        System.out.println("RUT: " + paciente.getRut());
    	        System.out.println("Edad: " + paciente.getEdad());

    	        System.out.println("¿Qué desea modificar?");
    	        System.out.println("1. Nombre");
    	        System.out.println("2. Edad");
    	        System.out.println("3. Signos vitales");
    	        System.out.println("0. Salir");
    	        System.out.print("Seleccione una opción: ");

    	        int opcion = scanner.nextInt();
    	        scanner.nextLine();

    	        if (opcion == 1) {

    	            System.out.print("Nuevo nombre: ");
    	            String nuevoNombre = scanner.nextLine();

    	            paciente.setNombre(nuevoNombre);

    	            System.out.println("Nombre modificado correctamente");

    	        } else if (opcion == 2) {

    	            System.out.print("Nueva edad: ");
    	            int nuevaEdad = scanner.nextInt();
    	            scanner.nextLine();

    	            paciente.setEdad(nuevaEdad);

    	            System.out.println("Edad modificada correctamente");

    	        } else if (opcion == 3) {

    	            System.out.print("Nueva frecuencia cardíaca: ");
    	            int fc = scanner.nextInt();

    	            System.out.print("Nueva presión arterial: ");
    	            double pa = scanner.nextDouble();

    	            System.out.print("Nueva saturación: ");
    	            int sat = scanner.nextInt();

    	            System.out.print("Nueva temperatura: ");
    	            double temp = scanner.nextDouble();
    	            scanner.nextLine();

    	            SignosVitales nuevosSignos =
    	                    new SignosVitales(fc, pa, sat, temp);

    	            paciente.setSignos(nuevosSignos);

    	            System.out.println("Signos vitales modificados correctamente");
    	            System.out.println("Nuevo indicador de gravedad: "
    	                    + paciente.getGravedad());
    	        }

    	    } catch (ExcepcionPacienteNoEncontrado e) {
    	        System.out.println(e.getMessage());
    	    }
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
       
      public static void listarPacientesSinAsignar(Hospital hospital, Scanner scanner){

		  if (hospital.getPacientesSinAsignar().isEmpty()){
			  System.out.println("No hay pacientes en espera");
			  return;
		  } 
		
		  System.out.println("===== PACIENTES EN LISTA DE ESPERA =====");
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
