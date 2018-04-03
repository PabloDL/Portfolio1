package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public Cliente traerCliente( long idCliente)throws Exception {//TODO puede estar mal!
		Cliente cliente = dao.traerCliente(idCliente);
		if (cliente == null){
			throw new Exception("ERROR el cliente no existe");
		}
		return cliente;
	}
	
	public Cliente traerCliente( int dni) throws Exception{
		Cliente cliente = dao .traerCliente(dni);
		if (cliente == null ){
			throw new Exception ("ERROR el dni no existe");
		}
		return cliente;
	}
	
	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento) throws Exception{
		// consulta si existe un cliente con el mismo dni , si existe arrojar Excepcion ;
		if (dao.traerCliente(dni) != null){
			Cliente cliente = new Cliente(apellido, nombre, dni,fechaDeNacimiento);
			return dao.agregar(cliente);
		}
		else throw new Exception ("ERROR el cliente ya existe "+ dao.traerCliente(dni).toString());
	}
	
	public void modificar(Cliente cliente) throws Exception{
		/* implementar antes de actualizar que no exista un cliente
		con el mismo documento a modificar
		y con el mismo id, lanzar la Exception */	
		if (dao.traerCliente(cliente.getDni()) != null) {
			//TODO no se que campo es el que se intenta modificar,si se modifica el dni, chequear que no exista(consigna) 
			throw new Exception ("Error el usuario que intenta modificar no existe");
		}
		else {
			dao.actualizar(cliente);
		}
	}
	
	public void eliminar( long idCliente) throws Exception{ /*en este caso es física en gral. no se se
		aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga
		dependencias*/
		Cliente cliente = dao.traerCliente(idCliente);
		// Implementar que si es null que arroje la excepción la Excepción
		if(cliente!= null) {
			throw new Exception("Error el cliente que desea eliminar no existe");
		}		
		dao.eliminar(cliente);
		}
		public List<Cliente> traerCliente(){ return dao.traerCliente();
	}
}
