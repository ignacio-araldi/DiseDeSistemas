package clasesDelTp;

import java.util.HashSet;

import java.util.Set;

//ver como agregar el import de arrays

public class Composite implements Componente {
	
	private ArrayList<Componente> procesos = new ArrayList<Componente>();
	
	public void agregarProceso (Componente unProceso){
		procesos.add(unProceso);
		
	}
}
