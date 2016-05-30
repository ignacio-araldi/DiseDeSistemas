package clasesDelTp;

public class LocalComercial extends POI {
    public LocalComercial () {
    		super();
        } 
	public Boolean calculoDeCercania(POI unPoi){
		return (aCuantoEstoyDe(unPoi)<=getRadioLimite());
	}
	
}