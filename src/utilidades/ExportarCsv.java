package utilidades;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import modelo.Cliente;
import servicio.ClienteServicio;

public class ExportarCsv {
	
	public void exportarCSV(String file, ClienteServicio clienteServicio) {
		String filePath = Paths.get("BDClientesExportado.csv").toAbsolutePath().toString();
		try (FileWriter fw = new FileWriter(filePath)){
			List<Cliente> clientes =  clienteServicio.getListaClientes();
			fw.append("RUN,Nombre,Apellido,Anios,Categoria\n");
			
			for(Cliente cliente : clientes) {
			fw.append(String.join(",", cliente.getRunCliente(), cliente.getNombreCliente(), cliente.getApellidoCliente(), cliente.getAniosCliente(), cliente.getNombreCategoria().name())).append("\n");
			}
			
			System.out.println("Datos exportados a CSV exitosamente en: " + filePath);
			
		} catch (IOException e) {
			System.out.println("Error al exportar datos: " + e.getMessage());
			
		}
	}

}
