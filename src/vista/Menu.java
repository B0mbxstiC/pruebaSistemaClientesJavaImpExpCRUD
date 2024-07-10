package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import servicio.ClienteServicio;
import utilidades.ArchivoServicio;
import utilidades.ExportarCsv;
import utilidades.ExportarTxt;

public class Menu {
	
	List<Cliente> listaClientes = new ArrayList();
	Scanner sc = new Scanner(System.in);
	
	private ClienteServicio clienteServicio = new ClienteServicio();
	private ExportarCsv exportarCSV = new ExportarCsv();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private String archivoClientes = "DBClientes.csv";
	private ExportarTxt exportarTxt = new ExportarTxt();
	
	
	
	public void iniciarMenu() {
		
		while(true) {
			System.out.println("Bienvenido al menú, a continuación indique una opción:");
			System.out.println("1. Listar Clientes");
	        System.out.println("2. Agregar Cliente");
	        System.out.println("3. Editar Cliente");
	        System.out.println("4. Eliminar Cliente");
	        System.out.println("5. Cargar Datos");
	        System.out.println("6. Exportar Datos");
	        System.out.println("7. Salir");
	        System.out.print("Ingrese una opción: ");
	        Integer opcion = Integer.parseInt(sc.nextLine());
	        
	     switch (opcion) {
	    		case 1:
	    			listaClientes();
	    			break;
	    			
	    		case 2:
	    			agregarCliente();
	    			break;
	    		
	    		case 3:
	    			editarCliente();
	    			break;
	    			
	    		case 4:
	    			eliminarCliente();
	    			break;
	    			
	    		case 5:
	    			cargarDatos();
	    			break;
	    			
	    		case 6:
	    			exportarDatos();
	    			break;
	    		
	    		case 7: 
	    			terminarPrograma();
	    			return;
	    		default:
	    			System.out.println("La opción ingresada no es correcta.");
	    		}
		}
		
		
		
        
	}
	
	
	//Lista de métodos utilizados más arriba.
	
	public void listaClientes() {
		clienteServicio.retornolistaClientes();
	}
	
	public void agregarCliente() {
		System.out.print("Ingresa RUN del Cliente: ");
        String run = sc.nextLine();
        System.out.print("Ingresa Nombre del Cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Ingresa Apellido del Cliente: ");
        String apellido = sc.nextLine();
        System.out.print("Ingresa años como Cliente: ");
        String anios = sc.nextLine();
        clienteServicio.agregarCliente(run, nombre, apellido, anios);
	}
	
	public void editarCliente() {
		clienteServicio.editarCliente();
	}
	
	public void eliminarCliente() {
		System.out.println("Ingrese el rut del cliente a eliminar en formato 12.345.678-9");
		String rut = sc.nextLine();
		clienteServicio.eliminarCliente(rut);
	}
	
	public void cargarDatos() {
		archivoServicio.cargarDatos(archivoClientes, clienteServicio);
		System.out.println("Carga realizada con éxito");
	}
	
	public void exportarDatos() {
		
		System.out.println("Seleccione el formato de exportación: ");
		System.out.println("1. CSV");
		System.out.println("2. TXT");
		
		Integer opcion = Integer.parseInt(sc.nextLine());
		
		switch(opcion) {
		case 1:
			exportarCSV.exportarCSV(archivoClientes, clienteServicio);
			break;
		case 2:
			exportarTxt.exportarTxt(archivoClientes, clienteServicio);
			break;
		default:
			System.out.println("Opción no válida");
		}
		
	}
	
	public void terminarPrograma() {
		System.out.println("Programa terminado.");
	}
	
	

}
