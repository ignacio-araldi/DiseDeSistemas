package clasesDelTp;

//import org.uqbar.geodds.Point;


public class Ubicacion{
	private double latitud;
	private double longitud;
	
	public Ubicacion(double latitud, double longitud){
  this.latitud = latitud;
  this.longitud = longitud;
}

	public double latitud(){
		return this.latitud;
	}
	
   public double longitud(){
	return this.longitud;
}
 /*  public Point coordenadas(){
  Point point = new Point(this.latitud(), this.longitud());
   return point;
   }*/
}