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
	private Ubicacion ubicacion;

	public POI() {

		nombre = "UTN";
		ubicacion= new Ubicacion();
		palabrasClaves = new HashSet<String>();
		
		radioLimite=5;
		tipoCercania=new MismaComuna();
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




	public int getRadioLimite() {
		return radioLimite;
	}
	
	public Ubicacion getUbicacion()
	{
		return ubicacion;
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
		return ((nombre.trim().length()==0)&&(ubicacion.getLongitud()!=0)&&(ubicacion.getLatitud()!=0));
	}
	
	public double aCuantoEstoyDe(Ubicacion unaUbicacion){
		double distancia=0;
		/*
		double longitud2, latitud2;
		
		
		// el usuario ingresa las coordenadas de dónde quiere ir
		// las coordenadas de donde se encuentra, longitud y latitud, ya estan con su getter y setter

		longitud2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese x del punto B al que quiere ir:"));

		latitud2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese y del punto B al que quiere ir:"));
*/
		// hace el procesamiento, resta las distancias
		distancia = Math.hypot(unaUbicacion.getLongitud()-ubicacion.getLongitud(), unaUbicacion.getLatitud()-ubicacion.getLatitud())/100;
		
		//muestra los resultados
		//JOptionPane.showMessageDialog(null, "La distancia entre los puntos \nA("+ubicacion.getLongitud()+","+ubicacion.getLatitud()+") y B("+unaUbicacion.getLongitud()+","+unaUbicacion.getLatitud()+") es ="+distancia);
		return distancia;
	}
	
	public Boolean calculoDeCercania(POI unPoi){
		return tipoCercania.calculoDeCercania(ubicacion, unPoi);
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
		System.out.println("Nombre:"+nombre+"\nCalle:"+ubicacion.getCalle()+"\nAltura"+ubicacion.getAltura()+"\n\n");//algunos datos de ejemplo
	}

}



