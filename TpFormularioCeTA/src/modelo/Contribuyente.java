package modelo;



public class Contribuyente {
	private int idContribuyente;
	private String apellido;
	private String nombre;
	private long dni;
	private char sexo;
	private String cuil;
	
	public Contribuyente(int idContribuyente, String apellido, String nombre, long dni, char sexo, String cuil)throws Exception{
		this.idContribuyente =idContribuyente;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.setSexo(sexo);
		this.setCuil(cuil);
	}
	
	public int getIdContribuyente(){
		return this.idContribuyente;		
	}

	public void setIdContribuyente(int idContribuyente) {
		this.idContribuyente = idContribuyente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) throws Exception{
		sexo= Character.toUpperCase(sexo);
		if (sexo=='M' || sexo=='F'){
			this.sexo = sexo;
		}
		else{
			throw new Exception("Error: sexo no valido, elija un caracter valido \"f\" o \"m\"");			
		}
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) throws Exception{
		if (esValidoCuil(cuil)){
			this.cuil=cuil;
		}
		else {
			 throw new Exception("Error: Cuil invalido");
		}
	}
	
	public int numDeVerifCuil(String cuil){
		int [] valores = {5,4,3,2,7,6,5,4,3,2};
		String [] cuilDividido = cuil.split("");
		int v1 = 0;
				
		for(int i = 0; i<cuil.length()-1; i++){
			v1 += valores[i]+Integer.parseInt(cuilDividido[i]);
		}
		int v2 = v1 % 11;
		int v3 = 11-v2;
		return v3;
	}
	
	public boolean esValidoCuil(String cuil){

	/*Consigna:
	
	Como se verifica un CUIT o CUIL (genérico)
	El atributo sexo char con valores posibles, F o M, en el método que valida el cuil los
	primeros dos dígitos que corresponden 27 y 20 respectivamente.
	El CUIL consta de 11 números. Los 10 primeros (2 + 8) constituyen el código de
	identificación y el último, el dígito de verificación. Para obtener esta verificación se procede de
	la siguiente forma: A cada dígito del código, se lo multiplica por los siguientes números
	(respectivamente) 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 y cada valor obtenido, se suma para obtener una
	expresión (que llamaremos "valor 1". A este "valor 1", se le saca el resto de la división entera
	a 11. Se obtiene de esta forma un número (del 0 al 10) (que llamamos "valor 2"). Sacamos la
	diferencia entre 11 y el "valor 2", y obtenemos un valor comprendido entre 1 y 11 (llamémosle
	"valor 3"). Si "valor 3"=11, el código verificador es cero. Si "valor 3"=10, el código
	verificador es 9. En cualquier otro caso, el código verificador es "valor 3".
	Ejemplo numérico con un número de CUIT, que es 20-17254359-7.
	2 0 1 7 2 5 4 3 5 9
	x
	5 4 3 2 7 6 5 4 3 2
	-------------------------------------------------
	10 + 00 + 03 + 14 + 14 + 30 + 20 + 12 + 15 + 18 = 136
	v1 = 136
	136 mod 11 = 4
	v2 = 4
	11 - 4 = 7
	v3 = 7 => Código de verificación es siete.*/
		
		boolean esValido = true;
		
 		if (cuil.length()!=11){
			esValido=false;
		}
		else if (this.sexo =='M' ) {
			if(! cuil.substring(0,2).equals("20")){
				esValido=false;
			}
		}
		else if(this.sexo=='F'){
			if (! cuil.substring(0, 2).equals("27")) {
				esValido=false;
			}
		}
		else if (Integer.parseInt(cuil.substring(10))!= numDeVerifCuil(cuil)){
			esValido=false;			
		}
		return esValido;		
	}

	@Override
	public String toString() {
		return "Contribuyente [idContribuyente=" + idContribuyente + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", dni=" + dni + ", sexo=" + sexo + ", cuil=" + cuil + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		
		if (getClass() != obj.getClass())
			return false;
		Contribuyente other = (Contribuyente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (cuil == null) {
			if (other.cuil != null)
				return false;
		} else if (!cuil.equals(other.cuil))
			return false;
		if (dni != other.dni)
			return false;
		if (idContribuyente != other.idContribuyente)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}
	
	
}
