package modelo;

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
		/**esFechaValida(int año, int mes, int día)**/
		boolean fechaValida= false;
		if (anio>1900){
			switch (mes){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:{
					//return(dia<=31 && dia>=1); porque está mal??	
					fechaValida = (dia<=31 && dia>=1);
					break;
				}
				case 2:
				case 4:
				case 6:
				case 9:
				case 11:{
					if (mes==2 && dia==29){
						//return Funciones.esBisiesto(anio);
						fechaValida = Funciones.esBisiesto(anio);
					}
					//return (dia<=30 && dia>=1);
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
		String [] numeros={"1","2","3","4","5","6","7","8","9","0"};
		boolean formatoValido=true;

		if (fecha.substring(2,2)=="/" && fecha.substring(5,5)=="/"){
			
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
		return String .format("%d/%d/%d",Funciones.traerDia(fecha),Funciones.traerMes(fecha),Funciones.traerAnio(fecha));
	}
	
	public static int traerFechaNumerica(GregorianCalendar fecha) {
		return fecha.get(Calendar.YEAR)*10000 +  (fecha.get(Calendar.MONTH)+1)*100 + fecha.get(Calendar.DAY_OF_MONTH);
	}
		
	public static String traerFechaHoraCorta (GregorianCalendar fecha){
		return String.format("%d/%d/%d %d:%d:%d", Funciones.traerDia(fecha),Funciones.traerMes(fecha),Funciones.traerAnio(fecha),fecha.get(Calendar.HOUR),fecha.get(Calendar.MINUTE),fecha.get(Calendar.SECOND));		
	}
	
	public static GregorianCalendar traerFechaProximo (GregorianCalendar fecha, int cantDias){
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
		
	public static GregorianCalendar fechaMayor(GregorianCalendar fecha1, GregorianCalendar fecha2){
		GregorianCalendar mayor;
		int anio1 = Funciones.traerAnio(fecha1);
		int mes1 = Funciones.traerMes(fecha1);
		int dia1 = Funciones.traerDia(fecha1);
		int anio2 = Funciones.traerAnio(fecha2);
		int mes2 = Funciones.traerMes(fecha2);
		int dia2 = Funciones.traerDia(fecha2);
		
		anio1= anio1*10000+mes1*100+dia1;
		anio2= anio2*10000+mes2*100+dia2;
		
		if (anio1 > anio2){
			mayor=fecha1;
		}
		else if (anio1==anio2){
			mayor= new GregorianCalendar(0,0,0);
		}
		else{
			mayor=fecha2;
		}
		
		return mayor;
	}
	
	public static int contarDias(GregorianCalendar fecha1, GregorianCalendar fecha2){
		int techo =2147483647;
		int medio = 12000;
		int piso =1;
		GregorianCalendar dardo = Funciones.traerFechaProximo(fecha1, medio);	//medio es la cantidad de dias desde la fecha1
				
		while(!Funciones.sonFechasIguales(dardo, fecha2)){//mientras no hagas diana
			dardo = Funciones.traerFechaProximo(fecha1, medio);
			//System.out.printf("techo: %d \n",techo);
			//System.out.printf("medio: %d \n",medio);
			//System.out.printf("piso:  %d \n\n",piso);

			if (Funciones.sonFechasIguales(Funciones.fechaMayor(dardo, fecha2),dardo)){//si la fecha mas reciente es dardo...
				//te pasaste 8 cuadras
				techo=medio;
				medio=Math.abs(techo+piso)/2;
			}
			else if (Funciones.sonFechasIguales(Funciones.fechaMayor(dardo, fecha2),fecha2)){
				//te quedaste cortina
				piso=medio;
				medio=Math.abs(techo+piso)/2;		
			}
			else{
				break;
			}		
		}
		return medio;
	}

	public static String traerDiaDeLaSemana (GregorianCalendar fecha){
		String [] semana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
		GregorianCalendar ref = new GregorianCalendar (1900,1,14);
		System.out.println(contarDias(ref,fecha));
		return semana[(contarDias(ref,fecha) % 7)-1];
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
		boolean resultado=false;
		for (char c : numeros){
			if (c==caracter){
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	
	public static boolean esLetra(char caracter){
		char [] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
		boolean resultado=false;
		for (char c : letras){
			if (c==Character.toLowerCase(caracter)){
				resultado=true;
				break;
			}
		}
		return resultado;
	}
	
	public static boolean esCadenaNros(String cadena){
		boolean resultado= true;
		char [] arrNros= cadena.toCharArray();

		for (char c : arrNros){
			if (!Funciones.esNumero(c)){
				resultado=false;
				break;
			}
		}
		return resultado;
	}
	
	public static boolean esCadenaLetras(String cadena){
		boolean resultado = true;
		char [] arrLetras = cadena.toCharArray();
		
		for (char c : arrLetras){
			if (!Funciones.esLetra(c)){
				resultado = false;
				break;
			}
		}
		return resultado;
	}
	
	
}
