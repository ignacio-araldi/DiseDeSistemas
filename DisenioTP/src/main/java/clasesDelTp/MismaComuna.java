package clasesDelTp;

public class MismaComuna implements Cercania{
	public Boolean calculoDeCercania(Ubicacion unaUbicacion,POI unPoi){
		return (unPoi.getUbicacion().getComuna()==unaUbicacion.getComuna());
	}

}
