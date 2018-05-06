package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.Contribuyente;
import modelo.Rodado;

public class Ceta {
	private int idCeta;
	private GregorianCalendar fecha;
	private Contribuyente vendedor;
	private Contribuyente comprador;
	private Rodado vehiculo;
	private double valorDeTransferecia;
	private boolean firmaComprador;
	
	public Ceta(int idCeta, GregorianCalendar fecha, Contribuyente vendedor, Contribuyente comprador, Rodado vehiculo,
			double valorDeTransferecia, boolean firmaComprador) throws Exception {
		super();
		this.idCeta = idCeta;
		this.setFecha(fecha);
		this.setVendedor(vendedor);
		this.setComprador(comprador);
		this.vehiculo=vehiculo;
		this.valorDeTransferecia = valorDeTransferecia;
		this.firmaComprador = firmaComprador;
	}
	
	public Rodado getVehiculo(){
		return this.vehiculo;
	}
	
	public int getIdCeta() {
		return idCeta;
	}

	public void setIdCeta(int idCeta) {
		this.idCeta = idCeta;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) throws Exception {	
		int fechaActualNumerica = Funciones.traerFechaNumerica(new GregorianCalendar());
		
		
		if (Funciones.traerFechaNumerica(fecha)<=fechaActualNumerica) {
			this.fecha = fecha;
		}
		else {
			throw new Exception("Error: Fecha Invalida");
		}
	}

	public Contribuyente getVendedor() {
		return vendedor;
	}

	public void setVendedor(Contribuyente vendedor) {
		this.vendedor = vendedor;
	}

	public Contribuyente getComprador() {
		return comprador;
	}

	public void setComprador(Contribuyente comprador) throws Exception {
		if(this.vendedor.equals(comprador)) {
			throw new Exception("Error: el Comprador y el Vendedor son la misma persona");
		}
		else {
			this.comprador = comprador;
		}
	}

	public double getValorDeTransferecia() {
		return valorDeTransferecia;
	}

	public void setValorDeTransferecia(double valorDeTransferecia) {
		this.valorDeTransferecia = valorDeTransferecia;
	}

	public boolean isFirmaComprador() {
		return firmaComprador;
	}

	public void setFirmaComprador(boolean firmaComprador) {
		this.firmaComprador = firmaComprador;
	}

	@Override
	public String toString() {
		return "Ceta [idCeta=" + idCeta + ", fecha=" + fecha + ", vendedor=" + vendedor + ", comprador=" + comprador
				+ ", vehiculo=" + vehiculo + ", valorDeTransferecia=" + valorDeTransferecia + ", firmaComprador="
				+ firmaComprador + "]";
	}
}
