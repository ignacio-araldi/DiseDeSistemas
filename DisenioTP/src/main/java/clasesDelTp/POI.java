package clasesDelTp;

import java.util.Date;
public class POI {

	private String calle;
	private String tipo;
	private Boolean validez;
	private int longitud=0,latitud=0,altura,comuna,distancia,radioLimite;
	private String etiqueta,rubro;		
	private Horario disponibilidadHoraria;
	
	
	public POI() {
		//FRUTA
		longitud = 5;
		latitud = 6;
		nombre = "UTN";
		calle = "Medrano";
		altura = 200;
		distancia=10;
		//
		
		radioLimite=5;
	}
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Boolean getValidez() {
		return validez;
	}



	public void setValidez(Boolean validez) {
		this.validez = validez;
	}



	public int getLongitud() {
		return longitud;
	}



	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}



	public int getLatitud() {
		return latitud;
	}



	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}



	public int getAltura() {
		return altura;
	}



	public void setAltura(int altura) {
		this.altura = altura;
	}



	public int getComuna() {
		return comuna;
	}



	public void setComuna(int comuna) {
		this.comuna = comuna;
	}



	public int getDistancia() {
		return distancia;
	}



	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}



	public int getRadioLimite() {
		return radioLimite;
	}



	public void setRadioLimite(int radioLimite) {
		this.radioLimite = radioLimite;
	}



	public String getEtiqueta() {
		return etiqueta;
	}



	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}



	public String getRubro() {
		return rubro;
	}



	public void setRubro(String rubro) {
		this.rubro = rubro;
	}



	public Horario getDisponibilidadHoraria() {
		return disponibilidadHoraria;
	}



	public void setDisponibilidadHoraria(int horaA, int horaC, int diaA, int diaC) {
		this.disponibilidadHoraria = new Horario(horaA,horaC,diaA,diaC);
	}
	
	
	//OTROS METODOS
	
	public Boolean esValido(){
		return ((nombre.trim().length()==0)&&(longitud!=0)&&(latitud!=0));
	}
	
	public int aCuantoEstoyDe(POI unPoi){
		return distancia;
	}
	
	public Boolean calculoDeCercania(POI unPoi){
		return (aCuantoEstoyDe(unPoi)<=radioLimite);
	}
	
	public Boolean estaDentroDeComuna(int comuna)
	{
		return (this.comuna==comuna);
	}
	
	public Boolean calculoDeDisponibilidad(){
		Date fechaActual = new Date();
		if((fechaActual.getHours()<disponibilidadHoraria.getHoraCierre())&&(fechaActual.getHours()>disponibilidadHoraria.getHoraApertura())&&(fechaActual.getDay()>=disponibilidadHoraria.getDiaApertura())&&(fechaActual.getDay()<disponibilidadHoraria.getDiaCierre()))
			return true;
		else return false;
	}

}

//public Boolean estoyAMenosDe(int metros, POI unPoi){
//Point poi2 = new Point(this.latitud(), this.longitud());
//Point poi2 = new Point(unPoi.latitud(),unPoi.longitud());	
//
//return difEsMenorA(poi1,poi2,metros);
//}

//public Boolean difEsMenorA(Point primero, Point segundo, int metros){
//return(primero.distance(segundo)<(metros/1000));
//}
//public Boolean calculoDeCercania(Ubicacion unaUbicacion){
//return (estoyAMenosDe(unaUbicacion,500);  //	

//}

//public Boolean estoyAMenosDe(int mettro, Ubicacion algunaUbicacion){
//Point poi1 = new Point(this.latitud(),this.longitud());
//Point po12 = new Point(algunaUbicacion.latitud(), algunaUbicacion.longitud());
//return difEsMenorA(poi1,poi2,metros);
//	}

//public Boolean estaDentroDeComuna(int comuna)
//{
//return (obtenerComuna()==comuna);
//}
}
