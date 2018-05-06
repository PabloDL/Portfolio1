package modelo;

public class Rodado {
	public int idRodado;
	public String dominio;
	public int modelo;
	public String marca;
	
	public Rodado(int idRodado, String dominio, int modelo, String marca)throws Exception{
		this.idRodado = idRodado;
		this.setDominio(dominio);
		this.modelo = modelo;
		this.marca = marca;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) throws Exception{
		if (esDominioValido(dominio)){
			this.dominio = dominio;
		}
		else{
			throw new Exception("Error: Dominio invalido");
		}
	}
	
	public boolean esLetra(String letraObjetivo){
		boolean esValida =false;
		String [] abecedario = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		for(String letra : abecedario){
			if (letraObjetivo.compareToIgnoreCase(letra)==0){
				esValida=true;
				break;
			}
		}
		return esValida;
	}

	public boolean esNumero(String numero){
		boolean esValido = false;
		String [] numeros = {"0","1","2","3","4","5","6","7","8","9"};
		for(String num : numeros){
			if (numero.compareTo(num)==0){
				esValido = true;
				break;
			}
		}
		return esValido;
	}

	public boolean esDominioValido (String dominio){
		boolean esValido=true;
		int tipo=0; 
		
		String [] patente = dominio.split("");
				
		if (dominio.length()==6 ){
			tipo=1;			//"letra,letra,letra,numero,numero,numero"
		}
		else if (dominio.length()==7){
			tipo=2;			//"letra,letra,numero,numero,numero,numero,letra,letra"
		}
		else{
			esValido=false;
		}
				
		int indice=0;
		while (indice<dominio.length()-1 && esValido!=false){			
		
			if (esLetra(patente[indice])){
				if (tipo==1 && indice<3){
					esValido=true;
				}
				else if (tipo==2 && (indice<2 || indice<4)){
					esValido=true;
				}
				else{
					esValido=false;
				}
			}
			
			else if (esNumero(patente[indice])){
				if (tipo==1 && indice>2){
					esValido = true;
				}
				else if(tipo==2 && (indice>=2 || indice<=4)){
					esValido = false;
				}
				else{
					esValido=false;
				}
			}
			
			else {
				esValido=false;
			}
			
			indice++;
		}
		return esValido;
	}
		
	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
 
	@Override
	public String toString() {
		return "Rodado [idRodado=" + idRodado + ", dominio=" + dominio + ", modelo=" + modelo + ", marca=" + marca
				+ "]";
	}
	
	
	
}
