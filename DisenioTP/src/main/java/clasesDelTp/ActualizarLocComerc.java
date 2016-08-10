package clasesDelTp;

import java.util.Set;

//hoja del composite
public class ActualizarLocComerc implements Componente {
	
	//simulo el texto plano 
	private String nombre;
	private Set<String> palabrasClavesACambiar;
	
	@override
	public void ejecutar(){
		
		for (POI poi:sistema.getPois()){
			if(poi.getNombre()==nombre){
				//lo encontro por lo q hay q actualizar las palabras claves
				 for (int i = 0; i <= palabrasClavesACambiar.size() - 1; i++) {
					 String palabra  = palabrasClavesACambiar.get(i));
					 if(poi.getPalabrasClaves().contains(palabra)){	 
					 } else { poi.agregarPalabrasClaves(palabra);}
			      }
			}	
		}
		//no lo encontro , por lo q hay q crearlo
		
	}
	
	

}
