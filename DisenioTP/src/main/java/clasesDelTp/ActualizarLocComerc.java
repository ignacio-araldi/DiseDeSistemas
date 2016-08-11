package clasesDelTp;

//import java.util.Set;
import java.util.List;

//hoja del composite
public class ActualizarLocComerc implements Componente {
	
	//simulo el texto plano 
	private String nombre;
	//con Set no existe el .get, es con listas 
	private List<String> palabrasClavesACambiar;
	
	Terminal sistema=new Terminal();
	
	public void ejecutar(){
		
		for (POI poi:sistema.getPois()){
			if(poi.getNombre()==nombre){
				//lo encontro por lo q hay q actualizar las palabras claves
				 for (int i = 0; i <= palabrasClavesACambiar.size() - 1; i++) {
					 String palabra  = palabrasClavesACambiar.get(i);
					 if(poi.getPalabrasClaves().contains(palabra)){	 
					 } else { poi.agregarPalabrasClaves(palabra);}
			      }
			}	
		}
		//no lo encontro , por lo q hay q crearlo
		
	}
	
	

}
