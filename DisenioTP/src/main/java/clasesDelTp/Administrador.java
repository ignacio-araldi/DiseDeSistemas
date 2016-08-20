package clasesDelTp;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Administrador extends Usuario{
	
	private String usuario, contrasenia;
	private Command command; 

	

	public Administrador(String usuario, String contrasenia, Terminal sistema , Command command) {
		super(sistema);
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.command = command;
	}

	public Administrador(Terminal sistema){
		super(sistema);

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
		usuario=usu;
		contrasenia =cont;
		for (Administrador admin:super.getSistema().getAdmins()){
			if((admin.getUsuario().equals(usu))&&(admin.getContrasenia().equals(cont)))
			{
				return true;
			}
		}
		return false;
	}
	
	public void agregarPOI(POI unPOI){
		
		super.getSistema().getPois().add(unPOI);

		//sistema.getConex().dbConnect("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","INSERT INTO Tabla_CGPs (id, comuna, zonas, director, domicilio, telefono, servicios) VALUES ("+unPOI.getId()+","+((CGP)unPOI).getComuna()+","+((CGP)unPOI).getZonas()+","+((CGP)unPOI).getDirector()+","+((CGP)unPOI).getDomicilio()+","+((CGP)unPOI).getTelefono()+","+((CGP)unPOI).getServicios()+")");

	}
	
	public Boolean modificarPOI(int id,String nombre, int latitud,int longitud){//y demas datos
		for(POI poi:super.getSistema().getPois())
		{
			if(poi.getId()==id){
				poi.setNombre(nombre);
				poi.setLatitud(latitud);
				poi.setLongitud(longitud);
				//super.getSistema().getConex().dbConnect("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","UPDATE Tabla_CGPs SET nombre="+nombre+", latitud="+latitud+", longitud="+longitud+" WHERE id="+poi.getId()+")");
				//ACA DEBERIA HACERSE SOLO SI ES CGP...ARREGLAR
				return true;
			}
		}
		return false;
	}

	public Boolean eliminarPOI(int id){
		for(POI poi:super.getSistema().getPois())
		{
			if(poi.getId()==id){
				super.getSistema().getPois().remove(poi);
				//super.getSistema().getConex().dbConnect("jdbc:sqlserver://localhost;databaseName=bdpois;integratedSecurity=true","DELETE FROM Tabla_CGPs WHERE id="+id+")");
				//ACA DEBERIA HACERSE SOLO SI ES CGP...ARREGLAR
				return true;
			}
		}
		return false;
	}

	public void agregarBusqueda(Busqueda unaBusqueda)
	{
		getBusquedas().add(unaBusqueda);
	}
	
	public Set<POI> buscarPoi(String palabra){  
		Calendar fecha = new GregorianCalendar();
		getPoisAux().clear();
		float tfinal,tinicial=System.currentTimeMillis();
		if(!getSistema().getPois().isEmpty())
			for (POI poi:getSistema().getPois()){
				if(poi.getPalabrasClaves().contains(palabra))
				{
					getPoisAux().add(poi);
				}
			}

		tfinal=System.currentTimeMillis();
		setBusquedaAux(new Busqueda(fecha.getTime(),getPoisAux().size(),((tfinal-tinicial)/1000),palabra,this));
		
		getSistema().actualizarAdminConBusqueda(this,getBusquedaAux());
		
		getSistema().getBusquedas().add(getBusquedaAux());

		getSistema().agregarFecha(fecha.getTime());
		
		getSistema().notificarPorMail((tfinal-tinicial)/1000, 1);
		
		return getPoisAux();
	}
	


	
	public void ejecutarProcesosCommand(){
		
		command.ejecutarProcesos();
	}
}
