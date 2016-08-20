package clasesDelTp;

import java.util.HashSet;
import java.util.Set;

public abstract class Componente {
	
	abstract public void ejecutar();
	
	abstract public void agregarProceso(Componente unProceso);
	
	abstract public void remover(Componente unProceso);
	
}
