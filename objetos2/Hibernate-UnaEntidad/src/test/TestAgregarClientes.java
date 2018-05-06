package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;

public class TestAgregarClientes {
	public static void main(String[] args) {
		try {
			String apellido = "De Laforé" ;
			String nombre= "Pablo" ;
			int documento = 37750103;
			GregorianCalendar fechaDeNacimiento = new GregorianCalendar(1993,8,17); // tu fecha de nacimiento
			
			ClienteABM abm = new ClienteABM();
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
			
		}
		catch(Exception currentException){
			currentException.getMessage();
			currentException.getStackTrace();
		}
	}
}
