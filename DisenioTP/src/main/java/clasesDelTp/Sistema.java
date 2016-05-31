package clasesDelTp;

import java.util.HashSet;
import java.util.Set;

public class Sistema {
	
	private Set<POI> pois,poisAux;
	private Set<Administrador> admins;
	private Administrador adminAux;
	
	public Sistema(){
		pois = new HashSet<POI>();
		poisAux = new HashSet<POI>();
		admins = new HashSet<Administrador>();
		adminAux=new Administrador("pepe","argento");
		admins.add(adminAux);
	}

	public Set<POI> buscarPoi(String palabra){  
		poisAux.clear();
		for (POI poi:pois){
			if(poi.getPalabrasClaves().contains(palabra))
			{
				poisAux.add(poi);
			}
		}
		return poisAux;
	}
	
	public Boolean logueo(String usu,String cont){
		for (Administrador admin:admins){
			if((admin.getUsuario().equals(usu))&&(admin.getContrasenia().equals(cont)))
			{
				return true;
			}
		}
		return false;
	}

	public Boolean eliminarPoi(POI unPoi)
	{
		return pois.remove(unPoi);
	}
	
	public Set<POI> getPois(){
		return pois;
	}

}
