package clasesDelTp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Terminal {
	
	private Set<POI> pois,poisAux;
	private Set<Administrador> admins;
	private Administrador adminAux;
	
	public Terminal(){
		pois = new HashSet<POI>();
		poisAux = new HashSet<POI>();
		admins = new HashSet<Administrador>();
		adminAux=new Administrador("pepe","argento");
		admins.add(adminAux);
	}


	
	public Set<POI> getPois(){
		return pois;
	}
	

	public Set<POI> getPoisAux() {
		return poisAux;
	}



	public void setPoisAux(Set<POI> poisAux) {
		this.poisAux = poisAux;
	}



	public Set<Administrador> getAdmins() {
		return admins;
	}



	public void setAdmins(Set<Administrador> admins) {
		this.admins = admins;
	}



	public Administrador getAdminAux() {
		return adminAux;
	}



	public void setAdminAux(Administrador adminAux) {
		this.adminAux = adminAux;
	}



	public void setPois(Set<POI> pois) {
		this.pois = pois;
	}
	

	public static void main(String[] args)
	{
		int opcion,valor;
		Boolean logueado=false;
		String usu,cont,texto;
		Scanner capt= new Scanner(System.in);
		POI miPoi = new POI();
		POI poiAux = new POI();

		Set<POI> pois;
		pois = new HashSet<POI>();
		
		System.out.println("Bienvenido al sistema de busqueda de POIS\n\n");


		System.out.println("Es usted administrador?\n-1 Si\n -2 No\n");
		opcion=capt.nextInt();
		if(opcion==1)
		{
			Administrador yo = new Administrador();
			do
			{
			System.out.println("Ingrese Usuario");
			usu=capt.nextLine();
			System.out.println("Ingrese Contrasenia");
			cont=capt.nextLine();
			logueado = yo.logueo(usu,cont);

			}while(!logueado);
			System.out.println("Logueo exitoso\n");

			do{
			System.out.println("Elija opcion:\n\n1-Agregar Poi\n2-Modificar Poi\n3-Eliminar Poi\n4-Salir\n\n");

			opcion=capt.nextInt();
			if (opcion==1){
				
				System.out.println("Ingrese nombre de poi\n\n");
				texto=capt.nextLine();
				poiAux.setNombre(texto);
				//y demas datos...
				yo.agregarPOI(poiAux);
			}
			if(opcion==2){
				System.out.println("Ingrese id de poi\n\n");
				valor=capt.nextInt();
				System.out.println("Ingrese nombre de poi\n\n");
				texto=capt.nextLine();
				if(yo.modificarPOI(valor,texto))
				{
					System.out.println("Modificado exitosamente\n\n");
				}
				else
					System.out.println("No se encuentra un POI con ese id\n\n");
			}
			
			if (opcion==3){
				System.out.println("Ingrese id de poi\n\n");
				valor=capt.nextInt();
				if(yo.eliminarPOI(valor))
				{
					System.out.println("Eliminado exitosamente\n\n");
				}
				else
					System.out.println("No se encuentra un POI con ese id\n\n");
			}
			}while(opcion!=4);
			
		}
		
		else{
			do{
		System.out.println("Elija opcion:\n\n1-Buscar Punto\n2-Calcular cercania (coordenada geografica)\n3-Calcular disponibilidad\n4-Salir\n\n");
		Usuario yo=new Usuario();
		yo.setMiPoi(miPoi);
		opcion=capt.nextInt();
		if (opcion==1){
			System.out.println("Ingrese texto a buscar\n\n");
			texto=capt.nextLine();
			pois=yo.buscarPoi(texto);
			if(pois.size()==0)
				System.out.println("Sin resultados\n");
			else
			{
				for(POI poi:pois){
					System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n");//algunos datos de ejemplo
				}
			}
		}
		
		if (opcion==2){
			
			System.out.println("Ingrese texto a buscar\n\n");
			texto=capt.nextLine();
			pois=yo.buscarPoi(texto);
			if(pois.size()==0)
				System.out.println("Sin resultados\n");
			else
			{
				for(POI poi:pois){
					System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n"+"La distancia a "+poi.getNombre()+"es:"+yo.getMiPoi().aCuantoEstoyDe(poi)+"\n");
					if(yo.getMiPoi().calculoDeCercania(poi))
						
						System.out.println("Usted esta cerca de "+poi.getNombre()+"\n");
					else
						
						System.out.println("Usted esta lejos de "+poi.getNombre()+"\n");

				}
			}
		
		}
		
		if (opcion==3){
			System.out.println("Ingrese texto a buscar\n\n");
			texto=capt.nextLine();
			pois=yo.buscarPoi(texto);
			if(pois.size()==0)
				System.out.println("Sin resultados\n");
			else
			{
				for(POI poi:pois){
					System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n");//algunos datos de ejemplo
					if(poi.calculoDeDisponibilidad())
						
						System.out.println(""+poi.getNombre()+" esta disponible ahora mismo\n");
					else
						
						System.out.println(""+poi.getNombre()+" no esta disponible ahora mismo\n");

				}
			}
		}
		
		else if(opcion!=4)
			System.out.println("Elija una opcion de las ofrecidas\n\n");
		
		pois.clear();
		}while(opcion!=4);
		}

}



	
}
