package clasesDelTp;

public class ParadaColectivo extends POI{
	
	public ParadaColectivo (int nuevoNro) {
			super();
			setRadioLimite(1);
		}
	
	public ParadaColectivo () {
		super();
	}
	
    public Boolean calculoDisponibilidad () { 
    		return true;
    	}
    
    public Boolean calculoDeCercania(POI unPoi, double longitudPOI, double latitudPOI, int comuna){
    	if(unPoi.aCuantoEstoyDe(longitudPOI, latitudPOI)<0.1){
			return true;
		}
		else return false;
    }

	}