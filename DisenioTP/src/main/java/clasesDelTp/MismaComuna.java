package clasesDelTp;

public class MismaComuna implements Cercania{
	public Boolean calculoDeCercania(double latitud, double longitud,POI unPoi){
		return (calcularComuna(latitud,longitud)==calcularComuna(unPoi.getLatitud(),unPoi.getLongitud()));
	}
	public double calcularComuna(double latitud, double longitud)
	{
		return latitud+longitud; //cualquier cosa
	}
}
