package clasesDelTp;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Composite implements Componente {

	private ArrayList<Componente> procesos = new ArrayList<Componente>();
	
	public void agregarProceso (Componente unProceso){
		procesos.add(unProceso);
	}
	
}
