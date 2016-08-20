package clasesDelTp;

import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Composite extends Componente {

	private ArrayList<Componente> procesos;
	
	public override void agregarProceso (Componente unProceso){
		procesos.add(unProceso);
	}
	
	 public override void remover( Componente unProceso )  {
		 procesos.remove(unProceso);   
		 } 
	
	 
	 public overrid void ejecutar(){
		for (int i =0 , (procesos.size)-1 , i++) {
			
			procesos.get(i).ejecutar();
			
		}
	 }
}
