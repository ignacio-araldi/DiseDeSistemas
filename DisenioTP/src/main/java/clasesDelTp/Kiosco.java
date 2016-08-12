package clasesDelTp;

public class Kiosco extends LocalComercial{

    public Kiosco (int horaA,int horaC, int diaA, int diaC) {
    	super();
	    setDisponibilidadHoraria(horaA,horaC,diaA,diaC); 
	}
    public Kiosco () {
    	super();
	}

    public Boolean calculoDeCercania(POI unPoi, double longitudPOI, double latitudPOI, int comuna){
    	setRadioLimite(2);
    	if (aCuantoEstoyDe(longitudPOI, latitudPOI)<=unPoi.getRadioLimite()){
    		return true;
    	}
    	else return false;
    }
}