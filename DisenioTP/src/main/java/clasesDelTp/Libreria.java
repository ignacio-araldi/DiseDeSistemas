package clasesDelTp;

public class Libreria extends LocalComercial{

    public Libreria (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC);        
    } 
    public Libreria () {
    	super();
    } 
    
    public Boolean calculoDeCercania(POI unPoi, double longitudPOI, double latitudPOI, int comuna){
    	setRadioLimite(5);
    	if (aCuantoEstoyDe(longitudPOI, latitudPOI)<=unPoi.getRadioLimite()){
    		return true;
    	}
    	else return false;
    }
	
}
