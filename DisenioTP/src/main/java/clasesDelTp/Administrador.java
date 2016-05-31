package clasesDelTp;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Administrador {
	
	private String usuario, contrasenia;
	private POI poiAux;
	private Sistema sistema;

	
	public Administrador(String usu, String contra){

		usuario=usu;
		contrasenia=contra;
	}
	
	//GET / SET
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	//OTROS METODOS
	
	public void agregarPOI(POI unPOI){
		sistema.getPois().add(unPOI);
	}
	
	public void modificarPOI(POI unPOI){
		
	}
	
	public void eliminarPOI(POI POIaEliminar){
		sistema.getPois().remove(POIaEliminar);
	}
	

	public static void main(String[] args)
	{
		int opcion;
		Boolean valido=false;
		String usu,cont,texto;
		Sistema sistema=new Sistema();
		Scanner capt= new Scanner(System.in);
		POI miPoi = new POI();
		Kiosco unKiosco = new Kiosco(8,17,0,5);
		Usuario yo = new Usuario();
		yo.setMiPoi(miPoi);
		Set<POI> pois;
		pois = new HashSet<POI>();
		
		System.out.println("Bienvenido al sistema de busqueda de POIS\n\n");
		
		do{
			
		System.out.println("Ingrese Usuario");
		usu=capt.nextLine();
		System.out.println("Ingrese Contrasenia");
		cont=capt.nextLine();
		valido = sistema.logueo(usu,cont);
		
		}while(!valido);
		
		valido=false;
		System.out.println("Logueo exitoso\n");
		do{
		System.out.println("Elija opcion:\n\n1-Buscar Punto\n2-Calcular cercania (coordenada geografica)\n3-Calcular disponibilidad\n4-Salir");
		opcion=capt.nextInt();
		if (opcion==1){
			System.out.println("Ingrese texto a buscar\n\n");
			texto=capt.nextLine();
			pois=sistema.buscarPoi(texto);
			if(pois.size()==0)
				System.out.println("Sin resultados\n");
			else
			{
				for(POI poi:pois){
					System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n");//algunos datos de ejemplo
				}
			}
		}
		
		if (opcion==3){
			
			
		
		}
		
		}while(opcion!=4);


}
}
