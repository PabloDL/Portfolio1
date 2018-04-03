package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	
	public static void main(String[] args) {
		try {
			ClienteABM abm = new ClienteABM();
			long id = 1;
			// traer el obj a modificar
			Cliente cliente = abm.traerCliente(id);
			System.out.println( "Cliente a Modificar -->" +cliente);
			// modificar por set los atributos
			cliente.setDni(35000001);
			abm.modificar(cliente); //update del objeto
			int dni = 35000001;
			Cliente clienteModif = abm.traerCliente(dni);
			System. out .println( "Cliente Modificado -->" +clienteModif);
		}
		catch(Exception currentException){
			currentException.getMessage();
			currentException.getStackTrace();
		}
		
	}

}
