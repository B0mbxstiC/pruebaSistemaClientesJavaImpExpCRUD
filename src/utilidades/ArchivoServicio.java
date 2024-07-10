package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class ArchivoServicio {

	public void cargarDatos(String fileName, ClienteServicio clienteServicio) {
		
		File file = new File("D:\\OneDrive - Universidad de Concepción\\Eclipse\\sistemaClientes\\BaseDeDatos\\BDClientes.csv");
		
		//Este bloque se llama try-with-resources y es una buena práctica en programación. 
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linea;
			while((linea = br.readLine()) != null){
				String[] datos = linea.split(",");
				if (datos.length < 5) {
					System.out.println("Línea con formato incorrecto: " + linea);
					continue;
				}
				
				String rut = datos[0];
				String nombre = datos[1];
				String apellido = datos[2];
				String anios = datos[3];
				String categoria = datos[4];
				CategoriaEnum categoriaEnum;
				
				if (categoria.equalsIgnoreCase("activo")) {
					categoriaEnum = CategoriaEnum.ACTIVO;
				} else if(categoria.equalsIgnoreCase("inactivo")) {
					categoriaEnum = CategoriaEnum.INACTIVO;
				} else {
					System.out.println("No se reconoce la categoria del cliente, por lo tanto quedará inactivo");
					categoriaEnum = CategoriaEnum.INACTIVO;
				}
				Cliente cliente = new Cliente(rut, nombre, apellido, anios, categoriaEnum);
				clienteServicio.agregarCliente(cliente);
				System.out.println(cliente);
			}
			System.out.println("Datos cargados exitosamente");
		} catch (IOException e) {
			System.out.println("Error al cargar datos: " + e.getMessage());
			
		}
		
	}
	
}
