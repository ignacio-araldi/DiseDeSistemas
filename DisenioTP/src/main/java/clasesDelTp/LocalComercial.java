package clasesDelTp;

public class LocalComercial extends POI {
    public LocalComercial () {
    		super();
    }
    
    public Boolean calculoDeCercania(POI unPoi, double longitudPOI, double latitudPOI, int comuna){
		int valor = 0;
    	setRadioLimite(valor);
    	if (aCuantoEstoyDe(longitudPOI, latitudPOI)<=unPoi.getRadioLimite()){
    		return true;
    	}
    	else return false;
    }
  
}