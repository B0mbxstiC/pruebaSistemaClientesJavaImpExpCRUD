package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {

	private List<Cliente> listaClientes = new ArrayList();
	private Scanner sc = new Scanner(System.in);

	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	//Método para llamar al listado de clientes existentes
	
	public void retornolistaClientes () {
		for(Cliente cliente : listaClientes) {
			System.out.println(cliente);
		}
	}
	
	//Método para agregar clientes a la lista de clientes. En esta parte se hace una sobrecarga al método agregarCliente para que así se puedan agregar clientes de 2 formas diferentes
	
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		System.out.println("Cliente agregado con éxito");			
	}
	
	public void agregarCliente(String run, String nombre, String apellido, String anios) {
		   Cliente cliente = new Cliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
		   listaClientes.add(cliente);
		   System.out.println("Cliente agregado con éxito");
	}
	
	
	public void editarCliente() {
		
		//Ingreso de rut cliente para buscarlo en la lista de clientes
		System.out.println("Ingresa el rut del cliente a editar: ");
		String rutCliente = sc.nextLine();
		
		Cliente cliente = buscarClientePorRut(rutCliente);
		if (cliente == null) {
			System.out.println("Cliente no encontrado");
			return;
		}
		
		System.out.println("Seleccione qué desea hacer:");
		System.out.println("1. Cambiar el estado del cliente");
		System.out.println("2. Edtar los datos ingresados del cliente");
		String opcionUno  =sc.nextLine();
		if (opcionUno.equalsIgnoreCase("1")) {
			System.out.println("El estado actual del cliente es: " + cliente.getNombreCategoria());
			System.out.println("1. Cambiar estado a INACTIVO");
			System.out.println("2. Mantener el estado del cliente ACTIVO");
			String opcionEstado = sc.nextLine();
			if (opcionEstado.equals("1")) {
				cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
				System.out.println("El estado del cliente se cambió a inactivo.");
			} else if (opcionEstado.equals("2")) {
				cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
				System.out.println("El estado del cliente se cambió a activo.");
			} else {
				System.out.println("Opción no válida");
			}			
			
		} else if (opcionUno.equals("2")) {
			System.out.println("1. El RUN del Cliente es: " + cliente.getRunCliente());
            System.out.println("2. El Nombre del Cliente es: " + cliente.getNombreCliente());
            System.out.println("3. El Apellido del Cliente es: " + cliente.getApellidoCliente());
            System.out.println("4. Los años como Cliente son: " + cliente.getAniosCliente());
            System.out.print("Ingrese opción a editar de los datos del cliente: ");
            Integer opcionDato = Integer.parseInt(sc.nextLine());
            
            switch (opcionDato) {
			case 1:
				System.out.println("Ingrese el nuevo RUN del cliente: ");
				cliente.setRunCliente(sc.nextLine());
				break;
				
			case 2:
				System.out.println("Ingresa el nuevo nombre del cliente: ");
				cliente.setNombreCliente(sc.nextLine());
				break;
			case 3:
				System.out.println("Ingresa el nuevo apellido del cliente: ");
				cliente.setApellidoCliente(sc.nextLine());
				break;
			case 4: 
				System.out.println("Ingresa la nueva edad del cliente: ");
				cliente.setAniosCliente(sc.nextLine());
				break;
			default:
				System.out.println("La opción ingresada no es válida.");
				
			}
            
		}
	}
	//Forma 2:
	
			/*
			 * System.out.println("Ingresa nuevo rut del cliente: ");
			String rut = sc.nextLine();
			System.out.println("Ingresa nuevo nombre del cliente: ");
			String nombre = sc.nextLine();
			System.out.println("Ingresa nuevo apellido del cliente: ");
			String apellido = sc.nextLine();
			System.out.println("Ingresa los años actuales del cliente: ");
			String anios = sc.nextLine();
			System.out.println("Ingresa el estado del cliente (ACTIVO/INACTIVO): ");
			String estadoCliente = sc.nextLine();
			
			//Instanciando Cliente y creando nuevo objeto clienteNuevo
			Cliente clienteNuevo;
			
			clienteNuevo.setRunCliente(rut);
			clienteNuevo.setNombreCliente(nombre);
			clienteNuevo.setApellidoCliente(apellido);
			clienteNuevo.setAniosCliente(anios);
			
			//Para establecer si el cliente está activo o inactivo.
			if(estadoCliente.equalsIgnoreCase("ACTIVO")) {
				nombreCategoria = CategoriaEnum.ACTIVO;
				clienteNuevo.setNombreCategoria(nombreCategoria);
			} else if(estadoCliente.equalsIgnoreCase("INACTIVO")) {
				nombreCategoria = CategoriaEnum.INACTIVO;
				clienteNuevo.setNombreCategoria(nombreCategoria);
			} else {
				System.out.println("El estado ha sido ingresado incorrectamente, intente nuevamente");
			}
			
			listaClientes.add(clienteNuevo);
			System.out.println("Cliente añadido con éxito");		
		
			 *  */
	
	//Método para eliminar clientes: 
	
	public void eliminarCliente(String rut) {
		Cliente clienteAEliminar = null;
		for(Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(rut)) {
				clienteAEliminar = cliente; 
				break;
			}
		}
		
		if (clienteAEliminar != null) {
			listaClientes.remove(clienteAEliminar);
			System.out.println("Cliente con RUN " + rut + "eliminado con éxito");
		} else {
			System.out.println("Cliente con RUN " + rut + " no encontrado");
		}
		
	}
		
		
		

	private Cliente buscarClientePorRut(String runCliente) {
		for(Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().trim().equalsIgnoreCase(runCliente.trim())) {
				return cliente;
			}
		}
		return null;
	}
	
	

	
}
