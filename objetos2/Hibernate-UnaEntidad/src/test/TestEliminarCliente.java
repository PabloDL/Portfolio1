package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		try{	
			ClienteABM abm = new ClienteABM();
			long id = 1;
			Cliente c = abm.traerCliente(id);
			System.out.println("Cliente a Eliminar -->" + c);
			c.setBaja(true);
			abm.modificar(c);
			System.out.println("Cliente Eliminado");

		}
		catch( Exception currentException){
			currentException.getStackTrace();
			currentException.getMessage();
			
		}
	}
}