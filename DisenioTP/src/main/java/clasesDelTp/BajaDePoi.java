package clasesDelTp;

import java.util.HashSet;
import java.util.Set;

//hoja del composite
public class BajaDePoi {
	
	@override 
	public void agregarProceso(Componente unProceso){
		
		System.out.println("No se puede agregar un proceso\n");
	}
	
	
	@override 
	public void remover(Componente unProceso){
		
		System.out.println("No se puede remover un proceso\n");
	}
	
	@override
	public void ejecutar(){
		
	}
	
	
	
}
