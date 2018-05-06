package test;

import java.util.GregorianCalendar;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	
	public static void main(String[] args) {
		try {
			ClienteABM abm = new ClienteABM();
			long id = 1;
			Cliente cliente = abm.traerCliente(id);
			System.out.println( "Cliente a Modificar -->" +cliente);
			// modificar por set los atributos
			cliente.setDni(37750103);
			cliente.setApellido("De Laforé");
			cliente.setNombre("Pablo");
			cliente.setFechaDeNacimiento(new GregorianCalendar(1993,8,17));
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
