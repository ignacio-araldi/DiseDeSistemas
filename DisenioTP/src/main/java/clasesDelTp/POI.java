package clasesDelTp;
//import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class POI {

	private Boolean validez;
	private double longitud=0,latitud=0,distancia=0;
	private int altura,comuna,radioLimite,id=0;
	private String calle, tipo,nombre;		
	private Horario disponibilidadHoraria;
	private Set<String> palabrasClaves;

	public POI() {

		longitud = 5;
		latitud = 6;
		nombre = "UTN";
		calle = "Medrano";
		altura = 200;
		distancia=10;
		
		palabrasClaves = new HashSet<String>();
		
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



	public double getLongitud() {
		return longitud;
	}



	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}



	public double getLatitud() {
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



	public double getDistancia() {
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


	public Set<String> getPalabrasClaves() {
		return palabrasClaves;
	}



	public void agregarPalabrasClaves(String palabraClave) {
		this.palabrasClaves.add(palabraClave);
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
		/*
		double longitud2, latitud2;
		
		
		// el usuario ingresa las coordenadas de dónde quiere ir
		// las coordenadas de donde se encuentra, longitud y latitud, ya estan con su getter y setter

		longitud2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese x del punto B al que quiere ir:"));

		latitud2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese y del punto B al que quiere ir:"));
*/
		// hace el procesamiento, resta las distancias
		distancia = Math.hypot(unPoi.getLongitud()-longitud, unPoi.getLatitud()-latitud)/100;
		
		//muestra los resultados
		JOptionPane.showMessageDialog(null, "La distancia entre los puntos \nA("+longitud+","+latitud+") y B("+unPoi.getLongitud()+","+unPoi.getLatitud()+") es ="+distancia);
	}
	
	public Boolean calculoDeCercania(POI unPoi){
		return (aCuantoEstoyDe(unPoi)<=radioLimite);
	}
	
	
	public Boolean calculoDeDisponibilidad(){
		Date fechaActual = new Date();
		if((fechaActual.getHours()<disponibilidadHoraria.getHoraCierre())&&(fechaActual.getHours()>disponibilidadHoraria.getHoraApertura())&&(fechaActual.getDay()>=disponibilidadHoraria.getDiaApertura())&&(fechaActual.getDay()<disponibilidadHoraria.getDiaCierre()))
			return true;
		else return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public void setDisponibilidadHoraria(Horario disponibilidadHoraria) {
		this.disponibilidadHoraria = disponibilidadHoraria;
	}

	public void setPalabrasClaves(Set<String> palabrasClaves) {
		this.palabrasClaves = palabrasClaves;
	}

}



