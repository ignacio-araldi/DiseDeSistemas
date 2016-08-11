package clasesDelTp;

import java.util.ArrayList;
import java.util.Scanner;

public class Terminal {
	
	private ArrayList<POI> pois;	
	
	private ArrayList<Administrador> admins;

	private Conexion conex = new Conexion();

	
	public Terminal(){
		pois = new ArrayList<POI>();
		admins = new ArrayList<Administrador>();
		conex.dbConnect("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","select * from Tabla_CGPs");
	}

	
	public ArrayList<POI> getPois(){
		return pois;
	}

	public ArrayList<Administrador> getAdmins() {
		return admins;
	}

	public Boolean agregarAdmin(Administrador admin)
	{
		return admins.add(admin);
	}

	public void setAdmins(ArrayList<Administrador> admins) {
		this.admins = admins;
	}


	public void setPois(ArrayList<POI> pois) {
		this.pois = pois;
	}
	
	public static void menuAdmin(Terminal sistema)
	{
		int opcion,valor,tipoPoi;
		Boolean logueado=false;
		String usu,cont,texto;
		
		Scanner capt= new Scanner(System.in);
		Administrador yo = new Administrador(sistema);
		
		do
		{
		System.out.println("Ingrese Usuario");
		usu=capt.next();
		System.out.println("Ingrese Contrasenia");
		cont=capt.next();
		if(logueado = yo.logueo(usu,cont))
		{
			System.out.println("Logueo exitoso\n");
		}
		else
			System.out.println("Usuario o contrase�a erroneos\n");


		}while(!logueado);

		do{
		System.out.println("Elija opcion:\n\n1-Agregar Poi\n2-Modificar Poi\n3-Eliminar Poi\n4-Salir\n\n");

		opcion=capt.nextInt();
		if (opcion==1){
			System.out.println("A qu� categor�a pertenece el Poi?\n\n");
			System.out.println("1-Banco\n2-CGP\n3-Kiosco\n4-Librer�a\n5-Parada de colectivo\nValor diferente-Otro\n");
			tipoPoi=capt.nextInt();
			POI poiAux;
		     switch (tipoPoi) {
	            case 1:  poiAux = new Banco();
	                     break;
	            case 2:  poiAux = new CGP();
	                     break;
	            case 3:  poiAux = new Kiosco();
	                     break;
	            case 4:  poiAux = new Libreria();
	                     break;
	            case 5:  poiAux = new ParadaColectivo();
	                     break;
	            default: poiAux = new POI();
	                     break;
	        }
			System.out.println("Ingrese nombre de poi\n\n");
			texto=capt.next();
			poiAux.setNombre(texto);
			System.out.println("Ingrese latitud de poi\n\n");
			valor=capt.nextInt();
			poiAux.setLatitud(valor);
			System.out.println("Ingrese longitud de poi\n\n");
			valor=capt.nextInt();
			poiAux.setLongitud(valor);
			//y demas datos...
			
			yo.agregarPOI(poiAux);
		}
		if(opcion==2){
			System.out.println("Ingrese id de poi\n\n");
			valor=capt.nextInt();
			System.out.println("Ingrese nombre de poi\n\n");
			texto=capt.next();
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
	
	public static void menuUsuario(Terminal sistema)
	{
		int opcion;
		String texto;
		Scanner capt= new Scanner(System.in);
		ArrayList<POI> poisAux = new ArrayList<POI>();
		Usuario yo=new Usuario();
		POI poiAux = new POI("Utn",34,34);
		yo.setMiPoi(poiAux);
		yo.setSistema(sistema);
		
		do{
			System.out.println("Elija opcion:\n\n1-Buscar Punto\n2-Calcular cercania (coordenada geografica)\n3-Calcular disponibilidad\n4-Salir\n\n");

			opcion=capt.nextInt();
			if (opcion==1){
				System.out.println("Ingrese texto a buscar\n\n");
				texto=capt.next();
				poisAux=yo.buscarPoi(texto);
				if(poisAux.size()==0)
					System.out.println("Sin resultados\n");
				else
				{
					for(POI poi:poisAux){
						poi.listar();
					}
					poisAux.clear();
				}
			}
			
			if (opcion==2){
				
				System.out.println("Ingrese texto a buscar\n\n");
				texto=capt.next();
				poisAux=yo.buscarPoi(texto);
				if(poisAux.size()==0)
					System.out.println("Sin resultados\n");
				else
				{
					for(POI poi:poisAux){
						System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n"+"La distancia a "+poi.getNombre()+"es:"+yo.getMiPoi().aCuantoEstoyDe(poi.getLatitud(),poi.getLongitud())+"\n");
						if(yo.getMiPoi().calculoDeCercania(poi))
							
							System.out.println("Usted esta cerca de "+poi.getNombre()+"\n");
						else
							
							System.out.println("Usted esta lejos de "+poi.getNombre()+"\n");

					}
					poisAux.clear();
				}
			
			}
			
			if (opcion==3){
				System.out.println("Ingrese texto a buscar\n\n");
				texto=capt.next();
				poisAux=yo.buscarPoi(texto);
				if(poisAux.size()==0)
					System.out.println("Sin resultados\n");
				else
				{
					for(POI poi:poisAux){
						System.out.println("Nombre:"+poi.getNombre()+"\nCalle:"+poi.getCalle()+"\nAltura"+poi.getAltura()+"\n\n");//algunos datos de ejemplo
						if(poi.calculoDeDisponibilidad())
							
							System.out.println(""+poi.getNombre()+" esta disponible ahora mismo\n");
						else
							
							System.out.println(""+poi.getNombre()+" no esta disponible ahora mismo\n");

					}
					poisAux.clear();
				}
			}
			
			else if(opcion!=4)
				System.out.println("Elija una opcion de las ofrecidas\n\n");
			
			poisAux.clear();
			}while(opcion!=4);
	}
	

	public static void main(String[] args)
	{
		Terminal sistema=new Terminal();
		int opcion;
		Scanner capt= new Scanner(System.in);
		Administrador unAdmin1=new Administrador("pepe","argento",sistema);
		Administrador unAdmin2=new Administrador("lionel","messi",sistema);
		Administrador unAdmin3=new Administrador("caruso","lombardi",sistema);
		
		sistema.agregarAdmin(unAdmin1);
		sistema.agregarAdmin(unAdmin2);
		sistema.agregarAdmin(unAdmin3);
		
		POI unPoi = new POI("Adidas",54,56);
		CGP unCgp = new CGP("Abasto",56,75);
		
		sistema.getPois().add(unPoi);
		sistema.getPois().add(unCgp);
		
		/* prueba para corroborar que funciona la distancia entre 2 puntos 
		Usuario guido = new Usuario();
		guido.setMiPoi(unPoi);
		guido.getMiPoi().aCuantoEstoyDe(56, 75);
		*/ 
		System.out.println("Bienvenido al sistema de busqueda de POIS\n\n");

		

		System.out.println("Es usted administrador?\n-1 Si\n-2 No\n-3 Salir\n");
		opcion=capt.nextInt();
		if(opcion==1)
		{
			menuAdmin(sistema);
			
		}
		
		if(opcion==2)
		{
			menuUsuario(sistema);
		}

}



	
}
