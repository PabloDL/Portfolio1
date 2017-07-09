package test;

import java.util.GregorianCalendar;
import modelo.Funciones;

public class TestFunciones {
	static GregorianCalendar date = new GregorianCalendar(2017,1,7);
	static GregorianCalendar targetDate = new GregorianCalendar(1900,1,14);
	static GregorianCalendar fullDate = new GregorianCalendar(2010,11,12,1,14,15);
	
	public static void main(String[] args) {
		
//		System.out.println(Funciones.esBisiesto(2008));
//		System.out.println(Funciones.esBisiesto(2006));
//		System.out.println(Funciones.esBisiesto(2224));
//		System.out.println(Funciones.esBisiesto(2100));
//		System.out.println(Funciones.esBisiesto(2300));
//		System.out.println(Funciones.esBisiesto(2900));
//		System.out.println(Funciones.esBisiesto(2600));
//		System.out.println(Funciones.esBisiesto(2400));
//		System.out.println(Funciones.esBisiesto(2800));
//		
//		System.out.printf("\ntraer año: %d \n",Funciones.traerAnio(date));
//		System.out.printf("traer mes: %d \n",Funciones.traerMes(date));
//		System.out.printf("traer dia; %d \n",Funciones.traerDia(date));
//		
//		System.out.print("\n2014/12/31 es fecha valida?: ");
//		System.out.println(Funciones.esFechaValida(2014, 12, 31));
//		System.out.println(Funciones.traerFecha(2015, 12, 31));
//		System.out.print("\nel formato de la fecha es valido? :");
//		System.out.println(Funciones.esFormatoFechaValido("13/02/2013"));
//		System.out.println(Funciones.traerFecha("13/01/2013"));
//		System.out.println("\n");
//		System.out.println(Funciones.traerFechaCorta(date));
//		System.out.println(Funciones.traerFechaHoraCorta(fullDate));
//		System.out.print("\n");
//		System.out.printf("18/1/2017 +100 dias = %s \n",Funciones.traerFechaCorta(Funciones.traerFechaProximo(targetDate,100)));
//		
		
		
//		System.out.println(Funciones.traerFechaCorta(Funciones.fechaMayor(date, targetDate)));
		
//		
//		System.out.printf("Funcion General\n18/1/2017 +100 dias = %s \n",Funciones.traerFechaCorta(Funciones.traerFechaProximo2(targetDate, 100)));
//		System.out.printf("28/4/2017 -100 dias = %s \n",Funciones.traerFechaCorta(Funciones.traerFechaProximo2(date, -100)));
//		
		System.out.println(Funciones.contarDias(targetDate, date));
		System.out.println(Funciones.traerFechaCorta(Funciones.traerFechaProximo(targetDate, 42698)));
//		System.out.println(Funciones.traerDiaDeLaSemana(date));
//		
//		System.out.println(Funciones.sonFechasIguales(date,fullDate));
//		System.out.println(Funciones.sonFechasHorasIguales(fullDate, date));
//		System.out.println(Funciones.traerCantDiasDeUnMes(2014,4));
//		System.out.println(Funciones.aproximar2Decimal(3.1415));
//		System.out.println(Funciones.esNumero('6'));
//		System.out.println(Funciones.esLetra('e'));
//		System.out.println(Funciones.esCadenaNros("127637576"));
//		System.out.println(Funciones.esCadenaLetras("sldkfjsl"));

//		System.out.println(Funciones.esDiaHabil(date));
		
		//System.out.println(Funciones.traerFechaCorta(Funciones.fechaMasReciente(date,fullDate)));
		
		
		System.out.printf("\n %s\n","practicar relaciones de composicion");
	}

}
