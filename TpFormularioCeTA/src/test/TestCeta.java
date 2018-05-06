package test;

import modelo.Contribuyente;
import modelo.Rodado;
import modelo.Ceta;
import java.util.GregorianCalendar;


	/*
	Excepciones mínimas a implementar : 
	ERROR: CUIL inválido; 
	ERROR: Dominio inválido;
	ERROR: El vendedor y el comprador son los mismos
	ERROR: la fecha no puede ser posterior al día de hoy
	*/

public class TestCeta {
	public static void main(String[] args) {
		try{
			System.out.println("_________________________\n\n");
			System.out.println("Test1: deberia fallar por cuil invalido(segun consigna)");
			
			Contribuyente persona1 = new Contribuyente(0001,"De Lafore", "pablo", 12345678, 'm', "29123456789" );
			System.out.printf( "%s %s\nDNI: %d\nSexo: %c\n Cuil: %s \n\n", persona1.getApellido() , persona1.getNombre(), persona1.getDni(), persona1.getSexo(), persona1.getCuil());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//__________________________________________________________________
		
		
		try{
			System.out.println("_________________________\n\n");
			System.out.println("Test2: deberia fallar por tener un dominio invalido"); 

			Rodado auto1 = new Rodado(0001,"ABC001R",505,"Peugeot");
			System.out.printf("Patente: %s\n Marca: %s\n Modelo: %d \n\n",auto1.dominio,auto1.marca,auto1.modelo);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//__________________________________________________________________	

		try{
			System.out.println("_________________________\n\n");
			System.out.println("Test3: deberia fallar por ser el comprador y vendedor la misma persona"); 
			
			Contribuyente persona1 = new Contribuyente(0002,"Rodriguez", "Pepito", 30134134, 'm', "20172543597");
			System.out.printf("%s %s\nDNI: %d\nSexo: %c\nCuil: %s\n\n", persona1.getApellido() , persona1.getNombre(), persona1.getDni(), persona1.getSexo(), persona1.getCuil());
					
			Contribuyente persona2 = new Contribuyente(0002,"Rodriguez", "Pepito", 30134134, 'm', "20172543597");
			System.out.printf("%s %s\nDNI: %d\nSexo: %c\nCuil: %s\n\n", persona2.getApellido() , persona2.getNombre(), persona2.getDni(), persona2.getSexo(), persona2.getCuil());
			
			Rodado auto1 = new Rodado(0001,"DIE001",505,"Peugeot");
			System.out.printf("Patente: %s\nMarca: %s\nModelo: %d\n\n",auto1.dominio,auto1.marca,auto1.modelo);
		
			Ceta tramite1 =new Ceta(00001,new GregorianCalendar(2017,5,20),persona1,persona2,auto1,55000.0, true);
			System.out.printf("%s", tramite1.toString());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//__________________________________________________________________	
		
				try{
					System.out.println("_________________________\n\n");
					System.out.println("Test4: deberia fallar por fecha invalida"); 
					
					
					Contribuyente persona1 = new Contribuyente(0001,"De Lafore", "pablo", 30135634, 'm', "20301356349" );
					System.out.printf("%s %s\nDNI: %d\nSexo: %c\nCuil: %s\n\n", persona1.getApellido() , persona1.getNombre(), persona1.getDni(), persona1.getSexo(), persona1.getCuil());
							
					Contribuyente persona2 = new Contribuyente(0002,"Rodriguez", "Pepito", 30134134, 'm', "20301341349");
					System.out.printf("%s %s\nDNI: %d\nSexo: %c\nCuil: %s\n\n", persona2.getApellido() , persona2.getNombre(), persona2.getDni(), persona2.getSexo(), persona2.getCuil());
					
					Rodado auto1 = new Rodado(0001,"DIE001",505,"Peugeot");
					System.out.printf("Patente: %s\nMarca: %s\nModelo: %d\n\n",auto1.dominio,auto1.marca,auto1.modelo);
				
					Ceta tramite1 =new Ceta(00001,new GregorianCalendar(2021,5,20),persona1,persona2,auto1,55000.0, true);
					System.out.printf("%s", tramite1.toString());
					
					
				}
				catch(Exception e){
					e.printStackTrace();
				}

		//__________________________________________________________________	
				
		try{
			System.out.println("_________________________\n\n");
			System.out.println("Test5: no deberia fallar"); 

			
			Contribuyente persona1 = new Contribuyente(0001,"De Lafore", "pablo", 30135634, 'm', "20301356349" );
			System.out.printf("%s %s\nDNI: %d\nSexo: %c\nCuil: %s\n\n", persona1.getApellido() , persona1.getNombre(), persona1.getDni(), persona1.getSexo(), persona1.getCuil());
					
			Contribuyente persona2 = new Contribuyente(0002,"Rodriguez", "Pepito", 30134134, 'm', "20301341349");
			System.out.printf("%s %s\nDNI: %d\nSexo: %c\nCuil: %s\n\n", persona2.getApellido() , persona2.getNombre(), persona2.getDni(), persona2.getSexo(), persona2.getCuil());
			
			Rodado auto1 = new Rodado(0001,"DIE001",505,"Peugeot");
			System.out.printf("Patente: %s\nMarca: %s\nModelo: %d\n\n",auto1.dominio,auto1.marca,auto1.modelo);
		
			Ceta tramite1 =new Ceta(00001,new GregorianCalendar(2017,5,20),persona1,persona2,auto1,55000.0, true);
			System.out.printf("%s", tramite1.toString());
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

		
	}

}
