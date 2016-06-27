package clasesDelTp;

public class DentroDeRadio implements Cercania{
	public Boolean calculoDeCercania(Ubicacion unaUbicacion,POI unPoi){
		return (unPoi.aCuantoEstoyDe(unaUbicacion)<=unPoi.getRadioLimite());
	}
}
                                           