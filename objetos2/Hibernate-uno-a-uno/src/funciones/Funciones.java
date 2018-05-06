package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones{
	
	public static boolean esBisiesto (int anio){
		return (anio%4==0 && (anio%100!=0 || anio%400==0));
	}
	
	public static int traerAnio (GregorianCalendar fecha){
		return fecha.get(Calendar.YEAR);	
	}
	
	public static int traerMes (GregorianCalendar fecha){
		return fecha.get(Calendar.MONTH);
	}
	
	public static int traerDia (GregorianCalendar fecha){
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	
	public static boolean esFechaValida (int anio, int mes, int dia){
		boolean fechaValida = false;
		if (anio>=1900){
			switch (mes){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:{	//si el mes es alguno de las siguientes: 1,3,5,7,8,10,12... (meses con 31 dias)
					fechaValida = (dia<=31 && dia>=1);
					break;
				}
				case 2:
				case 4:
				case 6:
				case 9:
				case 11:{	//si el mes es alguno de los siguientes: 2,4,6,9,11... (meses con 30 dias);
					if (mes==2 && dia==29){
						fechaValida = Funciones.esBisiesto(anio);
					}
					fechaValida = (dia<=30 && dia>=1);
				}
			}
		}
		return fechaValida; 	
	}

	public static GregorianCalendar traerFecha(int anio, int mes, int dia){ 
		GregorianCalendar fecha;
		if (esFechaValida(anio,mes,dia)){
			fecha = new GregorianCalendar(anio, mes, dia);
		}
		else{
			fecha=null;
		}
		
		return fecha;
	} 
	
	public static boolean esFormatoFechaValido (String fecha){ 
		//checkea que un String tenga el formato "AAAA/MM/DD"
		
		String [] numeros = {"1","2","3","4","5","6","7","8","9","0"};
		boolean formatoValido = true;

		if (fecha.substring(2,2) == "/" && fecha.substring(5,5) == "/"){
			
			for (int posStr=0; posStr<fecha.length(); posStr++){
				for (int posNum=0; posNum<numeros.length; posNum++){
					
					if (numeros[posNum]!=fecha.substring(posStr, posStr) || numeros[posNum]!="/"){
						formatoValido=false;
						break;
					}
				}
			}
		}
		return formatoValido; 
	}
	
	public static GregorianCalendar traerFecha(String fecha){
		GregorianCalendar nFecha = new GregorianCalendar();	
		
		if (Funciones.esFormatoFechaValido(fecha)){
			String[] sFecha = fecha.split("/");
			
			if (Funciones.esFechaValida(Integer.parseInt(sFecha[2]), Integer.parseInt(sFecha[1]), Integer.parseInt(sFecha[0]))){
				nFecha.set(Integer.parseInt(sFecha[2]), Integer.parseInt(sFecha[1]), Integer.parseInt(sFecha[0]));
			}		
			else{
				nFecha=null;
			}
		}
		return nFecha;							
	}

	public static String traerFechaCorta (GregorianCalendar fecha){
		// devuelve la fecha con el formato "DD/MM/AAAA"
		return String .format("%d/%d/%d",Funciones.traerDia(fecha),Funciones.traerMes(fecha),Funciones.traerAnio(fecha));
	}
		
	public static String traerFechaHoraCorta (GregorianCalendar fecha){
		// devuelve la fecha con el formato "DD/MM/AAAA hh:mm:ss"		
		return String.format("%d/%d/%d %d:%d:%d", Funciones.traerDia(fecha),Funciones.traerMes(fecha),Funciones.traerAnio(fecha),fecha.get(Calendar.HOUR),fecha.get(Calendar.MINUTE),fecha.get(Calendar.SECOND));		
	}
	
	public static GregorianCalendar traerFechaProximo (GregorianCalendar fecha, int cantDias){
		//TODO simplificar metodo, para retornar la fecha proxima a la actual + numero entero
		int anio = Funciones.traerAnio(fecha);
		int mes = Funciones.traerMes(fecha);
		int dia = Funciones.traerDia(fecha);
		int bis = 0;
		int[] meses = {31,28+bis,31,30,31,30,31,31,30,31,30,31};
		
		GregorianCalendar pFecha = new GregorianCalendar();
		
		if (Funciones.esFechaValida(anio, mes, dia)){
			if(Funciones.esBisiesto(anio)){
				bis=1;
			}
			else{
				bis=0;
			}
			dia +=cantDias;
			while (dia>=meses[mes-1]){	
				dia-=meses[mes-1];
				mes++;
				if(mes>12){
					mes=1;
					anio++;
					if (Funciones.esBisiesto(anio)){
						bis=1;
					}
					else{
						bis=0;
					}
				}
			}
			pFecha=new GregorianCalendar(anio,mes,dia);
		}
		else{
			pFecha=null;
		}
		
		return pFecha;
	}
	
/*	private static GregorianCalendar traerFechaProximo2NoUsar (GregorianCalendar fecha, int cantDias){
		//TODO TERMINAR GENERALIZACION PARA TRAER FECHAS ANTERIORES Y FUTURAS
		int anio = Funciones.traerAnio(fecha);
		int mes = Funciones.traerMes(fecha);
		int dia = Funciones.traerDia(fecha);
		int bis = 0;
		int modif = (cantDias/Math.abs(cantDias));//
		int[] meses = {31,28+bis,31,30,31,30,31,31,30,31,30,31};
		
		GregorianCalendar pFecha = new GregorianCalendar();
		
		if (Funciones.esFechaValida(anio, mes, dia)){
			if(Funciones.esBisiesto(anio)){
				bis=1;
			}
			else{
				bis=0;
			}
			
			dia +=cantDias;
				
				dia+=(meses[mes-1])*(modif*(-1));
				mes+=modif;			
			while (dia>=meses[mes-1]){	
				if(mes>12){
					mes=1;
					anio=anio+(Math.abs(cantDias)/cantDias);
					if (Funciones.esBisiesto(anio)){
						bis=1;
					}
					else{
						bis=0;
					}
				}
			}
			pFecha=new GregorianCalendar(anio,mes,dia);
		}
		else{
			pFecha=null;
		}		
		return pFecha;
	}
*/
	
	public static GregorianCalendar fechaMayor(GregorianCalendar fecha1, GregorianCalendar fecha2){
		GregorianCalendar mayor;
		int anio1 = Funciones.traerAnio(fecha1);
		int mes1 = Funciones.traerMes(fecha1);
		int dia1 = Funciones.traerDia(fecha1);
		int anio2 = Funciones.traerAnio(fecha2);
		int mes2 = Funciones.traerMes(fecha2);
		int dia2 = Funciones.traerDia(fecha2);
		
		if (anio1 > anio2){
			mayor=fecha1;
		}
		else if (anio1==anio2){
			if (mes1 > mes2){
				mayor=fecha1;
			}
			else if (mes1==mes2){
				if (dia1 > dia2){
					mayor=fecha1;
				}
				else if (dia1==dia2){
					mayor= new GregorianCalendar(0,0,0);
				}
				else{
					mayor=fecha2;
				}
			}
			else{
				mayor=fecha2;
			}
		}
		else{
			mayor=fecha2;
		}		
		
		return mayor;
	}
	
	public static int contarDias(GregorianCalendar fechaMenor, GregorianCalendar fechaMayor){
		//estima los dias usando una busqueda binaria (no se tiene en cuenta el dia actual en el total)
		int techo =2147483647;
		int dias = 12000;
		int piso = 1;
		GregorianCalendar dardo = Funciones.traerFechaProximo(fechaMenor, dias);	//medio es la cantidad de dias desde la fecha1
				
		while(!Funciones.sonFechasIguales(dardo, fechaMayor)){//mientras no hagas diana 
			dardo = Funciones.traerFechaProximo(fechaMenor, dias);
			
			if (Funciones.sonFechasIguales(Funciones.fechaMayor(dardo, fechaMayor),dardo)){//si la fecha mas reciente es dardo...
				//te pasaste 8 cuadras
				techo = dias;
				dias = Math.abs((techo+piso)/2);
			}
			else if (Funciones.sonFechasIguales(Funciones.fechaMayor(dardo, fechaMayor),fechaMayor)){//si la fecha mas reciente es fechaMayor
				//te quedaste cortina
				piso = dias;
				dias = Math.abs((techo+piso)/2);		
			}
			else{
				break;
			}		
		}
		return dias;
	}  
	 
	public static String traerDiaDeLaSemana (GregorianCalendar fecha){
		String [] semana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
		GregorianCalendar ref = new GregorianCalendar (1900,1,14);//fecha de referencia 14/1/1900 (fue lunes)
		System.out.println(contarDias(ref,fecha));
		return semana[(contarDias(ref,fecha) % 7)-1];
		//el dia de la semana corresponde al resto de la division entre la cantidad de dias desde la referencia hasta la fecha y 7 (cantidad de dias en la semana) 
	}

	public static boolean esDiaHabil (GregorianCalendar fecha){
		return (Funciones.traerDiaDeLaSemana(fecha)!="Domingo" || Funciones.traerDiaDeLaSemana(fecha)!= "Sabado" );
	}

	public static String traerMesEnLetras(GregorianCalendar fecha) {
		String [] meses = {"Enero", "febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
		return meses[Funciones.traerMes(fecha)];
	}

	public static String traerFechaLarga(GregorianCalendar fecha){
		//“Sábado 20 de Agosto del 2016”

		String diaS= Funciones.traerDiaDeLaSemana(fecha);
		String dia = Integer.toString(Funciones.traerDia(fecha));
		String mes = Funciones.traerMesEnLetras(fecha);
		String anio = Integer.toString(Funciones.traerAnio(fecha));
		return diaS + " " + dia +" de "+ mes +" del "+ anio;
	}

	public static boolean sonFechasIguales(GregorianCalendar fecha1, GregorianCalendar fecha2){
		boolean anios = true;
		boolean meses = true;
		boolean dias = true;
		if (Funciones.traerAnio(fecha1) != Funciones.traerAnio(fecha2)){
			anios = false;
		}
		if (Funciones.traerMes(fecha1) != Funciones.traerMes(fecha2)){
			meses = false;
		}
		if (Funciones.traerDia(fecha1) != Funciones.traerDia(fecha2)){
			dias = false;
		}	
		return 	anios && meses && dias;
	}
	
	public static boolean sonFechasHorasIguales(GregorianCalendar fecha1, GregorianCalendar fecha2) {
		boolean horas = true;
		boolean minutos = true;
		boolean segundos = true;
		boolean fechas = true;
		
		if (!Funciones.sonFechasIguales(fecha1, fecha2)){
			fechas = false;
		}
		if (fecha1.get(Calendar.HOUR) != fecha2.get(Calendar.HOUR)){
			horas = false;
		}
		if (fecha1.get(Calendar.MINUTE) != fecha2.get(Calendar.MINUTE)){
			minutos = false;
		}
		if (fecha1.get(Calendar.SECOND) != fecha2.get(Calendar.SECOND)){
			segundos = false;
		}
		return fechas && horas && minutos && segundos ;
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes){
		int bis=0;
		int [] meses = {31,28+bis,31,30,31,30,31,31,30,31,30,31};	
		if (Funciones.esBisiesto(anio)){
			bis=1;
		}
		return meses[mes-1];
	}
	
	public static double aproximar2Decimal(double valor) {
		double nValor = new Double(valor);
		int x=0;
		if (valor*100>=Math.floor(valor*100)+0.5){
			x=1;
		}
		
		nValor = (Math.floor(valor*100)+x)/100;
		return nValor;
	}
	
	public static boolean esNumero (char caracter){
		char[] numeros = {'1','2','3','4','5','6','7','8','9','0'};
		boolean encontrado = false;
		int index = 0;
		
		while (index < numeros.length && !encontrado){
			char c = numeros[index];
			if (c==caracter){
				encontrado = true;
			}
			index++;
		}
		return encontrado;
	}
	
	public static boolean esNumero (String caracter){
		String [] numeros = {"1","2","3","4","5","6","7","8","9","0"};
		boolean encontrado = false;
		int index = 0;
		
		while (index < numeros.length && !encontrado){
			String c = numeros[index];
			if (c.contentEquals(caracter)){
				encontrado=true;
			}
			index++;
		}
		return encontrado;
	}
	
	public static boolean esLetra(char caracter){
		char [] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
		boolean encontrado=false;
		int index = 0;
		
		while (index < letras.length && !encontrado){
			char c = letras[index];
			if (c==Character.toLowerCase(caracter)){
				encontrado = true;
			}
			index++;
		}
		return encontrado;
	}
	
	public static boolean esLetra(String caracter){
		String [] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
		boolean encontrado = false;
		int index = 0;
		
		while (index <= letras.length && !encontrado){
			String c = letras[index];
			if (c.contentEquals(caracter.toLowerCase())){
				encontrado = true;
			}
			index++;
		}
		return encontrado;
	}
	
	public static boolean esCadenaNros(String cadena){
		boolean esCadena = true;
		char [] arrNros= cadena.toCharArray();
		int index = 0;

		while (index < arrNros.length && esCadena){
			char c = arrNros[index];
		
			if (!Funciones.esNumero(c)){
				esCadena=false;
			}
			index++;
		}
		return esCadena;
	}
	
	public static boolean esCadenaLetras(String cadena){
		boolean esCadena = true;
		char [] arrLetras = cadena.toCharArray();
		int index = 0;
		
		while (index < arrLetras.length && esCadena){
			char c = arrLetras[index];
			if (!Funciones.esLetra(c)){
				esCadena = false;
			}
			index++;
		}
		return esCadena;
	}
	
	
}
