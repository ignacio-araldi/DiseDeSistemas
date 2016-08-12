package clasesDelTp;

public interface Cercania {
	// esta clase no deberia volar? 
	Boolean calculoDeCercania(double latitud,double longitud ,POI unPoi);
	
	Boolean calculoDeCercania(int comuna,POI unPoi);
	
}
