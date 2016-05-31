package clasesDelTp;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Administrador extends Usuario{
	
	private String usuario, contrasenia;
	private Terminal sistema;

	
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
	/*
	public Boolean logueo(String usu,String cont){
		return sistema.logueo(usu, cont);
	}

	*/
}
