package clasesDelTp;


import java.util.Set;
import java.util.List;

public class Administrador {
	
	private int usuario, contrasenia;
	
	private List<POI> Pois,result;
	private List<LocalComercial> locales;
	private Set<String> etiquetas,rubros;
	
	public Administrador(){
		

	}
	
	//GET / SET
	
	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(int contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<POI> getPois() {
		return Pois;
	}

	public void setPois(List<POI> pois) {
		Pois = pois;
	}

	public List<POI> getResult() {
		return result;
	}

	public void setResult(List<POI> result) {
		this.result = result;
	}

	public List<LocalComercial> getLocales() {
		return locales;
	}

	public void setLocales(List<LocalComercial> locales) {
		this.locales = locales;
	}

	public Set<String> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<String> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Set<String> getRubros() {
		return rubros;
	}

	public void setRubros(Set<String> rubros) {
		this.rubros = rubros;
	}
	
	//OTROS METODOS
	
	public void agregarPOI(POI unPOI){
		Pois.add(unPOI);
	}
	
	public void modificarPOI(POI unPOI){
		
	}
	
	public void eliminarPOI(POI POIaEliminar){
		Pois.remove(POIaEliminar);
	}
	
	public Set<String> todasLasEtiquetas(){
		etiquetas.removeAll(etiquetas);
		for (POI poi: Pois){
			etiquetas.add(poi.getEtiqueta());
		}
		return etiquetas;
	}
	
	public Set<String> todosLosRubros(){
		rubros.removeAll(rubros);
		for (POI poi: Pois){
			rubros.add(poi.getRubro());
		}
		return rubros;
	}
	
	public List<POI> resolverBusqueda(String palabra){
		if(etiquetas.contains(palabra))
		{
			return poisPorEtiqueta(palabra);
		}
		//if()
		return poisPorEtiqueta(palabra);
		
	}
	
	public List<POI> poisPorEtiqueta(String etiqueta){
		for (POI poi: Pois){
			if(poi.getEtiqueta()==etiqueta)
			result.add(poi);
		}
		return result;
	}



}
