package clasesDelTp;

import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import com.google.gson.Gson;


public class Banco extends POI{

	private String gerente, sucursal,nombre;
	private Float latitud, longitud;
	private  Set<String> serviciosC;
	private Object servicios;
	
    public Banco (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC); 
		serviciosC = new HashSet<String>();
    }
    
    private Banco(String nombre, Float latitud, Float longitud, String sucursal, String gerente, Set<String> serviciosC){
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.sucursal = sucursal;
		this.gerente = gerente;
		this.serviciosC = serviciosC;
    }
    	
    	public String getGerente() {
    		return gerente;
    	}
	public void setGerente(String gerente) {
    		this.gerente = gerente;
    	}

	public String getSucursal() {
		return sucursal;
	}
public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

public Set<String> getserviciosC() {
	return serviciosC;
}
public void agregarservicios(String servicio) {
	this.serviciosC.add(servicio);
}


public void ConsultarBanco (String nombreBanco, String serv ){
	nombreBanco
	
	
	
	
	
}

//creo algunos bancos para luego conultar

Banco obj = new Banco("Banco Patagonia", 2.3445 , 3.234, "Caballito", "Marcelo Polino", );
Banco obj = new Banco("Banco Nacion", 2.6456 , 7.2355, "Mataderos", "Fabian Doman", );
Banco obj = new Banco("Banco Santander", 5.3445 , 8.234, "Avellaneda", "Joge Rial", );
Banco obj = new Banco("Banco ICBC", 2.987 , 3.874, "Fllores", "Osvaldo Laport", );
Banco obj = new Banco("Banco Santander", 4.3445 , 1.234, "Balvanera", "Marcelo Tinelli", );
Banco obj = new Banco("Banco Frances", 7.3445 , 9.234, "Palermo", "Angel Lebrito", );
Banco obj = new Banco("Banco Rio", 5.3445 , 3.234, "Villa Crespo", "Jose Maria Listorti", );
Banco obj = new Banco("Banco Galicia", 5.23445 , 3.234, "Devoto", "Pedro Alfonso", );



/*static class BancoConsultado{
 private String banco;
 private String x;
 private String y;
 private String sucursal;
 private String gerente;
 Collection servicios = new ArrayList();
 private BancoConsultado(String banco, String x, String y, String sucursal, String gerente){
	this.banco = banco;
	this.x = x;
	this.y = y;
	this.sucursal = sucursal;
	this.gerente = gerente;
	servicios.addAll(serviciosC);
	
}
/*
 
 
BancoConsultado obj = new BancoConsultado("Banco Patagonia",);
String jsonString = gson.toJson(obj);
System.out.println("JSON:" + jsonString);
}