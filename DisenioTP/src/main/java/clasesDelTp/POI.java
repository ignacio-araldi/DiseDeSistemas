package clasesDelTp;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class POI {

	private Boolean validez;
	private int radioLimite,id=0;
	private String  tipo,nombre;		
	private Horario disponibilidadHoraria;
	private Set<String> palabrasClaves;
	public Cercania tipoCercania;
	private double latitud=0,longitud=0;
	private int comuna,altura;
	private String calle;

	public POI(String nombre, int longitud, int latitud) {

		palabrasClaves = new HashSet<String>();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		radioLimite=5;
		tipoCercania=new MismaComuna();
	}
	public POI()
	{
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
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
		return ((nombre.trim().length()==0)&&(getLongitud()!=0)&&(getLatitud()!=0));
	}
	
	public double aCuantoEstoyDe(double longitudPOI, double latitudPOI){
		double R = 6372.8; // en kilometros, radio de la tierra
		double distancia=0;

		// formula de haversine
		double dLat = Math.toRadians(latitudPOI-this.latitud);
        double dLon = Math.toRadians(longitudPOI-this.longitud);
        	
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(latitudPOI));
        double c = 2 * Math.asin(Math.sqrt(a));
        distancia =  R * c;
        
        
		
		JOptionPane.showMessageDialog(null, "La distancia entre los puntos \nA("+getLongitud()+","+getLatitud()+") y B("+longitudPOI+","+latitudPOI+") en kilometros es ="+distancia);
		return distancia;
	}
	
	
	
	public Boolean calculoDeCercania(POI unPoi){
		return tipoCercania.calculoDeCercania(latitud, longitud, unPoi);
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

	public void setDisponibilidadHoraria(Horario disponibilidadHoraria) {
		this.disponibilidadHoraria = disponibilidadHoraria;
	}

	public void setPalabrasClaves(Set<String> palabrasClaves) {
		this.palabrasClaves = palabrasClaves;
	}
	
	public void listar()
	{
		System.out.println("Nombre:"+nombre+"\nCalle:"+getCalle()+"\nAltura"+getAltura()+"\n\n");//algunos datos de ejemplo
	}

}



