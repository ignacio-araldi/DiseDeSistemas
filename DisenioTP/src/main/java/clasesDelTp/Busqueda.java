package clasesDelTp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Busqueda {
	
Set<POI> poisAux=new HashSet<POI>();

List<String> palabrasClave = new ArrayList<String>();
//la lista se crea con el objeto Integer, no con la primitiva int
List<Integer> cantPoisxPalabra = new ArrayList<Integer>();

Terminal sistema = new Terminal();

// guardo la palabra que se busco y la cantidad de resultados , falta lo del tiempo
public Set<POI> buscarPoi(String palabra){  
	Set<POI> poisAux=new HashSet<POI>();
	poisAux.clear();
	for (POI poi:sistema.getPois()){
		if(poi.getPalabrasClaves().contains(palabra))
		{
			poisAux.add(poi);
			if(palabrasClave.contains(palabra)){
			} else { palabrasClave.add(palabra);}
		}
	}
	//busco posicion para saber en q lugar guardar la cantidad
	int lugarAGuardar=palabrasClave.size();
	cantPoisxPalabra.set(lugarAGuardar, poisAux.size());		
	return poisAux;
}
	
	
}