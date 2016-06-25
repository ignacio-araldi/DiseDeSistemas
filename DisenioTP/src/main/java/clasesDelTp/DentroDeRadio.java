package clasesDelTp;

public class DentroDeRadio implements Cercania{
	public Boolean calculoDeCercania(double latitud, double longitud,POI unPoi){
		return (unPoi.aCuantoEstoyDe(latitud,longitud)<=unPoi.getRadioLimite());
	}
}
