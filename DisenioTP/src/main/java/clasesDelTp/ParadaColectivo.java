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

	}