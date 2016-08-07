package clasesDelTp;

import java.util.HashSet;
import java.util.Set;

public class Administrador {
	
	private String usuario, contrasenia;
	private Terminal sistema;
	
	public Administrador(String usuario, String contrasenia, Terminal sistema) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.sistema = sistema;
	}

	public Administrador(Terminal sistema){
		this.sistema = sistema;
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
	
	public Boolean logueo(String usu,String cont){
		for (Administrador admin:sistema.getAdmins()){
			if((admin.getUsuario().equals(usu))&&(admin.getContrasenia().equals(cont)))
			{
				return true;
			}
		}
		return false;
	}
	
	public void agregarPOI(POI unPOI){
		unPOI.setId(sistema.getPois().size()+1);
		sistema.getPois().add(unPOI);
	}
	
	public void agregarPOI(CGP unCGP){
		unPOI.setId(sistema.getPois().size()+1);
		sistema.getPois().add(unPOI);
	}
	
	public Boolean modificarPOI(int id, String nombre){//y demas datos
		for(POI poi:sistema.getPois())
		{
			if(poi.getId()==id){
				poi.setNombre(nombre);
				return true;
			}
		}
		return false;
	}
	public POI obtenerPoiPorId(int id){
		POI poiAux=new POI();
		for(POI poi:sistema.getPois())
		{
			if(poi.getId()==id){
				poiAux= poi;
			}
		}
		return poiAux;
	}
	
	public Boolean eliminarPOI(int id){
		if(obtenerPoiPorId(id).getId()!=0)
		{
			sistema.getPois().remove(obtenerPoiPorId(id));
			return true;
		}
		else return false;
	}
}
